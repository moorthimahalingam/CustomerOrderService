package com.gogenie.customer.orderservice.model;

import java.sql.Date;
import java.sql.Time;
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
	private Long orderId;
	@JsonProperty("customer_id")
	private Integer customerId;
	@JsonProperty("restaurant_id")
	private Integer restaurantId;
	@JsonProperty("machinfo")
	private String machinfo;
	@JsonProperty("orderstatus")
	private String orderstatus;
	@JsonProperty("order_status_id")
	private Integer orderStatusId;
	@JsonProperty("Menus")
	private List<Menu> Menus = new ArrayList<Menu>();
	@JsonProperty("total_price")
	private Double totalPrice;
	@JsonProperty("salesTax")
	private Double salesTax;
	@JsonProperty("cardInformation")
	private CardInformation cardInformation;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonProperty("payment_type")
	private String paymentType;
	@JsonProperty("payment_status")
	private String paymentStatus;
	@JsonProperty("special_instruction")
	private String specialInstrn;
	@JsonProperty("discount")
	private Double discount;
	@JsonProperty("delivery_request_date")
	private Date deliveryRequestDate;
	@JsonProperty("delivery_request_time")
	private Time deliveryRequestTime;
	@JsonProperty("vat_amount")
	private Double vatAmount;
	@JsonProperty("service_charge")
	private Double serviceCharge;
	@JsonProperty("delivery_fee")
	private Double deliveryFee;
	@JsonProperty("card_txn_fee")
	private Double cardTxnFee;
	@JsonProperty("contact_phone")
	private String contactPhone;
	
	
	/**
	 * 
	 * @return The orderId
	 */
	@JsonProperty("order_id")
	public Long getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * @param orderId
	 *            The order_id
	 */
	@JsonProperty("order_id")
	public void setOrderId(Long orderId) {
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

	@JsonProperty("payment_type")
	public String getPaymentType() {
		return paymentType;
	}

	@JsonProperty("payment_type")
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	@JsonProperty("payment_status")
	public String getPaymentStatus() {
		return paymentStatus;
	}

	@JsonProperty("payment_status")
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@JsonProperty("special_instruction")
	public String getSpecialInstrn() {
		return specialInstrn;
	}

	@JsonProperty("special_instruction")
	public void setSpecialInstrn(String specialInstrn) {
		this.specialInstrn = specialInstrn;
	}

	@JsonProperty("discount")
	public Double getDiscount() {
		return discount;
	}

	@JsonProperty("discount")
	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	@JsonProperty("delivery_request_date")
	public Date getDeliveryRequestDate() {
		return deliveryRequestDate;
	}

	@JsonProperty("delivery_request_date")
	public void setDeliveryRequestDate(Date deliveryRequestDate) {
		this.deliveryRequestDate = deliveryRequestDate;
	}

	@JsonProperty("delivery_request_time")
	public Time getDeliveryRequestTime() {
		return deliveryRequestTime;
	}

	@JsonProperty("delivery_request_time")
	public void setDeliveryRequestTime(Time deliveryRequestTime) {
		this.deliveryRequestTime = deliveryRequestTime;
	}

	@JsonProperty("vat_amount")
	public Double getVatAmount() {
		return vatAmount;
	}

	@JsonProperty("vat_amount")
	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	@JsonProperty("service_charge")
	public Double getServiceCharge() {
		return serviceCharge;
	}

	@JsonProperty("service_charge")
	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	@JsonProperty("card_txn_fee")
	public Double getCardTxnFee() {
		return cardTxnFee;
	}

	@JsonProperty("card_txn_fee")
	public void setCardTxnFee(Double cardTxnFee) {
		this.cardTxnFee = cardTxnFee;
	}

	@JsonProperty("contact_phone")
	public String getContactPhone() {
		return contactPhone;
	}

	@JsonProperty("contact_phone")
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@JsonProperty("order_status_id")
	public Integer getOrderStatusId() {
		return orderStatusId;
	}

	@JsonProperty("order_status_id")
	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	@JsonProperty("delivery_fee")
	public Double getDeliveryFee() {
		return deliveryFee;
	}

	@JsonProperty("delivery_fee")
	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
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
