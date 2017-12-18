package com.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * InfoGoods entity. @author MyEclipse Persistence Tools
 */

public class InfoGoods implements java.io.Serializable {

	// Fields

	private Integer gid;
	private String gname;
	private String gprice;
	private String gtype;
	private Integer gkucun;
	private Integer gkongxiankucun;
	private Integer gxihuanshu;
	private String gpic;
	private String gbigPic;
	private String gjieshao;
	private String gjianjie;
	private Timestamp grukushijian;
	private Set infoCollections = new HashSet(0);
	private Set orderSmalls = new HashSet(0);

	// Constructors

	/** default constructor */
	public InfoGoods() {
	}

	/** minimal constructor */
	public InfoGoods(String gname, String gtype, Integer gkucun, Integer gxihuanshu, String gjieshao, String gjianjie,
			Timestamp grukushijian) {
		this.gname = gname;
		this.gtype = gtype;
		this.gkucun = gkucun;
		this.gxihuanshu = gxihuanshu;
		this.gjieshao = gjieshao;
		this.gjianjie = gjianjie;
		this.grukushijian = grukushijian;
	}

	/** full constructor */
	public InfoGoods(String gname, String gprice, String gtype, Integer gkucun, Integer gkongxiankucun,
			Integer gxihuanshu, String gpic, String gbigPic, String gjieshao, String gjianjie, Timestamp grukushijian,
			Set infoCollections, Set orderSmalls) {
		this.gname = gname;
		this.gprice = gprice;
		this.gtype = gtype;
		this.gkucun = gkucun;
		this.gkongxiankucun = gkongxiankucun;
		this.gxihuanshu = gxihuanshu;
		this.gpic = gpic;
		this.gbigPic = gbigPic;
		this.gjieshao = gjieshao;
		this.gjianjie = gjianjie;
		this.grukushijian = grukushijian;
		this.infoCollections = infoCollections;
		this.orderSmalls = orderSmalls;
	}

	// Property accessors

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGprice() {
		return this.gprice;
	}

	public void setGprice(String gprice) {
		this.gprice = gprice;
	}

	public String getGtype() {
		return this.gtype;
	}

	public void setGtype(String gtype) {
		this.gtype = gtype;
	}

	public Integer getGkucun() {
		return this.gkucun;
	}

	public void setGkucun(Integer gkucun) {
		this.gkucun = gkucun;
	}

	public Integer getGkongxiankucun() {
		return this.gkongxiankucun;
	}

	public void setGkongxiankucun(Integer gkongxiankucun) {
		this.gkongxiankucun = gkongxiankucun;
	}

	public Integer getGxihuanshu() {
		return this.gxihuanshu;
	}

	public void setGxihuanshu(Integer gxihuanshu) {
		this.gxihuanshu = gxihuanshu;
	}

	public String getGpic() {
		return this.gpic;
	}

	public void setGpic(String gpic) {
		this.gpic = gpic;
	}

	public String getGbigPic() {
		return this.gbigPic;
	}

	public void setGbigPic(String gbigPic) {
		this.gbigPic = gbigPic;
	}

	public String getGjieshao() {
		return this.gjieshao;
	}

	public void setGjieshao(String gjieshao) {
		this.gjieshao = gjieshao;
	}

	public String getGjianjie() {
		return this.gjianjie;
	}

	public void setGjianjie(String gjianjie) {
		this.gjianjie = gjianjie;
	}

	public Timestamp getGrukushijian() {
		return this.grukushijian;
	}

	public void setGrukushijian(Timestamp grukushijian) {
		this.grukushijian = grukushijian;
	}

	public Set getInfoCollections() {
		return this.infoCollections;
	}

	public void setInfoCollections(Set infoCollections) {
		this.infoCollections = infoCollections;
	}

	public Set getOrderSmalls() {
		return this.orderSmalls;
	}

	public void setOrderSmalls(Set orderSmalls) {
		this.orderSmalls = orderSmalls;
	}

}