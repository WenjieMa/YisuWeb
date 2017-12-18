package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * AddressCity entity. @author MyEclipse Persistence Tools
 */

public class AddressCity implements java.io.Serializable {

	// Fields

	private Integer cid;
	private AddressProvince addressProvince;
	private String cname;
	private Set addressDistricts = new HashSet(0);

	// Constructors

	/** default constructor */
	public AddressCity() {
	}

	/** minimal constructor */
	public AddressCity(AddressProvince addressProvince) {
		this.addressProvince = addressProvince;
	}

	/** full constructor */
	public AddressCity(AddressProvince addressProvince, String cname, Set addressDistricts) {
		this.addressProvince = addressProvince;
		this.cname = cname;
		this.addressDistricts = addressDistricts;
	}

	// Property accessors

	public Integer getCid() {
		return this.cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public AddressProvince getAddressProvince() {
		return this.addressProvince;
	}

	public void setAddressProvince(AddressProvince addressProvince) {
		this.addressProvince = addressProvince;
	}

	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public Set getAddressDistricts() {
		return this.addressDistricts;
	}

	public void setAddressDistricts(Set addressDistricts) {
		this.addressDistricts = addressDistricts;
	}

}