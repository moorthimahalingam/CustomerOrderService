package com.gogenie.customer.orderservice.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_EMPTY)
public class OrderDetailResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 350995320542034436L;
	
	@JsonProperty("order_id")
	private Long orderId;
	@JsonProperty("customer_id")
	private Integer customerId;
	@JsonProperty("order_status")
	private String orderStatus;
	@JsonProperty("Menus")
	private List<Menu> Menus = new ArrayList<Menu>();

	@JsonProperty("restaurant_id")
	private Integer restaurantId;
	@JsonProperty("machinfo")
	private String machinfo;
	@JsonProperty("orderstatus")
	private String orderstatus;
	@JsonProperty("order_status_id")
	private Integer orderStatusId;
	@JsonProperty("total_price")
	private Double totalPrice;
	@JsonProperty("salesTax")
	private Double salesTax;
	@JsonProperty("cardInformation")
	private CardInformation cardInformation;
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
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	
	@JsonProperty("order_id")
	public Long getOrderId() {
		return orderId;
	}

	@JsonProperty("order_id")
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	@JsonProperty("customer_id")
	public Integer getCustomerId() {
		return customerId;
	}

	@JsonProperty("customer_id")
	public void setCustomerId(Integer customerId) {
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

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getMachinfo() {
		return machinfo;
	}

	public void setMachinfo(String machinfo) {
		this.machinfo = machinfo;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public Integer getOrderStatusId() {
		return orderStatusId;
	}

	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getSalesTax() {
		return salesTax;
	}

	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}

	public CardInformation getCardInformation() {
		return cardInformation;
	}

	public void setCardInformation(CardInformation cardInformation) {
		this.cardInformation = cardInformation;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getSpecialInstrn() {
		return specialInstrn;
	}

	public void setSpecialInstrn(String specialInstrn) {
		this.specialInstrn = specialInstrn;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Date getDeliveryRequestDate() {
		return deliveryRequestDate;
	}

	public void setDeliveryRequestDate(Date deliveryRequestDate) {
		this.deliveryRequestDate = deliveryRequestDate;
	}

	public Time getDeliveryRequestTime() {
		return deliveryRequestTime;
	}

	public void setDeliveryRequestTime(Time deliveryRequestTime) {
		this.deliveryRequestTime = deliveryRequestTime;
	}

	public Double getVatAmount() {
		return vatAmount;
	}

	public void setVatAmount(Double vatAmount) {
		this.vatAmount = vatAmount;
	}

	public Double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(Double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public Double getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(Double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}

	public Double getCardTxnFee() {
		return cardTxnFee;
	}

	public void setCardTxnFee(Double cardTxnFee) {
		this.cardTxnFee = cardTxnFee;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	
}
