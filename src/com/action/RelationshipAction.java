package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.InfoUser;
import com.pojo.RelationshipAcceptance;
import com.pojo.RelationshipChatrecord;
import com.pojo.RelationshipFriends;
import com.service.RelationshipService;
import com.util.ChangeCode;
import com.util.MD5Util;
@Controller
@RequestMapping("/re.do")
public class RelationshipAction extends HttpServlet {
	@Autowired
	private RelationshipService relationshipService;
	
	private ChangeCode change=new ChangeCode();
	@RequestMapping(params = "method=refreshFriendsList")
	private void doRefreshFriendsList(HttpServletRequest request,
			HttpServletResponse response) {
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		List<InfoUser> friendsList = relationshipService.searchAllFriends(uId);
		if (friendsList != null) {
			StringBuffer str = new StringBuffer("[");
			for (int i = 0; i < friendsList.size(); i++) {
				InfoUser ctif = friendsList.get(i);
				String FriPicPath = "pic/headpic/" + ctif.getUtouxiang();
				str.append("{'friId':'" + ctif.getUid() + "','friName':'"
						+ ctif.getUsername() + "','friuNicheng':'"
						+ change.changCode(ctif.getUnicheng()) + "','friPicPath':'" + FriPicPath
						+ "'},");
			}
			str=str.replace(str.length() - 1, str.length(), "]");

			try {
				response.getWriter().print(str.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print("false");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@RequestMapping(params = "method=searchUnreadAcceptance")
	private void doSearchUnreadAcceptanceByacId(HttpServletRequest request,
			HttpServletResponse response) {
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		List<RelationshipAcceptance> acceptanceInfos = relationshipService
				.searchUnreadAcceptanceByacGetId(uId);
		try {
			if (acceptanceInfos != null) {
				StringBuffer str = new StringBuffer("[");
				for (int i = 0; i < acceptanceInfos.size(); i++) {
					RelationshipAcceptance ctif = acceptanceInfos.get(i);
					String FriPicPath = "pic/headpic/"
							+ ctif.getInfoUserByAcSenduId().getUtouxiang();
					str.append("{'friId':'"
							+ ctif.getInfoUserByAcSenduId().getUid()
							+ "','friName':'"
							+ ctif.getInfoUserByAcSenduId().getUsername()
							+ "','friuNicheng':'"
							+ URLEncoder.encode(ctif.getInfoUserByAcSenduId().getUnicheng(),"UTF-8")
							+ "','friacId':'" + ctif.getAcId()
							+ "','friPicPath':'" + FriPicPath + "'},");
				}
				str=str.replace(str.length() - 1, str.length(), "]");

				response.getWriter().print(str.toString());
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=updateAcceptAcceptance")
	private void doUpdateAcceptAcceptanceByacId(HttpServletRequest request,
			HttpServletResponse response) {
		int acId = Integer.parseInt(request.getParameter("acId"));
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		int friId = Integer.parseInt(request.getParameter("friId"));
		RelationshipFriends relationshipInfo = relationshipService
				.searchRelationshipFriendsByacId(acId);
		try {
			if (relationshipInfo == null) {
				int n = relationshipService.updateAcceptAcceptanceByacId(acId);
				relationshipService.addFriendsRelationship(uId, friId);
				if (n == 1) {
					response.getWriter().print("true");
				} else {
					response.getWriter().print("false");
				}
			} else {
				response.getWriter().print("excist");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=updateRefuseAcceptance")
	private void doUpdateRefuseAcceptanceByacId(HttpServletRequest request,
			HttpServletResponse response) {
		int acId = Integer.parseInt(request.getParameter("acId"));
		int n = relationshipService.updateRefuseAcceptanceByacId(acId);
		try {
			if (n == 1) {
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@RequestMapping(params = "method=searchRefusedAcceptance")
	private void doSearchRefusedAcceptanceByuId(HttpServletRequest request,
			HttpServletResponse response) {
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		List<RelationshipAcceptance> acceptanceInfos = relationshipService
				.searchRefusedAcceptanceByuid(uId);
		try {
			if (acceptanceInfos != null) {
				StringBuffer str = new StringBuffer("[");
				for (int i = 0; i < acceptanceInfos.size(); i++) {
					RelationshipAcceptance ctif = acceptanceInfos.get(i);
					String FriPicPath = "pic/headpic/"
							+ ctif.getInfoUserByAcSenduId().getUtouxiang();
					str.append("{'friId':'"
							+ ctif.getInfoUserByAcSenduId().getUid()
							+ "','friName':'"
							+ ctif.getInfoUserByAcSenduId().getUsername()
							+ "','friuNicheng':'"
							+ URLEncoder.encode(ctif.getInfoUserByAcSenduId().getUnicheng(),"UTF-8")
							+ "','friPicPath':'" + FriPicPath + "'},");
				}
				str=str.replace(str.length() - 1, str.length(), "]");

				response.getWriter().print(str.toString());
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=searchAcceptedAcceptance")
	private void doSearchAcceptedAcceptanceByuId(HttpServletRequest request,
			HttpServletResponse response) {
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		List<RelationshipAcceptance> acceptanceInfos = relationshipService
				.searchAcceptedAcceptanceByuid(uId);
		try {
			if (acceptanceInfos != null) {
				StringBuffer str = new StringBuffer("[");
				for (int i = 0; i < acceptanceInfos.size(); i++) {
					RelationshipAcceptance ctif = acceptanceInfos.get(i);
					String FriPicPath = "pic/headpic/"
							+ ctif.getInfoUserByAcSenduId().getUtouxiang();
					str.append("{'friId':'"
							+ ctif.getInfoUserByAcSenduId().getUid()
							+ "','friName':'"
							+ ctif.getInfoUserByAcSenduId().getUsername()
							+ "','friuNicheng':'"
							+ URLEncoder.encode(ctif.getInfoUserByAcSenduId().getUnicheng(),"UTF-8")
							+ "','friPicPath':'" + FriPicPath + "'},");
				}
				str=str.replace(str.length() - 1, str.length(), "]");

				response.getWriter().print(str.toString());
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=searchAllAcceptanceByuId")
	private void doSearchAllAcceptanceByuId(HttpServletRequest request,
			HttpServletResponse response) {

		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		List<RelationshipAcceptance> acceptanceInfos = relationshipService
				.searchAllAcceptanceByuid(uId);
		try {
			if (acceptanceInfos != null) {
				StringBuffer str = new StringBuffer("[");
				for (int i = 0; i < acceptanceInfos.size(); i++) {
					RelationshipAcceptance ctif = acceptanceInfos.get(i);
					String FriPicPath = "pic/headpic/"
							+ ctif.getInfoUserByAcSenduId().getUtouxiang();
					str.append("{'friId':'"
							+ ctif.getInfoUserByAcSenduId().getUid()
							+ "','friName':'"
							+ ctif.getInfoUserByAcSenduId().getUsername()
							+ "','friuNicheng':'"
							+ URLEncoder.encode(ctif.getInfoUserByAcSenduId().getUnicheng(),"UTF-8")
							+ "','friPicPath':'" + FriPicPath + "'},");
				}
				str=str.replace(str.length() - 1, str.length(), "]");

				response.getWriter().print(str.toString());
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=searchFriendsByuNicheng")
	private void doSearchFriendsByuNicheng(HttpServletRequest request,
			HttpServletResponse response) {
		String uNicheng="";
		try {
			uNicheng = URLDecoder.decode(request.getParameter("friuNicheng"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<InfoUser> friendInfos = relationshipService
				.searchFriendsByuNicheng(uNicheng);
		try {
			if (friendInfos != null) {
				StringBuffer str = new StringBuffer("[");
				for (int i = 0; i < friendInfos.size(); i++) {
					InfoUser ctif = friendInfos.get(i);
					String FriPicPath = "pic/headpic/" + ctif.getUtouxiang();
					str.append("{'friId':'" + ctif.getUid() + "','friName':'"
							+ ctif.getUsername() + "','friuNicheng':'"
							+ URLEncoder.encode(ctif.getUnicheng(),"UTF-8") + "','friPicPath':'"
							+ FriPicPath + "'},");
				}
				str=str.replace(str.length() - 1, str.length(), "]");

				response.getWriter().print(str.toString());
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=searchFriendsByUsername")
	private void doSearchFriendsByUsername(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		List<InfoUser> friendInfos = relationshipService
				.searchFriendsByUsername(username);
		try {
			if (friendInfos != null) {
				StringBuffer str = new StringBuffer("[");
				for (int i = 0; i < friendInfos.size(); i++) {
					InfoUser ctif = friendInfos.get(i);
					String FriPicPath = "pic/headpic/" + ctif.getUtouxiang();
					str.append("{'friId':'" + ctif.getUid() + "','friName':'"
							+ ctif.getUsername() + "','friuNicheng':'"
							+ URLEncoder.encode(ctif.getUnicheng(),"UTF-8") + "','friPicPath':'"
							+ FriPicPath + "'},");
				}
				str=str.replace(str.length() - 1, str.length(), "]");

				response.getWriter().print(str.toString());
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@RequestMapping(params = "method=addInsertAcceptance")
	private void doAddInsertAcceptance(HttpServletRequest request,
			HttpServletResponse response) {
		int acSenduId = ((InfoUser) request.getSession().getAttribute(
				"userinfo")).getUid();
		int acGetuId = Integer.parseInt(request.getParameter("acGetuId"));
		relationshipService.addInsertAcceptance(acSenduId, acGetuId);
		try {
			response.getWriter().print("true");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=refreshChating")
	private void doRefreshChating(HttpServletRequest request,
			HttpServletResponse response) {
		int friId = Integer.parseInt(request.getSession().getAttribute("friId")
				.toString());
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		List<RelationshipChatrecord> chatingInfos = relationshipService
				.searchAllRelationshipChatrecord(uId, friId);
		System.out.println(chatingInfos);
		StringBuffer str = new StringBuffer("[");
		try {
			for (int i = 0; i < chatingInfos.size(); i++) {
				RelationshipChatrecord ctif = chatingInfos.get(i);
				str.append("{'chatTime':'" + ctif.getRecordTime()
						+ "','chatPerson':'" + change.changCode(ctif.getInfoUser().getUnicheng())
						+ "','chatText':'" + change.changCode(ctif.getRecordText()) + "'},");
			}
			str=str.replace(str.length() - 1, str.length(), "]");
			response.getWriter().print(str.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=addSendChating")
	private void doAddSendChating(HttpServletRequest request,
			HttpServletResponse response) {
		int friId = Integer.parseInt(request.getSession().getAttribute("friId")
				.toString());
		String uNicheng = ((InfoUser) request.getSession().getAttribute(
				"userinfo")).getUnicheng();
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		int reId = Integer.parseInt(relationshipService
				.searchreIdByreuid1reuid2(friId, uId));
		String text = "";
		try {
			text = URLDecoder.decode(request.getParameter("text"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date nowDate = new Date();
		String time = new Timestamp(nowDate.getTime()) + "";
		time = time.substring(0, 21);
		String str = "[{'chatTime':'" + time + "','chatPerson':'" + change.changCode(uNicheng)
				+ "','chatText':'" + change.changCode(text) + "'}]";
		relationshipService.addSendChatingInfo(friId, uId, text, reId);
		try {
			response.getWriter().print(str.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=startChating")
	private void doStartChating(HttpServletRequest request,
			HttpServletResponse response) {
		int friId = Integer.parseInt(request.getParameter("friId"));
		request.getSession().setAttribute("friId", friId);
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		List<RelationshipChatrecord> chatingInfos = relationshipService
				.searchAllRelationshipChatrecord(uId, friId);
		StringBuffer str = new StringBuffer("[");
		try {
			if (chatingInfos == null) {
				response.getWriter().print("[]");
			} else {
				for (int i = 0; i < chatingInfos.size(); i++) {
					RelationshipChatrecord ctif = chatingInfos.get(i);
					str.append("{'chatTime':'" + ctif.getRecordTime()
							+ "','chatPerson':'"
							+ change.changCode(ctif.getInfoUser().getUnicheng())
							+ "','chatText':'" + change.changCode(ctif.getRecordText()) + "'},");
				}
				str=str.replace(str.length() - 1, str.length(), "]");
				response.getWriter().print(str.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=searchAllFriends")
	private void doSearchAllFriends(HttpServletRequest request,
			HttpServletResponse response) {
		int uId = ((InfoUser) request.getSession().getAttribute("userinfo"))
				.getUid();
		List<InfoUser> infoUsers = relationshipService.searchAllFriends(uId);
		request.getSession().setAttribute("infoUsers", infoUsers);
		System.out.println("查找好友人数成功");
		try {
			response.getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
