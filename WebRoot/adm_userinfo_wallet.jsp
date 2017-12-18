<%@page import="com.pojo.InfoUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	InfoUser userInfo = (InfoUser) session.getAttribute("userinfo");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的钱包</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/wallet.css" />
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
				<a href="adm_userinfo_wallet_recharge.jsp"><img
					src="pic/anniu_chongzhi.jpg" id="chongzhi"
					class="money_gongnenganniu_anniu"> </img> </a> <a
					href="adm_userinfo_wallet_cash.jsp"><img
					src="pic/anniu_tixian.jpg" id="tixian"
					class="money_gongnenganniu_anniu"> </img> </a>
			</div>
		</div>
	</div>
</body>
<%@include file="adm_headfoot_footer.html"%>
</html>
