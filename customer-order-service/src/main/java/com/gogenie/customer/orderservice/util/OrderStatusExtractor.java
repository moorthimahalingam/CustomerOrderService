package com.gogenie.customer.orderservice.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.gogenie.customer.orderservice.model.Menu;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;

public class OrderStatusExtractor implements ResultSetExtractor<OrderDetailResponse> {

	public OrderDetailResponse extractData(ResultSet rs) throws SQLException, DataAccessException {
		OrderDetailResponse response = new OrderDetailResponse();
		List<Menu> menus = new ArrayList<Menu>();
		while (rs.next()) {
			response.setOrderId(rs.getLong("ORDER_ID"));
			response.setRestaurantId(rs.getInt("RESTAURANT_ID"));
			response.setOrderStatusId(rs.getInt("ORDER_STATUS_ID"));
			response.setCustomerId(rs.getInt("CUST_ID"));
			response.setPaymentType(rs.getString("PAYMENT_TYPE"));
			response.setPaymentStatus(rs.getString("PAYMENT_STATUS"));
			response.setSpecialInstrn(rs.getString("SPECIAL_INS"));
			response.setTotalPrice(rs.getDouble("TOTAL_AMOUNT"));
			response.setDiscount(rs.getDouble("DISCOUNT"));
//			co.CREATEDDATE,
			response.setDeliveryRequestDate(rs.getDate("DELIVERY_REQUEST_DATE"));
			response.setDeliveryRequestTime(rs.getTime("DELIVERY_REQUEST_TIME"));
			response.setVatAmount(rs.getDouble("VAT_AMOUNT"));
			response.setServiceCharge(rs.getDouble("SERVICE_CHARGE"));
			response.setDeliveryFee(rs.getDouble("DELIVERY_FEE"));
			response.setCardTxnFee(rs.getDouble("CARD_TXN_FEE"));
			response.setOrderId(rs.getLong("ORDER_ID"));
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
			menus.add(menu);
		}
		response.setMenus(menus);
		return response;
	}
}
