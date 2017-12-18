package com.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * InfoUser entity. @author MyEclipse Persistence Tools
 */

public class InfoUser implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String username;
	private String password;
	private String uzhifumima;
	private String unicheng;
	private String uxingming;
	private String uxingbie;
	private String uphone;
	private String uqq;
	private String uxingzuo;
	private String uemail;
	private Date ushengri;
	private Timestamp uzhuceshijian;
	private String utouxiang;
	private Double umoney;
	private String uchangyongdizhi1;
	private String uchangyongdizhi2;
	private String uchangyongdizhi3;
	private String uchangyongdizhi4;
	private String uchangyongdizhi5;
	private String umibaowenti1;
	private String umibaowenti2;
	private String udaan1;
	private String udaan2;
	private Integer udiangId;
	private Set relationshipFriendsesForReuId2 = new HashSet(0);
	private Set relationshipChatrecords = new HashSet(0);
	private Set infoCollections = new HashSet(0);
	private Set relationshipAcceptancesForAcGetuId = new HashSet(0);
	private Set relationshipAcceptancesForAcSenduId = new HashSet(0);
	private Set relationshipFriendsesForReuId1 = new HashSet(0);

	// Constructors

	/** default constructor */
	public InfoUser() {
	}

	/** minimal constructor */
	public InfoUser(String username, String password, String unicheng, Timestamp uzhuceshijian, String utouxiang,
			Double umoney) {
		this.username = username;
		this.password = password;
		this.unicheng = unicheng;
		this.uzhuceshijian = uzhuceshijian;
		this.utouxiang = utouxiang;
		this.umoney = umoney;
	}

	/** full constructor */
	public InfoUser(String username, String password, String uzhifumima, String unicheng, String uxingming,
			String uxingbie, String uphone, String uqq, String uxingzuo, String uemail, Date ushengri,
			Timestamp uzhuceshijian, String utouxiang, Double umoney, String uchangyongdizhi1, String uchangyongdizhi2,
			String uchangyongdizhi3, String uchangyongdizhi4, String uchangyongdizhi5, String umibaowenti1,
			String umibaowenti2, String udaan1, String udaan2, Integer udiangId, Set relationshipFriendsesForReuId2,
			Set relationshipChatrecords, Set infoCollections, Set relationshipAcceptancesForAcGetuId,
			Set relationshipAcceptancesForAcSenduId, Set relationshipFriendsesForReuId1) {
		this.username = username;
		this.password = password;
		this.uzhifumima = uzhifumima;
		this.unicheng = unicheng;
		this.uxingming = uxingming;
		this.uxingbie = uxingbie;
		this.uphone = uphone;
		this.uqq = uqq;
		this.uxingzuo = uxingzuo;
		this.uemail = uemail;
		this.ushengri = ushengri;
		this.uzhuceshijian = uzhuceshijian;
		this.utouxiang = utouxiang;
		this.umoney = umoney;
		this.uchangyongdizhi1 = uchangyongdizhi1;
		this.uchangyongdizhi2 = uchangyongdizhi2;
		this.uchangyongdizhi3 = uchangyongdizhi3;
		this.uchangyongdizhi4 = uchangyongdizhi4;
		this.uchangyongdizhi5 = uchangyongdizhi5;
		this.umibaowenti1 = umibaowenti1;
		this.umibaowenti2 = umibaowenti2;
		this.udaan1 = udaan1;
		this.udaan2 = udaan2;
		this.udiangId = udiangId;
		this.relationshipFriendsesForReuId2 = relationshipFriendsesForReuId2;
		this.relationshipChatrecords = relationshipChatrecords;
		this.infoCollections = infoCollections;
		this.relationshipAcceptancesForAcGetuId = relationshipAcceptancesForAcGetuId;
		this.relationshipAcceptancesForAcSenduId = relationshipAcceptancesForAcSenduId;
		this.relationshipFriendsesForReuId1 = relationshipFriendsesForReuId1;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUzhifumima() {
		return this.uzhifumima;
	}

	public void setUzhifumima(String uzhifumima) {
		this.uzhifumima = uzhifumima;
	}

	public String getUnicheng() {
		return this.unicheng;
	}

	public void setUnicheng(String unicheng) {
		this.unicheng = unicheng;
	}

	public String getUxingming() {
		return this.uxingming;
	}

	public void setUxingming(String uxingming) {
		this.uxingming = uxingming;
	}

	public String getUxingbie() {
		return this.uxingbie;
	}

	public void setUxingbie(String uxingbie) {
		this.uxingbie = uxingbie;
	}

	public String getUphone() {
		return this.uphone;
	}

	public void setUphone(String uphone) {
		this.uphone = uphone;
	}

	public String getUqq() {
		return this.uqq;
	}

	public void setUqq(String uqq) {
		this.uqq = uqq;
	}

	public String getUxingzuo() {
		return this.uxingzuo;
	}

	public void setUxingzuo(String uxingzuo) {
		this.uxingzuo = uxingzuo;
	}

	public String getUemail() {
		return this.uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public Date getUshengri() {
		return this.ushengri;
	}

	public void setUshengri(Date ushengri) {
		this.ushengri = ushengri;
	}

	public Timestamp getUzhuceshijian() {
		return this.uzhuceshijian;
	}

	public void setUzhuceshijian(Timestamp uzhuceshijian) {
		this.uzhuceshijian = uzhuceshijian;
	}

	public String getUtouxiang() {
		return this.utouxiang;
	}

	public void setUtouxiang(String utouxiang) {
		this.utouxiang = utouxiang;
	}

	public Double getUmoney() {
		return this.umoney;
	}

	public void setUmoney(Double umoney) {
		this.umoney = umoney;
	}

	public String getUchangyongdizhi1() {
		return this.uchangyongdizhi1;
	}

	public void setUchangyongdizhi1(String uchangyongdizhi1) {
		this.uchangyongdizhi1 = uchangyongdizhi1;
	}

	public String getUchangyongdizhi2() {
		return this.uchangyongdizhi2;
	}

	public void setUchangyongdizhi2(String uchangyongdizhi2) {
		this.uchangyongdizhi2 = uchangyongdizhi2;
	}

	public String getUchangyongdizhi3() {
		return this.uchangyongdizhi3;
	}

	public void setUchangyongdizhi3(String uchangyongdizhi3) {
		this.uchangyongdizhi3 = uchangyongdizhi3;
	}

	public String getUchangyongdizhi4() {
		return this.uchangyongdizhi4;
	}

	public void setUchangyongdizhi4(String uchangyongdizhi4) {
		this.uchangyongdizhi4 = uchangyongdizhi4;
	}

	public String getUchangyongdizhi5() {
		return this.uchangyongdizhi5;
	}

	public void setUchangyongdizhi5(String uchangyongdizhi5) {
		this.uchangyongdizhi5 = uchangyongdizhi5;
	}

	public String getUmibaowenti1() {
		return this.umibaowenti1;
	}

	public void setUmibaowenti1(String umibaowenti1) {
		this.umibaowenti1 = umibaowenti1;
	}

	public String getUmibaowenti2() {
		return this.umibaowenti2;
	}

	public void setUmibaowenti2(String umibaowenti2) {
		this.umibaowenti2 = umibaowenti2;
	}

	public String getUdaan1() {
		return this.udaan1;
	}

	public void setUdaan1(String udaan1) {
		this.udaan1 = udaan1;
	}

	public String getUdaan2() {
		return this.udaan2;
	}

	public void setUdaan2(String udaan2) {
		this.udaan2 = udaan2;
	}

	public Integer getUdiangId() {
		return this.udiangId;
	}

	public void setUdiangId(Integer udiangId) {
		this.udiangId = udiangId;
	}

	public Set getRelationshipFriendsesForReuId2() {
		return this.relationshipFriendsesForReuId2;
	}

	public void setRelationshipFriendsesForReuId2(Set relationshipFriendsesForReuId2) {
		this.relationshipFriendsesForReuId2 = relationshipFriendsesForReuId2;
	}

	public Set getRelationshipChatrecords() {
		return this.relationshipChatrecords;
	}

	public void setRelationshipChatrecords(Set relationshipChatrecords) {
		this.relationshipChatrecords = relationshipChatrecords;
	}

	public Set getInfoCollections() {
		return this.infoCollections;
	}

	public void setInfoCollections(Set infoCollections) {
		this.infoCollections = infoCollections;
	}

	public Set getRelationshipAcceptancesForAcGetuId() {
		return this.relationshipAcceptancesForAcGetuId;
	}

	public void setRelationshipAcceptancesForAcGetuId(Set relationshipAcceptancesForAcGetuId) {
		this.relationshipAcceptancesForAcGetuId = relationshipAcceptancesForAcGetuId;
	}

	public Set getRelationshipAcceptancesForAcSenduId() {
		return this.relationshipAcceptancesForAcSenduId;
	}

	public void setRelationshipAcceptancesForAcSenduId(Set relationshipAcceptancesForAcSenduId) {
		this.relationshipAcceptancesForAcSenduId = relationshipAcceptancesForAcSenduId;
	}

	public Set getRelationshipFriendsesForReuId1() {
		return this.relationshipFriendsesForReuId1;
	}

	public void setRelationshipFriendsesForReuId1(Set relationshipFriendsesForReuId1) {
		this.relationshipFriendsesForReuId1 = relationshipFriendsesForReuId1;
	}

}