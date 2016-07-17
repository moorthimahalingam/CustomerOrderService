package com.gogenie.customer.orderservice.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(Include.NON_EMPTY)
public class Menu implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3430236567729063503L;
	@JsonProperty("menu_id")
	private Integer menuId;
	@JsonProperty("name")
	private String name;
	@JsonProperty("price")
	private Double price;
	@JsonProperty("spice_level")
	private Integer spiceLevel;
	@JsonProperty("special_instruction")
	private String specialInstruction;
	@JsonProperty("quantity")
	private Integer quantity;
	@JsonProperty("cuisine_id")
	private Integer cuisineId;
	@JsonProperty("item_size")
	private Integer itemSize;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * 
	 * @return The menuId
	 */
	@JsonProperty("menu_id")
	public Integer getMenuId() {
		return menuId;
	}

	/**
	 * 
	 * @param menuId
	 *            The menu_id
	 */
	@JsonProperty("menu_id")
	public void setMenuId(Integer menuId) {
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
	@JsonProperty("spice_level")
	public Integer getSpiceLevel() {
		return spiceLevel;
	}

	/**
	 * 
	 * @param spiceLevel
	 *            The spiceLevel
	 */
	@JsonProperty("spice_level")
	public void setSpiceLevel(Integer spiceLevel) {
		this.spiceLevel = spiceLevel;
	}

	/**
	 * 
	 * @return The specialInstruction
	 */
	@JsonProperty("special_instruction")
	public String getSpecialInstruction() {
		return specialInstruction;
	}

	/**
	 * 
	 * @param specialInstruction
	 *            The specialInstruction
	 */
	@JsonProperty("special_instruction")
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
	
	@JsonProperty("item_size")
	public Integer getItemSize() {
		return itemSize;
	}

	@JsonProperty("item_size")
	public void setItemSize(Integer itemSize) {
		this.itemSize = itemSize;
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