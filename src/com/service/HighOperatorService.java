package com.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.InfoGoodsDAO;
import com.dao.InfoUserDAO;
import com.pojo.InfoDep;
import com.pojo.InfoHighOperator;
import com.pojo.InfoOperator;
import com.pojo.InfoOperatorId;
@Service
public class HighOperatorService {
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private InfoUserDAO userDAO;
	@Autowired
	private InfoGoodsDAO goodsDAO;

	public InfoHighOperator highOperatorLogin(String username, String password) {
		String hql = "from infoHighOperator h where h.username=? and h.password=?";
		List<InfoHighOperator> list = hqlDAO.findByHql(hql, username, password);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public int updateInfoOperator(int oid, String username, String password,
			String oxingming, String ophone, String oshenfenzheng,
			String ogongzi, int bmId) {
		String hql = "update infoOperator o set o.username=?, o.password=?, o.oxingming=?, o.ophone=?, o.oshenfenzheng=?, o.ogongzi=?,o.infoDep.bmId=? where o.oid=?";
		int n = hqlDAO.update(hql, username, password, oxingming,
				ophone, oshenfenzheng, ogongzi, bmId, oid);
		return n;
	}
	
	public int deleteInfoOperator(int oid) {
		String hql = "update infoOperator o set o.olizhi=1 where o.infoOperatorId.oid=?";
		int n = hqlDAO.update(hql, oid);
		return n;
	}
	
	public void addInfoOperator(int oid, String username, String password,
			String oxingming, String ophone, String oshenfenzheng,
			String ogongzi, int bmId) {
		String hql="from InfoDep p where bmId=?";
		List<InfoDep> infoDeps=hqlDAO.findByHql(hql, bmId);
		Timestamp ojinruTime=new Timestamp(new Date().getTime());
		InfoOperatorId infoOperatorId=new InfoOperatorId();
		infoOperatorId.setOid(oid);
		infoOperatorId.setPassword(password);
		infoOperatorId.setUsername(username);
		InfoOperator infoOperator=new InfoOperator();
		infoOperator.setId(infoOperatorId);
		infoOperator.setInfoDep(infoDeps.get(0));
		infoOperator.setOgongzi(ogongzi);
		infoOperator.setOjinruTime(ojinruTime);
		infoOperator.setOlizhi(false);
		infoOperator.setOphone(ophone);
		infoOperator.setOshenfenzheng(oshenfenzheng);
		infoOperator.setOxingming(oxingming);
		hqlDAO.getSessionFromSpring().save(infoOperator);
	}
	
	public List<InfoOperator> searchAllInfoOperator() {
		String hql = "from infoOperator i where i.olizhi=0";
		List<InfoOperator> n = hqlDAO.findByHql( hql);
		return n;
	}
	
	public InfoOperator searchInfoOperatorByoid(int oid) {
		String hql = "from infoOperator u where u.oid=? and u.olizhi=0";
		List<InfoOperator> n = hqlDAO.findByHql( hql, oid);
		if (n.size() == 0) {
			return null;
		}
		return n.get(0);
	}
	
	public InfoOperator searchInfoOperatorByoxingming(String oxingming) {
		String hql = "from infoOperator i where i.oxingming=? and i.olizhi=0";
		List<InfoOperator> n = hqlDAO.findByHql( hql, oxingming);
		if (n.size() == 0) {
			return null;
		}
		return n.get(0);
	}
	
	public InfoOperator searchLizhiInfoOperatorByoid(int oid) {
		String hql = "from infoOperator o where o.oid=? and o.olizhi=1";
		List<InfoOperator> n = hqlDAO.findByHql( hql, oid);
		if (n.size() == 0) {
			return null;
		}
		return n.get(0);
	}
	
	public InfoOperator searchLizhiInfoOperatorByoxingming(String oxingming) {
		String hql = "from infoOperator o where o.oxingming=? and o.olizhi=1";
		List<InfoOperator> n = hqlDAO.findByHql( hql, oxingming);
		if (n.size() == 0) {
			return null;
		}
		return n.get(0);
	}
	
}
