package com.pojo;

/**
 * InfoHighOperatorId entity. @author MyEclipse Persistence Tools
 */

public class InfoHighOperatorId implements java.io.Serializable {

	// Fields

	private Integer hid;
	private String username;
	private String password;

	// Constructors

	/** default constructor */
	public InfoHighOperatorId() {
	}

	/** full constructor */
	public InfoHighOperatorId(Integer hid, String username, String password) {
		this.hid = hid;
		this.username = username;
		this.password = password;
	}

	// Property accessors

	public Integer getHid() {
		return this.hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
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
		if (!(other instanceof InfoHighOperatorId))
			return false;
		InfoHighOperatorId castOther = (InfoHighOperatorId) other;

		return ((this.getHid() == castOther.getHid())
				|| (this.getHid() != null && castOther.getHid() != null && this.getHid().equals(castOther.getHid())))
				&& ((this.getUsername() == castOther.getUsername()) || (this.getUsername() != null
						&& castOther.getUsername() != null && this.getUsername().equals(castOther.getUsername())))
				&& ((this.getPassword() == castOther.getPassword()) || (this.getPassword() != null
						&& castOther.getPassword() != null && this.getPassword().equals(castOther.getPassword())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getHid() == null ? 0 : this.getHid().hashCode());
		result = 37 * result + (getUsername() == null ? 0 : this.getUsername().hashCode());
		result = 37 * result + (getPassword() == null ? 0 : this.getPassword().hashCode());
		return result;
	}

}