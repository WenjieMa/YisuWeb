package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.InfoDepDAO;
import com.pojo.InfoDep;
import com.pojo.InfoHighOperator;
import com.pojo.InfoOperator;
import com.service.DepService;
import com.service.HighOperatorService;
import com.util.MD5Util;
@Controller
@RequestMapping("/highoperator.do")
public class HighOperatorAction extends HttpServlet {
	@Autowired
	private HighOperatorService highOperatorService;
	@Autowired
	private DepService depService;
	
	@RequestMapping(params="method=login")
	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		InfoHighOperator highInfoOperator = highOperatorService.highOperatorLogin(
				MD5Util.getMD5(MD5Util.getMD5(username)),
				MD5Util.getMD5(MD5Util.getMD5(password)));
		try {
			if (highInfoOperator != null) {
				List<InfoOperator> operatorInfos = highOperatorService
						.searchAllInfoOperator();
				List<InfoDep> depInfos = depService.findAll();
				request.getSession().setAttribute("depInfos", depInfos);
				request.getSession().setAttribute("highInfoOperator",
						highInfoOperator);
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