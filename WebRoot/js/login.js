onload = function() {
	shu = document.querySelectorAll(".xuhao");
	shu[0].style.background = '#f7c477';
	tupian = document.getElementsByName('lunbo');
	a = 0;
	var shuzu = new Array();
	for ( var i = 0; i < tupian.length; i++) {
		shuzu[i] = Math.random() * 100 % 11 + 1;
		var suijishu = shuzu[i] + '';
		shuzu[i] = suijishu.substring(0, 1);
		for ( var k = 0; k < i; k++) {
			while (shuzu[i] == shuzu[k]) {
				shuzu[i] = Math.random() * 100 % 11 + 1;
				var suijishu = shuzu[i] + '';
				shuzu[i] = suijishu.substring(0, 1);
			}
		}

		tupian[i].onmouseover = function() {
			window.clearInterval(t);
		}
		tupian[i].onmouseout = function() {
			window.clearInterval(t);
			t = window.setInterval('bo()', 6000);
		}
		shu[i].onmouseout = function() {
			window.clearInterval(t);
			t = window.setInterval('bo()', 6000);
		}
	}
	while (shuzu[2] == shuzu[0]) {
		shuzu[2] = Math.random() * 100 % 11 + 1;
		var suijishu = shuzu[2] + '';
		shuzu[2] = suijishu.substring(0, 1);
	}
	for ( var m = 0; m < shu.length; m++) {
		var j = m + 1;
		document.getElementById("img" + j).src = "pic/shouye/" + shuzu[m]
				+ ".jpeg";
	}
	bo();
	t = window.setInterval('bo()', 6000);
}

function bo() {
	for ( var i = 0; i < tupian.length; i++) {
		if (i == a) {
			tupian[i].className = 'show';
			shu[i].style.background = '#f7c477';
		} else {
			tupian[i].className = 'hid';
			shu[i].style.background = '#a3520a';

		}
	}
	a++;
	if (a == tupian.length) {
		a = 0;
	}
}
function checkdenglu() {
	var request = new XMLHttpRequest();
	var username = document.getElementById("yonghuming").value;
	var password = document.getElementById("mima").value;
	request.open("get", "yanzheng.do?method=verifyLogin&username=" + username + "&password="
			+ password);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "true") {
				var request2 = new XMLHttpRequest();
				request2.open("get", "user.do?method=login&username=" + username+ "&password="
						+ password);
				request2.send(null);
				request2.onreadystatechange = function() {
					if (request2.readyState == 4 && request2.status == 200) {
						var result2 = request2.responseText;
						if (result2 == "true") {
						window.location.href="adm_zhuye.jsp";
						}else{
							alert("出小差了:)");
						}
					}
				}
			} else {
			document.getElementById("mimacuowu").style.display="block";
			}
		}
	}
}



function checkdenglu_operator(){
	var request = new XMLHttpRequest();
	var username = document.getElementById("yonghuming").value;
	var password = document.getElementById("mima").value;
	request.open("get", "yanzheng.do?method=verifyOperatorLogin&username=" + username + "&password="
			+ password);
	
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "true") {
				var request2 = new XMLHttpRequest();
				request2.open("get", "operator.do?method=login&username=" + username+ "&password="
						+ password);
				request2.send(null);
				request2.onreadystatechange = function() {
					if (request2.readyState == 4 && request2.status == 200) {
						var result2 = request2.responseText;
						if (result2 == "true") {
						window.location.href="operator_zhuye.jsp";
						}else{
							alert("出小差了:)");
						}
					}
				}
			} else {
			document.getElementById("mimacuowu").style.display="block";
			}
		}
	}
}

function checkdenglu_high_operator() {
	var request = new XMLHttpRequest();
	var username = document.getElementById("yonghuming").value;
	var password = document.getElementById("mima").value;
	request.open("get", "yanzheng.do?method=verifyHighOperatorLogin&username=" + username + "&password="
			+ password);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "true") {
				var request2 = new XMLHttpRequest();
				request2.open("get", "highoperate.do?method=login&username=" + username+ "&password="
						+ password);
				request2.send(null);
				request2.onreadystatechange = function() {
					if (request2.readyState == 4 && request2.status == 200) {
						var result2 = request2.responseText;
						if (result2 == "true") {
						window.location.href="high_operator_zhuye.jsp";
						}else{
							alert("出小差了:)");
						}
					}
				}
			} else {
			document.getElementById("mimacuowu").style.display="block";
			}
		}
	}
}
function go(x) {
	a = x;
	window.clearInterval(t);
	for ( var i = 0; i < tupian.length; i++) {
		if (i == x) {
			tupian[i].className = 'show';
			shu[i].style.background = '#f7c477';

		} else {
			tupian[i].className = 'hid';
			shu[i].style.background = '#a3520a';

		}
	}
}
