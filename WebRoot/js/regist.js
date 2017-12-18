onload = function() {
	shu = document.querySelectorAll(".xuhao");
	shu[0].style.background = '#ac520f';
	tupian = document.getElementsByName('lunbo');
	a = 0;
	for ( var i = 0; i < tupian.length; i++) {

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

	t = window.setInterval('bo()', 6000);

	var now = new Date();

	var nowtime = now.getFullYear();
	var yearselect = document.getElementById("zhuce_xinxi_year");
	var monthselect = document.getElementById("zhuce_xinxi_month");
	var dayselect = document.getElementById("zhuce_xinxi_day");
	var mi1select = document.getElementById("zhuce_xinxi_mibaowenti1");
	var mi2select = document.getElementById("zhuce_xinxi_mibaowenti2");
	var sexselect = document.getElementById("zhuce_xinxi_xingbie");
	var wenti1 = [ "我的父亲叫什么？", "我的母亲叫什么？", "我叫什么？", "我的伴侣叫什么？", "我的爷爷叫什么？" ];
	var wenti2 = [ "我的第一辆车叫什么？", "我的第一个好朋友叫什么？", "我的第一个女/男朋友叫什么？",
			"我的第一只笔是什么牌子？", "我的小学班主任叫什么？" ];
	sexselect.options.add(new Option("男", "男"));

	sexselect.options.add(new Option("女", "女"));
	sexselect.options.add(new Option("保密", "保密"));
	for ( var w = 0; w < 5; w++) {
		mi1select.options.add(new Option(wenti1[w], wenti1[w]));
		mi2select.options.add(new Option(wenti2[w], wenti2[w]));
	}
	for ( var y = nowtime; y >= 1900; y--) {
		yearselect.options.add(new Option(y + "", y + ""));
	}
	for ( var y = 1; y <= 12; y++) {
		monthselect.options.add(new Option(y + "", y + ""));
	}
	for ( var y = 1; y <= 31; y++) {
		dayselect.options.add(new Option(y + "", y + ""));
	}
	bo();
}

function nian() {
	var monthselected = document.getElementById("zhuce_xinxi_month");
	var yearselected = document.getElementById("zhuce_xinxi_year");
	var dayselected = document.getElementById("zhuce_xinxi_day");
	var index = monthselected.selectedIndex;
	var temp = monthselected.options[index].value * 1;
	if (temp == 2) {
		dayselected.options.length = 0;
		for ( var y = 1; y <= 28; y++) {
			dayselected.options.add(new Option(y + "", y + ""));
		}
		var yindex = yearselected.selectedIndex;
		var ytemp = yearselected.options[yindex].value * 1;
		if (ytemp % 4 == 0) {
			if (ytemp % 100 == 0) {
				if (ytemp % 400 == 0) {
					dayselected.options.add(new Option("29", "29"));
				}

			} else {
				dayselected.options.add(new Option("29", "29"));
			}
		}
	}
}

function riqi() {
	var monthselected = document.getElementById("zhuce_xinxi2_month");
	var yearselected = document.getElementById("zhuce_xinxi2_year");
	var dayselected = document.getElementById("zhuce_xinxi2_day");
	var index = monthselected.selectedIndex;
	var temp = monthselected.options[index].value * 1;
	switch (temp) {
	case 2:
		dayselected.options.length = 0;
		for ( var y = 1; y <= 28; y++) {
			dayselected.options.add(new Option(y + "", y + ""));
		}
		var yindex = yearselected.selectedIndex;
		var ytemp = yearselected.options[yindex].value * 1;
		if (ytemp % 4 == 0) {
			if (ytemp % 100 == 0) {
				if (ytemp % 400 == 0) {
					dayselected.options.add(new Option("29", "29"));
				}

			} else {
				dayselected.options.add(new Option("29", "29"));
			}
		}
		break;
	case 4:
		dayselected.options.length = 0;
		for ( var y = 1; y <= 30; y++) {
			dayselected.options.add(new Option(y + "", y + ""));
		}
		break;
	case 6:
		dayselected.options.length = 0;
		for ( var y = 1; y <= 30; y++) {
			dayselected.options.add(new Option(y + "", y + ""));
		}
		break;
	case 9:
		dayselected.options.length = 0;
		for ( var y = 1; y <= 30; y++) {
			dayselected.options.add(new Option(y + "", y + ""));
		}
		break;
	case 11:
		dayselected.options.length = 0;
		for ( var y = 1; y <= 30; y++) {
			dayselected.options.add(new Option(y + "", y + ""));
		}
		break;
	default:
		dayselected.options.length = 0;
		for ( var y = 1; y <= 31; y++) {
			dayselected.options.add(new Option(y + "", y + ""));
		}
		break;
	}
}

function bo() {
	for ( var i = 0; i < tupian.length; i++) {
		if (i == a) {
			tupian[i].className = 'show';
			shu[i].style.background = '#ac520f';
		} else {
			tupian[i].className = 'hid';
			shu[i].style.background = '#fee6b4';

		}
	}
	switch (a) {
	case 0:
		document.getElementById("zhuce_tishi_wenben").innerHTML = "Find what is your favorate";
		break;
	case 1:
		document.getElementById("zhuce_tishi_wenben").innerHTML = "Try to do fascinating things";
		break;
	case 2:
		document.getElementById("zhuce_tishi_wenben").innerHTML = "Or,buy a bunch of flowers";
		break;
	}
	a++;
	if (a == tupian.length) {
		a = 0;
	}
}

function go(x) {
	a = x;
	switch (x) {
	case 0:
		document.getElementById("zhuce_tishi_wenben").innerHTML = "Find what is your favorate";
		break;
	case 1:
		document.getElementById("zhuce_tishi_wenben").innerHTML = "Try to do fascinating things";
		break;
	case 2:
		document.getElementById("zhuce_tishi_wenben").innerHTML = "Or,buy a bunch of flowers";
		break;
	}
	window.clearInterval(t);
	for ( var i = 0; i < tupian.length; i++) {
		if (i == x) {
			tupian[i].className = 'show';
			shu[i].style.background = '#ac520f';

		} else {
			tupian[i].className = 'hid';
			shu[i].style.background = '#fee6b4';

		}
	}
}
function regist() {
	var xing = document.querySelectorAll(".xing");
	var a = true;
	for ( var i = 0; i < 4; i++) {
		if (document.getElementById("zq" + i).className != "zhengquetishi show"
				|| xing[i].style.display != "none") {
			a = false;
		}
	}

	if (a == true) {
		document.getElementById("zhuce").click();
	} else {
		alert("请务必填写正确再注册哦:)  ");
	}

}
function shujukujiance(zhi, num) {
	var zhi_l = zhi.length;
	var xing = document.querySelectorAll(".xing");
	var request = new XMLHttpRequest();
	var shuju = document.querySelectorAll(".shuju");
	switch (num) {
	case 0:
		if (zhi_l < 6) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			xing[num].style.display = "none";
			request
					.open("get", "yanzheng.do?method=verifyUsername&username="
							+ zhi);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					if (result == "true") {
						document.getElementById("zq" + num).className = "zhengquetishi show";
						document.getElementById("cw" + num).className = "cuowutishi hid";
					} else {
						document.getElementById("cw" + num).className = "cuowutishi show";
						document.getElementById("zq" + num).className = "zhengquetishi hid";
					}
				}
			}
		}
		break;
	case 4:
		if (zhi_l < 11) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			var reg = /^1[35789]\d{9}$/g;
			if (reg.test(zhi)) {
				xing[num].style.display = "none";
				request.open("get", "yanzheng.do?method=verifyPhoneNumber&uPhone="
						+ zhi);
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState == 4 && request.status == 200) {
						var result = request.responseText;
						if (result == "true") {
							document.getElementById("zq" + num).className = "zhengquetishi show";
							document.getElementById("cw" + num).className = "cuowutishi hid";
						} else {
							document.getElementById("cw" + num).className = "cuowutishi show";
							document.getElementById("zq" + num).className = "zhengquetishi hid";
						}
					}
				}
			} else {
				xing[num].style.display = "block";
			}
		}
		break;
	case 5:
		var reg = /^([a-zA-Z0-9])+([a-z0-9_-])+@([a-zA-Z0-9_-])+(\.([a-zA-Z0-9_-]){2,3}){1,2}$/;
		if (reg.test(zhi)) {
			xing[num].style.display = "none";
			request.open("get", "yanzheng.do?method=verifyEmail&uEmail=" + zhi);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					if (result == "true") {
						document.getElementById("zq" + num).className = "zhengquetishi show";
						document.getElementById("cw" + num).className = "cuowutishi hid";
					} else {
						document.getElementById("cw" + num).className = "cuowutishi show";
						document.getElementById("zq" + num).className = "zhengquetishi hid";
					}
				}
			}
		} else {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		}
		break;
	case 1:
		if(zhi_l ==0){
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		}else if (zhi_l < 6&&zhi_l>0) {
			xing[num].style.display = "none";
			document.getElementById("cw" + num).className = "cuowutishi show";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			xing[num].style.display = "none";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi show";
		}
		break;
	case 2:	
		if (zhi_l == 0) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else if(zhi_l<6&&zhi_l>0){
			xing[num].style.display = "none";
			document.getElementById("cw" + num).className = "cuowutishi show";
			document.getElementById("zq" + num).className = "zhengquetishi hid";			
		}
		else if(zhi_l>=6){
			if(zhi==shuju[num-1].value){
			xing[num].style.display = "none";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi show";
			}else{
				document.getElementById("cw" + num).className = "cuowutishi show";
				document.getElementById("zq" + num).className = "zhengquetishi hid";
			}
		}
		break;
	case 3:
		if (zhi_l <= 1) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			xing[num].style.display = "none";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi show";
		}
		break;
	case 7:
		if (zhi_l <= 1) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			xing[num].style.display = "none";
		}
		break;
	}

}


