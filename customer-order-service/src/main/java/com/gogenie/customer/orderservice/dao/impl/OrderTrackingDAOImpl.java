package com.gogenie.customer.orderservice.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.gogenie.customer.orderservice.dao.OrderTrackingDAO;
import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;

@Repository
public class OrderTrackingDAOImpl implements OrderTrackingDAO {

	@Resource
	private DataSource gogenieDataSource;

	Logger logger = LoggerFactory.getLogger(OrderTrackingDAOImpl.class);

	private SimpleJdbcCall jdbcCall;

	private SimpleJdbcInsert jdbcInsert;

	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	public void setupDataSource() {
		jdbcTemplate = new JdbcTemplate(gogenieDataSource);
		jdbcInsert = new SimpleJdbcInsert(gogenieDataSource);

	}

	public OrderDetailResponse submitAnOrder(SubmitOrder request) throws CustomerOrderServiceException {
		logger.debug("Entering into submitAnOrder()");
		OrderDetailResponse orderDetailResponse = null;
		try {
			jdbcCall = new SimpleJdbcCall(jdbcTemplate);

			jdbcInsert.withTableName("customer_order_detail")
					.usingGeneratedKeyColumns("order_id");
			Number generated_orderId = jdbcInsert.executeAndReturnKey(orderDataMap(request));
			
			orderDetailResponse = new OrderDetailResponse();
			orderDetailResponse.setOrderId(generated_orderId.intValue());
		} catch (Exception e) {
			throw new CustomerOrderServiceException(e, "submitAnOrder");
		}
		logger.debug("Exiting from submitAnOrder()");
		return orderDetailResponse;
	}

	public OrderDetailResponse orderStatusOfAnExistingOrder(Integer orderId) throws CustomerOrderServiceException {
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
						while(rs.next()) {
							
						}
						return null;
					}

				});
		logger.debug("Exiting from retrieveCustomerOrdersHistory()");
		return null;
	}

	public String addOrderAsCustomerFav(Integer customerId, Integer orderId) throws CustomerOrderServiceException {
		logger.debug("Entering into addOrderAsCustomerFav()");
		jdbcInsert.withTableName("cust_fav_order");
		Map<String, Object> favorites = new HashMap<String, Object>();
		favorites.put("cust_id", customerId);
		favorites.put("order_id", orderId);
		logger.debug("Exiting from addOrderAsCustomerFav()");
		return null;
	}

	private Map<String, Object> orderDataMap(SubmitOrder request) {
		logger.debug("Entering into orderDataMap()");
		Map<String, Object> newOrderDetails = new HashMap<String, Object>();
		
		newOrderDetails.put("restaurant_id", request.getRestaurantId());
		newOrderDetails.put("order_status_id", request.getOrderStatusId());
		newOrderDetails.put("payment_type", request.getPaymentType());
		newOrderDetails.put("payment_status", request.getPaymentStatus());
		newOrderDetails.put("special_ins", request.getSpecialInstrn());
		newOrderDetails.put("total_amount", request.getTotalPrice());
		newOrderDetails.put("discount", request.getDiscount());
		newOrderDetails.put("delivery_request_date", request.getDeliveryRequestDate());
		newOrderDetails.put("delivery_request_time", request.getDeliveryRequestTime());
		newOrderDetails.put("vat_amount", request.getVatAmount());
		newOrderDetails.put("service_charge", request.getServiceCharge());
		newOrderDetails.put("delivery_fee", request.getDeliveryFee());
		newOrderDetails.put("createdby", 12312321);
		newOrderDetails.put("createddate", new Date(System.currentTimeMillis()));
		newOrderDetails.put("contact_phone", request.getContactPhone());
		logger.debug("Exiting from orderDataMap()");
		return newOrderDetails;
	}
}
