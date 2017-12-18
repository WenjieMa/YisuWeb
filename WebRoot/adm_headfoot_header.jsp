<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pojo.InfoUser"%>
<%@page import="com.pojo.arranged.GoodsBuyInfo"%>
<%@page import="com.pojo.InfoGoods"%>
<%
	InfoUser userinfo = (InfoUser) session.getAttribute("userinfo");
	List<GoodsBuyInfo> goodsBuyInfo_list = (List<GoodsBuyInfo>) session.getAttribute("goodsBuyInfo_list");
	int gouwuche_shuliang_num = 0;
	if (session.getAttribute("gouwuche_shuliang") != null) {
		gouwuche_shuliang_num = Integer.parseInt(session.getAttribute("gouwuche_shuliang").toString());
	}
	if (gouwuche_shuliang_num == 0) {
		session.setAttribute("gouwuche_shuliang", gouwuche_shuliang_num + "");
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/header.css" />
<script type="text/JavaScript" src="js/business.js"></script>


</head>
<body>

	<div id="shouye_toubu">
		<div style="display:none;position:absolute;" id="uShengri">${userinfo.ushengri }</div>
		<img src="pic/wangzhantubiao_mingchenban.jpg"
			class="shouye_toubu_tubiao" />
		<div id="shouye_toubu_shuxing">
			<ul class="shouye_toubu_shuxing_ul">
				<li class="yonghuming shouye_toubu_shuxing_li"><span
					id="yonghuming_shouye"><c:if test="${userinfo==null}"
							var="t">欢迎您进入易俗网</c:if> <c:if test="${not t}">
							<a href="javascript:enterSetting(1)"></span><img
					src="${pageContext.request.contextPath }/pic/headpic/${userinfo.utouxiang}"
					id="header_touxiang" />${userinfo.unicheng} </a> </c:if></li>
				<li class="shouye_toubu_shuxing_li"><a
					href="javascript:enterZhuye()"><img
						src="pic/woodenpics/214262.png"
						class="shouye_toubu_shuxing_li tubiao" />首页</a></li>
				<li class="shouye_toubu_shuxing_li"><a
					href="javascript:searchAllCollection()"><img
						src="pic/woodenpics/214259.png"
						class="shouye_toubu_shuxing_li tubiao" />收藏</a></li>
				<li class="shouye_toubu_shuxing_li"><a
					href="javascript:searchAllOders()"><img
						src="pic/woodenpics/214263.png"
						class="shouye_toubu_shuxing_li tubiao" />订单</a></li>
				<li class="shouye_toubu_shuxing_li"><a
					href="javascript:enterSetting(4)"><img
						src="pic/hand_drawing/h8.ico"
						class="shouye_toubu_shuxing_li tubiao" />消息</a></li>
				<li class="shouye_toubu_shuxing_li gouwuche">
					<div id="quick_links" class="quick_links">
						<div id="shopCart">
							<a href="javascript:searchAllGoodsBuyInfos()" class="message_list"><div
									class="span">
									<img src="pic/hand_drawing/cart.png"
										class="shouye_toubu_shuxing_li tubiao" />购物车
								</div> <span class="cart_num" style="display:none"></span>
								<div id="shuliang_shouye_text_div">
									(<span id="gouwuche_shouye_shuliang"><%=gouwuche_shuliang_num%></span>)
								</div></a>
						</div>
					</div>
				</li>

				<a
					href="javascript:enterSetting(1)"
					onmouseover="javascript:shezhi_yishang()"
					onmouseout="javascript:shezhi_zoukai()"><li class="shouye_toubu_shuxing_li"><img
						src="pic/woodenpics/214257.png"
						class="shouye_toubu_shuxing_li tubiao" /> 设置</li></a>
				<li class="shouye_toubu_shuxing_li zhuxiao"><a
					href="javascript:logout()"><img
						src="pic/woodenpics/214260.png"
						class="shouye_toubu_shuxing_li tubiao" /> <c:if
							test="${userinfo==null}" var="t">登录</c:if> <c:if test="${not t}">注销</c:if></a></li>
				<li class="shouye_toubu_shuxing_li ">
						<input type="text" placeholder="输入想搜索的商品" class="sousuo"
							name="gName" id="sousuoneirong_header" maxlength="20" /><div
						id="sousuo_text"> <a
							href="javascript:searchAllGoodsByName_FromHeader()">搜索<img src="./pic/hand_drawing/152.png" id="sousuo_header_img">
							</a></div>
				</li>
			</ul>
			<div id="shezhilan" onmouseover="javascript:shezhi_yishang()"
				onmouseout="javascript:shezhi_zoukai()">
				<ul class="shouye_toubu_shuxing_ul shezhi_ul">
					<li class="shezhi_li"><a href="javascript:enterSetting(1)">个人信息</a>
					</li>
					<li class="shezhi_li"><a href="javascript:enterSetting(3)">我的钱包</a>
					</li>
					<li class="shezhi_li"><a href="javascript:enterSetting(2)">安全设置</a>
					</li>
				</ul>
			</div>
			<div id="now"></div>
			<div id="nowtime">
				<ul id="panel" class="time_ul">

					<li><img src="" class="pic01"> <img src="" class="pic02">

					</li>

					<li><img src="" class="pic01"> <img src="" class="pic02">

					</li>

					<li><img src=""></li>

					<li><img src="" class="pic01"> <img src="" class="pic02">

					</li>

					<li><img src="" class="pic01"> <img src="" class="pic02">

					</li>

					<li><img src=""></li>
					<li><img src="" class="pic01"> <img src="" class="pic02">

					</li>

					<li><img src="" class="pic01"> <img src="" class="pic02">

					</li>

				</ul>
			</div>
		</div>
	</div>

</body>
</html>
