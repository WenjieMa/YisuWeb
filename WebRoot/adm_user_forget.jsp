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
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>易俗-找回密码</title>
		<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
		<link rel="stylesheet" type="text/css" href="css/body.css" />
		<link rel="stylesheet" type="text/css"
			href="css/forgetyourpassword.css" />
		<script type="text/javascript" src="js/forgetyourpassword.js"></script>
		<script type="text/JavaScript" src="js/zifushuru.js"></script>
		<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
	</head>

	<body id="zhaohui_body">

		<div id="zhaohui_tianxielan">
			<img src="pic/temp_zhaohui.jpg" id="img_zhaohui_tianxielan" />
			<img src="pic/wangzhantubiao_mingchenban.jpg"
				class="img_zhaohui_xuanchuan" />

			<div id="zhaohui_sangebuzhou1" class="zhaohui_sangebuzhou">
				<div class="buzhou">
					<form>
						<span class="zhaohui_yonghuming_text text_yonghuming">请输入您的用户名：</span>
						<input type="text" class="zhaohui_yonghuming shuju"
							placeholder="包括6位以上英文,数字和下划线" name="username"
							onkeypress=
	shuruyonghu(event);
onkeyup=
	check(event);
onblur="shujukujiance(this.value,0)" maxlength="20"
							onpaste="return false" id="yhm" />
						<span class="xing">用户名长度不够哦:)</span>
						<br>
						<span class="cuowutishi hid" id="cw0">该用户名不存在</span><span
							class="zhengquetishi hid" id="zq0">正确</span>
						<br>

						<a href="javascript:xiayibu(1,0)"><img src="pic/next.jpg"
								class="zhaohui_xiayibu" /> </a>
						<br>
						<br>
						<br>
						<a href="adm_login.jsp"><img src="pic/anniu_fanhui.jpg"
								class="zhaohui_xiayibu" /> </a>
					</form>
				</div>
			</div>
			<div id="zhaohui_sangebuzhou2" class="zhaohui_sangebuzhou">

				<div class="buzhou">
					<form>
						<span class="zhaohui_yonghuming_text wenti1" id="mibaowenti1">密保问题1：</span>
						<br>
						<input type="text" class="zhaohui_daan Odaan" name="uDaan1"
							onblur="shujukujiance(this.value,1)" maxlength="20" id="daan1" />
						<span class="xing"></span>
						<br>
						<span class="cuowutishi hid" id="cw1"></span>
						<span class="zhengquetishi hid" id="zq1"></span>
						<span class="zhaohui_yonghuming_text wenti2" id="mibaowenti2">密保问题2：</span>
						<input type="text" class="zhaohui_daan Tdaan" name="uDaan2"
							onblur="shujukujiance(this.value,2)" maxlength="20" id="daan2" />
						<span class="xing"></span>
						<span class="cuowutishi hid" id="cw2"></span>
						<span class="zhengquetishi hid" id="zq2"></span>
						<a href="javascript:xiayibu(2,1)"><img src="pic/next.jpg"
								class="zhaohui_xiayibu" /> </a>
						<br>
						<br>
						<br>
						<a href="javascript:xiayibu(4)"><img
								src="pic/anniu_fanhui.jpg" class="zhaohui_xiayibu" /> </a>
					</form>
				</div>
			</div>
			<div id="zhaohui_sangebuzhou3" class="zhaohui_sangebuzhou">

				<div class="buzhou">
					<form>
						<span class="zhaohui_yonghuming_text mima1">请输入新的密码：</span>
						<input type="password" class="zhaohui_daan Tmima1 shuju"
							onblur="shujukujiance(this.value,3)"
							onkeyup=
	qiangdu(this.value);
onpaste="return false"
							maxlength="16" id="mm" />
						<div id="qiangdu">
							<div id="qiangdu_neizhi" class="qiangdu q1">
								弱
							</div>
						</div>
						<div id="qiangdu">
							<div id="qiangdu_neizhi" class="qiangdu q2">
								中
							</div>
						</div>
						<div id="qiangdu">
							<div id="qiangdu_neizhi" class="qiangdu q3">
								强
							</div>
						</div>
						<span class="xing cuowumima1">必须填写密码哦:)</span>
						<br>
						<span class="cuowutishi hid" id="cw3">密码长度不够哦:)</span><span
							class="zhengquetishi hid" id="zq3">√</span>
						<span class="zhaohui_yonghuming_text mima2">请再次输入密码：</span>
						<input type="password" class="zhaohui_daan Tmima2 shuju"
							name="passwordconfirm" maxlength="16"
							onblur="shujukujiance(this.value,4)" onpaste="return false" />
						<span class="xing cuowumima2">*</span>
						<br>
						<span class="cuowutishi hid" id="cw4">*</span><span
							class="zhengquetishi hid" id="zq4">√</span>
						<a href="javascript:xiayibu(3)"><img
								src="pic/anniu_querenchongzhi.jpg" class="zhaohui_xiayibu" />
						</a>
						<br>
						<br>
						<br>
						<a href="javascript:xiayibu(5)"><img
								src="pic/anniu_fanhui.jpg" class="zhaohui_xiayibu" /> </a>
					</form>
				</div>
			</div>
		</div>
	</body>
	<%@include file="adm_headfoot_footer.html"%>
</html>
