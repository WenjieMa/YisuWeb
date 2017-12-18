package com.pojo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * OrderBig entity. @author MyEclipse Persistence Tools
 */

public class OrderBig implements java.io.Serializable {

	// Fields

	private Integer bid;
	private InfoUser infoUser;
	private String bshouhuodizhi;
	private String fukuanjine;
	private Boolean bshifoufukuan;
	private Boolean bshifoushouhuo;
	private Timestamp bchuangjianshijian;
	private Boolean bshifoupingjia;
	private Timestamp bfukuanshijian;
	private Timestamp bshouhuoshijian;
	private Integer bkuaidiId;
	private Boolean bshifoufahuo;
	private Timestamp bfahuoshijian;
	private Timestamp bpingjiashijian;
	private Set orderSmalls = new HashSet(0);

	// Constructors

	/** default constructor */
	public OrderBig() {
	}

	/** minimal constructor */
	public OrderBig(InfoUser infoUser, String bshouhuodizhi, String fukuanjine, Boolean bshifoufukuan,
			Boolean bshifoushouhuo, Timestamp bchuangjianshijian, Boolean bshifoupingjia, Timestamp bfukuanshijian,
			Timestamp bshouhuoshijian, Integer bkuaidiId, Boolean bshifoufahuo, Timestamp bfahuoshijian,
			Timestamp bpingjiashijian) {
		this.infoUser = infoUser;
		this.bshouhuodizhi = bshouhuodizhi;
		this.fukuanjine = fukuanjine;
		this.bshifoufukuan = bshifoufukuan;
		this.bshifoushouhuo = bshifoushouhuo;
		this.bchuangjianshijian = bchuangjianshijian;
		this.bshifoupingjia = bshifoupingjia;
		this.bfukuanshijian = bfukuanshijian;
		this.bshouhuoshijian = bshouhuoshijian;
		this.bkuaidiId = bkuaidiId;
		this.bshifoufahuo = bshifoufahuo;
		this.bfahuoshijian = bfahuoshijian;
		this.bpingjiashijian = bpingjiashijian;
	}

	/** full constructor */
	public OrderBig(InfoUser infoUser, String bshouhuodizhi, String fukuanjine, Boolean bshifoufukuan,
			Boolean bshifoushouhuo, Timestamp bchuangjianshijian, Boolean bshifoupingjia, Timestamp bfukuanshijian,
			Timestamp bshouhuoshijian, Integer bkuaidiId, Boolean bshifoufahuo, Timestamp bfahuoshijian,
			Timestamp bpingjiashijian, Set orderSmalls) {
		this.infoUser = infoUser;
		this.bshouhuodizhi = bshouhuodizhi;
		this.fukuanjine = fukuanjine;
		this.bshifoufukuan = bshifoufukuan;
		this.bshifoushouhuo = bshifoushouhuo;
		this.bchuangjianshijian = bchuangjianshijian;
		this.bshifoupingjia = bshifoupingjia;
		this.bfukuanshijian = bfukuanshijian;
		this.bshouhuoshijian = bshouhuoshijian;
		this.bkuaidiId = bkuaidiId;
		this.bshifoufahuo = bshifoufahuo;
		this.bfahuoshijian = bfahuoshijian;
		this.bpingjiashijian = bpingjiashijian;
		this.orderSmalls = orderSmalls;
	}

	// Property accessors

	public Integer getBid() {
		return this.bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public InfoUser getInfoUser() {
		return this.infoUser;
	}

	public void setInfoUser(InfoUser infoUser) {
		this.infoUser = infoUser;
	}

	public String getBshouhuodizhi() {
		return this.bshouhuodizhi;
	}

	public void setBshouhuodizhi(String bshouhuodizhi) {
		this.bshouhuodizhi = bshouhuodizhi;
	}

	public String getFukuanjine() {
		return this.fukuanjine;
	}

	public void setFukuanjine(String fukuanjine) {
		this.fukuanjine = fukuanjine;
	}

	public Boolean getBshifoufukuan() {
		return this.bshifoufukuan;
	}

	public void setBshifoufukuan(Boolean bshifoufukuan) {
		this.bshifoufukuan = bshifoufukuan;
	}

	public Boolean getBshifoushouhuo() {
		return this.bshifoushouhuo;
	}

	public void setBshifoushouhuo(Boolean bshifoushouhuo) {
		this.bshifoushouhuo = bshifoushouhuo;
	}

	public Timestamp getBchuangjianshijian() {
		return this.bchuangjianshijian;
	}

	public void setBchuangjianshijian(Timestamp bchuangjianshijian) {
		this.bchuangjianshijian = bchuangjianshijian;
	}

	public Boolean getBshifoupingjia() {
		return this.bshifoupingjia;
	}

	public void setBshifoupingjia(Boolean bshifoupingjia) {
		this.bshifoupingjia = bshifoupingjia;
	}

	public Timestamp getBfukuanshijian() {
		return this.bfukuanshijian;
	}

	public void setBfukuanshijian(Timestamp bfukuanshijian) {
		this.bfukuanshijian = bfukuanshijian;
	}

	public Timestamp getBshouhuoshijian() {
		return this.bshouhuoshijian;
	}

	public void setBshouhuoshijian(Timestamp bshouhuoshijian) {
		this.bshouhuoshijian = bshouhuoshijian;
	}

	public Integer getBkuaidiId() {
		return this.bkuaidiId;
	}

	public void setBkuaidiId(Integer bkuaidiId) {
		this.bkuaidiId = bkuaidiId;
	}

	public Boolean getBshifoufahuo() {
		return this.bshifoufahuo;
	}

	public void setBshifoufahuo(Boolean bshifoufahuo) {
		this.bshifoufahuo = bshifoufahuo;
	}

	public Timestamp getBfahuoshijian() {
		return this.bfahuoshijian;
	}

	public void setBfahuoshijian(Timestamp bfahuoshijian) {
		this.bfahuoshijian = bfahuoshijian;
	}

	public Timestamp getBpingjiashijian() {
		return this.bpingjiashijian;
	}

	public void setBpingjiashijian(Timestamp bpingjiashijian) {
		this.bpingjiashijian = bpingjiashijian;
	}

	public Set getOrderSmalls() {
		return this.orderSmalls;
	}

	public void setOrderSmalls(Set orderSmalls) {
		this.orderSmalls = orderSmalls;
	}

}