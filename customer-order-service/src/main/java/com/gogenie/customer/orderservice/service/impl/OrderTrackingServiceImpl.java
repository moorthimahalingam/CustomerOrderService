package com.gogenie.customer.orderservice.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gogenie.customer.orderservice.dao.OrderTrackingDAO;
import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;
import com.gogenie.customer.orderservice.service.OrderTrackingService;

@Named
@Service
public class OrderTrackingServiceImpl implements OrderTrackingService {

	Logger logger = LoggerFactory.getLogger(OrderTrackingServiceImpl.class);
	
	@Inject
	OrderTrackingDAO orderServiceDao;

	public OrderDetailResponse submitAnOrder(SubmitOrder request) throws CustomerOrderServiceException {
		logger.debug("Entering into submitAnOrder()");
		OrderDetailResponse response = orderServiceDao.submitAnOrder(request);
		logger.debug("Exiting from submitAnOrder()");
		return response;
	}

	public OrderDetailResponse trackAnExistingOrder(Long orderId) throws CustomerOrderServiceException {
		logger.debug("Entering into trackAnExistingOrder()");
		OrderDetailResponse response = orderServiceDao.orderStatusOfAnExistingOrder(orderId);
		logger.debug("Exiting from trackAnExistingOrder()");
		return response;
	}

	public List<OrderDetailResponse> historyOfOrders(Integer customerId) throws CustomerOrderServiceException {
		logger.debug("Entering into historyOfOrders()");
		List<OrderDetailResponse> history = orderServiceDao.retrieveCustomerOrdersHistory(customerId);
		logger.debug("Exiting from historyOfOrders()");
		return history;
	}

	public String addOrderAsCustomerFav(Integer customerId, Long orderId) throws CustomerOrderServiceException {
		logger.debug("Entering into addOrderAsCustomerFav()");
		String addOrderFav = orderServiceDao.addOrderAsCustomerFav(customerId, orderId);
		logger.debug("Exiting from addOrderAsCustomerFav()");
		return addOrderFav;
	}

}
