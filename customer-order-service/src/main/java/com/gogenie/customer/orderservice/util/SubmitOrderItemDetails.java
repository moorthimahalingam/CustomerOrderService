package com.gogenie.customer.orderservice.util;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.gogenie.customer.orderservice.model.Menu;

public class SubmitOrderItemDetails extends StoredProcedure {
	
	private static final String ITEM_DETAIL_STORED_PROC = "post_order_item_detail";
	Logger logger = LoggerFactory.getLogger(SubmitOrderItemDetails.class);
	
	public SubmitOrderItemDetails (DataSource dataSource) {
		super(dataSource, ITEM_DETAIL_STORED_PROC);
		logger.debug("Entering into the SubmitOrderItemDetails constructor ()");
		declareParameter(new SqlParameter("order_id", Types.BIGINT));
		declareParameter(new SqlParameter("menu_item_id", Types.BIGINT));
		declareParameter(new SqlParameter("item_name", Types.VARCHAR));
		declareParameter(new SqlParameter("quantity", Types.INTEGER));
		declareParameter(new SqlParameter("price", Types.FLOAT));
		declareParameter(new SqlParameter("special_ins", Types.VARCHAR));
		declareParameter(new SqlParameter("spice_level", Types.INTEGER));
		declareParameter(new SqlParameter("menu_item_size", Types.INTEGER));
		declareParameter(new SqlParameter("createdby" , Types.VARCHAR));
		declareParameter(new SqlParameter("createddate",  Types.DATE));
		declareParameter(new SqlOutParameter("estatus" , Types.VARCHAR));
		declareParameter(new SqlOutParameter("sstatus" , Types.VARCHAR));
		compile();
		logger.debug("Exiting from the SubmitOrderItemDetails constructor ()");
	}

	public Map<String, Object> submitMenuOrderItemDetails(Menu menu, Long orderId) {
		logger.debug("Entering into the submitMenuOrderItemDetails ()");
		Map <String, Object> menuItems = new HashMap<String, Object>();
		menuItems.put("order_id", orderId);
		menuItems.put("menu_item_id", menu.getMenuId());
		menuItems.put("item_name", menu.getName());
		menuItems.put("quantity", menu.getQuantity());
		menuItems.put("price", menu.getPrice());
		menuItems.put("special_ins", menu.getSpecialInstruction());
		menuItems.put("spice_level", menu.getSpiceLevel());
		menuItems.put("menu_item_size", menu.getItemSize());
		menuItems.put("createdby", "121232");
		menuItems.put("createddate", new java.sql.Date(new Date().getTime()));
		
		logger.debug("Value will be inserted into Order item details {}" , menuItems.toString());
		Map<String, Object> result = super.execute(menuItems);
		
		logger.debug("Order item details result {}" , result.toString());
		
		logger.debug("Exiting from the submitMenuOrderItemDetails()");
		return result;
	}
}
