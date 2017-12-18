<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pojo.InfoDep"%>
<%@page import="com.pojo.InfoOperator"%>
<%@page import="com.pojo.InfoUser"%>
<%@page import="com.pojo.InfoGoods"%>
<%
	InfoOperator operatorInfo = (InfoOperator) session.getAttribute("operatorInfo");
	List<InfoGoods> goodslist = (List<InfoGoods>) session.getAttribute("goodslist");
	List<InfoUser> userlist = (List<InfoUser>) session.getAttribute("userlist");
	InfoDep bumenInfo = (InfoDep) session.getAttribute("bumenInfo");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<style>
tr {
	width: 600px;
}

td {
	width: 200px;
}

.head_pic {
	width: 45px;;
	height: 45px;
}
</style>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script type="text/javascript" src="js/jquery1.10.2.js"></script>
<script type="text/javascript" src="js/jquery-form.js"></script>

<title>易俗-管理员</title>
<script src="js/regist.js"></script>
</head>
<body>
	欢迎您${bumenInfo.bmName}的员工${operatorInfo.oxingming}
	<br> 请开始您的工作:
	<br>
	<c:if test="${bumenInfo.bmId==1}">
		<div id="searchGoodsInfoDiv">
			请输入想搜索的商品名:<input type="text" maxlength="16" id="gNameSearch" /><input
				type="button" value="搜索" id="gNameSearchBtn"
				onclick="searchGoodsInfoBygName()" /><br> 请输入想搜索的商品编号:<input
				type="text" maxlength="16" id="gIdSearch" /><input type="button"
				value="搜索" id="gIdSearchBtn" onclick="searchGoodsInfoBygId()" /><br>
			<input type="button" onclick="searchAllGoods()" value="刷新商品页面" /><br>
		</div>
		<div id="showGoodsInfoDiv"
			style="width: 600px;height: 600px;float: left;overflow: scroll;">
			<table id="showGoodsInfoTable"
				style="overflow:scroll;height: 600px;width: 600px;background-color: #CC9966;">
				<c:forEach items="${ goodslist}" var="goods">
					<tr>
						<td><a href="javascript:showGoodsInfoToForm(${goods.gid})">
								编号:${goods.gid }名称:${goods.gname }图片:<img
								src="${pageContext.request.contextPath}/pic/goods/${goods.gpic } "
								class="head_pic" />入库时间:${goods.grukushijian }
						</a> <br></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="updateGoodsInfoDiv"
			style="float: left;width: 300px;height: 400px;">
			商品编号:<input type="text" maxlength="16" readonly="readonly"
				id="gIdUpdate" /><br> 商品名：<input type="text" maxlength="16"
				id="gNameUpdate" /><br> 价格：<input type="text" maxlength="16"
				id="gPriceUpdate" /><br> 商品类型：<input type="text"
				id="gTypeUpdate" maxlength="6" /><br> 库存：<input type="text"
				maxlength="16" id="gKucunUpdate" readonly="readonly" /><br>进货数量:<input
				type="text" maxlength="16" id="gImportCount" /> <input
				type="button" onclick="importGoods()" value="进货" /><br>
			<form action="upload.do?method=uploadGoodsPic"
				enctype="multipart/form-data" method="post" id="picform1">
				<input type="text" maxlength="16" readonly="readonly"
					id="gIdUpdate2" style="display: none" name="gId" /> 图片：<img
					id="gPicUpdate_img" /><input type="text" readonly="readonly"
					id="gPicUpdate" /><input type="file" name="file1"
					id="updateUploadBtnSmall"><br /> <br> 大图：<img
					id="gBigPicUpdate_img" /><input type="text" readonly="readonly"
					id="gBigPicUpdate" /><input type="file" name="file2"
					id="updateUploadBtnBig"><br /> <br> <input
					type="submit" value="提交" style="display: none;">
			</form>
			介绍：<input type="text" maxlength="16" id="gJieshaoUpdate" /><br>
			简介：<input type="text" maxlength="16" id="gJianjieUpdate" /><br>
			入库时间：<input type="text" maxlength="16" id="gRukushijianUpdate"
				readonly="readonly" /><br> <input type="button"
				onclick="updateGoodsInfo()" value="更新商品信息" /><br>
		</div>
		<div id="insertGoodsInfoDiv"
			style="float: left;width: 400px;height: 300px;">
			商品名：<input type="text" maxlength="16" id="gNameInsert" /><br>
			价格：<input type="text" maxlength="16" id="gPriceInsert" /><br>
			商品类型：<input type="text" id="gTypeInsert" maxlength="3" /><br>
			库存：<input type="text" maxlength="16" id="gKucunInsert" /><br>
			<form action="upload.do?method=uploadGoodsPic"
				enctype="multipart/form-data" method="post" id="picform2">
				<input type="text" maxlength="16" readonly="readonly" id="gIdInsert"
					style="display: none" name="gId" /> 图片：<img id="gPicUpdate_img" /><input
					type="text" readonly="readonly" id="gPicInsert" /><input
					type="file" name="file1" id="insertUploadBtnSmall"><br />
				<br> 大图：<img id="gBigPicUpdate_img" /><input type="text"
					readonly="readonly" id="gBigPicInsert" /><input type="file"
					name="file2" id="insertUploadBtnBig"><br /> <br> <input
					type="submit" value="提交" style="display: none;">
			</form>
			介绍：<input type="text" maxlength="16" id="gJieshaoInsert" /><br>
			简介：<input type="text" maxlength="16" id="gJianjieInsert" /><br>
			<input type="button" onclick="insertGoodsInfo()" value="新增商品信息" /><br>
		</div>
	</c:if>
	<c:if test="${bumenInfo.bmId==2}">
		<div id="searchOrderInfoDiv">
			请输入想搜索的大订单编号:<input type="text" maxlength="16" id="bIdSearch" /><input
				type="button" value="搜索" id="bIdSearchBtn"
				onclick="searchOrderInfoBybId()" /><br> 请输入想搜索的小订单编号:<input
				type="text" maxlength="16" id="dIdSearch" /><input type="button"
				value="搜索" id="dIdSearchBtn" onclick="searchOrderInfoBydId()" /><br>
			<input type="button" onclick="searchAllOrderInfo()" value="刷新订单列表" /><br>
		</div>
		<div id="showOrderInfoDiv"
			style="width: 600px;height: 600px;float: left;overflow: scroll;">
			<table id="showOrderInfoTable"
				style="overflow:scroll;height: 600px;width: 600px;background-color: #CC9966;">
				<c:forEach items="${ orderlist}" var="order">
					<tr>
						<td><a href="javascript:showOrderInfoToForm(${order.bId})">
								编号:${order.bId } </a> <br></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</c:if>
	<script>
		function searchOrderInfoBybId() {
		}
		function searchOrderInfoBydId() {
		}
		function showOrderInfoToForm(bId) {
		}
	</script>
	<c:if test="${bumenInfo.bmId==3}">
		<div id="searchUserInfoDiv">
			请输入想搜索的用户名:<input type="text" maxlength="16" id="usernameSearch" /><input
				type="button" value="搜索" id="usernameSearchBtn"
				onclick="searchUserInfoByusername()" /><br> 请输入想搜索的用户编号:<input
				type="text" maxlength="16" id="uIdSearch" /><input type="button"
				value="搜索" id="uIdSearchBtn" onclick="searchUserInfoByuId()" /><br>
			<input type="button" onclick="searchAllUserInfo()" value="刷新用户列表" /><br>
		</div>
		<div id="showUserInfoDiv"
			style="overflow: scoll;height: 400px;width: 600px;background-color: #CC9966;float: left;">
			<table id="showUserInfoTable"
				style="overflow: scoll;height: 400px;width: 600px;background-color: #CC9966;">
				<c:forEach var="user" items="${userlist }">
					<tr>
						<td><a href="javascript:showUserInfoToForm(${user.uid})">
								用户编号:${user.uid }用户名:${user.username }昵称:${user.unicheng } </a></td>
					</tr>
					<br>
				</c:forEach>
			</table>
		</div>
		<div id="updateUserInfoDiv"
			style="float: left;width: 400px;height: 300px;">
			用户编号:<input type="text" maxlength="16" readonly="readonly"
				id="uIdUpdate" /><br> 用户名：<input type="text" maxlength="16"
				id="usernameUpdate" readonly="readonly" /><br> 昵称：<input
				type="text" maxlength="16" id="uNichengUpdate" /><br> 姓名:<input
				type="text" maxlength="16" id="uXingmingUpdate" /><br> 性别：<input
				type="text" id="uXingbieUpdate" maxlength="10" /><br> 手机号：<input
				type="text" maxlength="16" id="uPhoneUpdate" /><br> 邮箱：<input
				type="text" id="uEmailUpdate" /><br> 生日：<input type="text"
				id="uShengriUpdate" /> <br>密保问题1：<input type="text"
				maxlength="16" id="uMibaowenti1Update" /><br> 答案1：<input
				type="text" maxlength="16" id="uDaan1Update" /><br> 密保问题2：<input
				type="text" maxlength="16" id="uMibaowenti2Update" /><br> 答案2：<input
				type="text" maxlength="16" id="uDaan2Update" /><br> <input
				onclick="updateUserInfo()" value="更新用户信息" type="button" /><br>
		</div>
	</c:if>
	<script type="text/javascript">
		onload = function() {
			searchBiggId();
		}
		function searchBiggId() {
			var request = new XMLHttpRequest();
			request.open("post", "operator.do?method=searchBiggId");
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					var json;
					if (result == "false") {
						alert("查找失败");
					} else {
						$("#gIdInsert").val(result);
					}
				}
			}
		}
		function importGoods() {
			alert("进货了");
			alert($("#uIdUpdate").val());
		}
		function searchAllUserInfo() {
			var request = new XMLHttpRequest();
			request.open("post", "operator.do?method=searchAllUserInfo");
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					var json;
					if (result == "false") {
						alert("查找失败");
					} else {
						json = eval(result);
						var showUserInfoTable = document
							.getElementById("showUserInfoTable");
						var str = "";
						for (var i = 0; i < json.length; i++) {
							str += "<tr><td><a href='javascript:showUserInfoToForm("
								+ json[i].uIdUpdate
								+ ")'>用户编号:"
								+ json[i].uIdUpdate
								+ "用户名:"
								+ decodeURI(json[i].usernameUpdate)
								+ "昵称:"
								+ decodeURI(json[i].uNichengUpdate)
								+ "</a></td></tr><br>";
						}
						showUserInfoTable.innerHTML = str;
					}
				}
			}
		}
		function searchAllGoods() {
			var request = new XMLHttpRequest();
			request.open("post", "operator.do?method=searchAllGoods");
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					var json;
					if (result == "false") {
						alert("查找失败");
					} else {
						json = eval(result);
	
						var showGoodsInfoTable = document
							.getElementById("showGoodsInfoTable");
						var str = "";
						for (var i = 0; i < json.length; i++) {
							str += "<tr><td><a href='javascript:showGoodsInfoToForm("
								+ json[i].gIdUpdate
								+ ")'>编号:"
								+ json[i].gIdUpdate
								+ "名称:"
								+ decodeURI(decodeURI(json[i].gNameUpdate))
								+ "图片:<img src='" + json[i].gPicUpdate + " ' class='head_pic'/>入库时间:"
								+ json[i].gRukushijianUpdate
								+ "</a></td></tr><br>";
						}
						showGoodsInfoTable.innerHTML = str;
					}
				}
			}
		}
		function updateUserInfo() {
			var uIdUpdate = document.getElementById("uIdUpdate");
			if (uIdUpdate.value.length == 0) {
				alert("请选择用户再提交新信息：）");
			} else {
				var request = new XMLHttpRequest();
				request.open("post", "operator.do?method=updateUserInfo&uId="
					+ uIdUpdate.value + "&uXingming="
					+ encodeURI(encodeURI($("#uXingmingUpdate").val()))
					+ "&uNicheng="
					+ encodeURI(encodeURI($("#uNichengUpdate").val()))
					+ "&uXingbie="
					+ encodeURI(encodeURI($("#uXingbieUpdate").val()))
					+ "&uEmail="
					+ encodeURI(encodeURI($("#uEmailUpdate").val()))
					+ "&uShengri="
					+ encodeURI(encodeURI($("#uShengriUpdate").val()))
					+ "&uPhone="
					+ encodeURI(encodeURI($("#uPhoneUpdate").val()))
					+ "&uMibaowenti1="
					+ encodeURI(encodeURI($("#uMibaowenti1Update").val()))
					+ "&uDaan1="
					+ encodeURI(encodeURI($("#uDaan1Update").val()))
					+ "&uMibaowenti2="
					+ encodeURI(encodeURI($("#uMibaowenti2Update").val()))
					+ "&uDaan2="
					+ encodeURI(encodeURI($("#uDaan2Update").val())));
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						var result = request.responseText;
						var json;
						if (result == "false") {
							alert("修改失败");
						} else {
							alert("修改成功");
							searchAllUserInfo()
						}
					}
				}
			}
		}
		function updateGoodsInfo() {
			var filenameSmall = document.getElementById("updateUploadBtnSmall").value;
			var realFilenameSmall = "";
			for (var j = filenameSmall.length - 1; j >= 0; j--) {
				if (filenameSmall.charAt(j) != '\\') {
					realFilenameSmall = filenameSmall.charAt(j)
						+ realFilenameSmall;
				} else {
					break;
				}
			}
			var filenameBig = document.getElementById("updateUploadBtnBig").value;
			var realFilenameBig = "";
			for (var j = filenameBig.length - 1; j >= 0; j--) {
				if (filenameBig.charAt(j) != '\\') {
					realFilenameBig = filenameBig.charAt(j) + realFilenameBig;
				} else {
					break;
				}
			}
			var gIdUpdate = document.getElementById("gIdUpdate");
			if (gIdUpdate.value.length == 0) {
				alert("请选择商品再提交新信息：）");
			} else {
				var request = new XMLHttpRequest();
				request.open("post", "operator.do?method=updateGoodsInfo&gId="
					+ gIdUpdate.value + "&gPic="
					+ encodeURI(encodeURI(realFilenameSmall)) + "&gBigPic="
					+ encodeURI(encodeURI(realFilenameBig)) + "&gType="
					+ encodeURI(encodeURI($("#gTypeUpdate").val()))
					+ "&gName="
					+ encodeURI(encodeURI($("#gNameUpdate").val()))
					+ "&gPrice="
					+ encodeURI(encodeURI($("#gPriceUpdate").val()))
					+ "&gJieshao="
					+ encodeURI(encodeURI($("#gJieshaoUpdate").val()))
					+ "&gJianjie="
					+ encodeURI(encodeURI($("#gJianjieUpdate").val())));
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						var result = request.responseText;
						var json;
						if (result == "false") {
							alert("修改失败");
						} else {
							alert("修改成功");
							document.getElementById("picform1").submit();
							searchAllGoods();
						}
					}
				}
			}
		}
	
		function insertGoodsInfo() {
			var filenameSmall = document.getElementById("insertUploadBtnSmall").value;
			var realFilenameSmall = "";
			for (var j = filenameSmall.length - 1; j >= 0; j--) {
				if (filenameSmall.charAt(j) != '\\') {
					realFilenameSmall = filenameSmall.charAt(j)
						+ realFilenameSmall;
				} else {
					break;
				}
			}
			var filenameBig = document.getElementById("insertUploadBtnBig").value;
			var realFilenameBig = "";
			for (var j = filenameBig.length - 1; j >= 0; j--) {
				if (filenameBig.charAt(j) != '\\') {
					realFilenameBig = filenameBig.charAt(j) + realFilenameBig;
				} else {
					break;
				}
			}
			if (realFilenameBig.length == 0 || realFilenameSmall.length == 0) {
				alert("请选择图片再上传哦：）");
			} else {
				var request = new XMLHttpRequest();
				request
					.open(
						"post",
						"operator.do?method=insertGoodsInfo&gType="
						+ encodeURI(encodeURI($("#gTypeInsert")
							.val()))
						+ "&gPic="
						+ encodeURI(encodeURI(realFilenameSmall))
						+ "&gBigPic="
						+ encodeURI(encodeURI(realFilenameBig))
						+ "&gName="
						+ encodeURI(encodeURI($("#gNameInsert")
							.val()))
						+ "&gPrice="
						+ encodeURI(encodeURI($("#gPriceInsert")
							.val()))
						+ "&gJieshao="
						+ encodeURI(encodeURI($(
							"#gJieshaoInsert").val()))
						+ "&gJianjie="
						+ encodeURI(encodeURI($(
							"#gJianjieInsert").val()))
						+ "&gKucun="
						+ encodeURI(encodeURI($(
							"#gKucunInsert").val()))
				);
				alert(+encodeURI(encodeURI($("#gKucunInsert").val())));
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						var result = request.responseText;
						var json;
						if (result == "false") {
							alert("添加失败");
						} else {
							searchBiggId();
							alert("添加成功");
							document.getElementById("picform2").submit();
							searchAllGoods();
						}
					}
				}
			}
		}
		function searchGoodsInfoBygName() {
			var gNameSearch = document.getElementById("gNameSearch");
			if (gNameSearch.value.length == 0) {
				alert("请输入信息哦：）");
			} else {
				var request = new XMLHttpRequest();
				request.open("post",
					"operator.do?method=searchGoodsInfoBygName&gName="
					+ encodeURI(encodeURI(gNameSearch.value)));
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						var result = request.responseText;
						var json;
						if (result == "false") {
							alert("查找失败");
						} else {
							json = eval(result);
							var showGoodsInfoTable = document
								.getElementById("showGoodsInfoTable");
							var str = "";
							for (var i = 0; i < json.length; i++) {
								str += "<tr><td><a href='javascript:showGoodsInfoToForm("
									+ json[i].gIdUpdate
									+ ")'>编号:"
									+ json[i].gIdUpdate
									+ "名称:"
									+ decodeURI(json[i].gNameUpdate)
									+ "图片:<img src='" + json[i].gPicUpdate + " ' class='head_pic'/>入库时间:"
									+ json[i].gRukushijianUpdate
									+ "</a></td></tr><br>";
							}
							showGoodsInfoTable.innerHTML = str;
						}
					}
				}
			}
		}
		function searchGoodsInfoBygId() {
			var gIdSearch = document.getElementById("gIdSearch");
			if (gIdSearch.value.length == 0) {
				alert("请输入信息哦：）");
			} else {
				var request = new XMLHttpRequest();
				request.open("post",
					"operator.do?method=searchGoodsInfoBygId&gId="
					+ gIdSearch.value);
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						var result = request.responseText;
						var json;
						if (result == "false") {
							alert("查找失败");
						} else {
							json = eval(result);
							var showGoodsInfoTable = document
								.getElementById("showGoodsInfoTable");
							var str = "<tr><td><a href='javascript:showGoodsInfoToForm("
								+ json[0].gIdUpdate
								+ ")'>编号:"
								+ json[0].gIdUpdate
								+ "名称:"
								+ decodeURI(decodeURI(json[0].gNameUpdate))
								+ "图片:<img src='" + json[0].gPicUpdate + "' class='head_pic'/>入库时间:"
								+ json[0].gRukushijianUpdate
								+ "</a></td></tr><br>";
							showGoodsInfoTable.innerHTML = str;
						}
					}
				}
			}
		}
		function showGoodsInfoToForm(gId) {
			var request = new XMLHttpRequest();
			request.open("get", "operator.do?method=searchGoodsInfoBygId&gId="
				+ gId);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					var json;
					if (result == "false") {
						alert("展示失败");
					} else {
						json = eval(result);
						$("#gIdUpdate2").val(json[0].gIdUpdate);
						$("#gIdUpdate").val(json[0].gIdUpdate);
						$("#gNameUpdate").val(decodeURI(json[0].gNameUpdate));
						$("#gPriceUpdate").val(json[0].gPriceUpdate);
						$("#gTypeUpdate").val(decodeURI(json[0].gTypeUpdate));
						$("#gKucunUpdate").val(json[0].gKucunUpdate);
						$("#gPicUpdate").val(json[0].gPicUpdate);
						$("#gBigPicUpdate").val(json[0].gBigPicUpdate);
						$("#gJieshaoUpdate").val(decodeURI(json[0].gJieshaoUpdate));
						$("#gJianjieUpdate").val(decodeURI(json[0].gJianjieUpdate));
						$("#gRukushijianUpdate")
							.val(json[0].gRukushijianUpdate);
					}
				}
			}
		}
		function searchUserInfoByusername() {
			var usernameSearch = document.getElementById("usernameSearch");
			if (usernameSearch.value.length == 0) {
				alert("请输入信息哦：）");
			} else {
				var request = new XMLHttpRequest();
				request.open("post",
					"operator.do?method=searchUserInfoByusername&username="
					+ encodeURI(encodeURI(usernameSearch.value)));
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						var result = request.responseText;
						var json;
						if (result == "false") {
							alert("查找失败");
						} else {
							json = eval(result);
							var showUserInfoTable = document
								.getElementById("showUserInfoTable");
							var str = "";
							for (var i = 0; i < json.length; i++) {
								str += "<tr><td><a href='javascript:showUserInfoToForm("
									+ json[i].uIdUpdate
									+ ")'>用户编号:"
									+ json[i].uIdUpdate
									+ "用户名:"
									+ json[i].usernameUpdate
									+ "昵称:"
									+ decodeURI(json[i].uNichengUpdate)
									+ "</a></td></tr><br>";
							}
							showUserInfoTable.innerHTML = str;
						}
					}
				}
			}
		}
		function searchUserInfoByuId() {
			var uIdSearch = document.getElementById("uIdSearch");
			if (uIdSearch.value.length == 0) {
				alert("请输入信息哦：）");
			} else {
				var request = new XMLHttpRequest();
				request.open("post",
					"operator.do?method=searchUserInfoByuId&uId="
					+ uIdSearch.value);
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						var result = request.responseText;
						var json;
						if (result == "false") {
							alert("没找到用户");
						} else {
							json = eval(result);
							var showUserInfoTable = document
								.getElementById("showUserInfoTable");
							var str = "";
							for (var i = 0; i < json.length; i++) {
								str += "<tr><td><a href='javascript:showUserInfoToForm("
									+ json[i].uIdUpdate
									+ ")'>用户编号:"
									+ json[i].uIdUpdate
									+ "用户名:"
									+ json[i].usernameUpdate
									+ "昵称:"
									+ decodeURI(json[i].uNichengUpdate)
									+ "</a></td></tr><br>";
							}
							showUserInfoTable.innerHTML = str;
						}
					}
				}
			}
		}
		function showUserInfoToForm(uId) {
			var request = new XMLHttpRequest();
			request.open("post", "operator.do?method=searchUserInfoByuId&uId="
				+ uId);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					var json;
					if (result == "false") {
						alert("展示失败");
					} else {
						alert("展示成功");
						json = eval(result);
						$("#uIdUpdate").val(json[0].uIdUpdate);
						$("#usernameUpdate").val(json[0].usernameUpdate);
						$("#uNichengUpdate").val(decodeURI(json[0].uNichengUpdate));
						$("#uXingmingUpdate").val(decodeURI(json[0].uXingmingUpdate));
						$("#uXingbieUpdate").val(decodeURI(json[0].uXingbieUpdate));
						$("#uPhoneUpdate").val(json[0].uPhoneUpdate);
						$("#uEmailUpdate").val(json[0].uEmailUpdate);
						$("#uMibaowenti1Update")
							.val(decodeURI(json[0].uMibaowenti1Update));
						$("#uDaan1Update").val(decodeURI(json[0].uDaan1Update));
						$("#uShengriUpdate").val(json[0].uShengriUpdate);
						$("#uMibaowenti2Update")
							.val(decodeURI(json[0].uMibaowenti2Update));
						$("#uDaan2Update").val(decodeURI(json[0].uDaan2Update));
					}
				}
			}
		}
	</script>
</body>
</html>