package com.gogenie.customer.orderservice.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OrderDetailResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 350995320542034436L;
	
	@JsonProperty("order_id")
	private Long orderId;

	@JsonProperty("customer_id")
	private String customerId;

	@JsonProperty("order_status")
	private String orderStatus;

	@JsonProperty("Menus")
	private List<Menu> Menus = new ArrayList<Menu>();
	
	@JsonProperty("order_id")
	public Long getOrderId() {
		return orderId;
	}

	@JsonProperty("order_id")
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@JsonProperty("customer_id")
	public String getCustomerId() {
		return customerId;
	}

	@JsonProperty("customer_id")
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@JsonProperty("order_status")
	public String getOrderStatus() {
		return orderStatus;
	}

	@JsonProperty("order_status")
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	
	/**
	 * 
	 * @return The Menus
	 */
	@JsonProperty("Menus")
	public List<Menu> getMenus() {
		return Menus;
	}

	/**
	 * 
	 * @param Menus
	 *            The Menus
	 */
	@JsonProperty("Menus")
	public void setMenus(List<Menu> Menus) {
		this.Menus = Menus;
	}

}
