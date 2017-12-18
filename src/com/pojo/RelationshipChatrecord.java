package com.pojo;

import java.sql.Timestamp;

/**
 * RelationshipChatrecord entity. @author MyEclipse Persistence Tools
 */

public class RelationshipChatrecord implements java.io.Serializable {

	// Fields

	private Integer recordId;
	private RelationshipFriends relationshipFriends;
	private InfoUser infoUser;
	private String recordText;
	private Boolean recordIsPic;
	private Timestamp recordTime;

	// Constructors

	/** default constructor */
	public RelationshipChatrecord() {
	}

	/** minimal constructor */
	public RelationshipChatrecord(RelationshipFriends relationshipFriends, InfoUser infoUser) {
		this.relationshipFriends = relationshipFriends;
		this.infoUser = infoUser;
	}

	/** full constructor */
	public RelationshipChatrecord(RelationshipFriends relationshipFriends, InfoUser infoUser, String recordText,
			Boolean recordIsPic, Timestamp recordTime) {
		this.relationshipFriends = relationshipFriends;
		this.infoUser = infoUser;
		this.recordText = recordText;
		this.recordIsPic = recordIsPic;
		this.recordTime = recordTime;
	}

	// Property accessors

	public Integer getRecordId() {
		return this.recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public RelationshipFriends getRelationshipFriends() {
		return this.relationshipFriends;
	}

	public void setRelationshipFriends(RelationshipFriends relationshipFriends) {
		this.relationshipFriends = relationshipFriends;
	}

	public InfoUser getInfoUser() {
		return this.infoUser;
	}

	public void setInfoUser(InfoUser infoUser) {
		this.infoUser = infoUser;
	}

	public String getRecordText() {
		return this.recordText;
	}

	public void setRecordText(String recordText) {
		this.recordText = recordText;
	}

	public Boolean getRecordIsPic() {
		return this.recordIsPic;
	}

	public void setRecordIsPic(Boolean recordIsPic) {
		this.recordIsPic = recordIsPic;
	}

	public Timestamp getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Timestamp recordTime) {
		this.recordTime = recordTime;
	}

}