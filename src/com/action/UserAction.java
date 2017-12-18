package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.InfoGoodsDAO;
import com.pojo.InfoGoods;
import com.pojo.InfoUser;
import com.service.GoodsService;
import com.service.UserService;
import com.util.MD5Util;
import com.util.MyRandomNum;
@Controller
@RequestMapping("/user.do")
public class UserAction extends HttpServlet {
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private InfoGoodsDAO goodsDAO;

	@RequestMapping(params = "method=updateUserPassword")
	private void doUpdateUserPassword(HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println("我进来了");
		InfoUser userinfo = (InfoUser) request.getSession().getAttribute(
				"userinfo");
		String password = request.getParameter("password");
		try {
			if (userinfo != null) {
				int uId = userinfo.getUid();
				int panduan = userService.updateUserPassword(uId,
						MD5Util.getMD5(MD5Util.getMD5(password)));
				if (panduan == 1) {
					InfoUser userInfo2 = userService.login(
							userinfo.getUsername(),
							MD5Util.getMD5(MD5Util.getMD5(password)));
					if (userInfo2 != null) {
						request.getSession()
								.setAttribute("userinfo", userInfo2);
						response.getWriter().print("true");
						System.out.println("用户密码修改成功");
					} else {
						System.out.println("用户密码修改出错");
						response.getWriter().print("false");
					}
				} else {
					System.out.println("用户密码修改出错");
					response.getWriter().print("false");
				}
			} else {
				System.out.println("用户检测出错");
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=updatePayPassword")
	private void doUpdatePayPassword(HttpServletRequest request,
			HttpServletResponse response) {
		InfoUser userinfo = (InfoUser) request.getSession().getAttribute(
				"userinfo");
		String uZhifumima = request.getParameter("uZhifumima");
		try {
			if (userinfo != null) {
				int uId = userinfo.getUid();
				int panduan = userService.updatePayPassword(uId,
						MD5Util.getMD5(MD5Util.getMD5(uZhifumima)));
				if (panduan == 1) {
					InfoUser userInfo2 = userService.login(
							userinfo.getUsername(), userinfo.getPassword());
					if (userInfo2 != null) {
						request.getSession()
								.setAttribute("userinfo", userInfo2);
						response.getWriter().print("true");
						System.out.println("支付密码修改成功");
					} else {
						System.out.println("重新存储用户信息出错");
						System.out.println("支付密码修改出错");
						response.getWriter().print("false");
					}
				} else {
					System.out.println("支付密码修改出错");
					response.getWriter().print("false");
				}
			} else {
				System.out.println("用户检测出错");
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=updateUserInfo")
	private void doUpdateInfoUser(HttpServletRequest request,
			HttpServletResponse response) {
		InfoUser userinfo = (InfoUser) request.getSession().getAttribute(
				"userinfo");
		if (userinfo == null) {
			System.out.println("用户检测出错");
		} else {
			String uNicheng = "";
			String uXingzuo = "";
			String uQq = "";
			String uTouxiang = "";
			try {
				uNicheng = URLDecoder.decode(request.getParameter("uNicheng"),
						"UTF-8");
				uXingzuo = URLDecoder.decode(request.getParameter("uXingzuo"),
						"UTF-8");
				uQq = URLDecoder.decode(request.getParameter("uQq"), "UTF-8");
				uTouxiang = URLDecoder.decode(
						request.getParameter("uTouxiang"), "UTF-8");
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int n = userService.updateInfoUser(uNicheng, uXingzuo, uTouxiang,
					uQq, userinfo.getUid());
			if (n == 1) {
				InfoUser userinfo2 = userService.login(
						userinfo.getUsername(), userinfo.getPassword());
				if (userinfo2 != null) {
					request.getSession().setAttribute("userinfo", userinfo2);
					try {
						request.getRequestDispatcher(
								"adm_userinfo_update.jsp").forward(request,
								response);
					} catch (ServletException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					System.out.println("修改后重新加载用户名失败");
				}
			} else {
				try {
					response.getWriter().print(
							"<script>alert('修改失败了');</script>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	@RequestMapping(params = "method=login")
	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		InfoUser userinfo = userService.login(username,
				MD5Util.getMD5(MD5Util.getMD5(password)));
		try {
			if (userinfo != null) {
				request.getSession().setAttribute("userinfo", userinfo);
				for (int i = 1; i <= 5; i++) {
					if (userinfo.getUchangyongdizhi1() != null) {

					}
				}
				List<InfoGoods> goodslist_sj = new ArrayList<InfoGoods>();
				List<InfoGoods> goodslist_sj_from_big_pic = new ArrayList<InfoGoods>();
				List integers = goodsService.searchRandomGoodsgid();
				int[] array = new int[30];
				int[] array_from_big_pic = new int[5];
				List<InfoGoods> goodslist_sj2 = new ArrayList<InfoGoods>();
				List<InfoGoods> goodslist_sj_from_big_pic2 = new ArrayList<InfoGoods>();
				int[] array2 = new int[30];
				List<InfoGoods> goodslist_sj3 = new ArrayList<InfoGoods>();
				List<InfoGoods> goodslist_sj_from_big_pic3 = new ArrayList<InfoGoods>();
				int[] array3 = new int[30];

				for (int i = 0; i < 30; i++) {
					array[i] = new MyRandomNum().createRandomNum(integers
							.size());
					for (int j = 0; j < i; j++) {
						if (array[i] == array[j]) {
							array[i] = new MyRandomNum()
									.createRandomNum(integers.size());
						}
					}
					array2[i] = new MyRandomNum().createRandomNum(integers
							.size());
					for (int j = 0; j < i; j++) {
						if (array2[i] == array2[j]) {
							array2[i] = new MyRandomNum()
									.createRandomNum(integers.size());
						}
					}
					array3[i] = new MyRandomNum().createRandomNum(integers
							.size());
					for (int j = 0; j < i; j++) {
						if (array3[i] == array3[j]) {
							array3[i] = new MyRandomNum()
									.createRandomNum(integers.size());
						}
					}
				}
				for (int i = 0; i < 5; i++) {
					array_from_big_pic[i] = new MyRandomNum()
							.createRandomNum(integers.size());
					for (int j = 0; j < i; j++) {
						if (array_from_big_pic[i] == array_from_big_pic[j]) {
							array_from_big_pic[i] = new MyRandomNum()
									.createRandomNum(integers.size());
						}
					}
				}
				for (int j = 0; j < 30; j++) {
					InfoGoods info = goodsDAO.findById(Integer
							.parseInt(integers.get(array[j]).toString()));
					goodslist_sj.add(info);
					InfoGoods info3 = goodsDAO.findById(Integer
							.parseInt(integers.get(array3[j]).toString()));
					goodslist_sj3.add(info3);
					InfoGoods info2 = goodsDAO.findById(Integer
							.parseInt(integers.get(array2[j]).toString()));
					goodslist_sj2.add(info2);

				}
				for (int j = 0; j < 5; j++) {
					InfoGoods info = goodsDAO.findById(Integer
							.parseInt(integers.get(array_from_big_pic[j])
									.toString()));
					goodslist_sj_from_big_pic.add(info);
				}
				try {
					if (goodslist_sj != null
							&& goodslist_sj_from_big_pic != null
							&& goodslist_sj2 != null
							&& goodslist_sj_from_big_pic2 != null
							&& goodslist_sj3 != null
							&& goodslist_sj_from_big_pic3 != null) {
						request.getSession().setAttribute("goodslist_sj",
								goodslist_sj);
						request.getSession().setAttribute(
								"goodslist_sj_from_big_pic",
								goodslist_sj_from_big_pic);
						request.getSession().setAttribute("goodslist_sj2",
								goodslist_sj2);
						request.getSession().setAttribute("goodslist_sj3",
								goodslist_sj3);
						response.getWriter().print("true");
						System.out.println("找到了");
						return;
					} else {
						System.out.println("没找到");
						response.getWriter().print("false");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=regist")
	private void doRegist(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = MD5Util.getMD5(MD5Util.getMD5(request
				.getParameter("password")));
		String uXingming = request.getParameter("xingming");
		String uPhone = request.getParameter("phonenumber");
		String uEmail = request.getParameter("email");
		String uXingbie = request.getParameter("sex");
		String uTouxiang = request.getParameter("headpic");
		if (uTouxiang == null) {
			uTouxiang = "1.png";
		}

		String uyear = request.getParameter("bornyear");
		String umonth = request.getParameter("bornmonth");
		String uday = request.getParameter("bornday");
		String uShengri = uyear + "/" + umonth + "/" + uday;
		String uMibaowenti1 = request.getParameter("question1");
		String uDaan1 = request.getParameter("answer1");
		String uMibaowenti2 = request.getParameter("question2");
		String uDaan2 = request.getParameter("answer2");

		userService.regist(username, password, uXingming, uXingbie, uPhone,
				uEmail, uTouxiang, uShengri, uMibaowenti1, uMibaowenti2,
				uDaan1, uDaan2);
		try {
			InfoUser userinfo = userService.login(username, password);
			if (userinfo == null) {
				System.out.println("写入失败");
			} else {
				request.getSession().setAttribute("userinfo", userinfo);
				List<InfoGoods> goodslist_sj = new ArrayList<InfoGoods>();
				List<InfoGoods> goodslist_sj_from_big_pic = new ArrayList<InfoGoods>();
				List integers = goodsService.searchRandomGoodsgid();
				int[] array = new int[30];
				int[] array_from_big_pic = new int[5];
				for (int i = 0; i < 30; i++) {
					array[i] = new MyRandomNum().createRandomNum(integers
							.size());
					for (int j = 0; j < i; j++) {
						if (array[i] == array[j]) {
							array[i] = new MyRandomNum()
									.createRandomNum(integers.size());
						}
					}
				}
				for (int i = 0; i < 5; i++) {
					array[i] = new MyRandomNum().createRandomNum(integers
							.size());
					for (int j = 0; j < i; j++) {
						if (array[i] == array[j]) {
							array[i] = new MyRandomNum()
									.createRandomNum(integers.size());
						}
					}
				}
				for (int j = 0; j < 30; j++) {
					InfoGoods info = goodsDAO.findById(Integer
							.parseInt(integers.get(j).toString()));
					goodslist_sj.add(info);
				}
				for (int j = 0; j < 5; j++) {
					InfoGoods info = goodsDAO.findById(Integer
							.parseInt(integers.get(j).toString()));
					goodslist_sj_from_big_pic.add(info);
				}
				try {
					if (goodslist_sj != null
							&& goodslist_sj_from_big_pic != null) {
						request.getSession().setAttribute("goodslist_sj",
								goodslist_sj);
						request.getSession().setAttribute(
								"goodslist_sj_from_big_pic",
								goodslist_sj_from_big_pic);
						request.getRequestDispatcher("adm_zhuye.jsp").forward(
								request, response);
						System.out.println("找到了");
					} else {
						System.out.println("没找到");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@RequestMapping(params = "method=updatePassword")
	private void doUpdatePassword(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		InfoUser userinfo1 = userService.login(username,
				MD5Util.getMD5(MD5Util.getMD5(password)));
		int n = userService.updateUserPassword(userinfo1.getUid(),
				MD5Util.getMD5(MD5Util.getMD5(password)));
		try {
			if (n == 1) {
				InfoUser userinfo = userService.login(username,
						MD5Util.getMD5(MD5Util.getMD5(password)));
				request.getSession().setAttribute("userinfo", userinfo);
				List<InfoGoods> goodslist_sj = new ArrayList<InfoGoods>();
				List<InfoGoods> goodslist_sj_from_big_pic = new ArrayList<InfoGoods>();
				List integers = goodsService.searchRandomGoodsgid();
				int[] array = new int[30];
				int[] array_from_big_pic = new int[5];
				for (int i = 0; i < 30; i++) {
					array[i] = new MyRandomNum().createRandomNum(integers
							.size());
					for (int j = 0; j < i; j++) {
						if (array[i] == array[j]) {
							array[i] = new MyRandomNum()
									.createRandomNum(integers.size());
						}
					}
				}
				for (int i = 0; i < 5; i++) {
					array[i] = new MyRandomNum().createRandomNum(integers
							.size());
					for (int j = 0; j < i; j++) {
						if (array[i] == array[j]) {
							array[i] = new MyRandomNum()
									.createRandomNum(integers.size());
						}
					}
				}
				for (int j = 0; j < 30; j++) {
					InfoGoods info = goodsDAO.findById(Integer
							.parseInt(integers.get(j).toString()));
					goodslist_sj.add(info);
				}
				for (int j = 0; j < 5; j++) {
					InfoGoods info = goodsDAO.findById(Integer
							.parseInt(integers.get(j).toString()));
					goodslist_sj_from_big_pic.add(info);
				}
				try {
					if (goodslist_sj != null
							&& goodslist_sj_from_big_pic != null) {
						request.getSession().setAttribute("goodslist_sj",
								goodslist_sj);
						request.getSession().setAttribute(
								"goodslist_sj_from_big_pic",
								goodslist_sj_from_big_pic);
						request.getRequestDispatcher("adm_zhuye.jsp").forward(
								request, response);
						System.out.println("找到了");
					} else {
						System.out.println("没找到");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				response.getWriter().print(
						"<script>alert('修改失败，未知错误:(');</script>");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=updateAddress")
	private void doUpdateAddress(HttpServletRequest request,
			HttpServletResponse response) {
		InfoUser userinfo = (InfoUser) request.getSession().getAttribute(
				"userinfo");
		String username = userinfo.getUsername();
		String uChangyongdizhi = "";
		try {
			uChangyongdizhi = URLDecoder.decode(
					request.getParameter("changyongdizhi"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int uCid = 1;
		/* Integer.parseInt(request.getParameter("uCid")); */
		int n = userService.updateAddress(username, uChangyongdizhi, uCid);
		try {
			if (n == 1) {
				userinfo.setUchangyongdizhi1(uChangyongdizhi);
				request.getSession().setAttribute("userinfo", userinfo);
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=logout")
	private void doLogout(HttpServletRequest request,
			HttpServletResponse response) {
		request.getSession().setAttribute("userinfo", null);
		try {
			response.getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
