package com.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.dialect.InformixDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.HqlDAO;
import com.dao.InfoUserDAO;
import com.dao.RelationshipAcceptanceDAO;
import com.dao.RelationshipChatrecordDAO;
import com.dao.RelationshipFriendsDAO;
import com.pojo.InfoUser;
import com.pojo.RelationshipAcceptance;
import com.pojo.RelationshipChatrecord;
import com.pojo.RelationshipFriends;

@Service
public class RelationshipService {
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private InfoUserDAO infoUserDAO;
	@Autowired
	private RelationshipAcceptanceDAO acceptanceDAO;
	@Autowired
	private RelationshipChatrecordDAO chatrecordDAO;
	@Autowired
	private RelationshipFriendsDAO friendsDAO;

	public List<RelationshipChatrecord> searchAllRelationshipChatrecord(int reuid1, int reuid2) {
		String hql = "From RelationshipChatrecord r join fetch r.relationshipFriends f join fetch f.infoUserByReuId1 us1 join fetch f.infoUserByReuId2 us2 join fetch r.infoUser u where us1.uid=? and us2.uid=? or us2.uid=? and us1.uid=?";
		List<RelationshipChatrecord> chatrecords = hqlDAO.findByHql(hql, reuid1, reuid2, reuid1, reuid2);
		return chatrecords;
	}

	public List<RelationshipFriends> searchRelationshipFriendssByuid(int uid) {
		String hql = "from RelationshipFriends r where r.infoUserByReuid1.uid=? or r.infoUserByReuid2.uid=?";
		List<RelationshipFriends> RelationshipFriendss = hqlDAO.findByHql(hql, uid, uid);
		if (RelationshipFriendss.size() == 0) {
			return null;
		}
		return RelationshipFriendss;
	}

	public List<RelationshipChatrecord> searchAllChatingInfo(int friId, int uid) {
		String hql = "from RelationshipFriends f where f.infoUserByReuid1.uid=? and f.infoUserByReuid2.uid=? or f.infoUserByReuid2.uid=? and f.infoUserByReuid1.uid=? ";
		List<RelationshipFriends> relationshipFriends = hqlDAO.findByHql(hql, friId, uid, friId, uid);
		if (relationshipFriends.size() != 0) {
			RelationshipFriends friends = relationshipFriends.get(0);
			String hql2 = "from RelationshipChatrecord r where r.infoUser.uid=? and r.relationshipFriends.reId=? or r.infoUser.uid=? and r.relationshipFriends.reId=?";
			List<RelationshipChatrecord> chatrecords = hqlDAO.findByHql(hql2, friId, friends.getReId(), uid,
					friends.getReId());
			return chatrecords;
		} else {
			System.out.println("查找聊天信息的时候没找到朋友关系");
		}
		return null;
	}

	public void addSendChatingInfo(int friId, int uid, String text, int reId) {
		RelationshipChatrecord chatrecord = new RelationshipChatrecord();
		String hql = "from InfoUser u where u.uid=?";
		List<InfoUser> infoSendUsers = hqlDAO.findByHql(hql, uid);
		String hql2 = "from RelationshipFriends f where f.reId=?";
		List<RelationshipFriends> friends = hqlDAO.findByHql(hql2, reId);
		chatrecord.setInfoUser(infoSendUsers.get(0));
		chatrecord.setRelationshipFriends(friends.get(0));
		chatrecord.setRecordText(text);
		hqlDAO.getSessionFromSpring().save(chatrecord);
	}

	public String searchreIdByreuid1reuid2(int friId, int uid) {
		System.out.println(friId+"/t"+uid);
		String hql = "from RelationshipFriends r join fetch r.infoUserByReuId1 r1 join fetch r.infoUserByReuId2 r2 where r1.uid=? and r2.uid=? or r1.uid=? and r2.uid=?";
		List<RelationshipFriends> list = hqlDAO.findByHql(hql, uid, friId, friId, uid);
		if (list.size() == 0) {
			System.out.println("没找到好友");
			return null;
		}
		return list.get(0).getReId().toString();
	}

	public List<InfoUser> searchAllFriends(int uid) {
		String hql = "from RelationshipFriends r join fetch r.infoUserByReuId1 r1 join fetch r.infoUserByReuId2 r2 where r1.uid=? or r2.uid=?";
		List<RelationshipFriends> list = hqlDAO.findByHql(hql, uid, uid);
		List<InfoUser> infoUsers = new ArrayList<InfoUser>();
		for (RelationshipFriends relationshipFriends : list) {
			if (relationshipFriends.getInfoUserByReuId1().getUid() == uid) {
				infoUsers.add(relationshipFriends.getInfoUserByReuId2());
			} else {
				infoUsers.add(relationshipFriends.getInfoUserByReuId1());
			}
		}
		return infoUsers;
	}

	public void addInsertAcceptance(int acSenduid, int acGetuid) {
		RelationshipAcceptance acceptance = new RelationshipAcceptance();
		InfoUser infoUserByAcGetuId = infoUserDAO.findById(acGetuid);
		InfoUser infoUserByAcSenduId = infoUserDAO.findById(acSenduid);
		acceptance.setInfoUserByAcGetuId(infoUserByAcGetuId);
		acceptance.setInfoUserByAcSenduId(infoUserByAcSenduId);
		hqlDAO.getSessionFromSpring().save(acceptance);
	}

	public List<InfoUser> searchFriendsByuNicheng(String uNicheng) {
		uNicheng = "%" + uNicheng + "%";
		String hql = "from InfoUser u where u.unicheng like ?";
		List<InfoUser> list = hqlDAO.findByHql(hql, uNicheng);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public List<InfoUser> searchFriendsByUsername(String username) {
		username = "%" + username + "%";
		String hql = "from InfoUser u where u.username like ?";
		List<InfoUser> list = hqlDAO.findByHql(hql, username);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public List<RelationshipAcceptance> searchAllAcceptanceByuid(int uid) {
		String hql = "from RelationshipAcceptance a where a.infoUserByAcGetuId.uid=?";
		List<RelationshipAcceptance> list = hqlDAO.findByHql(hql, uid);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public List<RelationshipAcceptance> searchAcceptedAcceptanceByuid(int uid) {
		String hql = "from RelationshipAcceptance a where a.infoUserByAcGetuId.uid=? and acAccept=true";
		List<RelationshipAcceptance> list = hqlDAO.findByHql(hql, uid);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public List<RelationshipAcceptance> searchRefusedAcceptanceByuid(int uid) {
		String hql = "from RelationshipAcceptance a where a.infoUserByAcGetuId.uid=? and acRefuse=true";
		List<RelationshipAcceptance> list = hqlDAO.findByHql(hql, uid);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public int updateRefuseAcceptanceByacId(int acId) {
		String hql = "update RelationshipAcceptance a set a.acRefuse=true,a.acRefuseTime=CURRENT_TIMESTAMP where a.acId=?";
		int n = hqlDAO.update(hql, acId);
		return n;
	}

	public int updateAcceptAcceptanceByacId(int acId) {
		String hql = "update RelationshipAcceptance a set a.acAccept=true,a.acAcceptTime=CURRENT_TIMESTAMP where a.acId=?";
		int n = hqlDAO.update(hql, acId);
		return n;
	}

	public List<RelationshipAcceptance> searchUnreadAcceptanceByacGetId(int acGetuid) {
		String hql = "from RelationshipAcceptance a where a.infoUserByAcGetuId.uid=? and a.acRefuse=false and a.acAccept=false";
		List<RelationshipAcceptance> list = hqlDAO.findByHql(hql, acGetuid);
		if (list.size() == 0) {
			return null;
		}
		return list;
	}

	public RelationshipFriends searchRelationshipFriendsByacId(int acId) {
		String acHql = "from RelationshipAcceptance a where a.acId=?";
		RelationshipAcceptance acceptance = (RelationshipAcceptance) hqlDAO.findByHql(acHql, acId).get(0);
		String hql = "from RelationshipFriends r where r.infoUserByReuId1.uid=? and r.infoUserByReuId2.uid=?"
				+ "or r.infoUserByReuId1.uid=? and r.infoUserByReuId2.uid=?";
		int sendUid = acceptance.getInfoUserByAcSenduId().getUid();
		int getUid = acceptance.getInfoUserByAcGetuId().getUid();
		List<RelationshipFriends> list = hqlDAO.findByHql(hql, sendUid, getUid, sendUid, getUid);
		if (list.size() == 0) {
			return null;
		}
		return list.get(0);
	}

	public void addFriendsRelationship(int uid, int friId) {
		InfoUser infoUserByReuId1 = infoUserDAO.findById(uid);
		InfoUser infoUserByReuId2 = infoUserDAO.findById(friId);
		RelationshipFriends friends = new RelationshipFriends(infoUserByReuId1, infoUserByReuId2);
		hqlDAO.getSessionFromSpring().save(friends);
	}
}