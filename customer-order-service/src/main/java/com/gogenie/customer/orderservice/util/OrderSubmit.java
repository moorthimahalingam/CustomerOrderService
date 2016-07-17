package com.gogenie.customer.orderservice.util;

import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.gogenie.customer.orderservice.model.SubmitOrder;

public class OrderSubmit extends StoredProcedure {

	Logger logger = LoggerFactory.getLogger(OrderSubmit.class);

	private static final String PROC_NAME = "post_customer_order";

	@Inject
	public OrderSubmit(DataSource dataSource) {
		super(dataSource, PROC_NAME);
		logger.debug("Entering into OrderSubmit() constructor ");
		declareParameter(new SqlParameter("restaurant_id", Types.BIGINT));
		declareParameter(new SqlParameter("order_status_id", Types.BIGINT));
		declareParameter(new SqlParameter("cust_id", Types.INTEGER));
		declareParameter(new SqlParameter("payment_type", Types.VARCHAR));
		declareParameter(new SqlParameter("payment_status", Types.VARCHAR));
		declareParameter(new SqlParameter("special_ins", Types.VARCHAR));
		declareParameter(new SqlParameter("total_amount", Types.FLOAT));
		declareParameter(new SqlParameter("discount", Types.FLOAT));
		declareParameter(new SqlParameter("delivery_request_date", Types.DATE));
		declareParameter(new SqlParameter("delivery_request_time", Types.TIME));
		declareParameter(new SqlParameter("vat_amount", Types.FLOAT));
		declareParameter(new SqlParameter("service_charge", Types.FLOAT));
		declareParameter(new SqlParameter("delivery_fee", Types.FLOAT));
		declareParameter(new SqlParameter("card_txn_fee", Types.FLOAT));
		declareParameter(new SqlParameter("createdby", Types.VARCHAR));
		declareParameter(new SqlParameter("createddate", Types.DATE));
		declareParameter(new SqlParameter("contact_phone", Types.VARCHAR));
		declareParameter(new SqlOutParameter("returnOrderId", Types.BIGINT));
		declareParameter(new SqlOutParameter("error_status", Types.VARCHAR));
		compile();
		logger.debug("Exiting from OrderSubmit() constructor ");
	}

	public Map<String, Object> submitOrderExecute(SubmitOrder request) {
		logger.debug("Entering into submitOrderExecute()");
		Map<String, Object> newOrderDetails = new HashMap<String, Object>();
		newOrderDetails.put("restaurant_id", request.getRestaurantId());
		newOrderDetails.put("order_status_id", request.getOrderStatusId());
		newOrderDetails.put("cust_id", request.getCustomerId());
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
		newOrderDetails.put("card_txn_fee", request.getCardTxnFee());
		newOrderDetails.put("createdby", "12312321");
		newOrderDetails.put("createddate", new java.sql.Date(new Date().getTime()));
		newOrderDetails.put("contact_phone", request.getContactPhone());
		Map<String, Object> orderResults = super.execute(newOrderDetails);
		logger.debug("Exiting from submitOrderExecute()");
		return orderResults;
	}

}
