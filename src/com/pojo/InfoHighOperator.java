package com.pojo;

/**
 * InfoHighOperator entity. @author MyEclipse Persistence Tools
 */

public class InfoHighOperator implements java.io.Serializable {

	// Fields

	private InfoHighOperatorId id;
	private String hname;

	// Constructors

	/** default constructor */
	public InfoHighOperator() {
	}

	/** minimal constructor */
	public InfoHighOperator(InfoHighOperatorId id) {
		this.id = id;
	}

	/** full constructor */
	public InfoHighOperator(InfoHighOperatorId id, String hname) {
		this.id = id;
		this.hname = hname;
	}

	// Property accessors

	public InfoHighOperatorId getId() {
		return this.id;
	}

	public void setId(InfoHighOperatorId id) {
		this.id = id;
	}

	public String getHname() {
		return this.hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

}