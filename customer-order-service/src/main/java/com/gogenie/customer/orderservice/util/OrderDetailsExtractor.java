package com.gogenie.customer.orderservice.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.gogenie.customer.orderservice.model.Menu;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;

public class OrderDetailsExtractor implements ResultSetExtractor<List<OrderDetailResponse>> {

	Logger logger = LoggerFactory.getLogger(OrderDetailsExtractor.class);

	public List<OrderDetailResponse> extractData(ResultSet rs) throws SQLException, DataAccessException {
		logger.debug("Entering into extractData ()");
		List<OrderDetailResponse> orders = new ArrayList<OrderDetailResponse>();
		List<Menu> menus = null;
		List<Long> orderIds = new ArrayList<Long>();
		Map<Long, OrderDetailResponse> orderIdMap = new HashMap<Long, OrderDetailResponse>();
		while (rs.next()) {
			OrderDetailResponse response = null;
			Long orderId = rs.getLong("ORDER_ID");
			if (orderIdMap.get(orderId) != null) {
				response = orderIdMap.get(orderId);
			} else {
				orderIds.add(orderId);
				response = new OrderDetailResponse();
				response.setOrderId(rs.getLong("ORDER_ID"));
				response.setRestaurantId(rs.getInt("RESTAURANT_ID"));
				response.setOrderStatusId(rs.getInt("ORDER_STATUS_ID"));
				response.setCustomerId(rs.getInt("CUST_ID"));
				response.setPaymentType(rs.getString("PAYMENT_TYPE"));
				response.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
				response.setSpecialInstrn(rs.getString("SPECIAL_INS"));
				response.setTotalPrice(rs.getDouble("TOTAL_AMOUNT"));
				response.setDiscount(rs.getDouble("DISCOUNT"));
//				co.CREATEDDATE,
				response.setDeliveryRequestDate(rs.getDate("DELIVERY_REQUEST_DATE"));
				response.setDeliveryRequestTime(rs.getTime("DELIVERY_REQUEST_TIME"));
				response.setVatAmount(rs.getDouble("VAT_AMOUNT"));
				response.setServiceCharge(rs.getDouble("SERVICE_CHARGE"));
				response.setDeliveryFee(rs.getDouble("DELIVERY_FEE"));
				response.setCardTxnFee(rs.getDouble("CARD_TXN_FEE"));
				response.setOrderId(rs.getLong("ORDER_ID"));
			}
			Menu menu = new Menu();
			menu.setMenuId(rs.getInt("MENU_ITEM_ID"));
			menu.setName(rs.getString("ITEM_NAME"));
			menu.setQuantity(rs.getInt("QUANTITY"));
			menu.setPrice(rs.getDouble("PRICE"));
			menu.setSpecialInstruction(rs.getString("SPECIAL_INS"));
			menu.setSpiceLevel(rs.getInt("SPICE_LEVEL"));
//			oid.CREATEDDATE,
//			oid.UPDATEDDATE,
//			oid.ORDER_ITEM_DETAILID ,
			menu.setItemSize(rs.getInt("MENU_ITEM_SIZE"));
			menus = response.getMenus();
			if (menus == null || menus.isEmpty()) {
				menus = new ArrayList<Menu>();
			}
			menus.add(menu);
			response.setMenus(menus);
			orderIdMap.put(orderId, response);
//			orders.add(response);
		}
		
		for (Long orderId : orderIds) {
			orders.add(orderIdMap.get(orderId));
		}
		logger.debug("Exiting from extractData ()");
		return orders;
	}

}
