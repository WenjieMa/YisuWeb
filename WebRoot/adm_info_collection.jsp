<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pojo.InfoGoods"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pojo.InfoUser"%>
<%
	List<InfoGoods> shoucanglist = (List<InfoGoods>) request
			.getSession().getAttribute("shoucanglist");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的收藏</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/goods.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
		<c:if test="${shoucanglist==null}" var="t">
		您还没有收藏任何商品哦！快去寻找喜欢的东西吧：）
		</c:if>
		<c:if test="${not t}">
			<c:forEach items="${shoucanglist}" var="cl" varStatus="seq">
				<c:set var="panduan" value="${seq.count%3}"></c:set>
				<c:if test="${panduan==1}">
					<div class="wrapper">
				</c:if>
				<div class="box">
					<span class="gId"><c:out value="${cl.gid}"></c:out> </span> <a
						href="javascript:deleteSingleGoodsFromCollection(${seq.count-1})"><img
						src="pic/png/garbage/recycle-bin-04.png"
						class="shanchushoucang_anniu_img"></img> </a> <a
						href="goods.do?method=searchSingleGoods&gId=${cl.gid}">
						<div class="product">
							<span class="mingzi">${cl.gname}</span> <img
								src="${pageContext.request.contextPath }/pic/goods/${cl.gpic}"
								class="goods_single" /> <span class="description">${cl.gjianjie}<br>
							</span>
						</div>
					</a>
				</div>
				<span class="price">${cl.gprice}</span>
				<c:if test="${panduan==0}">
	</div>
	</c:if>
	</c:forEach>
	</c:if>
	</div>
</body>
</html>
