<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="java.util.*"%>
<%@page import="com.pojo.AddressDistrict"%>
<%@page import="com.pojo.AddressCity"%>
<%@page import="com.pojo.AddressProvince"%>
<%@page import="com.pojo.InfoUser"%>
<%@page import="com.pojo.InfoGoods"%>
<%@page import="com.pojo.arranged.GoodsBuyInfo"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
InfoUser userinfo = (InfoUser) session.getAttribute("userinfo");
List<AddressProvince> provinceInfos=(List<AddressProvince>)session.getAttribute("provinceInfos");
List<AddressCity> cityInfos = (List<AddressCity>)session.getAttribute("cityInfos ");
List<AddressDistrict> districtInfos = (List<AddressDistrict>)session.getAttribute("districtInfos");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>购物车</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/gouwuche.css" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/JavaScript" src="js/zhuye.js"></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
</head>
<style>
td {
	text-align: center;
	width: 1000px;
}

tr {
	text-align: center;
}

table td {
	border: 2px solid silver;
}

.goodsimg {
	width: 100px;
	height: 80px;
}
</style>
<body>
	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<div id="meihuo">
			<span>您还没有加入任何商品进入购物车哦，快去选购吧。</span>
		</div>
		<div id="bigdiv">
			<div>
				收货地址: <span id="shouhuodizhi">${userinfo.uchangyongdizhi1 }</span><br>
				<select id="province" onchange="searchSingleProvince()">
					<c:forEach items="${provinceInfos}" var="pro" varStatus="seq">
						<option value="${pro.proId }">${pro.proName }</option>
					</c:forEach>
				</select> <select id="city" onchange="searchSingleCity()">
					<c:forEach items="${cityInfos}" var="city" varStatus="seq">
						<option value="${city.cid }">${city.cname }</option>
					</c:forEach>
				</select> <select id="district">
					<c:forEach items="${districtInfos}" var="district" varStatus="seq">
						<option value="${district.disId }">${district.disName }</option>
					</c:forEach>
				</select> <input type="text" id="shouhuodizhi_text" name="changyongdizhi"
					maxlength="30"  placeholder="不超过30个字"/> <input type="button" value="设置为常用地址"
					onclick="xiugaidizhi()" />
				<script>
					function xiugaidizhi() {
						var selectCity=document.getElementById("city");
						var selectDistrict=document.getElementById("district");
						var selectProvince=document.getElementById("province");
						var request = new XMLHttpRequest();
						var str=selectProvince.options[selectProvince.selectedIndex].text+selectCity.options[selectCity.selectedIndex].text+selectDistrict.options[selectDistrict.selectedIndex].text+document.getElementById("shouhuodizhi_text").value;
						request.open("get", "user.do?method=updateAddress&changyongdizhi="+str);
						request.send(null);
						request.onreadystatechange = function() {
							if (request.status == 200 && request.readyState == 4) {
								var result = request.responseText;
								if (result == "true") {
									document.getElementById("shouhuodizhi").innerHTML=str;
									alert("修改成功：）");
								} else {
									alert("修改失败：（");
								}
							}
						}
					}
					</script>
			</div>
			<br>
			<table>
				<tr>
					<td><input type="checkbox" class="checkbox_all_class"
						onclick="quanxuan()" id="checkbox_all" /> 全选</td>
					<td><input type="button" onclick="quanbushanchu()"
						value="多选删除" /></td>
				</tr>
				<c:forEach items="${goodsBuyInfo_list}" var="goodsBuy">
					<div class="each_goods">
						<tr>
							<td><input type="checkbox" name="checkbox_name"
								class="checkbox_class" onclick="jisuan()" /></td>
							<td>商品编号: <span class="checkbox_gId">${goodsBuy.gid}</span>
							</td>
							<td>名称:<a
								href="goods.do?method=searchSingleGoods&gId=${goodsBuy.gid}">${goodsBuy.gname}</a></td>
							<td><a
								href="goods.do?method=searchSingleGoods&gId=${goodsBuy.gid}"><img
									src="${pageContext.request.contextPath}/pic/goods/${goodsBuy.gpic}"
									class="goodsimg" /></a></td>
							<td>价格: <span id="jiage" class="jiage_class">${goodsBuy.gprice}</span>
							</td>
							<td>购买数量: <input type="image"
								src="pic/png/jisuanfuhao/anniu_jia.png"
								class="shuliang_jia_anniu" onclick="gouwuche_singel_jia(event)">
								<span id="shuliang" class="shuliang_class">${goodsBuy.shuliang}</span>
								<input type="image" src="pic/png/jisuanfuhao/anniu_jian.png"
								class="shuliang_jian_anniu"
								onclick="gouwuche_singel_jian(event)">
							</td>
							<td><input type="button" onclick="gouwuche_shanchu(event)"
								class="shanchu_anniu" value="删除" /></td>
						</tr>
					</div>
				</c:forEach>
			</table>
			总价: <span id="zongjia">0</span>元 <br> <a
				href="javascript:tijiaodingdan()"><img
				src="pic/anniu_tijiaodingdan.jpg" alt="提交订单" /> </a>
		</div>
	</div>
</body>
<script type="text/javascript">
fuxuankuang = document.getElementsByName("checkbox_name");
if (fuxuankuang.length == 0) {
	document.getElementById('bigdiv').style.display = "none";
	document.getElementById('meihuo').style.display = "display";
} else {
	document.getElementById('bigdiv').style.display = "display";
	document.getElementById('meihuo').style.display = "none";
}
	
</script>
</html>
