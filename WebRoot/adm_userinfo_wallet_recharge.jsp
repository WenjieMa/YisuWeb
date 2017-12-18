<%@page import="com.pojo.InfoUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
InfoUser userInfo = (InfoUser) session.getAttribute("userinfo");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的钱包-充值</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/wallet_chongzhi.css" />
<script type="text/JavaScript" src="js/zhuye.js"></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>

	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<div id="big">
			<div id="money_show">
				<span class="money_text">我的余额:</span><span id="money_shuzi">${userinfo.umoney
					}</span><span
					class="money_text">元</span>
			</div>
			<div id="money_gongnenganniu">
				<a href="javascript:chongzhi(0)"><img
					src="pic/shoukuan/zhuanzhang_1.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(1)"><img
					src="pic/shoukuan/zhuanzhang_5.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(2)"><img
					src="pic/shoukuan/zhuanzhang_10.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(3)"><img
					src="pic/shoukuan/zhuanzhang_50.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(4)"><img
					src="pic/shoukuan/zhuanzhang_100.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(5)"><img
					src="pic/shoukuan/zhuanzhang_500.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(6)"><img
					src="pic/shoukuan/zhuanzhang_1000.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(7)"><img
					src="pic/shoukuan/zhuanzhang_5000.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(8)"><img
					src="pic/shoukuan/zhuanzhang_10000.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="javascript:chongzhi(9)"><img
					src="pic/shoukuan/zhuanzhang_50000.jpg"
					class="money_gongnenganniu_anniu"> </img> </a> </a>
			</div>
			<div id="chongzhi_zfbtupian">
				<img src="pic/shoukuan/IMG_0267.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0268.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0269.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0270.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0271.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0272.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0273.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0274.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0275.JPG" class="zfb_tupian"></img> <img
					src="pic/shoukuan/IMG_0276.JPG" class="zfb_tupian"></img>
			</div>
		</div>
	</div>
</body>
<%@include file="adm_headfoot_footer.html"%>
</html>
