<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pojo.InfoGoods"%>
<%@page import="com.pojo.InfoUser"%>
<%@page import="com.pojo.arranged.ChatingInfo"%>
<%
	List<InfoUser> infoUsers =(List<InfoUser>)session.getAttribute("infoUsers");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>我的好友</title>

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/friends.css" />
<script type="text/JavaScript" src="js/zhuye.js"></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
<script type="text/JavaScript" src="js/friends.js"></script>

</head>
<body>
	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<div id="big" style="overflow: auto;height: 800px;">
			<input type="button" value="未读好友请求"
				onclick="searchUnreadAcceptance()" /> <input type="button"
				value="已拒绝请求" onclick="searchRefusedAcceptance()" /> <input
				type="button" value="已接受请求" onclick="searchAcceptedAcceptance()" />
			<div id="friendusernamediv" class="searchdiv">
				输好友的用户名:<input type="text" maxlength="30" id="friendusername" /> <input
					type="button" onclick="searchFriendsByUsername()" value="查找" />
			</div>
			<br>
			<div id="friendusernamediv" class="searchdiv">
				输入好友的昵称:<input type="text" maxlength="30" id="frienduNicheng" /> <input
					type="button" onclick="searchFriendsByuNicheng()" value="查找" />
			</div>
			<br>
			<div id="searchfriendslist"
				style="background-color: #CC9966;margin-left: 20%;
margin-top: 10%;height: 400px;width: 600px;overflow: auto;display: none;">
			</div>
			<div id="searchacceptancelist"
				style="background-color: #CC9966;margin-left: 5%;
margin-top: 0px;height: 400px;width: 600px;overflow: auto;display: none;">
			</div>
			<hr>
			<input type="button" onclick="refreshFriendsList()" value="刷新好友列表"
				id="btn_refreshfriendslist" />
			<table id="friends">
				<c:forEach items="${infoUsers}" var="user">
					<tr>
						<td><a href="javascript:startChating('${user.uid}','${user.unicheng}')"><span>${user.unicheng}</span>
								<img
								src="${pageContext.request.contextPath}/pic/headpic/${user.utouxiang}"
								class="headpic_td" /></a><br></td>
					</tr>
				</c:forEach>
			</table>
			<div style="display:none; background-color: #CC9966;width: 600px;height: 600px;overflow: scoll;" id="chatingDiv" >
				<input type="button" onclick="hideChatingDiv()" value="X" style="float: right;"/>
				<div id="chatingTextDiv" style="width: 600px;height: 300px;background-color: gray;overflow:auto;">
				<span style="font-size: 28px;" id="getuNichengSpan"></span>
					<table id="chatingTable" style="width: 600px;font-size: 11px;">
					</table>
				</div>
				<textarea id="chatingInput" rows="5" cols="71"  onkeypress="checkEnter()"></textarea>
				<input type="button" onclick="addSendChating()" id="sendButton" value="发送消息">
			</div>
		</div>
	</div>
</body>
<%@include file="adm_headfoot_footer.html"%>
</html>