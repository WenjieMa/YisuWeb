package com.pojo.arranged;

import java.util.List;

import com.pojo.OrderSmall;

public class GoodsShowInfo {
	protected int gId;
	protected String xingji;
	protected int hao;
	protected int zhong;
	protected int cha;
	protected List<OrderSmall> infoSmall_hao;
	protected List<OrderSmall> infoSmall_zhong;
	protected List<OrderSmall> infoSmall_cha;
	protected List<OrderSmall> infoSmall;

	public int getCha() {
		return cha;
	}
	public int getgId() {
		return gId;
	}
	public int getHao() {
		return hao;
	}
	public List<OrderSmall> getInfoSmall() {
		return infoSmall;
	}
	public List<OrderSmall> getInfoSmall_cha() {
		return infoSmall_cha;
	}
	public List<OrderSmall> getInfoSmall_hao() {
		return infoSmall_hao;
	}
	public List<OrderSmall> getInfoSmall_zhong() {
		return infoSmall_zhong;
	}
	public int getZhong() {
		return zhong;
	}
	public void setCha(int cha) {
		this.cha = cha;
	}
	public void setgId(int gId) {
		this.gId = gId;
	}
	public void setHao(int hao) {
		this.hao = hao;
	}
	public void setInfoSmall(List<OrderSmall> infoSmall) {
		this.infoSmall = infoSmall;
	}
	public void setInfoSmall_cha(List<OrderSmall> infoSmallCha) {
		infoSmall_cha = infoSmallCha;
	}
	public void setInfoSmall_hao(List<OrderSmall> infoSmallHao) {
		infoSmall_hao = infoSmallHao;
	}
	public void setInfoSmall_zhong(List<OrderSmall> infoSmallZhong) {
		infoSmall_zhong = infoSmallZhong;
	}
	public String getXingji() {
		return xingji;
	}
	public void setXingji(String xingji) {
		this.xingji = xingji;
	}
	public void setZhong(int zhong) {
		this.zhong = zhong;
	}

}
