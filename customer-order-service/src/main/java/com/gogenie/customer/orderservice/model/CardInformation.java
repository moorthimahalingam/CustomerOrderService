package com.gogenie.customer.orderservice.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CardInformation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2282964002499808087L;
	@JsonProperty("name")
	private String name;
	@JsonProperty("creditcardnumber")
	private Integer creditcardnumber;
	@JsonProperty("expirydate")
	private String expirydate;
	@JsonProperty("cvv")
	private Integer cvv;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return The creditcardnumber
	 */
	@JsonProperty("creditcardnumber")
	public Integer getCreditcardnumber() {
		return creditcardnumber;
	}

	/**
	 * 
	 * @param creditcardnumber
	 *            The creditcardnumber
	 */
	@JsonProperty("creditcardnumber")
	public void setCreditcardnumber(Integer creditcardnumber) {
		this.creditcardnumber = creditcardnumber;
	}

	/**
	 * 
	 * @return The expirydate
	 */
	@JsonProperty("expirydate")
	public String getExpirydate() {
		return expirydate;
	}

	/**
	 * 
	 * @param expirydate
	 *            The expirydate
	 */
	@JsonProperty("expirydate")
	public void setExpirydate(String expirydate) {
		this.expirydate = expirydate;
	}

	/**
	 * 
	 * @return The cvv
	 */
	@JsonProperty("cvv")
	public Integer getCvv() {
		return cvv;
	}

	/**
	 * 
	 * @param cvv
	 *            The cvv
	 */
	@JsonProperty("cvv")
	public void setCvv(Integer cvv) {
		this.cvv = cvv;
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