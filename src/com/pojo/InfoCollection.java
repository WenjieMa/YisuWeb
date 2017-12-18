package com.pojo;

/**
 * InfoCollection entity. @author MyEclipse Persistence Tools
 */

public class InfoCollection implements java.io.Serializable {

	// Fields

	private InfoCollectionId id;

	// Constructors

	/** default constructor */
	public InfoCollection() {
	}

	/** full constructor */
	public InfoCollection(InfoCollectionId id) {
		this.id = id;
	}

	// Property accessors

	public InfoCollectionId getId() {
		return this.id;
	}

	public void setId(InfoCollectionId id) {
		this.id = id;
	}

}