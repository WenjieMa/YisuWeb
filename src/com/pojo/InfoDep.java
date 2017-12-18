package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * InfoDep entity. @author MyEclipse Persistence Tools
 */

public class InfoDep implements java.io.Serializable {

	// Fields

	private Integer bmId;
	private String bmName;
	private Integer bmCount;
	private Set infoOperators = new HashSet(0);

	// Constructors

	/** default constructor */
	public InfoDep() {
	}

	/** full constructor */
	public InfoDep(String bmName, Integer bmCount, Set infoOperators) {
		this.bmName = bmName;
		this.bmCount = bmCount;
		this.infoOperators = infoOperators;
	}

	// Property accessors

	public Integer getBmId() {
		return this.bmId;
	}

	public void setBmId(Integer bmId) {
		this.bmId = bmId;
	}

	public String getBmName() {
		return this.bmName;
	}

	public void setBmName(String bmName) {
		this.bmName = bmName;
	}

	public Integer getBmCount() {
		return this.bmCount;
	}

	public void setBmCount(Integer bmCount) {
		this.bmCount = bmCount;
	}

	public Set getInfoOperators() {
		return this.infoOperators;
	}

	public void setInfoOperators(Set infoOperators) {
		this.infoOperators = infoOperators;
	}

}