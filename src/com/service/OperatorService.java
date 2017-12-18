package com.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.InfoGoodsDAO;
import com.dao.InfoUserDAO;
import com.pojo.InfoDep;
import com.pojo.InfoGoods;
import com.pojo.InfoOperator;
import com.pojo.InfoUser;
@Service
public class OperatorService {
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private InfoGoodsDAO goodsDAO;
	@Autowired
	private InfoUserDAO userDAO;

	public InfoOperator operatorLogin(String username, String password) {
		System.out.println(username+"/"+password);
		String hql = "from InfoOperator i where i.id.username=? and i.id.password=?";
		List<InfoOperator> list = hqlDAO.findByHql(hql, username, password);
		if (list.size() == 0) {
			System.out.println("没找到啊啊");
			return null;
		}
		return list.get(0);
	}

	public int updateSendGoodsBybid(int bid) {
		String hql = "update OrderBig o set o.bshifoufahuo=true,o.bfahuoshijian=? where bid=?";
		Timestamp timestamp = new Timestamp(new java.util.Date().getTime());
		int n = hqlDAO.update(hql, timestamp, bid);
		return n;
	}

	public InfoDep searchDepBybmId(int bmId) {
		String hql = "from InfoDep where bmId=?";
		List<InfoDep> list = hqlDAO.findByHql(hql, bmId);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	public InfoDep searchDepBybmName(String bmName) {
		String hql = "from InfoDep d where d.bmName=?";
		List<InfoDep> list = hqlDAO.findByHql(hql, bmName);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}
	public void addGoodsInfo(String gtype, String gname, String gprice,
			String gpic, String gbigPic, String gjieshao, String gjianjie,int gkucun) {
		// 属性为空会不会成功存进数据库？
		InfoGoods infoGoods = new InfoGoods();
		infoGoods.setGtype(gtype);
		infoGoods.setGname(gname);
		infoGoods.setGprice(gprice);
		infoGoods.setGpic(gpic);
		infoGoods.setGbigPic(gbigPic);
		infoGoods.setGjieshao(gjieshao);
		infoGoods.setGjianjie(gjianjie);
		infoGoods.setGkucun(gkucun);
		hqlDAO.getSessionFromSpring().save(infoGoods);
	}

	public int updateGoodsInfo(int gid, String gname, String gprice,
			String gtype, String gpic, String gbigPic, String gjieshao,
			String gjianjie) {
		String hql = "update InfoGoods g set g.gname=?,g.gtype=?,g.gprice=?,g.gpic=?,g.gbigPic=?,g.gjieshao=?,g.gjianjie=? where g.gid=?";
		int n = hqlDAO.update(hql, gname, gtype, gprice, gpic, gbigPic,
				gjieshao, gjianjie, gid);
		return n;
	}

	public int updateUserInfo(int uid, String unicheng, String uxingming,
			String uxingbie, String uemail, String ushengri, String uphone,
			String umibaowenti1, String udaan1, String umibaowenti2,
			String udaan2) {
		java.util.Date date=new java.util.Date();
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(ushengri);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Timestamp shengri=new Timestamp(date.getTime());
		String hql = "update InfoUser set unicheng=?,uxingbie=?, uemail=?,uxingming=?, ushengri=?,uphone=?, umibaowenti1=?,udaan1=?,umibaowenti2=?,udaan2=? where uid=?";
		int n = hqlDAO.update(hql, unicheng, uxingbie, uemail, uxingming,
				shengri, uphone, umibaowenti1, udaan1, umibaowenti2, udaan2,
				uid);
		return n;
	}
	public List<InfoUser> searchAllUserInfo() {
		String hql = "from InfoUser o order by o.uid";
		List<InfoUser> list = hqlDAO.findByHql(hql);
		return list;
	}
	public List<InfoGoods> searchAllGoods() {
		String hql = "from InfoGoods g order by g.gid";
		List<InfoGoods> list = hqlDAO.findByHql(hql);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}
	public List<InfoGoods> searchGoodsInfoBygname(String gname) {
		String newgname = "%" + gname + "%";
		String hql = "from InfoGoods g where g.gname like ?";
		List<InfoGoods> list = hqlDAO.findByHql(hql, newgname);
		System.out.println("我搜到的总共商品数量为:"+list.size());
		if (list.size() == 0) {
			return null;
		}
		return list;
	}
	public InfoGoods searchGoodsInfoBygid(int gid) {
		return goodsDAO.findById(gid);
	}

	public List<InfoUser> doSearchUserInfoByuid(int uid) {
		String hql = "from InfoUser u where u.uid=? order by uid";
		List<InfoUser> list = hqlDAO.findByHql(hql, uid);
		return list;
	}

	public List<InfoUser> doSearchUserInfoByusername(String username) {
		String newusername = "%" + username.trim() + "%";
		String hql = "from InfoUser u where u.username like ?";
		List<InfoUser> list = hqlDAO.findByHql(hql,newusername);
		return list;
	}

	public InfoUser searchUserInfoByuid(int uid) {
		return userDAO.findById(uid);
	}
	public List<InfoUser> searchUserInfoByusername(String username) {
		String newUsername = "%" + username + "%";
		String hql = "from InfoUser where username like ?";
		List<InfoUser> list = hqlDAO.findByHql(hql,newUsername);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public Integer searchBiggid() {
		String hql = "select Max(u.gid) from InfoGoods u";
		List list = hqlDAO.findByHql(hql);
		if (list.size() != 0) {
			return Integer.parseInt(list.get(0).toString());
		}
		return null;
	}
}
