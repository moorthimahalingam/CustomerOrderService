package com.gogenie.customer.orderservice.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gogenie.customer.orderservice.exception.CustomerOrderServiceException;
import com.gogenie.customer.orderservice.model.SubmitOrder;

@RestController
public class OrderServiceController {

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submitAnOrder(@RequestBody SubmitOrder request, BindingResult result)
			throws CustomerOrderServiceException {
		return null;
	}

	@RequestMapping(value = "/history", method = RequestMethod.GET)
	public String retrieveCustomerOrderHistory(@RequestParam(value = "customerId") Integer customer)
			throws CustomerOrderServiceException {
		return null;
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String retrieveOrderCurrentStatus(@RequestParam(value = "orderId") Integer orderId)
			throws CustomerOrderServiceException {
		return null;
	}

	@RequestMapping(value = "/addToFavorite", method = RequestMethod.PUT)
	public String addOrderAsFavorite(@RequestParam(value = "orderId") Integer orderId,
			@RequestParam(value = "customerId") Integer customerId) throws CustomerOrderServiceException {
		return null;
	}

	@RequestMapping(value = "/reorder", method = RequestMethod.POST)
	public String submitOneMoreOrderUsingExistingOrderDetails(@RequestBody SubmitOrder request, BindingResult result) throws CustomerOrderServiceException {
		return null;
	}

}
