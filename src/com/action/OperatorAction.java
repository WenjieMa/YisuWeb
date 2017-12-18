package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.InfoDep;
import com.pojo.InfoGoods;
import com.pojo.InfoOperator;
import com.pojo.InfoUser;
import com.service.OperatorService;
import com.util.ChangeCode;
import com.util.MD5Util;

@Controller
@RequestMapping("/operator.do")
public class OperatorAction extends HttpServlet {
	@Autowired
	private OperatorService operatorService;

	private ChangeCode change = new ChangeCode();

	@RequestMapping(params = "method=searchBiggId")
	private void doSearchBiggId(HttpServletRequest request, HttpServletResponse response) {
		Integer n = operatorService.searchBiggid();
		if (n != null) {
			n = n + 1;
			String str = n + "";
			try {
				response.getWriter().print(str);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@RequestMapping(params = "method=searchAllUserInfo")
	private void doSearchAllUserInfo(HttpServletRequest request, HttpServletResponse response) {
		List<InfoUser> infos = operatorService.searchAllUserInfo();
		if (infos != null) {
			StringBuffer str = new StringBuffer("[");
			for (int i = 0; i < infos.size(); i++) {
				InfoUser info = infos.get(i);
				str.append("{'uIdUpdate':'" + info.getUid() + "','usernameUpdate':'" + info.getUsername()
						+ "','uNichengUpdate':'" + change.changCode(info.getUnicheng()) + "','uXingmingUpdate':'"
						+ change.changCode(info.getUxingming()) + "','uXingbieUpdate':'"
						+ change.changCode(info.getUxingbie()) + "','uPhoneUpdate':'" + info.getUphone()
						+ "','uEmailUpdate':'" + info.getUemail() + "','uShengriUpdate':'" + info.getUshengri()
						+ "','uMibaowenti1Update':'" + change.changCode(info.getUmibaowenti1()) + "','uDaan1Update':'"
						+ change.changCode(info.getUdaan1()) + "','uMibaowenti2Update':'"
						+ change.changCode(info.getUmibaowenti2()) + "','uDaan2Update':'"
						+ change.changCode(info.getUdaan2()) + "'},");
			}
			str.substring(str.length() - 1, str.length());
			str.append("]");
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

	@RequestMapping(params = "method=searchAllGoods")
	private void doSearchAllGoods(HttpServletRequest request, HttpServletResponse response) {
		List<InfoGoods> info = operatorService.searchAllGoods();
		StringBuffer str = new StringBuffer("[");
		for (int i = 0; i < info.size(); i++) {
			InfoGoods ctif = info.get(i);
			str.append("{'gIdUpdate':'" + ctif.getGid() + "','gNameUpdate':'" + change.changCode(ctif.getGname())
					+ "','gPriceUpdate':'" + ctif.getGprice() + "','gTypeUpdate':'" + change.changCode(ctif.getGtype())
					+ "','gKucunUpdate':'" + ctif.getGkucun() + "','gPicUpdate':'" + request.getContextPath()
					+ "/pic/goods/" + ctif.getGpic() + "','gBigPicUpdate':'" + request.getContextPath() + "/pic/goods/"
					+ ctif.getGbigPic() + "','gJieshaoUpdate':'" + change.changCode(ctif.getGjieshao())
					+ "','gJianjieUpdate':'" + change.changCode(ctif.getGjianjie()) + "','gRukushijianUpdate':'"
					+ ctif.getGrukushijian() + "'},");
		}
		str.substring(str.length() - 1, str.length());
		str.append("]");
		try {
			response.getWriter().print(str.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=searchUserInfoByusername")
	private void doSearchUserInfoByusername(HttpServletRequest request, HttpServletResponse response) {
		String username = URLDecoder.decode(request.getParameter("username"));
		List<InfoUser> infos = operatorService.searchUserInfoByusername(username);
		if (infos != null) {
			StringBuffer str = new StringBuffer("[");
			for (int i = 0; i < infos.size(); i++) {
				InfoUser info = infos.get(i);
				str.append("{'uIdUpdate':'" + info.getUid() + "','usernameUpdate':'" + info.getUsername()
						+ "','uNichengUpdate':'" + change.changCode(info.getUnicheng()) + "','uXingmingUpdate':'"
						+ change.changCode(info.getUxingming()) + "','uXingbieUpdate':'"
						+ change.changCode(info.getUxingbie()) + "','uPhoneUpdate':'" + info.getUphone()
						+ "','uEmailUpdate':'" + info.getUemail() + "','uShengriUpdate':'" + info.getUshengri()
						+ "','uMibaowenti1Update':'" + change.changCode(info.getUmibaowenti1()) + "','uDaan1Update':'"
						+ change.changCode(info.getUdaan1()) + "','uMibaowenti2Update':'"
						+ change.changCode(info.getUmibaowenti2()) + "','uDaan2Update':'"
						+ change.changCode(info.getUdaan2()) + "'},");

			}
			str.substring(str.length() - 1, str.length());
			str.append("]");
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

	@RequestMapping(params = "method=searchUserInfoByuId")
	private void doSearchUserInfoByuId(HttpServletRequest request, HttpServletResponse response) {
		int uId = Integer.parseInt(request.getParameter("uId"));
		InfoUser info = operatorService.searchUserInfoByuid(uId);
		if (info != null) {
			StringBuffer str = new StringBuffer("[{'uIdUpdate':'" + info.getUid() + "','usernameUpdate':'"
					+ info.getUsername() + "','uNichengUpdate':'" + change.changCode(info.getUnicheng())
					+ "','uXingmingUpdate':'" + change.changCode(info.getUxingming()) + "','uXingbieUpdate':'"
					+ change.changCode(info.getUxingbie()) + "','uPhoneUpdate':'" + info.getUphone()
					+ "','uEmailUpdate':'" + info.getUemail() + "','uShengriUpdate':'" + info.getUshengri()
					+ "','uMibaowenti1Update':'" + change.changCode(info.getUmibaowenti1()) + "','uDaan1Update':'"
					+ change.changCode(info.getUdaan1()) + "','uMibaowenti2Update':'"
					+ change.changCode(info.getUmibaowenti2()) + "','uDaan2Update':'"
					+ change.changCode(info.getUdaan2()) + "'}]");
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

	@RequestMapping(params = "method=searchGoodsInfoBygId")
	private void doSearchGoodsInfoBygId(HttpServletRequest request, HttpServletResponse response) {
		int gId = Integer.parseInt(request.getParameter("gId"));
		InfoGoods info = operatorService.searchGoodsInfoBygid(gId);
		if (info != null) {
			StringBuffer str = new StringBuffer("[{'gIdUpdate':'" + info.getGid() + "','gNameUpdate':'"
					+ change.changCode(info.getGname()) + "','gPriceUpdate':'" + info.getGprice() + "','gTypeUpdate':'"
					+ change.changCode(info.getGtype()) + "','gKucunUpdate':'" + info.getGkucun() + "','gPicUpdate':'"
					+ request.getContextPath() + "/pic/goods/" + info.getGpic() + "','gBigPicUpdate':'"
					+ request.getContextPath() + "/pic/goods/" + info.getGbigPic() + "','gJieshaoUpdate':'"
					+ change.changCode(info.getGjieshao()) + "','gJianjieUpdate':'"
					+ change.changCode(info.getGjianjie()) + "','gRukushijianUpdate':'" + info.getGrukushijian()
					+ "'}]");
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

	@RequestMapping(params = "method=searchGoodsInfoBygName")
	private void doSearchGoodsInfoBygName(HttpServletRequest request, HttpServletResponse response) {
		String gName = "";
		try {
			gName = URLDecoder.decode(request.getParameter("gName"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<InfoGoods> info = operatorService.searchGoodsInfoBygname(gName);
		if (info != null) {
			StringBuffer str = new StringBuffer("[");
			for (int i = 0; i < info.size(); i++) {
				InfoGoods ctif = info.get(i);
				str.append("{'gIdUpdate':'" + ctif.getGid() + "','gNameUpdate':'" + change.changCode(ctif.getGname())
						+ "','gPriceUpdate':'" + ctif.getGprice() + "','gTypeUpdate':'"
						+ change.changCode(ctif.getGtype()) + "','gKucunUpdate':'" + ctif.getGkucun()
						+ "','gPicUpdate':'" + request.getContextPath() + "/pic/goods/" + ctif.getGpic()
						+ "','gBigPicUpdate':'" + request.getContextPath() + "/pic/goods/" + ctif.getGbigPic()
						+ "','gJieshaoUpdate':'" + change.changCode(ctif.getGjieshao()) + "','gJianjieUpdate':'"
						+ change.changCode(ctif.getGjianjie()) + "','gRukushijianUpdate':'" + ctif.getGrukushijian()
						+ "'},");
			}
			str.substring(str.length() - 1, str.length());
			str.append("]");
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

	@RequestMapping(params = "method=insertGoodsInfo")
	private void doInsertGoodsInfo(HttpServletRequest request, HttpServletResponse response) {
		String gType = "";
		String gName = "";
		String gPrice = "";
		String gPic = "";
		String gBigPic = "";
		String gJieshao = "";
		String gJianjie = "";
		int gkucun = 0;
		try {
			gType = URLDecoder.decode(request.getParameter("gType"), "UTF-8");
			gName = URLDecoder.decode(request.getParameter("gName"), "UTF-8");
			gPrice = URLDecoder.decode(request.getParameter("gPrice"), "UTF-8");
			gPic = URLDecoder.decode(request.getParameter("gPic"), "UTF-8");
			gBigPic = URLDecoder.decode(request.getParameter("gBigPic"), "UTF-8");
			gJieshao = URLDecoder.decode(request.getParameter("gJieshao"), "UTF-8");
			gJianjie = URLDecoder.decode(request.getParameter("gJianjie"), "UTF-8");
			gkucun = Integer.parseInt(URLDecoder.decode(request.getParameter("gKucun"), "UTF-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		operatorService.addGoodsInfo(gType, gName, gPrice, gPic, gBigPic, gJieshao, gJianjie, gkucun);
		try {
			response.getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=updateGoodsInfo")
	private void doUpdateGoodsInfo(HttpServletRequest request, HttpServletResponse response) {
		int gId = 0;
		String gType = "";
		String gName = "";
		String gPrice = "";
		String gPic = "";
		String gBigPic = "";
		String gJieshao = "";
		String gJianjie = "";
		try {
			gId = Integer.parseInt(URLDecoder.decode(request.getParameter("gId"), "UTF-8"));
			gType = URLDecoder.decode(request.getParameter("gType"), "UTF-8");
			gName = URLDecoder.decode(request.getParameter("gName"), "UTF-8");
			gPrice = URLDecoder.decode(request.getParameter("gPrice"), "UTF-8");
			gPic = URLDecoder.decode(request.getParameter("gPic"), "UTF-8");
			gBigPic = URLDecoder.decode(request.getParameter("gBigPic"), "UTF-8");
			gJieshao = URLDecoder.decode(request.getParameter("gJieshao"), "UTF-8");
			gJianjie = URLDecoder.decode(request.getParameter("gJianjie"), "UTF-8");
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int n = operatorService.updateGoodsInfo(gId, gName, gPrice, gType, gPic, gBigPic, gJieshao, gJianjie);
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

	@RequestMapping(params = "method=updateUserInfo")
	private void doUpdateUserInfo(HttpServletRequest request, HttpServletResponse response) {
		int uId = 0;
		String uNicheng = "";
		String uXingming = "";
		String uXingbie = "";
		String uEmail = "";
		String uShengri = "";
		String uPhone = "";
		String uMibaowenti1 = "";
		String uDaan1 = "";
		String uMibaowenti2 = "";
		String uDaan2 = "";
		try {
			uId = Integer.parseInt(URLDecoder.decode(request.getParameter("uId"), "UTF-8"));
			uXingming = URLDecoder.decode(request.getParameter("uXingming"), "UTF-8");
			uNicheng = URLDecoder.decode(request.getParameter("uNicheng"), "UTF-8");
			uXingbie = URLDecoder.decode(request.getParameter("uXingbie"), "UTF-8");
			uEmail = URLDecoder.decode(request.getParameter("uEmail"), "UTF-8");
			uShengri = URLDecoder.decode(request.getParameter("uShengri"), "UTF-8");
			uPhone = URLDecoder.decode(request.getParameter("uPhone"), "UTF-8");
			uMibaowenti1 = URLDecoder.decode(request.getParameter("uMibaowenti1"), "UTF-8");
			uDaan1 = URLDecoder.decode(request.getParameter("uDaan1"), "UTF-8");
			uMibaowenti2 = URLDecoder.decode(request.getParameter("uMibaowenti2"), "UTF-8");
			uDaan2 = URLDecoder.decode(request.getParameter("uDaan2"), "UTF-8");
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int n = operatorService.updateUserInfo(uId, uNicheng, uXingming, uXingbie, uEmail, uShengri, uPhone,
				uMibaowenti1, uDaan1, uMibaowenti2, uDaan2);
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

	@RequestMapping(params = "method=login")
	private void doLogin(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		InfoOperator operatorInfo = operatorService.operatorLogin(username, MD5Util.getMD5(MD5Util.getMD5(password)));

		try {
			if (operatorInfo != null) {
				List<InfoGoods> goodsInfos = operatorService.searchAllGoods();
				List<InfoUser> completeUserInfos = operatorService.searchAllUserInfo();
				request.getSession().setAttribute("userlist", completeUserInfos);
				request.getSession().setAttribute("goodslist", goodsInfos);
				request.getSession().setAttribute("operatorInfo", operatorInfo);
				InfoDep bumenInfo = operatorService.searchDepBybmId(operatorInfo.getInfoDep().getBmId());
				request.getSession().setAttribute("bumenInfo", bumenInfo);
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
