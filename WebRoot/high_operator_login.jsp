<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>易俗-管理员登录</title>
		<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
		<link rel="stylesheet" type="text/css" href="css/body.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<script type="text/JavaScript" src="js/login.js"></script>
		<script type="text/JavaScript" src="js/zifushuru.js"></script>
	</head>
	<body id="denglu_body">		
		<div>
			<div id="denglu_tubiao">
				<img src="pic/wangzhan_logo.png"
					class="denglu_tubiao_tupian" />
			</div>
			<div id="denglu_zuoce">
				<img id="img1" src="pic/shouye/1.jpeg" class="show" name="lunbo" />
				<img id="img2" src="pic/shouye/2.jpeg" class="hid" name="lunbo" />
				<img id="img3" src="pic/shouye/3.jpeg" class="hid" name="lunbo" />
			</div>
			<div id="denglu_xuanzequan">
				<ul>
					<li class="xuhao" onmouseover=
	go(0);
></li>
					<li class="xuhao" onmouseover=
	go(1);
></li>
					<li class="xuhao" onmouseover=
	go(2);
></li>
				</ul>
			</div>
			<div id="denglu_denglukuang">
					<input type="text" name="username"
						placeholder="请输入您的用户名(英文大小写，数字和下划线)" onkeyup="check(event)" class="denglu_yonghuming"onkeypress="shuruyonghu(event)"maxlength="20" name="username"
						id="yonghuming" />
					<input type="password" name="password"
						placeholder="请输入您的密码(不超过16位)" class="denglu_yonghuming mima"
						maxlength="16" name="password" id="mima" />
						<br>
						<span id="mimacuowu">用户名或密码错误</span>
					<a href="javascript:checkdenglu_high_operator()"><img src="pic/denglu_anniu.jpg"
							class='denglu_denglukuang_anniu' /></a>
			</div>
		</div>
	</body>
	<%@include file="adm_headfoot_footer.html" %>
</html>
