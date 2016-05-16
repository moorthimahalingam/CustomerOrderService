package com.gogenie.customer.orderservice.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;
import com.gogenie.customer.orderservice.service.OrderTrackingService;

@Named
@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {

	public OrderDetailResponse submitAnOrder(SubmitOrder request) throws CustomerOrderServiceException {
		return null;
	}

	public OrderDetailResponse trackAnExistingOrder(Integer orderId) throws CustomerOrderServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderDetailResponse> historyOfOrders(Integer customerId) throws CustomerOrderServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	public String addOrderAsCustomerFav(Integer customerId, Integer orderId) throws CustomerOrderServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
