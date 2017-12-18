<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pojo.InfoUser"%>
<%@page import="com.pojo.InfoGoods"%>
<%@page import="com.pojo.arranged.GoodsBuyInfo"%>
<%@page import="com.pojo.OrderSmall"%>
<%@page import="com.pojo.OrderBig"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	InfoUser userInfo = (InfoUser) session.getAttribute("userinfo");
	OrderBig infoBig = (OrderBig) session.getAttribute("infoBig");
	List<OrderSmall> infoSmalls = (List<OrderSmall>) session.getAttribute("infoSmalls");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>订单购买</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/goumai_dingdan.css" />
<script type="text/JavaScript" src="js/body.js"></script>
<script type="text/JavaScript" src="js/zhuye.js""></script>
<script type="text/JavaScript" src="js/business.js""></script>
<link type="text/css" rel="stylesheet" media="all"
	href="css/keyboard.css" />
<script src="js/keyboard.js"></script>

</head>
<div id="all">
	<div id="bigdiv">
		订单编号: <span class="dingdanbianhao_big_each">${infoBig.bid}</span> <br>
		收货地址: <span class="shouhuodizhi_each">${infoBig.bshouhuodizhi}
		</span> <br>
		<c:forEach items="${infoSmalls}" var="eachSmall">
			小订单编号<span class="dingdanbianhao_small_each">${eachSmall.id.did}</span>
			<div class="each_goods">
				<span class="goodsIds">商品编号:${eachSmall.infoGoods.gid}</span>
				名称:${eachSmall.infoGoods.gname} <img
					src="${pageContext.request.contextPath}/pic/goods/${eachSmall.infoGoods.gpic}" />
				价格: <span id="jiage" class="jiage_class">${eachSmall.infoGoods.gprice}</span>
				购买数量: <span id="shuliang" class="shuliang_class">${eachSmall.shuliang}</span>
			</div> 
		</c:forEach>
		总价: <span class="zongjia">${infoBig.fukuanjine}</span>元 <br> <a
			href="#" onclick="showPayDiv()"><img
			src="pic/anniu_querengoumai.jpg" /> <br></a> <a href="#"
			onclick="fanhui()"><img src="pic/anniu_fanhui.jpg" alt="fanhui"
			class="fukuan_fanhui" /> </a>
	</div>
	<!-- 	<div class="formkey" style="display:none"> -->
	<div class="formkey">
		<br> <span style="position: absolute;margin-left: -70px;">在此输入支付密码</span>
		<form action="#testform" method="GET">
			<input type="password" value="" name="testfild" class="keyboard"
				id="keyinputtext" maxlength="6" />
		</form>
		<input type="button" onclick="querengoumai(event)" value="确认付款"
			class="fukuan_anniu" />
	</div>
	<script>
		function showPayDiv() {
			var paydiv = document.querySelectorAll(".formkey")[0];
			if (isHide(paydiv) == true) {
				paydiv.style.display = "block";
			}
			if (getOpacity(paydiv) > 0) {
				hideObj(paydiv);
			} else {
				showObj(paydiv);
			}
		}
	</script>
	<div id="dingdangoumai_yue">您的余额:${userinfo.umoney }元</div>
</div>
</body>
<script type="text/javascript">
	function fanhui() {
		var goodsIds = document.querySelectorAll(".goodsIds");
		var shuliang_class = document.querySelectorAll(".shuliang_class");
		//待写的订单提交信息BACK
		/* var request = new XMLHttpRequest();
		request.open("get", "goods.do?method=backToShoppingCart");
		request.send(null);
		request.onreadystatechange = function() {
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					window.location = "adm_goods_collection.jsp";
				} else {
					alert("哎呀！出了点小错误！");
				}
			}
		} */
		window.history.back();
	}

	$(".keyboard").keyboard({
		lang : 'en'
	});

	/*時間滾動*/
</script>
</html>
