package com.pojo;

/**
 * InfoOperatorId entity. @author MyEclipse Persistence Tools
 */

public class InfoOperatorId implements java.io.Serializable {

	// Fields

	private Integer oid;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public InfoOperatorId() {
	}

	/** full constructor */
	public InfoOperatorId(Integer oid, String username, String password) {
		this.oid = oid;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getOid() {
		return this.oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof InfoOperatorId))
			return false;
		InfoOperatorId castOther = (InfoOperatorId) other;

		return ((this.getOid() == castOther.getOid())
				|| (this.getOid() != null && castOther.getOid() != null && this.getOid().equals(castOther.getOid())))
				&& ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
						&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getPassword() == castOther.getPassword()) || (this.getPassword() != null
						&& castOther.getPassword() != null && this.getPassword().equals(castOther.getPassword())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getOid() == null ? 0 : this.getOid().hashCode());
		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getPassword() == null ? 0 : this.getPassword().hashCode());
		return result;
	}

}