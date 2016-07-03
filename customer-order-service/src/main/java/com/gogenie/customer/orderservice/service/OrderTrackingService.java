package com.gogenie.customer.orderservice.service;

import java.util.List;

import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;

public interface OrderTrackingService {

	public OrderDetailResponse submitAnOrder(SubmitOrder request) throws CustomerOrderServiceException;

	public OrderDetailResponse trackAnExistingOrder(Long orderId) throws CustomerOrderServiceException;
	
	public List<OrderDetailResponse> historyOfOrders(Integer customerId) throws CustomerOrderServiceException;
	
	public String addOrderAsCustomerFav(Integer customerId, Long orderId) throws CustomerOrderServiceException;

}

