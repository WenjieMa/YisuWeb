package com.pojo;

/**
 * InfoKuaidigongsi entity. @author MyEclipse Persistence Tools
 */

public class InfoKuaidigongsi implements java.io.Serializable {

	// Fields

	private Integer wid;
	private String wname;

	// Constructors

	/** default constructor */
	public InfoKuaidigongsi() {
	}

	/** full constructor */
	public InfoKuaidigongsi(String wname) {
		this.wname = wname;
	}

	// Property accessors

	public Integer getWid() {
		return this.wid;
	}

	public void setWid(Integer wid) {
		this.wid = wid;
	}

	public String getWname() {
		return this.wname;
	}

	public void setWname(String wname) {
		this.wname = wname;
	}

}