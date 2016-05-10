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
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3430236567729063503L;
	@JsonProperty("menu_id")
	private String menuId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("spiceLevel")
	private String spiceLevel;
	@JsonProperty("specialInstruction")
	private String specialInstruction;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("cuisine_id")
	private Integer cuisineId;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The menuId
	 */
	@JsonProperty("menu_id")
	public String getMenuId() {
		return menuId;
	}

	/**
	 * 
	 * @param menuId
	 *            The menu_id
	 */
	@JsonProperty("menu_id")
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

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
	 * @return The price
	 */
	@JsonProperty("price")
	public Double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 *            The price
	 */
	@JsonProperty("price")
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * 
	 * @return The spiceLevel
	 */
	@JsonProperty("spiceLevel")
	public String getSpiceLevel() {
		return spiceLevel;
	}

	/**
	 * 
	 * @param spiceLevel
	 *            The spiceLevel
	 */
	@JsonProperty("spiceLevel")
	public void setSpiceLevel(String spiceLevel) {
		this.spiceLevel = spiceLevel;
	}

	/**
	 * 
	 * @return The specialInstruction
	 */
	@JsonProperty("specialInstruction")
	public String getSpecialInstruction() {
		return specialInstruction;
	}

	/**
	 * 
	 * @param specialInstruction
	 *            The specialInstruction
	 */
	@JsonProperty("specialInstruction")
	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	/**
	 * 
	 * @return The quantity
	 */
	@JsonProperty("quantity")
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 *            The quantity
	 */
	@JsonProperty("quantity")
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @return The cuisineId
	 */
	@JsonProperty("cuisine_id")
	public Integer getCuisineId() {
		return cuisineId;
	}

	/**
	 * 
	 * @param cuisineId
	 *            The cuisine_id
	 */
	@JsonProperty("cuisine_id")
	public void setCuisineId(Integer cuisineId) {
		this.cuisineId = cuisineId;
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