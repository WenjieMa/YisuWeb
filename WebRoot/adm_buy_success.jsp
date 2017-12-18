<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.pojo.InfoGoods"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>购买成功</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/JavaScript" src="js/zhuye.js""></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
<link rel="stylesheet" type="text/css" href="css/body.css" />


<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

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
			<span id="chenggong"><h1>购买成功!</h1> </span> 预计您的订单将在7日内送到您的手中! 本页面将在
			<span id="miao">5</span>秒后返回。

		</div>
		<script type="text/javascript">
			t = window.setInterval('time_cg()', 1000);
			function time_cg() {
				var miaoshu = document.getElementById('miao');
				var maoshu_num = miaoshu.innerHTML * 1;
				if (maoshu_num > 0) {
					miaoshu.innerHTML = maoshu_num - 1;
				} else {
					var request = new XMLHttpRequest();
					request.open("get", "goods.do?method=searchAllOders");
					request.send(null);
					request.onreadystatechange = function() {
						if (request.status == 200 && request.readyState == 4) {
							var result = request.responseText;
							if (result == "true") {
								window.location = "adm_info_orders.jsp";
							} else {
								window.location = "adm_info_orders.jsp";
							}
						}
					}
				}
			}
		</script>
	</div>
</body>
</html>
