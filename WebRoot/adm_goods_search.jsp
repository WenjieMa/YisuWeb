<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pojo.InfoGoods"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pojo.InfoUser"%>
<%
	List<InfoGoods> goodslist = (List<InfoGoods>) session
	.getAttribute("goodslist");
	/*List<List<GoodsInfo>> goodslist_3 = new ArrayList<List<GoodsInfo>>();

	for (int j = 0; j < goodslist.size(); j++) {
		List<GoodsInfo> temp = new ArrayList<GoodsInfo>();
		for (int i = j; i < j + 3; i++) {
	if (i == goodslist.size()) {
		break;
	}
	temp.add(goodslist.get(i));
	j++;
		}
		goodslist_3.add(temp);
	}*/
	if (goodslist == null) {

	} else {

	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>商品页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<link rel="stylesheet" type="text/css" href="css/goods.css" />
<link rel="stylesheet" type="text/css" href="css/body.css" />
<script type="text/JavaScript" src="js/zhuye.js""></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
</head>
<body>
	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<c:if test="${goodslist==null}" var="t">
		对不起哦！没有搜索到相关商品呢，试试换个关键词吧。
		</c:if>
		<div id="allgoodsshow" style="margin-left: -300px;">
			<c:if test="${not t}">
				<c:forEach items="${goodslist}" var="cl" varStatus="seq">
					<c:set var="panduan" value="${seq.count%4}"></c:set>
					<c:if test="${panduan==1}">
						<div class="wrapper">
					</c:if>
					<div class="box">
						<a href="goods.do?method=searchSingleGoods&gId=${cl.gid}">
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
