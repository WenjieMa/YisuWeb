package com.pojo;

/**
 * AddressDistrict entity. @author MyEclipse Persistence Tools
 */

public class AddressDistrict implements java.io.Serializable {

	// Fields

	private Integer disId;
	private AddressCity addressCity;
	private String disName;

	// Constructors

	/** default constructor */
	public AddressDistrict() {
	}

	/** minimal constructor */
	public AddressDistrict(AddressCity addressCity) {
		this.addressCity = addressCity;
	}

	/** full constructor */
	public AddressDistrict(AddressCity addressCity, String disName) {
		this.addressCity = addressCity;
		this.disName = disName;
	}

	// Property accessors

	public Integer getDisId() {
		return this.disId;
	}

	public void setDisId(Integer disId) {
		this.disId = disId;
	}

	public AddressCity getAddressCity() {
		return this.addressCity;
	}

	public void setAddressCity(AddressCity addressCity) {
		this.addressCity = addressCity;
	}

	public String getDisName() {
		return this.disName;
	}

	public void setDisName(String disName) {
		this.disName = disName;
	}

}