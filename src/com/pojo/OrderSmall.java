package com.pojo;

import java.sql.Timestamp;

/**
 * OrderSmall entity. @author MyEclipse Persistence Tools
 */

public class OrderSmall implements java.io.Serializable {

	// Fields

	private OrderSmallId id;
	private InfoGoods infoGoods;
	private OrderBig orderBig;
	private InfoUser infoUser;
	private Integer shuliang;
	private String pingjia;
	private Integer haozhongcha;
	private Integer xingji;
	private Timestamp pingjiaShijian;
	private Boolean shifoupingjia;

	// Constructors

	/** default constructor */
	public OrderSmall() {
	}

	/** full constructor */
	public OrderSmall(OrderSmallId id, InfoGoods infoGoods, OrderBig orderBig, InfoUser infoUser, Integer shuliang,
			String pingjia, Integer haozhongcha, Integer xingji, Timestamp pingjiaShijian, Boolean shifoupingjia) {
		this.id = id;
		this.infoGoods = infoGoods;
		this.orderBig = orderBig;
		this.infoUser = infoUser;
		this.shuliang = shuliang;
		this.pingjia = pingjia;
		this.haozhongcha = haozhongcha;
		this.xingji = xingji;
		this.pingjiaShijian = pingjiaShijian;
		this.shifoupingjia = shifoupingjia;
	}

	// Property accessors

	public OrderSmallId getId() {
		return this.id;
	}

	public void setId(OrderSmallId id) {
		this.id = id;
	}

	public InfoGoods getInfoGoods() {
		return this.infoGoods;
	}

	public void setInfoGoods(InfoGoods infoGoods) {
		this.infoGoods = infoGoods;
	}

	public OrderBig getOrderBig() {
		return this.orderBig;
	}

	public void setOrderBig(OrderBig orderBig) {
		this.orderBig = orderBig;
	}

	public InfoUser getInfoUser() {
		return this.infoUser;
	}

	public void setInfoUser(InfoUser infoUser) {
		this.infoUser = infoUser;
	}

	public Integer getShuliang() {
		return this.shuliang;
	}

	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}

	public String getPingjia() {
		return this.pingjia;
	}

	public void setPingjia(String pingjia) {
		this.pingjia = pingjia;
	}

	public Integer getHaozhongcha() {
		return this.haozhongcha;
	}

	public void setHaozhongcha(Integer haozhongcha) {
		this.haozhongcha = haozhongcha;
	}

	public Integer getXingji() {
		return this.xingji;
	}

	public void setXingji(Integer xingji) {
		this.xingji = xingji;
	}

	public Timestamp getPingjiaShijian() {
		return this.pingjiaShijian;
	}

	public void setPingjiaShijian(Timestamp pingjiaShijian) {
		this.pingjiaShijian = pingjiaShijian;
	}

	public Boolean getShifoupingjia() {
		return this.shifoupingjia;
	}

	public void setShifoupingjia(Boolean shifoupingjia) {
		this.shifoupingjia = shifoupingjia;
	}

}