package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * AddressProvince entity. @author MyEclipse Persistence Tools
 */

public class AddressProvince implements java.io.Serializable {

	// Fields

	private Integer proId;
	private String proName;
	private Set addressCities = new HashSet(0);

	// Constructors

	/** default constructor */
	public AddressProvince() {
	}

	/** full constructor */
	public AddressProvince(String proName, Set addressCities) {
		this.proName = proName;
		this.addressCities = addressCities;
	}

	// Property accessors

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Set getAddressCities() {
		return this.addressCities;
	}

	public void setAddressCities(Set addressCities) {
		this.addressCities = addressCities;
	}

}