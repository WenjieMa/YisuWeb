<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>易俗-注册</title>
		<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
		<link rel="stylesheet" type="text/css" href="css/body.css" />
		<link rel="stylesheet" type="text/css" href="css/regist.css" />
		<script type="text/JavaScript" src="js/regist.js"></script>
		<script type="text/JavaScript" src="js/zifushuru.js"></script>
		<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
		-->

	</head>

	<body id="zhuce_body">
		<div id="zuoce">
			<form method="post" action="user.do?method=regist">
				<div id="zhuce_xinxi">
					用户名:
					<input type="text" placeholder="包括6位以上英文,数字和下划线" name="username"
					onkeypress="shuruyonghu(event)"onkeyup="check(event)"onblur="shujukujiance(this.value,0)"
					maxlength="20" class="shuju" onpaste="return false" id="yhm"/>
					<span class="xing">格式错误或忘记填啦</span>
					<br>
					<span class="cuowutishi hid" id="cw0">该用户名已被注册</span><span
							class="zhengquetishi hid" id="zq0">该用户名可以使用</span>
					<br>
					密码:
					<input type="password" placeholder="长度6-16位" name="password"
					maxlength="16" class="shuju" onblur="shujukujiance(this.value,1)" onkeyup="qiangdu(this.value)"" onpaste="return false"/>
					<div id="qiangdu"><div id="qiangdu_neizhi" class="qiangdu q1">弱</div></div><div id="qiangdu"><div id="qiangdu_neizhi" class="qiangdu q2">中</div></div><div id="qiangdu"><div id="qiangdu_neizhi" class="qiangdu q3">强</div></div>
					<span class="xing">格式错误或忘记填啦</span>
					<br>
					<span class="cuowutishi hid" id="cw1">密码长度不够哦</span><span
							class="zhengquetishi hid" id="zq1">正确</span>
					<br>
					确认密码:
					<input type="password" placeholder="长度6-16位" name="passwordconfirm"
					maxlength="16" class="shuju" onblur="shujukujiance(this.value,2)"  onpaste="return false"/>
					<span class="xing">格式错误或忘记填啦</span>&nbsp&nbsp&nbsp&nbsp
					<br>
					<span class="cuowutishi hid" id="cw2">密码输入不正确哦</span><span
							class="zhengquetishi hid" id="zq2">正确</span>
					<br>
					姓名:
					<input type="text" name="xingming" maxlength="18"
					placeholder="支持1-18个字符" class="shuju"
					onblur="shujukujiance(this.value,3)" />
					<span class="xing">格式错误或忘记填啦</span>
					<br>
					<span class="cuowutishi hid" id="cw3">姓名格式不正确哦</span><span
							class="zhengquetishi hid" id="zq3">正确</span>
					<br>
					手机号码:
					<input type="text" placeholder="仅支持大陆13位手机号码" name="phonenumber"
					onkeypress="shuzi(event)"onblur="shujukujiance(this.value,4)"onkeyup="check(event)"maxlength="11"
					class="shuju"  onpaste="return false" id="sjh"/>
					<span class="xing">格式错误或忘记填啦</span>
					<br>
					<span class="cuowutishi hid" id="cw4">该手机号已被注册</span>
					<span class="zhengquetishi hid" id="zq4">该手机号可以使用</span>
					<br>
					电子邮箱:
					<input type="text" name="email" placeholder="支持30个字符长度以内的邮箱"
					onkeypress="youxiang(event)"onkeyup="check(event)"onblur="shujukujiance(this.value, 5)"
					maxlength="30" class="shuju" maxlength="30" id="yx"/>
					<span class="xing">格式错误或忘记填啦</span>
					<br>
					<span class="cuowutishi hid" id="cw5">该用邮箱已被注册</span><span
							class="zhengquetishi hid" id="zq5">该邮箱可以使用</span>
					<br>
					性别:
					<select id="zhuce_xinxi_xingbie" name="sex"></select>
					<br>
					<br>
					出生日期:
					<div id="chushengriqi">
						<select id="zhuce_xinxi_year" onchange="nian()" name="bornyear"></select>
						<span>年</span>
						<select id="zhuce_xinxi_month" onchange="riqi()" name="bornmonth"></select>
						<span>月</span>
						<select id="zhuce_xinxi_day" name="bornday"></select>
						<span>日</span>
					</div>
					<br>
					<br>
					密保问题1:
					<select id="zhuce_xinxi_mibaowenti1" name="question1"></select>
					<br>
					<br>
					答案1:
					<input type="text" class="shuju daan" name="answer1" 
					onblur="shujukujiance(this.value,6)" placeholder="1-18个字符" maxlength="18"/>
					<span class="xing">格式错误或忘记填啦</span>
					<span class="cuowutishi hid" id="cw6">不正确</span><span
							class="zhengquetishi hid" id="zq6">正确</span>
					<br>
					<br>
					密保问题2:
					<select id="zhuce_xinxi_mibaowenti2" name="question2"></select>
					<br>
					<br>
					答案2:
					<input type="text" class="shuju daan" name="answer2"
					onblur="shujukujiance(this.value,7)"  placeholder="1-18个字符" maxlength="18"/>
					<span class="xing">格式错误或忘记填啦</span>
					<span class="cuowutishi hid" id="cw6">不正确</span><span
							class="zhengquetishi hid" id="zq6">正确</span>
					<input type="submit" id="zhuce" />
				</div>
			</form>
		</div>
		<div id="zhongbu">
		<div id="kong"></div>
			<div id="zhuce_xuanchuantubiao">
				<img src="pic/wangzhantubiao_touming.png"
				class="zhuce_wangzhantubiao" />
			</div>
			<div id="zhuce_xuanchuanci">
				<img src="pic/xuanchuanci.png" class="zhuce_wangzhanxuanchuanci" />
			</div>
			<div id="zhuce_anniu">
				<a href="javascript:regist()"><img src="pic/zhuce_anniu.jpg"
					class="img_zhuce_anniu" /></a>
					<br>
					<br>
					<br>
				<a href="adm_user_login.jsp"><img src="pic/anniu_fanhui.jpg"
					class="img_zhuce_anniu" /></a>
			</div>
		</div>
		<div id="youce">
			<div id="zhuce_tupian">
				<img id="img1" src="pic/BigPictrues/b5.jpeg" class="show"
				name="lunbo"/>
				<img id="img2" src="pic/BigPictrues/b6.jpeg" class="hid"
				name="lunbo" />
				<img id="img3" src="pic/BigPictrues/l3.jpg" class="hid"
				name="lunbo" />
			</div>
			<div id="zhuce_tishi">
				<span id="zhuce_tishi_wenben"></span>
			</div>
			<div id="zhuce_xuanzequan">
				<ul>
					<li class="xuhao" onmouseover=
	go(0);
></li>
					<li class="xuhao" onmouseover=
	go(1);
></li>
					<li class="xuhao" onmouseover=
	go(2);
><br></li>
				</ul>
				<br>
				<br>
			</div>	
		</div>
	</body>
	<br><br><br><br><br>
		<%@include file="adm_headfoot_footer.html" %>
</html>
