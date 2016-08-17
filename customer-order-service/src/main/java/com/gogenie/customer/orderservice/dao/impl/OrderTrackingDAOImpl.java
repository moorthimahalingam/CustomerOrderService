package com.gogenie.customer.orderservice.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.gogenie.customer.orderservice.dao.OrderTrackingDAO;
import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.Menu;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;
import com.gogenie.customer.orderservice.util.OrderDetailsExtractor;
import com.gogenie.customer.orderservice.util.OrderStatusExtractor;
import com.gogenie.customer.orderservice.util.OrderSubmit;
import com.gogenie.customer.orderservice.util.SubmitOrderItemDetails;

@Repository
public class OrderTrackingDAOImpl implements OrderTrackingDAO {

	@Resource
	private DataSource gogenieDataSource;

	Logger logger = LoggerFactory.getLogger(OrderTrackingDAOImpl.class);

	private SimpleJdbcCall jdbcCall;

	private SimpleJdbcInsert jdbcInsert;

	private JdbcTemplate jdbcTemplate;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@PostConstruct
	public void setupDataSource() {
		jdbcTemplate = new JdbcTemplate(gogenieDataSource);
		namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(gogenieDataSource);
		jdbcCall = new SimpleJdbcCall(gogenieDataSource);
		jdbcInsert = new SimpleJdbcInsert(gogenieDataSource);

	}

	public OrderDetailResponse submitAnOrder(SubmitOrder request) throws CustomerOrderServiceException {
		logger.debug("Entering into submitAnOrder()");
		OrderDetailResponse orderDetailResponse = null;
		Long orderId = null;
		try {
			OrderSubmit orderSubmit = new OrderSubmit(gogenieDataSource);
			Map<String, Object> resultSet = orderSubmit.submitOrderExecute(request);
			logger.debug("Result set is {} after insert the order into DB ", resultSet.toString());

			if (resultSet.get("estatus") != null) {
				errorMessageHandler((String)resultSet.get("estatus"));
			}
			
//			List<Map> orderIdResult = (List) resultSet.get("#result-set-1");
//			logger.debug("Order list {} is ", orderIdResult.toString());
//			orderId = (Long) orderIdResult.get(0).get("returnOrderId");
			orderId = (Long) resultSet.get("sstatus");
			logger.debug("Order id for this new order is {} ", orderId);
			logger.debug("Begin into Insert Order Item details ");
			if (orderId > 0) {
				SubmitOrderItemDetails orderItemDetails = new SubmitOrderItemDetails(gogenieDataSource);
				for (Menu menu : request.getMenus()) {
					orderItemDetails.submitMenuOrderItemDetails(menu, orderId);
				}
			}
			logger.debug("Order Item details inserted successfully ");
			orderDetailResponse = new OrderDetailResponse();
			orderDetailResponse.setOrderId(orderId);
		} catch (Exception e) {
			if (orderId > 0) {
				jdbcTemplate.execute("delete from order_item_detail where order_id =" + orderId);
				jdbcTemplate.execute("delete from customer_order where order_id =" + orderId);
				logger.error("Order Id {} has been revoked ", orderId);
				logger.error("Rollback the inserted order details from the table");
			}
			throw new CustomerOrderServiceException(e, "submitAnOrder");
		}
		logger.debug("Exiting from submitAnOrder()");
		return orderDetailResponse;
	}

	public OrderDetailResponse orderStatusOfAnExistingOrder(Long orderId) throws CustomerOrderServiceException {
		logger.debug("Entering into orderStatusOfAnExistingOrder()");
		OrderDetailResponse response =  null;
		try {
			SqlParameterSource inputParam = new MapSqlParameterSource().addValue("orderId", orderId);
			response = namedParameterJdbcTemplate.query("{call get_customer_order_status(:orderId)}",
					inputParam, new OrderStatusExtractor());
		} catch (Exception e) {
			throw new CustomerOrderServiceException(e, "orderStatusOfAnExistingOrder");
		}
		logger.debug("Exiting from orderStatusOfAnExistingOrder()");
		return response;
	}

	public List<OrderDetailResponse> retrieveCustomerOrdersHistory(Integer customerId)
			throws CustomerOrderServiceException {
		logger.debug("Entering into retrieveCustomerOrdersHistory()");
		SqlParameterSource inputParam = new MapSqlParameterSource().addValue("custid", customerId);
		List<OrderDetailResponse> response = namedParameterJdbcTemplate.query("{call get_customer_order(:custid)}",
				inputParam, new OrderDetailsExtractor());
		logger.debug("Exiting from retrieveCustomerOrdersHistory()");
		return response;
	}

	public String addOrderAsCustomerFav(Integer customerId, Long orderId) throws CustomerOrderServiceException {
		logger.debug("Entering into addOrderAsCustomerFav()");
		jdbcInsert.withTableName("cust_fav_order");
		Map<String, Object> favorites = new HashMap<String, Object>();
		favorites.put("cust_id", customerId);
		favorites.put("order_id", orderId);
		logger.debug("Exiting from addOrderAsCustomerFav()");
		return null;
	}

	/**
	 * 
	 * @param errorMessage
	 * @return
	 */
	private void errorMessageHandler(String errorMessage) throws CustomerOrderServiceException {
		String errorMsg[] = errorMessage.split(":");
		CustomerOrderServiceException cre = new CustomerOrderServiceException(errorMsg[0], errorMsg[1]);
		throw cre;
	}
	
}
