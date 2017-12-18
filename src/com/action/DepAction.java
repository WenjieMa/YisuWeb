package com.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.InfoDepDAO;
import com.service.DepService;
@Controller
@RequestMapping("/dep.do")
public class DepAction {
	@Autowired
	private DepService depService;
	@RequestMapping(params = "method=searchSingleEmp")
	private void doSearchSingleEmp(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	@RequestMapping(params = "method=searchSingleDep")
	private void doSearchSingleDep(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	@RequestMapping(params = "method=doSearchAllEmp")
	private void doSearchAllEmp(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	@RequestMapping(params="method=searchAllDep")
	private void doSearchAllDep(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
}
