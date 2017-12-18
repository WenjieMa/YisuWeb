<%@page import="com.pojo.InfoOperator"%>
<%@page import="com.pojo.InfoDep"%>
<%@page import="com.pojo.InfoHighOperator"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
InfoHighOperator highOperatorInfo=(InfoHighOperator)session.getAttribute("highOperatorInfo");
List<InfoDep> depInfos=(List<InfoDep>)session.getAttribute("depInfos");
List<InfoOperator> operatorInfos=(List<InfoOperator>)session.getAttribute("operatorInfos");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>易俗-Boss</title>
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />

</head>
<body>
	欢迎您BOSS ${highOperatorInfo}
	<br> 请开始您的工作:
	<table>
	<th>员工管理</th>
	<c:forEach items="${operatorInfos }" var="operatorInfos">
	<tr>
	</tr>
	</c:forEach>
	</table>
		<table>
	<th>部门管理</th>
	<c:forEach items="${depInfos}" var="depInfos">
	<tr>
	</tr>
	</c:forEach>
	</table>
</body>
</html>