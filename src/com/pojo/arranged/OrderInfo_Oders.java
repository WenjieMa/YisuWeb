package com.pojo.arranged;

import java.util.List;

import com.pojo.OrderSmall;

public class OrderInfo_Oders {
	
	protected List<OrderSmall> list;
	protected String fukuanjine;
	protected String bShifoufukuan;
	protected Boolean bShifoupingjia;
	public String getbShifoufukuan() {
		return bShifoufukuan;
	}
	public Boolean getbShifoupingjia() {
		return bShifoupingjia;
	}
	public void setbShifoupingjia(Boolean bShifoupingjia) {
		this.bShifoupingjia = bShifoupingjia;
	}
	public void setbShifoufukuan(String bShifoufukuan) {
		this.bShifoufukuan = bShifoufukuan;
	}
	public String getFukuanjine() {
		return fukuanjine;
	}
	public List<OrderSmall> getList() {
		return list;
	}
	public void setFukuanjine(String fukuanjine) {
		this.fukuanjine = fukuanjine;
	}
	public void setList(List<OrderSmall> list) {
		this.list = list;
	}

}
