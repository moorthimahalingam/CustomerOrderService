package com.gogenie.customer.orderservice.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.sql.DataSource;

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
	private DataSource orderTrackingSource;

	private SimpleJdbcCall jdbcCall;

	private JdbcTemplate jdbcTemplate;

	@PostConstruct
	private void setupDataSource() {
		jdbcTemplate = new JdbcTemplate(orderTrackingSource);

	}

	public OrderDetailResponse submitAnOrder(SubmitOrder request) throws CustomerOrderServiceException {
		OrderDetailResponse orderDetailResponse = null;
		try {
			jdbcCall = new SimpleJdbcCall(jdbcTemplate);

			SimpleJdbcInsert submitOrder = new SimpleJdbcInsert(jdbcTemplate).withTableName("customer_order_detail")
					.usingGeneratedKeyColumns("order_id");
			Number generated_orderId = submitOrder.executeAndReturnKey(orderDataMap(request));
			orderDetailResponse = new OrderDetailResponse();
			orderDetailResponse.setOrderId(generated_orderId.intValue());
		} catch (Exception e) {
			throw new CustomerOrderServiceException(e, "submitAnOrder");
		}
		return orderDetailResponse;
	}

	public OrderDetailResponse orderStatusOfAnExistingOrder(Integer orderId) throws CustomerOrderServiceException {
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
		return response;
	}

	public List<OrderDetailResponse> retrieveCustomerOrdersHistory(Integer customerId)
			throws CustomerOrderServiceException {
		jdbcTemplate.queryForObject("select * from customer_order_detail where cust_id=?", new Object[] { customerId },
				new RowMapper<List<OrderDetailResponse>>() {
					public List<OrderDetailResponse> mapRow(ResultSet rs, int rowNum) throws SQLException {
						return null;
					}

				});
		// TODO Auto-generated method stub
		return null;
	}

	public String addOrderAsCustomerFav(Integer customerId, Integer orderId) throws CustomerOrderServiceException {
		SimpleJdbcInsert addCustFavOrder = new SimpleJdbcInsert(orderTrackingSource).withTableName("cust_fav_order");
		Map<String, Object> favorites = new HashMap<String, Object>();
		favorites.put("cust_id", customerId);
		favorites.put("order_id", orderId);
		return null;
	}

	private Map<String, String> orderDataMap(SubmitOrder request) {
		return null;
	}
}
