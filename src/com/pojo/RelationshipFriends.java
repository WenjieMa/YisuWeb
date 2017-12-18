package com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * RelationshipFriends entity. @author MyEclipse Persistence Tools
 */

public class RelationshipFriends implements java.io.Serializable {

	// Fields

	private Integer reId;
	private InfoUser infoUserByReuId1;
	private InfoUser infoUserByReuId2;
	private Set relationshipChatrecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public RelationshipFriends() {
	}

	/** minimal constructor */
	public RelationshipFriends(InfoUser infoUserByReuId1, InfoUser infoUserByReuId2) {
		this.infoUserByReuId1 = infoUserByReuId1;
		this.infoUserByReuId2 = infoUserByReuId2;
	}

	/** full constructor */
	public RelationshipFriends(InfoUser infoUserByReuId1, InfoUser infoUserByReuId2, Set relationshipChatrecords) {
		this.infoUserByReuId1 = infoUserByReuId1;
		this.infoUserByReuId2 = infoUserByReuId2;
		this.relationshipChatrecords = relationshipChatrecords;
	}

	// Property accessors

	public Integer getReId() {
		return this.reId;
	}

	public void setReId(Integer reId) {
		this.reId = reId;
	}

	public InfoUser getInfoUserByReuId1() {
		return this.infoUserByReuId1;
	}

	public void setInfoUserByReuId1(InfoUser infoUserByReuId1) {
		this.infoUserByReuId1 = infoUserByReuId1;
	}

	public InfoUser getInfoUserByReuId2() {
		return this.infoUserByReuId2;
	}

	public void setInfoUserByReuId2(InfoUser infoUserByReuId2) {
		this.infoUserByReuId2 = infoUserByReuId2;
	}

	public Set getRelationshipChatrecords() {
		return this.relationshipChatrecords;
	}

	public void setRelationshipChatrecords(Set relationshipChatrecords) {
		this.relationshipChatrecords = relationshipChatrecords;
	}

}