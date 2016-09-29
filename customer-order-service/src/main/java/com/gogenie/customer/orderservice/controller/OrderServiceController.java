package com.gogenie.customer.orderservice.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.OrderDetailResponse;
import com.gogenie.customer.orderservice.model.SubmitOrder;
import com.gogenie.customer.orderservice.service.OrderTrackingService;

@RestController
public class OrderServiceController {

	Logger logger = LoggerFactory.getLogger(OrderServiceController.class);

	@Inject
	OrderTrackingService service;

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public OrderDetailResponse submitAnOrder(@RequestBody SubmitOrder request, BindingResult result)
			throws CustomerOrderServiceException {
		logger.debug("Entering into submitAnOrder()");
		OrderDetailResponse response = service.submitAnOrder(request);
		logger.debug("Exiting from submitAnOrder()");
		return response;
	}

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public List<OrderDetailResponse> retrieveCustomerOrderHistory(
			@RequestParam(value = "customer_id", required = true) Integer customerId)
			throws CustomerOrderServiceException {
		logger.debug("Entering into retrieveCustomerOrderHistory()");
		List<OrderDetailResponse> listOfOrders = service.historyOfOrders(customerId);
		logger.debug("Exiting from retrieveCustomerOrderHistory()");
		return listOfOrders;
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public OrderDetailResponse retrieveOrderCurrentStatus(
			@RequestParam(value = "order_id", required = true) Long orderId) throws CustomerOrderServiceException {
		logger.debug("Entering into retrieveOrderCurrentStatus()");
		OrderDetailResponse response = service.trackAnExistingOrder(orderId);
		logger.debug("Exiting from retrieveOrderCurrentStatus()");
		return response;
	}

	@RequestMapping(value = "/addToFavorite", method = RequestMethod.PUT)
	public String addOrderAsFavorite(@RequestParam(value = "order_id", required = true) Long orderId,
			@RequestParam(value = "customer_id", required = true) Integer customerId)
			throws CustomerOrderServiceException {
		logger.debug("Entering into addOrderAsFavorite()");
		String status = service.addOrderAsCustomerFav(customerId, orderId);
		logger.debug("Exiting from addOrderAsFavorite()");
		status = "Order id " + orderId + " is added in your favorite list";
		return "{\"responseText\": \"" + status + "\"}";
	}

	@RequestMapping(value = "/reorder", method = RequestMethod.POST)
	public OrderDetailResponse submitOneMoreOrderUsingExistingOrderDetails(@RequestBody SubmitOrder request,
			BindingResult result) throws CustomerOrderServiceException {
		logger.debug("Entering into submitOneMoreOrderUsingExistingOrderDetails()");
		request.setOrderId(null);
		OrderDetailResponse reponse = service.submitAnOrder(request);
		logger.debug("Exiting from submitOneMoreOrderUsingExistingOrderDetails()");
		return reponse;
	}

	@ExceptionHandler(CustomerOrderServiceException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public String exceptionHandler(CustomerOrderServiceException exception) {
		return "{\"errorResponse\":" + exception.getErrorDesc() + "}";
	}
}
