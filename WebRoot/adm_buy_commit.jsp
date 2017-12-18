<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pojo.InfoGoods"%>
<%@page import="com.pojo.InfoUser"%>
<%@page import="com.pojo.OrderBig"%>
<%@page import="com.pojo.OrderSmall"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	InfoUser userInfo = (InfoUser) session.getAttribute("userinfo");
	OrderBig infoBig = (OrderBig) session.getAttribute("infoBig");
	List<OrderSmall> infoSmalls = (List<OrderSmall>) session
			.getAttribute("infoSmalls");
%>
<html>
<head>

<title>评价页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/JavaScript" src="js/zhuye.js""></script>
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/pingjia.css" />
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
</head>
<style>
#miao {
	color: red;
}

#chenggong {
	color: red;
}
</style>
<body>

	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<div align="center">
			<span id="chenggong"><h1></h1> </span> 请评价商品： <br>
			<div id="bigdiv">
				订单编号: <span class="dingdanbianhao_big_each">${infoBig.bid}</span> <br>
				收货地址: <span class="shouhuodizhi_each">${infoBig.bshouhuodizhi}
				</span> <br>
				<c:forEach items="${infoSmalls}" var="eachSmall" varStatus="seq">
			小订单编号<span class="dingdanbianhao_small_each">${eachSmall.id.did}</span>
					<div class="each_goods">
						商品编号:${eachSmall.infoGoods.gid} <br> 名称:${eachSmall.infoGoods.gname} <br> <img
							src="${pageContext.request.contextPath}/pic/goods/${eachSmall.infoGoods.gpic}" />
						<br> 价格: <span id="jiage" class="jiage_class">${eachSmall.infoGoods.gprice}</span>
						<br> 购买数量: <span id="shuliang" class="shuliang_class">${eachSmall.shuliang}</span>
						<br> 好评: <input type="radio" checked="checked"
							name="haozhongcha${eachSmall.infoGoods.gid}" class="haoping" /> 中评: <input
							type="radio" name="haozhongcha${eachSmall.infoGoods.gid}" class="zhongping" />
						差评: <input type="radio" name="haozhongcha${eachSmall.infoGoods.gid}"
							class="chaping" /> <br>
						<%-- <div id="xingji_imgs">
							<img src="pic/SimpleIcon/normal/xing (1).gif" name="xingji_img${seq.count }"class="xingji_img"
								style="display:block"></img> <img
								src="pic/SimpleIcon/normal/xing (2).gif" name="xingji_img${seq.count }"class="xingji_img"
								style="display:none"></img> <img
								src="pic/SimpleIcon/normal/xing (3).gif" name="xingji_img${seq.count }"class="xingji_img"
								style="display:none"></img> <img
								src="pic/SimpleIcon/normal/xing (4).gif" name="xingji_img${seq.count }"class="xingji_img"
								style="display:none"></img> <img
								src="pic/SimpleIcon/normal/xing (5).gif" name="xingji_img${seq.count }" class="xingji_img"
								style="display:none"></img>
						</div> --%>
						<br> 商品打星: 5星 <input type="radio"
							name="xingji${eachSmall.infoGoods.gid}" class="xingji5" checked="checked" />
						4星 <input type="radio" name="xingji${eachSmall.infoGoods.gid}"
							class="xingji4" /> 3星 <input type="radio"
							name="xingji${eachSmall.infoGoods.gid}" class="xingji3" />2星 <input
							type="radio" name="xingji${eachSmall.infoGoods.gid}" class="xingji2" /> 1星
						<input type="radio" name="xingji${eachSmall.infoGoods.gid}" class="xingji1" />
						<br>

						<%-- 	<input type="radio" checked="checked"
							name="xingji${eachSmall.gid}" class="xingji1" onclick="daxing()" /> 
							2星 <input
							type="radio" name="xingji${eachSmall.gid}" class="xingji2" onclick="daxing()"
							onclick="daxing()" /> 
							3星 <input type="radio" name="xingji${eachSmall.gid}"
							class="xingji3" onclick="daxing()" onclick="daxing()" /> 
							4星 <input
							type="radio" name="xingji${eachSmall.gid}" class="xingji4" onclick="daxing()"
							onclick="daxing()" /> 
							5星 <input type="radio" name="xingji${eachSmall.gid}"
							class="xingji5" onclick="daxing()" onclick="daxing()" /> <br> --%>



						请输入评价:
						<textarea rows="5" cols="50" placeholder="系统默认好评"
							class="pingjia_eachtext" name="pingjia${seq.count}"></textarea>
					</div>
				</c:forEach>
				总价: <span class="zongjia">${infoBig.fukuanjine}</span>元 <br> <a
					href="#" onclick="pingjia()"><img
					src="pic/anniu_zhongxing_tijiao.jpg" id="pingjia_anniu" /> </a>
			</div>
		</div>
</body>

</html>
