package com.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.InfoUserDAO;
import com.pojo.InfoUser;
@Service
public class UserService {
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private InfoUserDAO userDAO;

	public InfoUser login(String username, String password) {
		String hql = "from InfoUser u where u.username=? and u.password=?";
		List<InfoUser> list = hqlDAO.findByHql(hql, username, password);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);

	}
	public void regist(String username, String password, String uxingming,
			String uxingbie, String uphone, String uemail, String utouxiang,
			String ushengri, String umibaowenti1, String umibaowenti2,
			String udaan1, String udaan2) {
		InfoUser infoUser = new InfoUser();
		infoUser.setUsername(username);
		infoUser.setPassword(password);
		infoUser.setUxingming(uxingming);
		infoUser.setUxingbie(uxingbie);
		infoUser.setUphone(uphone);
		infoUser.setUemail(uemail);
		infoUser.setUtouxiang(utouxiang);
		try {
			infoUser.setUshengri(new SimpleDateFormat("yyyy-mm-dd")
					.parse(ushengri));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		infoUser.setUmibaowenti1(umibaowenti1);
		infoUser.setUmibaowenti2(umibaowenti2);
		infoUser.setUdaan1(udaan1);
		infoUser.setUdaan2(udaan2);
		hqlDAO.getSessionFromSpring().save(infoUser);
	}

	public int updateAddress(String username, String uchangyongdizhi, int uCid) {
		String hql = "update InfoUser u set u.uchangyongdizhi" + uCid
				+ "=? where u.username=?";
		int n = hqlDAO.update(hql, uchangyongdizhi, username);
		return n;
	}

	public int updateUserPassword(int uid, String password) {
		String hql = "update InfoUser u set u.password=? where u.uid=?";
		int n = hqlDAO.update(hql, password, uid);
		return n;
	}

	public int updatePayPassword(int uid, String uzhifumima) {
		String hql = "update InfoUser u set u.uzhifumima=? where u.uid=?";
		int n = hqlDAO.update(hql, uzhifumima, uid);
		return n;
	}

	public String searchQuestion1(String username) {
		String hql = "from InfoUser u where u.username=?";
		InfoUser infoUser = (InfoUser) hqlDAO.findByHql(hql, username).get(0);
		return infoUser.getUmibaowenti1();
	}

	public String searchQuestion2(String username) {
		String hql = "from InfoUser u where u.username=?";
		InfoUser infoUser = (InfoUser) hqlDAO.findByHql(hql, username).get(0);
		return infoUser.getUmibaowenti2();
	}

	public boolean verifyAnswer1(String username, String uDaan) {
		String hql = "from InfoUser u where u.username=? and u.udaan1=?";
		List list = hqlDAO.findByHql(hql, username, uDaan);
		if (list.size() == 0) {
			return false;
		}
		return true;
	}

	public boolean verifyAnswer2(String username, String uDaan) {
		String hql = "from InfoUser u where u.username=? and u.udaan2=?";
		List list = hqlDAO.findByHql(hql, username, uDaan);
		if (list.size() == 0) {
			return false;
		}
		return true;
	}

	public boolean verifyPhoneNumber(String uphone) {
		String hql = "from InfoUser u where u.uphone=?";
		List list = hqlDAO.findByHql(hql, uphone);
		if (list.size() == 0) {
			return true;
		}
		return false;
	}

	public boolean verifyUsername(String username) {
		String hql = "from InfoUser u where u.username=?";
		List list = hqlDAO.findByHql(hql, username);
		if (list.size() == 0) {
			return true;
		}
		return false;
	}

	public boolean verifyEmail(String uemail) {
		String hql = "from InfoUser u where u.uemail=?";
		List list = hqlDAO.findByHql(hql, uemail);
		if (list.size() == 0) {
			return true;
		}
		return false;
	}

	public int updateInfoUser(String unicheng, String uxingzuo,
			String utouxiang, String uqq, int uid) {
		String hql = "update InfoUser u set u.unicheng=?,u.uxingzuo=?,u.utouxiang=?,u.uqq=? where u.uid=?";
		int n = hqlDAO.update(hql, unicheng, uxingzuo, utouxiang, uqq, uid);
		return n;
	}

	public boolean verifyPayPassword(String uzhifumima, int uid) {
		String hql = "from InfoUser u where u.uid=? and u.uzhifumima=?";
		List t = hqlDAO.findByHql(hql, uid, uzhifumima);
		if (t.size() == 0) {
			return false;
		}
		return true;
	}

	public boolean verifyUserPassword(String password, int uid) {
		String hql = "from InfoUser u where u.uid=? and u.password=?";
		List t = hqlDAO.findByHql(hql, uid, password);
		if (t.size() == 0) {
			return false;
		}
		return true;
	}

	public String searchPayPassword(int uid) {
		String hql = "from InfoUser u where  u.uid=?";
		List<InfoUser> t = hqlDAO.findByHql(hql, uid);
		if (t.size() == 0) {
			return null;
		}
		return t.get(0).getUzhifumima();
	}
}
