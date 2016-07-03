package com.gogenie.customer.orderservice.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.gogenie.customer.orderservice.dao.OrderTrackingDAO;
import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.Menu;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;
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

			List<Map> orderIdResult = (List) resultSet.get("#result-set-1");

			logger.debug("Order list {} is ", orderIdResult.toString());

			orderId = (Long) orderIdResult.get(0).get("returnOrderId");

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
		OrderDetailResponse response;
		try {
			String orderStatus = jdbcTemplate.queryForObject(
					"select order_status from customer_order_detail where order_id=?", new Object[] { orderId },
					String.class);
			response = new OrderDetailResponse();
			response.setOrderId(orderId);
			response.setOrderStatus(orderStatus);

		} catch (Exception e) {
			throw new CustomerOrderServiceException(e, "orderStatusOfAnExistingOrder");
		}
		logger.debug("Exiting from orderStatusOfAnExistingOrder()");
		return response;
	}

	public List<OrderDetailResponse> retrieveCustomerOrdersHistory(Integer customerId)
			throws CustomerOrderServiceException {
		logger.debug("Entering into retrieveCustomerOrdersHistory()");
		jdbcTemplate.queryForObject("select * from customer_order_detail where cust_id=?", new Object[] { customerId },
				new RowMapper<List<OrderDetailResponse>>() {
					public List<OrderDetailResponse> mapRow(ResultSet rs, int rowNum) throws SQLException {
						List<OrderDetailResponse> ordersHistoryList = new ArrayList<OrderDetailResponse>();
						while (rs.next()) {

						}
						return null;
					}

				});
		logger.debug("Exiting from retrieveCustomerOrdersHistory()");
		return null;
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

	private MapSqlParameterSource orderItemDetailMap(Menu menu, Long orderId) {
		MapSqlParameterSource orderedMenu = new MapSqlParameterSource();
		orderedMenu.addValue("order_id", orderId);
		orderedMenu.addValue("menu_item_id", menu.getMenuId());
		orderedMenu.addValue("item_name", menu.getName());
		orderedMenu.addValue("quantity", menu.getQuantity());
		orderedMenu.addValue("price", menu.getPrice());
		orderedMenu.addValue("special_ins", menu.getSpecialInstruction());
		orderedMenu.addValue("spice_level", menu.getSpiceLevel());
		orderedMenu.addValue("createdby", 12312321);
		// orderedMenu.addValue("createddate", new
		// Date(System.currentTimeMillis()));
		orderedMenu.addValue("menu_item_size", menu.getItemSize());
		return orderedMenu;
	}
}
