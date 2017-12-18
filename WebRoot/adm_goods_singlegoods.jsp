<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.pojo.InfoGoods"%>
<%@page import="com.pojo.InfoUser"%>
<%@page import="com.pojo.OrderSmall"%>
<%@page import="com.pojo.arranged.GoodsShowInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
InfoGoods goodsInfo = (InfoGoods) session.getAttribute("goodsInfo");

	if (goodsInfo == null) {
		response.sendRedirect("adm_zhuye.jsp");
	} else {
		GoodsShowInfo showInfo = (GoodsShowInfo) session
				.getAttribute("showInfo");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>单个商品页面</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/singel_goods.css" />
<link rel="stylesheet" type="text/css" href="css/header.css" />
<script type="text/JavaScript" src="js/zifushuru.js"></script>
<script type="text/JavaScript" src="js/zhuye.js"></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
<script type="text/JavaScript" src="js/parabola.js"></script>
</head>
<body>
	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<div id="toubu_goodsshow">
			<img
				src="${pageContext.request.contextPath}/pic/goods/${goodsInfo.gpic}"
				id="img_goods_zhanshi">
			<div id="flyItem" class="fly_item">
				<img
					src="${pageContext.request.contextPath}/pic/goods/${goodsInfo.gpic}"
					width="40" height="40">
			</div>
			<span style="display: none">No. <span id="No">${goodsInfo.gid}</span>
			</span> <span id="text_goods_name">${goodsInfo.gname}<br> <span
				id="text_goods_jianjie">${goodsInfo.gjianjie} </span> <br>
				星级:${showInfo.xingji } <br> 好评数:${showInfo.hao }<br>
				<h1 id="text_goods_jiage">${goodsInfo.gprice}</h1> 数量：<input
				type="text" id="text_shuliang" onkeypress=shuzi(event);;;;
				onkeyup=check(event);;;; maxlength="4" onpaste="return false"
				value="1" />
				<div id="addToShoppingCart_div">
					<a href="javascript:addToShoppingCart()" class="add_cart_large btnCart">
						<span id="addToShoppingCart_text">加入购物车</span> <img
						src="pic/png/buying/red-shopping-basket.png"
						id="addToShoppingCart_img"></img>
					</a>
				</div>
				<div id="shoucang_div">
					<a href="javascript:addToCollection()"> <span id="addToShoppingCart_text">收藏</span>
						<img src="pic/hand_drawing/44.png" id="shoucang_img">
					</a>
				</div>
			</span>
		</div>
		<div id="xiabu_jieshao">
			<div id="xiabu_introduction">${goodsInfo.gjieshao}</div>
			<img
				src="${pageContext.request.contextPath}/pic/goods/${goodsInfo.gbigPic}"
				width="400" height="400"> <br>
			<br>
			<br>
			<div id="xiabu_pingjia">
				<br> <a href="javascript:haozhongchaZhanshi(0)">全部评价:(${showInfo.hao+showInfo.zhong+showInfo.cha
					})</a>
				<a href="javascript:haozhongchaZhanshi(1)">好评数:(${showInfo.hao
					})</a>
				<a href="javascript:haozhongchaZhanshi(2)">中评数:(${showInfo.zhong
					})</a>
				<a href="javascript:haozhongchaZhanshi(3)">差评数:(${showInfo.cha
					})</a>
				<br />
				<div id="allping_div">
					<br>
					<c:forEach var="infoa" items="${showInfo.infoSmall}">
					用户:${infoa.infoUser.unicheng} &nbsp的评论 ${infoa.pingjia}<br>
					</c:forEach>
				</div>
				<div id="haoping_div" class="hid">
					<br>
					<c:forEach var="infoh" items="${showInfo.infoSmall_hao}">
					用户:${infoh.infoUser.unicheng} &nbsp的评论  ${infoh.pingjia}<br>
					</c:forEach>
				</div>
				<div id="zhongping_div" class="hid">
					<br>
					<c:forEach var="infoz" items="${showInfo.infoSmall_zhong}">
					用户:${infoz.infoUser.unicheng} &nbsp的评论  ${infoz.pingjia}<br>
					</c:forEach>
				</div>
				<div id="chaping_div" class="hid">
					<br>
					<c:forEach var="infoc" items="${showInfo.infoSmall_cha}">
					用户: ${infoc.infoUser.unicheng} &nbsp的评论  ${infoc.pingjia}<br>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	// 元素以及其他一些变量
	var eleFlyElement = document.querySelector("#flyItem"), eleShopCart = document
			.querySelector("#shopCart");
	var numberItem = 0;
	// 抛物线运动
	var myParabola = funParabola(eleFlyElement, eleShopCart, {
		speed : 400, //抛物线速度
		curvature : 0.0008, //控制抛物线弧度
		complete : function() {
			eleFlyElement.style.visibility = "hidden";
			eleShopCart.querySelector("span").innerHTML = ++numberItem;
		}
	});
	// 绑定点击事件
	if (eleFlyElement && eleShopCart) {

		[].slice
				.call(document.getElementsByClassName("btnCart"))
				.forEach(
						function(button) {
							button
									.addEventListener(
											"click",
											function(event) {
												// 滚动大小
												var scrollLeft = document.documentElement.scrollLeft
														|| document.body.scrollLeft
														|| 0, scrollTop = document.documentElement.scrollTop
														|| document.body.scrollTop
														|| 0;
												eleFlyElement.style.left = event.clientX
														+ scrollLeft
														+ "px";
												eleFlyElement.style.top = event.clientY
														+ scrollTop
														+ "px";
												eleFlyElement.style.visibility = "visible";

												// 需要重定位
												myParabola.position()
														.move();
											});
						});
	}

	/*end*/
	</script>
</body>
<%@include file="adm_headfoot_footer.html"%>
</html>
