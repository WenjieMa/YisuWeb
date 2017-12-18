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

import com.pojo.InfoHighOperator;
import com.pojo.InfoOperator;
import com.pojo.InfoUser;
import com.service.HighOperatorService;
import com.service.OperatorService;
import com.service.UserService;
import com.util.MD5Util;
@Controller
@RequestMapping("/yanzheng.do")
public class VerifyAction extends HttpServlet {
	@Autowired
	private HighOperatorService highOperatorService;
	@Autowired
	private UserService userService;
	@Autowired
	private OperatorService operatorService;

	@RequestMapping(params = "method=verifyHighOperatorLogin")
	private void doVerifyHighOperatorLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		InfoHighOperator highInfoOperator = highOperatorService
				.highOperatorLogin(username, password);
		try {
			if (highInfoOperator != null) {
				response.getWriter().print("true");

			} else {
				response.getWriter().print("false");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=verifyUserPassword")
	private void doVerifyUserPassword(HttpServletRequest request,
			HttpServletResponse response) {
		InfoUser userinfo = (InfoUser) request.getSession().getAttribute(
				"userinfo");
		String password = request.getParameter("password");
		try {
			if (userinfo != null) {
				int uId = userinfo.getUid();
				Boolean panduan = userService.verifyUserPassword(
						MD5Util.getMD5(MD5Util.getMD5(password)), uId);
				if (panduan == true) {
					response.getWriter().print("true");
				} else {
					System.out.println("密码检测出错");
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

	@RequestMapping(params = "method=verifyPayPassword")
	private void doVerifyPayPassword(HttpServletRequest request,
			HttpServletResponse response) {
		InfoUser userinfo = (InfoUser) request.getSession().getAttribute(
				"userinfo");
		String uZhifumima = request.getParameter("uZhifumima");
		try {
			if (userinfo != null) {
				int uId = userinfo.getUid();
				Boolean panduan = userService.verifyPayPassword(
						MD5Util.getMD5(MD5Util.getMD5(uZhifumima)), uId);
				if (panduan == true) {
					response.getWriter().print("true");
				} else {
					System.out.println("支付密码检测出错");
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

	@RequestMapping(params = "method=verifyAnswer1")
	private void doVerifyAnswer1(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String uDaan = request.getParameter("uDaan1");
		Boolean b = null;
		try {
			b = userService.verifyAnswer1(username,
					URLDecoder.decode(uDaan, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if (b == true) {
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=verifyAnswer2")
	private void doVerifyAnswer2(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String uDaan = request.getParameter("uDaan2");
		Boolean b = null;
		try {
			b = userService.verifyAnswer2(username,
					URLDecoder.decode(uDaan, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (b == true) {
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@RequestMapping(params = "method=verifyLogin")
	private void doVerifyLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		InfoUser userinfo = userService.login(username,
				MD5Util.getMD5(MD5Util.getMD5(password)));
		try {
			if (userinfo != null) {
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping(params = "method=verifyPhoneNumber")
	private void doVerifyPhoneNumber(HttpServletRequest request,
			HttpServletResponse response) {
		String uPhone = request.getParameter("uPhone");
		Boolean b = userService.verifyPhoneNumber(uPhone);
		try {
			if (b == true) {
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=verifyQuestion")
	private void doVerifyQuestion(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String list1 = userService.searchQuestion1(username);
		String list2 = userService.searchQuestion2(username);
		try {
			if (list1 != null && list2 != null) {
				response.getWriter().print(list1 + "&" + list2);
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=verifyUsername")
	private void doVerifyUsername(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		Boolean b = userService.verifyUsername(username);
		try {
			if (b == true) {
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=verifyEmail")
	private void doVerifyEmail(HttpServletRequest request,
			HttpServletResponse response) {
		String uEmail = request.getParameter("uEmail");
		Boolean b = userService.verifyPhoneNumber(uEmail);
		try {
			if (b == true) {
				response.getWriter().print("true");

			} else {
				response.getWriter().print("false");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@RequestMapping(params = "method=verifyOperatorLogin")
	private void doVerifyOperatorLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		InfoOperator oper_userinfo = operatorService.operatorLogin(username,
				MD5Util.getMD5(MD5Util.getMD5(password)));
		try {
			if (oper_userinfo != null) {
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
