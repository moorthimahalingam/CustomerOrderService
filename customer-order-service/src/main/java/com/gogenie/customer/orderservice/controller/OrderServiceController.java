package com.gogenie.customer.orderservice.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;
import com.gogenie.customer.orderservice.service.OrderTrackingService;

@RestController
public class OrderServiceController {

	@Inject
	OrderTrackingService service;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public OrderDetailResponse submitAnOrder(@RequestBody SubmitOrder request, BindingResult result)
			throws CustomerOrderServiceException {
		OrderDetailResponse response = service.submitAnOrder(request);
		return response;
	}

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public List<OrderDetailResponse> retrieveCustomerOrderHistory(@RequestParam(value = "customerId") Integer customerId)
			throws CustomerOrderServiceException {
		List<OrderDetailResponse> listOfOrders = service.historyOfOrders(customerId);
		return listOfOrders;
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public OrderDetailResponse retrieveOrderCurrentStatus(@RequestParam(value = "orderId") Integer orderId)
			throws CustomerOrderServiceException {
		OrderDetailResponse response = service.trackAnExistingOrder(orderId);
		return response;
	}

	@RequestMapping(value = "/addToFavorite", method = RequestMethod.PUT)
	public String addOrderAsFavorite(@RequestParam(value = "orderId") Integer orderId,
			@RequestParam(value = "customerId") Integer customerId) throws CustomerOrderServiceException {
		String status = service.addOrderAsCustomerFav(customerId, orderId);
		return status;
	}

	@RequestMapping(value = "/reorder", method = RequestMethod.POST)
	public OrderDetailResponse submitOneMoreOrderUsingExistingOrderDetails(@RequestBody SubmitOrder request, BindingResult result)
			throws CustomerOrderServiceException {
		OrderDetailResponse reponse = service.submitAnOrder(request);
		return reponse;
	}

}
