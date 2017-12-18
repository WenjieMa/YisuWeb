package com.pojo;

/**
 * InfoCollectionId entity. @author MyEclipse Persistence Tools
 */

public class InfoCollectionId implements java.io.Serializable {

	// Fields

	private Integer sid;
	private InfoUser infoUser;
	private InfoGoods infoGoods;

	// Constructors

	/** default constructor */
	public InfoCollectionId() {
	}

	/** full constructor */
	public InfoCollectionId(Integer sid, InfoUser infoUser, InfoGoods infoGoods) {
		this.sid = sid;
		this.infoUser = infoUser;
		this.infoGoods = infoGoods;
	}

	// Property accessors

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public InfoUser getInfoUser() {
		return this.infoUser;
	}

	public void setInfoUser(InfoUser infoUser) {
		this.infoUser = infoUser;
	}

	public InfoGoods getInfoGoods() {
		return this.infoGoods;
	}

	public void setInfoGoods(InfoGoods infoGoods) {
		this.infoGoods = infoGoods;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InfoCollectionId))
			return false;
		InfoCollectionId castOther = (InfoCollectionId) other;

		return ((this.getSid() == castOther.getSid())
				|| (this.getSid() != null && castOther.getSid() != null && this.getSid().equals(castOther.getSid())))
				&& ((this.getInfoUser() == castOther.getInfoUser()) || (this.getInfoUser() != null
						&& castOther.getInfoUser() != null && this.getInfoUser().equals(castOther.getInfoUser())))
				&& ((this.getInfoGoods() == castOther.getInfoGoods()) || (this.getInfoGoods() != null
						&& castOther.getInfoGoods() != null && this.getInfoGoods().equals(castOther.getInfoGoods())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result + (getInfoUser() == null ? 0 : this.getInfoUser().hashCode());
		result = 37 * result + (getInfoGoods() == null ? 0 : this.getInfoGoods().hashCode());
		return result;
	}

}