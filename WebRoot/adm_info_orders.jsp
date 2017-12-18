<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pojo.InfoUser"%>
<%@page import="com.pojo.InfoGoods"%>
<%@page import="com.pojo.arranged.GoodsBuyInfo"%>
<%@page import="com.pojo.OrderBig"%>
<%@page import="com.pojo.OrderSmall"%>
<%@page import="com.pojo.arranged.OrderInfo_Oders"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	InfoUser userInfo = (InfoUser) session.getAttribute("userinfo");
	List<OrderInfo_Oders> zhengli_infos = (List<OrderInfo_Oders>) session
	.getAttribute("zhengli_infos");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的订单</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/order.css" />
<script type="text/JavaScript" src="js/zhuye.js""></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
</head>
<style>
td {
	text-align: center;
	width: 1000px;
	border: 1px solid silver;
}

tr {
	text-align: center;
	border: 1px solid silver;
}
</style>
<body>
	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<div id="bigdiv">
			<!-- 	<div class="formkey" style="display:none"> -->
			<span id="meiyoudingdan" style="display: none;">您还未购买任何商品哦！快去选购吧:)</span>
			<c:forEach items="${zhengli_infos}" var="eachBig" varStatus="seq">
				<c:set var="temp" value="1"></c:set>
				<br>
				<table>
					<tr>
						<td>
							<table class="big_table">
								<c:forEach items="${eachBig.list}" var="eachSmall">
									<tr>
										<td><c:if test="${temp==1}" var="t">订单编号：<span
													class="dingdanbianhao_big_each">${eachSmall.orderBig.bid}</span>
											</c:if></td>
										<td><c:set var="temp" value="${temp+1}"></c:set> 流水号 <span
											class="dingdanbianhao_small_each">${eachSmall.id.did}</span></td>
										<td>商品编号:${eachSmall.infoGoods.gid}</td>
										<td>名称:<a
											href="goods.do?method=searchSingleGoods&gId=${eachSmall.infoGoods.gid}">${eachSmall.infoGoods.gname}</a></td>
										<td><a
											href="goods.do?method=searchSingleGoods&gId=${eachSmall.infoGoods.gid}"><img
												src="${pageContext.request.contextPath}/pic/goods/${eachSmall.infoGoods.gpic}"
												class="ordergoodsimg" /></a></td>
										<td>价格: <span class="jiage_class">${eachSmall.infoGoods.gprice}</span>
										</td>
										<td>购买数量: <span class="shuliang_class">${eachSmall.shuliang}</span>
										</td>
										</td>
									</tr>
								</c:forEach>
							</table> <br> 总价: <span class="zongjia">${eachBig.fukuanjine}</span>元
							<br> 是否付款: <span class="shifoufukuan">${eachBig.bShifoufukuan}</span>
							<br> <a href="#" onclick="querengoumai_fromDingdan(event)"><img
								src="pic/anniu_querengoumai.jpg" alt="付款" class="fukuan_anniu" />
						</a> <a href="#" onclick="querenshouhuo(event)"><img
								src="pic/anniu_querenshouhuo.jpg" alt="确认收货"
								class="shouhuo_anniu" /> </a> <br> <span
							class="shifoupingjia_text">是否评价:</span> <span
							class="shifoupingjia">${eachBig.bShifoupingjia}</span> <br>
							<a href="#" onclick="pingjiaSingleGoods(event)"><img
								src="pic/anniu_zhongxing_pingjiaSingleGoods.jpg" alt="评价"
								class="pingjia_anniu" /> </a> <a href="#"
							onclick="quxiaoDingdan(event)"><img
								src="pic/anniu_quxiao.jpg" alt="取消订单" class="quxiao_anniu" /> </a>
					</tr>
				</table>
			</c:forEach>
		</div>
	</div>
	</div>
</body>
<script>
	/*我的主页代码*/
	var qx_anniu = document.querySelectorAll('.quxiao_anniu');
	var fk_anniu = document.querySelectorAll('.fukuan_anniu');
	var sh_anniu = document.querySelectorAll('.shouhuo_anniu');
	var shifoufukuan = document.querySelectorAll('.shifoufukuan');
	var shifoupingjia = document.querySelectorAll('.shifoupingjia');
	var shifoupingjia_text = document.querySelectorAll('.shifoupingjia_text');
	for (var f = 0; f < shifoupingjia.length; f++) {
		if (shifoupingjia[f].innerHTML == "false") {
			shifoupingjia[f].innerHTML = "未评价";
		} else if (shifoupingjia[f].innerHTML == "true") {
			shifoupingjia[f].innerHTML = "已评价";
		}
	}
	var pingjia_anniu = document.querySelectorAll('.pingjia_anniu');
	var bigDingdanBianhao = document
			.querySelectorAll('.dingdanbianhao_big_each');
	if (bigDingdanBianhao.length == 0) {
		document.getElementById('meiyoudingdan').style.display = "block";
	}
	for (var i = 0; i < shifoufukuan.length; i++) {
		if (shifoufukuan[i].innerHTML == "已付款") {
			fk_anniu[i].style.display = "none";
			pingjia_anniu[i].style.display = "none";
			shifoupingjia[i].style.display = "none";
			shifoupingjia_text[i].style.display = "none";
			qx_anniu[i].style.display = "none";
		} else if (shifoufukuan[i].innerHTML == "未付款") {
			sh_anniu[i].style.display = "none";
			shifoupingjia[i].style.display = "none";
			shifoupingjia_text[i].style.display = "none";
			pingjia_anniu[i].style.display = "none";
		} else if (shifoufukuan[i].innerHTML == "交易成功") {
			sh_anniu[i].style.display = "none";
			fk_anniu[i].style.display = "none";
			if (shifoupingjia[i].innerHTML == "已评价") {
				pingjia_anniu[i].style.display = "none";
			} else if (shifoupingjia[i].innerHTML == "未评价") {
			}
			qx_anniu[i].style.display = "none";
		}
	}

	/*end*/
</script>
</html>
