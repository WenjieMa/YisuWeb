<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>个人信息中心</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/JavaScript" src="js/zhuye.js""></script>
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
<script type="text/JavaScript" src="js/zifushuru.js"></script>
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/gerenxinxi.css" />

<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
<body>
	<jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		用户名:${ userinfo.username}<br> 昵称:<input type="text"
			value="${ userinfo.unicheng}" id="uNicheng" maxlength="16" /><br>
		QQ:<input type="text" value="${ userinfo.uqq}" id="uQq" maxlength="13"
			onkeypress="shuzi(event)" onblur="shujukujiance(this.value,4)"
			onkeyup="check(event)" maxlength="11" onpaste="return false" /><br>
		星座:<select onchange="xingzuoxuanze()" id="uSelect">
			<option value="白羊座" selected="selected">白羊座</option>
			<option value="金牛座">金牛座</option>
			<option value="双子座">双子座</option>
			<option value="巨蟹座">巨蟹座</option>
			<option value="狮子座">狮子座</option>
			<option value="处女座">处女座</option>
			<option value="天秤座">天秤座</option>
			<option value="天蝎座">天蝎座</option>
			<option value="射手座">射手座</option>
			<option value="摩羯座">摩羯座</option>
			<option value="水瓶座">水瓶座</option>
			<option value="双鱼座">双鱼座</option>
		</select><input type="text" value="${ userinfo.uxingzuo}" style="display: none"
			id="uXingzuo" /><br> 头像:<input type="text"
			value="${ userinfo.utouxiang}" id="tx_name" style="display: none" /><br>
		<form
			action="upload.do?method=uploadHeadPic"
			enctype="multipart/form-data" method="post" id="picform">
			<input type="text" value="${userinfo.uid} " name="uId"  style="display: none;"/> <input
				type="file" name="file2" id="insertUploadBtnBig"><br /> <br>
			<input type="submit" value="提交" style="display: none;">
		</form>
		<br> <a href="javascript:zhanshitouxiang(1)" id="txa_1"
			class="zhanshi_tx"><img
			src="${pageContext.request.contextPath }/pic/headpic/${userinfo.utouxiang}"
			class="xinxi_touxiang_original" /><br> 点击修改</a> <a
			href="javascript:zhanshitouxiang(2)" id="txa_2" class="zhanshi_tx"
			style="display:none"><img
			src="${pageContext.request.contextPath }/pic/headpic/${userinfo.utouxiang}"
			class="xinxi_touxiang_original" /><br> 点击修改</a>
		<div id="touxiangs_div">
			小动物<br>
			<div class="touxiangzhonglei_div">
				<c:forEach begin="1" end="25" varStatus="seq">
					<div class="xinxi_touxiang_div"
						onmouseover="yishang_touxiang(${seq.count-1})"
						onmouseout="zoukai_touxiang(${seq.count-1})">
						<a href="javascript:dianjitouxiang(${seq.count})"><img
							src="${pageContext.request.contextPath }/pic/headpic/animal (${seq.count }).png"
							class="xinxi_touxiang animal" /></a>
					</div>
				</c:forEach>
			</div>
			<br> 男<br>
			<div class="touxiangzhonglei_div">
				<c:forEach begin="1" end="25" varStatus="seq">
					<div class="xinxi_touxiang_div"
						onmouseover="yishang_touxiang(${seq.count+24})"
						onmouseout="zoukai_touxiang(${seq.count+24})">
						<a href="javascript:dianjitouxiang(${seq.count+25})"><img
							src="${pageContext.request.contextPath }/pic/headpic/boy-${seq.count }.png"
							class="xinxi_touxiang nan" /></a>
					</div>
				</c:forEach>
			</div>
			<br> 女<br>
			<div class="touxiangzhonglei_div">
				<c:forEach begin="1" end="27" varStatus="seq">
					<div class="xinxi_touxiang_div"
						onmouseover="yishang_touxiang(${seq.count+49})"
						onmouseout="zoukai_touxiang(${seq.count+49})">
						<a href="javascript:dianjitouxiang(${seq.count+50})"> <img
							src="${pageContext.request.contextPath }/pic/headpic/girl-${seq.count }.png"
							class="xinxi_touxiang nv" /></a>
					</div>
				</c:forEach>
			</div>
			<br>
			<script type="text/javascript">
				var uXingzuo = document.getElementById('uXingzuo');
				var uSelect = document.getElementById('uSelect');
				switch (uXingzuo.value) {
				case "白羊座":
					uSelect.options[0].selected = "selected";
					break;
				case "金牛座":
					uSelect.options[1].selected = "selected";
					break;
				case "双子座":
					uSelect.options[2].selected = "selected";
					break;
				case "巨蟹座":
					uSelect.options[3].selected = "selected";
					break;
				case "狮子座":
					uSelect.options[4].selected = "selected";
					break;
				case "处女座":
					uSelect.options[5].selected = "selected";
					break;
				case "天秤座":
					uSelect.options[6].selected = "selected";
					break;
				case "天蝎座":
					uSelect.options[7].selected = "selected";
					break;
				case "射手座":
					uSelect.options[8].selected = "selected";
					break;
				case "摩羯座":
					uSelect.options[9].selected = "selected";
					break;
				case "水瓶座":
					uSelect.options[10].selected = "selected";
					break;
				case "双鱼座":
					uSelect.options[11].selected = "selected";
					break;
				default:
					uSelect.options[1].selected = "selected";
					break;
				}
				/*end*/
				function zhanshitouxiang(num) {
					var txa_1 = document.getElementById('txa_1');
					var txa_2 = document.getElementById('txa_2');
					var touxiangdiv = document.getElementById('touxiangs_div');
					switch (num) {
					case 1:
						txa_2.style.display = "block";
						txa_1.style.display = "none";
						touxiangdiv.style.display = "block";
						break;
					case 2:
						txa_1.style.display = "block";
						txa_2.style.display = "none";
						touxiangdiv.style.display = "none";
						break;
					}
				}
				function zoukai_touxiang(q) {
					var xinxi_touxiangdiv = document
							.querySelectorAll('.xinxi_touxiang_div');
					xinxi_touxiangdiv[q].style.border = "solid white";
				}
				function yishang_touxiang(w) {
					var xinxi_touxiangdiv = document
							.querySelectorAll('.xinxi_touxiang_div');
					xinxi_touxiangdiv[w].style.border = "solid red";
				}
				function dianjitouxiang(num) {
					var xinxi_touxiang_original = document
							.querySelectorAll('.xinxi_touxiang_original');
					var tx_name = document.getElementById('tx_name');
					if (num <= 25) {
						for (var q = 0; q < xinxi_touxiang_original.length; q++) {
							xinxi_touxiang_original[q].src = "${pageContext.request.contextPath }/pic/headpic/animal ("
									+ num + ").png";
						}
						tx_name.value = "animal (" + num + ").png";
					} else if (num > 25 && num <= 50) {
						num = num - 25;
						for (var q = 0; q < xinxi_touxiang_original.length; q++) {
							xinxi_touxiang_original[q].src = "${pageContext.request.contextPath }/pic/headpic/boy-"
									+ num + ".png"
						}
						tx_name.value = "boy-" + num + ".png";
					} else {
						num = num - 50;
						for (var q = 0; q < xinxi_touxiang_original.length; q++) {
							xinxi_touxiang_original[q].src = "${pageContext.request.contextPath }/pic/headpic/girl-"
									+ num + ".png";
						}
						tx_name.value = "girl-" + num + ".png";
					}
				}
				function xingzuoxuanze() {
					var uXingzuo = document.getElementById('uXingzuo');
					var uSelect = document.getElementById('uSelect');
					var index = uSelect.selectedIndex;
					uXingzuo.value = uSelect.options[index].text;
				}
				function tijiaoxiugai() {
					var filenameSmall = document
							.getElementById("insertUploadBtnBig").value;
					var realFilenameSmall = "";
					for (var j = filenameSmall.length - 1; j >= 0; j--) {
						if (filenameSmall.charAt(j) != '\\') {
							realFilenameSmall = filenameSmall.charAt(j)
									+ realFilenameSmall;
						} else {
							break;
						}
					}
					if (realFilenameSmall.length != 0) {
						document.getElementById("tx_name").value = realFilenameSmall;
					}
					
					var request = new XMLHttpRequest();	alert(1);
					request.open("post","user.do?method=updateUserInfo&uNicheng="+ encodeURI(encodeURI(document.getElementById("uNicheng").value))
											+ "&uTouxiang="+ encodeURI(encodeURI(document.getElementById("tx_name").value))
											+ "&uQq="
											+ encodeURI(encodeURI(document.getElementById("uQq").value))
											+ "&uXingzuo="
											+ encodeURI(encodeURI(document.getElementById("uXingzuo").value)));
												
					request.send(null);
					request.onreadystatechange = function() {
						if (request.readyState == 4 && request.status == 200) {
							var result = request.responseText;
							var json;
							if (result == "false") {
								alert("修改失败");
							} else {
								alert("修改成功");
								document.getElementById("picform").submit();
							}
						}
					}
				}
			</script>
		</div>

		<br> <a href="#"><img alt="提交"
			src="./pic/anniu_zhongxing_tijiao.jpg" onclick="tijiaoxiugai()"></a>
	</div>
</body>
</html>
