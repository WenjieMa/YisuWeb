package com.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.service.UploadService;
@Controller
@RequestMapping("/upload.do")
/**
 * @ClassName: UploadHandleServlet
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author: 孤傲苍狼
 * @date: 2015-1-3 下午11:35:50
 * 
 */
public class UploadHandleServlet extends HttpServlet {
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping(params="method=uploadGoodsPic")
	public void uploadGoodsPic(HttpServletRequest request, HttpServletResponse response){
		String savePath = request.getSession().getServletContext().getRealPath("/pic/goods");
		System.out.println("这是我的路径"+savePath);
		try {
			uploadService.doUpload(request, response,savePath);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				request.getRequestDispatcher("operator_zhuye.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(params="method=uploadHeadPic")
	public void uploadHeadPic(HttpServletRequest request, HttpServletResponse response){
		String savePath = request.getSession().getServletContext().getRealPath("/pic/headpic");
		System.out.println(savePath);
		try {
			uploadService.doUpload(request, response,savePath);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				request.getRequestDispatcher("adm_userinfo_update.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}