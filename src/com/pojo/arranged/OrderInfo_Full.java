package com.pojo.arranged;

import java.util.List;

import com.pojo.OrderBig;
import com.pojo.OrderSmall;

public class OrderInfo_Full {
	protected List<OrderSmall> list;
	protected OrderBig orderInfo_Big;
	public List<OrderSmall> getList() {
		return list;
	}
	public void setList(List<OrderSmall> list) {
		this.list = list;
	}
	public OrderBig getOrderBig() {
		return orderInfo_Big;
	}
	public void setOrderBig(OrderBig orderInfo_Big) {
		this.orderInfo_Big = orderInfo_Big;
	}
	
}
