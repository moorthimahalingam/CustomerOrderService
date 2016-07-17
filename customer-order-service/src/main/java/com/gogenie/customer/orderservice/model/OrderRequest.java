package com.gogenie.customer.orderservice.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class OrderRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7713686254508058122L;

}
