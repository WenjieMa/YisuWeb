package com.pojo;

import java.sql.Timestamp;

/**
 * RelationshipAcceptance entity. @author MyEclipse Persistence Tools
 */

public class RelationshipAcceptance implements java.io.Serializable {

	// Fields

	private Integer acId;
	private InfoUser infoUserByAcSenduId;
	private InfoUser infoUserByAcGetuId;
	private Boolean acAccept;
	private Boolean acRefuse;
	private Timestamp acSendTime;
	private Timestamp acAcceptTime;
	private Timestamp acRefuseTime;

	// Constructors

	/** default constructor */
	public RelationshipAcceptance() {
	}

	/** minimal constructor */
	public RelationshipAcceptance(Timestamp acSendTime) {
		this.acSendTime = acSendTime;
	}

	/** full constructor */
	public RelationshipAcceptance(InfoUser infoUserByAcSenduId, InfoUser infoUserByAcGetuId, Boolean acAccept,
			Boolean acRefuse, Timestamp acSendTime, Timestamp acAcceptTime, Timestamp acRefuseTime) {
		this.infoUserByAcSenduId = infoUserByAcSenduId;
		this.infoUserByAcGetuId = infoUserByAcGetuId;
		this.acAccept = acAccept;
		this.acRefuse = acRefuse;
		this.acSendTime = acSendTime;
		this.acAcceptTime = acAcceptTime;
		this.acRefuseTime = acRefuseTime;
	}

	// Property accessors

	public Integer getAcId() {
		return this.acId;
	}

	public void setAcId(Integer acId) {
		this.acId = acId;
	}

	public InfoUser getInfoUserByAcSenduId() {
		return this.infoUserByAcSenduId;
	}

	public void setInfoUserByAcSenduId(InfoUser infoUserByAcSenduId) {
		this.infoUserByAcSenduId = infoUserByAcSenduId;
	}

	public InfoUser getInfoUserByAcGetuId() {
		return this.infoUserByAcGetuId;
	}

	public void setInfoUserByAcGetuId(InfoUser infoUserByAcGetuId) {
		this.infoUserByAcGetuId = infoUserByAcGetuId;
	}

	public Boolean getAcAccept() {
		return this.acAccept;
	}

	public void setAcAccept(Boolean acAccept) {
		this.acAccept = acAccept;
	}

	public Boolean getAcRefuse() {
		return this.acRefuse;
	}

	public void setAcRefuse(Boolean acRefuse) {
		this.acRefuse = acRefuse;
	}

	public Timestamp getAcSendTime() {
		return this.acSendTime;
	}

	public void setAcSendTime(Timestamp acSendTime) {
		this.acSendTime = acSendTime;
	}

	public Timestamp getAcAcceptTime() {
		return this.acAcceptTime;
	}

	public void setAcAcceptTime(Timestamp acAcceptTime) {
		this.acAcceptTime = acAcceptTime;
	}

	public Timestamp getAcRefuseTime() {
		return this.acRefuseTime;
	}

	public void setAcRefuseTime(Timestamp acRefuseTime) {
		this.acRefuseTime = acRefuseTime;
	}

}