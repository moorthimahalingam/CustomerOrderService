package com.gogenie.customer.orderservice.dao;

import java.util.List;

import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;

public interface OrderTrackingDAO {

	public OrderDetailResponse submitAnOrder(SubmitOrder request) throws CustomerOrderServiceException;

	public OrderDetailResponse orderStatusOfAnExistingOrder(Integer orderId) throws CustomerOrderServiceException;
	
	public List<OrderDetailResponse> retrieveCustomerOrdersHistory(Integer customerId) throws CustomerOrderServiceException;
	
	public String addOrderAsCustomerFav(Integer customerId, Integer orderId) throws CustomerOrderServiceException;

}
