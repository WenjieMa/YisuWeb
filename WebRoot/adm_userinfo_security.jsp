<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pojo.InfoGoods"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>安全管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/JavaScript" src="js/zhuye.js""></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
<link rel="stylesheet" type="text/css" href="css/body.css" />
<style>
.allDiv {
	display: none;
}
</style>

</head>
<body>
	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<c:if test="${userinfo.uzhifumima==null}" var="t">
		您是新用户，请设置您的支付密码。<br>
			<input type="button" value="设置支付密码" onclick="showDiv(event)"
				id="btn_setPayPsw" />
			<br>
			<div class="allDiv" id="div_setPayPsw">
				请设置支付密码:<input type="password" placeholder="请输入您的支付密码(不超过6位)"
					maxlength="6" id="newpaypsw" /> <br> <input type="button"
					value="确认" onclick="setPayPsw()" />
			</div>
		</c:if>
		<c:if test="${not t }">
			<input type="button" value="修改支付密码" onclick="showDiv(event)"
				id="btn_updatePayPsw" /><br>
			<input type="button" value="重置支付密码" onclick="showDiv(event)"
				id="btn_resetPayPsw" />
			<div class="allDiv" id="div_verifyUserPsw">
				登录密码确认:<input type="password" placeholder="请输入您的登录密码(不超过16位)"
					maxlength="16" id="userpsw" /> <input type="button" value="确认"
					onclick="verifyUserPsw()" />
			</div>
			<div class="allDiv" id="div_verifyPayPsw">
				原支付密码确认:<input type="password" placeholder="请输入您的支付密码" maxlength="6"
					id="verify_paypsw" /> <input type="button" value="确认"
					onclick="verifyPayPsw()" />
			</div>
			<div class="allDiv" id="div_updatePayPsw">
				请输入新的支付密码:<input type="password" placeholder="请输入您的支付密码(不超过6位)"
					maxlength="6" id="paypsw" /> <input type="button" value="确认"
					onclick="resetPayPsw()" />
			</div>
		</c:if>
		<br> <input type="button" value="修改帐号密码" onclick="showDiv(event)"
			id="btn_updateUserPsw" />
		<div class="allDiv" id="div_updateUserPsw">
			原密码:<input type="password" placeholder="原来密码(不超过16位)" maxlength="16"
				id="olduserpsw" /><br> 新密码:<input type="password"
				placeholder="请输入新密码(不超过16位)" maxlength="16" id="newuserpsw1" /><br>
			确认新密码:<input type="password" placeholder="请再次输入新密码" maxlength="16"
				id="newuserpsw2" /><br> <input type="button" value="确认"
				onclick="setUserPsw()" />
		</div>
	</div>
</body>
<script type="text/javascript">
function showDiv(e){
	var theEvent = window.event || e;
	var a = theEvent.srcElement;
	if (!a) {
		a = theEvent.target;
	}
	var btn_setPayPsw=document.getElementById("btn_setPayPsw");
	var btn_updatePayPsw=document.getElementById("btn_updatePayPsw");
	var btn_resetPayPsw=document.getElementById("btn_resetPayPsw");
	var btn_updateUserPsw=document.getElementById("btn_updateUserPsw");
	var div_setPayPsw=document.getElementById("div_setPayPsw");
	var div_updatePayPsw=document.getElementById("div_updatePayPsw");
	var div_verifyPayPsw=document.getElementById("div_verifyPayPsw");
	var div_verifyUserPsw=document.getElementById("div_verifyUserPsw");
	var div_updateUserPsw=document.getElementById("div_updateUserPsw");
	if(a==btn_setPayPsw){
			if(isHide(div_setPayPsw)==true){
				div_setPayPsw.style.display="block";
			}else{
			div_setPayPsw.style.display="none";
			}
	}else if(a==btn_resetPayPsw){
		document.getElementById("div_updatePayPsw").style.display="none";
		if(isHide(div_verifyUserPsw)==true){
			div_verifyUserPsw.style.display="block";div_verifyPayPsw.style.display="none";
		}else{
			div_verifyUserPsw.style.display="none";div_verifyPayPsw.style.display="none";
		}
	}else if(a==btn_updatePayPsw){
		document.getElementById("div_updatePayPsw").style.display="none";
		if(isHide(div_verifyPayPsw)==true){
			div_verifyPayPsw.style.display="block";div_verifyUserPsw.style.display="none";
		}else{
			div_verifyPayPsw.style.display="none";div_verifyUserPsw.style.display="none";
		}
	}else if(a==btn_updateUserPsw){
		if(isHide(div_updateUserPsw)==true){
			div_updateUserPsw.style.display="block";
			}else{
			div_updateUserPsw.style.display="none";
			}
		}
}


		</script>
</html>
