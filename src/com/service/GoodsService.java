package com.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.InfoCollectionDAO;
import com.dao.InfoGoodsDAO;
import com.dao.InfoUserDAO;
import com.dao.OrderBigDAO;
import com.dao.OrderSmallDAO;
import com.pojo.InfoCollection;
import com.pojo.InfoCollectionId;
import com.pojo.InfoGoods;
import com.pojo.InfoUser;
import com.pojo.OrderBig;
import com.pojo.OrderSmall;
import com.pojo.OrderSmallId;
import com.pojo.arranged.GoodsBuyInfo;
import com.util.*;
@Service
public class GoodsService {
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private InfoGoodsDAO goodsDAO;
	@Autowired
	private InfoUserDAO userDAO;
	@Autowired
	private InfoCollectionDAO collectionDAO;
	@Autowired
	private OrderSmallDAO orderSmallDAO;
	@Autowired
	private OrderBigDAO orderBigDAO;
	@Autowired
	private InfoUserDAO infoUserDAO;
	
	public int addCreateBigOrder(int uid, String bshouhuodizhi,
			List<GoodsBuyInfo> goodsBuyInfos) {
		double fukuanjine = 0;
		for (int m = 0; m < goodsBuyInfos.size(); m++) {
			fukuanjine = fukuanjine
					+ Double.parseDouble(goodsBuyInfos.get(m).getGprice())
					* goodsBuyInfos.get(m).getShuliang();
		}
		OrderBig orderBig = new OrderBig();
		List<InfoUser> infoUsers=hqlDAO.findByHql("from InfoUser u where u.uid=?", uid);
		orderBig.setInfoUser(infoUsers.get(0));
		orderBig.setBshouhuodizhi(bshouhuodizhi);
		orderBig.setFukuanjine(fukuanjine + "");
		orderBig.setOrderSmalls(new TurnToSet().turnListToSet(goodsBuyInfos));
		hqlDAO.getSessionFromSpring().save(orderBig);
		return orderBig.getBid();
	}

	public int deleteCollection(int gid, int uid) {
		String hql = "from InfoCollection c where c.id.infoUser.uid=? and c.id.infoGoods.gid=?";
		List<InfoCollection> collections =hqlDAO.findByHql(hql, uid,
				gid);
		collectionDAO.delete(collections.get(0));
		String hql2 = "update InfoGoods g set g.gxihuanshu=g.gxihuanshu-1 where g.gid=?";
		int n = hqlDAO.update(hql2, gid);
		return n;
	}

	public int updatePayOrderSuccessfully(int bid) {
		String hql = "update OrderBig b set b.bshifoufukuan=1 where b.bid=?";
		return hqlDAO.update(hql, bid);
	}

	public boolean updatePayOrder(int uid, double zongjia, int bid) {
		String hql = "from InfoUser u where u.uid=?";
		List<InfoUser> infoUser = hqlDAO.findByHql(hql, uid);
		if (infoUser != null) {
			InfoUser info=infoUser.get(0);
			Double cha = info.getUmoney() - zongjia;
			if (cha < 0) {
				return false;
			} else {
				String hql2 = "update InfoUser u  set u.umoney=? where u.uid=?";
				int n = hqlDAO.update(hql2, cha, uid);
				String nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new java.sql.Date(new Date().getTime()));
				Timestamp date = Timestamp.valueOf(nowtime);
				String hql3 = "update OrderBig o set o.bshifoufukuan=1,o.bfukuanshijian=? where o.bid=?";
				int n2 = hqlDAO.update(hql3, date, bid);
				if (n == 1 && n2 == 1) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	public List<InfoGoods> searchInfoGoodsByType(String gtype) {
		String hql = "from InfoGoods g where g.gtype like ? or g.gtype like ?";
		List<InfoGoods> list = hqlDAO.findByHql(hql,gtype+"%","%"+gtype);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}
	public List<InfoGoods> searchInfoGoodsBygname(String gname) {
		System.out.println(gname);
		String hql = "from InfoGoods g where g.gname like ? or g.gname like ?";
		List<InfoGoods> list = hqlDAO.findByHql(hql,gname+"%","%"+gname);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}
	public OrderBig searchBigOrderBybid(int bid) {
		String hql = "from OrderBig o where o.bid=?";
		List<OrderBig> infoBigs = hqlDAO.findByHql(hql, bid);
		if (infoBigs.size() == 0) {
			return null;
		}
		return infoBigs.get(0);
	}
	public List<OrderBig> searchBigOrdersByuid(int uid) {
		String hql = "from OrderBig o join fetch o.infoUser g where g.uid=?";
		List<OrderBig> infoBigs = hqlDAO.findByHql(hql, uid);
		if (infoBigs.size() == 0) {
			return null;
		}
		return infoBigs;
	}
	public List<OrderSmall> searchSmallOrderBygid(int gid) {
		String hql = "from OrderSmall o join fetch o.infoGoods g where g.gid=?";
		List<OrderSmall> infoSmall = hqlDAO.findByHql(hql, gid);
		if (infoSmall.size() == 0) {
			System.out.println("没找到666");
			return null;
		}
		return infoSmall;
	}
	public List<OrderSmall> searchSmallOrdersByuid(int uid) {
		String hql="from OrderSmall o join fetch o.infoUser u join fetch o.infoGoods gg join fetch o.orderBig oo where u.uid=?";
		List<OrderSmall> infoSmalls =hqlDAO.findByHql(hql, uid);
		if (infoSmalls.size() == 0) {
			System.out.println("我好像没找到东西");
			return null;
		}
		return infoSmalls;
	}
	public List<OrderSmall> searchSmallOrdersBybid(int bid) {
		String hql = "from OrderSmall o join fetch o.orderBig b join fetch o.infoGoods g where b.bid=?";
		List<OrderSmall> infoSmalls = hqlDAO.findByHql(hql, bid);
		if (infoSmalls.size() == 0) {
			System.out.println("没找到啊没找到");
			return null;
		}
		return infoSmalls;
	}
	public int addToCollection(int uid, int gid) {
		InfoCollectionId collectionId = new InfoCollectionId();
		collectionId.setInfoGoods(goodsDAO.findById(gid));
		collectionId.setInfoUser(userDAO.findById(uid));
		InfoCollection infoCollection=new InfoCollection(collectionId);
		hqlDAO.getSessionFromSpring().save(infoCollection);
		String hql2 = "update InfoGoods g set g.gxihuanshu=g.gxihuanshu+1 where g.gid=?";
		int n = hqlDAO.update(hql2, gid);
		return n;
	}
	public int searchCollections(int uid, int gid) {
		String hql = "from InfoCollection i where i.id.infoUser.uid=? and i.id.infoGoods.gid =?";
		List<InfoCollection> list = hqlDAO.findByHql(hql, uid, gid);
		if (list.size() == 0) {
			return 0;
		}
		return 1;
	}
	public List<InfoGoods> searchCollectionInfoGoodsByuid(int uid) {
		String hql2 = "from InfoCollection c where c.id.infoUser.uid=?";
		List<InfoCollection> collectionIds = hqlDAO.findByHql(hql2, uid);
		List<InfoGoods> list = new ArrayList<InfoGoods>();
		for (InfoCollection infoCollection : collectionIds) {
			String hql_temp = "from InfoGoods g where g.gid=?";
			List<InfoGoods> list2 = hqlDAO.findByHql(hql_temp,infoCollection.getId().getInfoGoods().getGid());
			list.addAll(list2);
		}
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public int updateGetGoods(int bid) {
		String hql = "update OrderBig o set o.bshifoushouhuo=true,o.bshouhuoshijian=?  where o.bid=?";
		String nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new java.sql.Date(new Date().getTime()));
		Timestamp date = Timestamp.valueOf(nowtime);
		int n = hqlDAO.update(hql, date, bid);
		if (n == 1) {
			return n;
		}
		return 0;
	}

	public GoodsBuyInfo verifyStock(int gid, int shuliang) {
		String hql = "from InfoGoods o where o.gid=?";
		List<InfoGoods> list = hqlDAO.findByHql(hql, gid);
		InfoGoods goods = (InfoGoods) list.get(0);
		if (goods.getGkongxiankucun() >= shuliang) {
			String hql2 = "update InfoGoods g set g.gkongxiankucun =? where g.gid=?";
			int n = hqlDAO.update(hql2, list.get(0).getGkongxiankucun()
					- shuliang, gid);
			if (n == 1) {
				String hql3 = "from InfoGoods o where o.gid = ?";
				List<InfoGoods> list2 = hqlDAO.findByHql(hql3, gid);
				GoodsBuyInfo goodsBuyInfo = new GoodsBuyInfo();
				goodsBuyInfo.setGid(list2.get(0).getGid());
				goodsBuyInfo.setGname(list2.get(0).getGname());
				goodsBuyInfo.setGpic(list2.get(0).getGpic());
				goodsBuyInfo.setGbigPic(list2.get(0).getGbigPic());
				goodsBuyInfo.setGprice(list2.get(0).getGprice());
				goodsBuyInfo.setShuliang(shuliang);
				return goodsBuyInfo;
			}
		}
		return null;
	}
	public int updateCommitSingleGoods(int did, int haozhongcha, int xingji,
			String pingjia) {
		String hql = "update OrderSmall o set o.shifoupingjia=1  where o.id.did=?";
		int n = hqlDAO.update(hql, did);
		String hql2 = "update OrderSmall o set o.pingjia=?,o.haozhongcha=?,xingji=?,pingjiaShijian=? where o.id.did=?";
		String nowtime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
				.format(new java.sql.Date(new Date().getTime()));
		Timestamp date = Timestamp.valueOf(nowtime);
		int n2 = hqlDAO.update(hql2, pingjia, haozhongcha, xingji, date, did);
		int panduan = 0;
		if (n == 1 && n2 == 1) {
			panduan = 1;
		}
		return panduan;
	}
	public OrderSmall searchSmallOrderBydid(int did) {
		String hql = "from OrderSmall o where o.id.did=?";
		List<OrderSmall> infoSmalls = hqlDAO.findByHql(hql, did);
		if (infoSmalls.size() == 0) {
			System.out.println("我好像没找到东西");
			return null;
		}
		return infoSmalls.get(0);
	}
	public int updateCommitSingleGoodsThenBigOrder(int bigDingdanId) {
		String hql = "update OrderBig o set o.bshifoupingjia=1 where o.bid=?";
		int n = hqlDAO.update(hql, bigDingdanId);
		return n;
	}
	public List<Integer> searchRandomGoodsgid() {
		String hql = "from InfoGoods g where g.gkucun>0";
		List<InfoGoods> infoGoods = hqlDAO.findByHql(hql);
		if (infoGoods.size() == 0) {
			return null;
		}
		List<Integer> integers = new ArrayList<Integer>();
		for (InfoGoods goods : infoGoods) {
			integers.add(goods.getGid());
		}
		return integers;
	}
	public int deleteBigOrder(int bid) {
		String hql = "delete from OrderSmall g where g.orderBig.bid=?";
		int n1 = hqlDAO.update(hql, bid);
		String hql2 = "delete from OrderBig g where g.bid=?";
		int n2 = hqlDAO.update(hql2, bid);
		int n;
		if (n1 != 0 && n2 == 1) {
			n = 1;
		} else {
			n = 0;
		}
		return n;
	}

	public InfoGoods findById(int gid) {
		return goodsDAO.findById(gid);
	}

	public void addCreateSmallOrder(int gid, int shuliang, int bid, int uid) {
		OrderSmall orderSmall=new OrderSmall();
		OrderSmallId id=new OrderSmallId();
		id.setBid(bid);
		id.setGid(gid);
		id.setUid(uid);
		orderSmall.setId(id);
		orderSmall.setShuliang(shuliang);
		hqlDAO.getSessionFromSpring().save(orderSmall);
	}

}
