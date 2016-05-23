package com.gogenie.customer.orderservice.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.gogenie.customer.orderservice.dao.OrderTrackingDAO;
import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;
import com.gogenie.customer.orderservice.service.OrderTrackingService;

@Named
@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {

	@Inject
	OrderTrackingDAO serviceDao;

	public OrderDetailResponse submitAnOrder(SubmitOrder request) throws CustomerOrderServiceException {
		OrderDetailResponse response = serviceDao.submitAnOrder(request);
		return response;
	}

	public OrderDetailResponse trackAnExistingOrder(Integer orderId) throws CustomerOrderServiceException {
		OrderDetailResponse response = serviceDao.orderStatusOfAnExistingOrder(orderId);
		return response;
	}

	public List<OrderDetailResponse> historyOfOrders(Integer customerId) throws CustomerOrderServiceException {
		List<OrderDetailResponse> history = serviceDao.retrieveCustomerOrdersHistory(customerId);
		return history;
	}

	public String addOrderAsCustomerFav(Integer customerId, Integer orderId) throws CustomerOrderServiceException {
		String addOrderFav = serviceDao.addOrderAsCustomerFav(customerId, orderId);
		return addOrderFav;
	}

}
