package com.pojo;

import java.sql.Timestamp;

/**
 * InfoOperator entity. @author MyEclipse Persistence Tools
 */

public class InfoOperator implements java.io.Serializable {

	// Fields

	private InfoOperatorId id;
	private InfoDep infoDep;
	private String oxingming;
	private String ophone;
	private String oshenfenzheng;
	private String ogongzi;
	private Boolean olizhi;
	private Timestamp ojinruTime;

	// Constructors

	/** default constructor */
	public InfoOperator() {
	}

	/** minimal constructor */
	public InfoOperator(InfoOperatorId id, String oxingming, String ophone, String oshenfenzheng,
			Timestamp ojinruTime) {
		this.id = id;
		this.oxingming = oxingming;
		this.ophone = ophone;
		this.oshenfenzheng = oshenfenzheng;
		this.ojinruTime = ojinruTime;
	}

	/** full constructor */
	public InfoOperator(InfoOperatorId id, InfoDep infoDep, String oxingming, String ophone, String oshenfenzheng,
			String ogongzi, Boolean olizhi, Timestamp ojinruTime) {
		this.id = id;
		this.infoDep = infoDep;
		this.oxingming = oxingming;
		this.ophone = ophone;
		this.oshenfenzheng = oshenfenzheng;
		this.ogongzi = ogongzi;
		this.olizhi = olizhi;
		this.ojinruTime = ojinruTime;
	}

	// Property accessors

	public InfoOperatorId getId() {
		return this.id;
	}

	public void setId(InfoOperatorId id) {
		this.id = id;
	}

	public InfoDep getInfoDep() {
		return this.infoDep;
	}

	public void setInfoDep(InfoDep infoDep) {
		this.infoDep = infoDep;
	}

	public String getOxingming() {
		return this.oxingming;
	}

	public void setOxingming(String oxingming) {
		this.oxingming = oxingming;
	}

	public String getOphone() {
		return this.ophone;
	}

	public void setOphone(String ophone) {
		this.ophone = ophone;
	}

	public String getOshenfenzheng() {
		return this.oshenfenzheng;
	}

	public void setOshenfenzheng(String oshenfenzheng) {
		this.oshenfenzheng = oshenfenzheng;
	}

	public String getOgongzi() {
		return this.ogongzi;
	}

	public void setOgongzi(String ogongzi) {
		this.ogongzi = ogongzi;
	}

	public Boolean getOlizhi() {
		return this.olizhi;
	}

	public void setOlizhi(Boolean olizhi) {
		this.olizhi = olizhi;
	}

	public Timestamp getOjinruTime() {
		return this.ojinruTime;
	}

	public void setOjinruTime(Timestamp ojinruTime) {
		this.ojinruTime = ojinruTime;
	}

}