package com.gogenie.customer.orderservice.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class SubmitOrder {

	@JsonProperty("order_id")
	private String orderId;
	@JsonProperty("customer_id")
	private Integer customerId;
	@JsonProperty("restaurant_id")
	private Integer restaurantId;
	@JsonProperty("machinfo")
	private String machinfo;
	@JsonProperty("orderstatus")
	private String orderstatus;
	@JsonProperty("Menus")
	private List<Menu> Menus = new ArrayList<Menu>();
	@JsonProperty("totalPrice")
	private Double totalPrice;
	@JsonProperty("salesTax")
	private Double salesTax;
	@JsonProperty("cardInformation")
	private CardInformation cardInformation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The orderId
	 */
	@JsonProperty("order_id")
	public String getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * @param orderId
	 *            The order_id
	 */
	@JsonProperty("order_id")
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 * 
	 * @return The customerId
	 */
	@JsonProperty("customer_id")
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * 
	 * @param customerId
	 *            The customer_id
	 */
	@JsonProperty("customer_id")
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * 
	 * @return The restaurantId
	 */
	@JsonProperty("restaurant_id")
	public Integer getRestaurantId() {
		return restaurantId;
	}

	/**
	 * 
	 * @param restaurantId
	 *            The restaurant_id
	 */
	@JsonProperty("restaurant_id")
	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	/**
	 * 
	 * @return The machinfo
	 */
	@JsonProperty("machinfo")
	public String getMachinfo() {
		return machinfo;
	}

	/**
	 * 
	 * @param machinfo
	 *            The machinfo
	 */
	@JsonProperty("machinfo")
	public void setMachinfo(String machinfo) {
		this.machinfo = machinfo;
	}

	/**
	 * 
	 * @return The orderstatus
	 */
	@JsonProperty("orderstatus")
	public String getOrderstatus() {
		return orderstatus;
	}

	/**
	 * 
	 * @param orderstatus
	 *            The orderstatus
	 */
	@JsonProperty("orderstatus")
	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
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

	/**
	 * 
	 * @return The totalPrice
	 */
	@JsonProperty("totalPrice")
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 
	 * @param totalPrice
	 *            The totalPrice
	 */
	@JsonProperty("totalPrice")
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * 
	 * @return The salesTax
	 */
	@JsonProperty("salesTax")
	public Double getSalesTax() {
		return salesTax;
	}

	/**
	 * 
	 * @param salesTax
	 *            The salesTax
	 */
	@JsonProperty("salesTax")
	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}

	/**
	 * 
	 * @return The cardInformation
	 */
	@JsonProperty("cardInformation")
	public CardInformation getCardInformation() {
		return cardInformation;
	}

	/**
	 * 
	 * @param cardInformation
	 *            The cardInformation
	 */
	@JsonProperty("cardInformation")
	public void setCardInformation(CardInformation cardInformation) {
		this.cardInformation = cardInformation;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
