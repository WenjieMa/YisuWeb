function xiayibu(x, num) {
	if (x == 1) {
		var xing = document.querySelectorAll(".xing");
		var a = true;
		if (document.getElementById("zq" + num).className != "zhengquetishi show"
				|| xing[num].style.display != "none") {
			a = false;
		}
		if (a == true) {
			document.getElementById("zhaohui_sangebuzhou1").style.display = "none";
			document.getElementById("zhaohui_sangebuzhou2").style.display = "block";
			var request = new XMLHttpRequest();
			request.open("post", "yanzheng.do?method=verifyQuestion&username="
					+ document.getElementById("yhm").value);
			request.send(null);
			request.onreadystatechange = function() {

				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					if (result == "false") {
						document.getElementById("cw" + num).className = "cuowutishi show";
						document.getElementById("zq" + num).className = "zhengquetishi hid";
					} else {
						var wt1 = "密保问题1:";
						var wt2 = "密保问题2:";
						for ( var t = 0; t < result.length; t++) {
							var str = result.charAt(t);
							if (str != '&') {
								wt1 = wt1 + str;
							} else if (str == '&') {
								result = result.substring(t + 1, result.length);
								break;
							}
						}
						for ( var t = 0; t < result.length; t++) {
							var str = result.charAt(t);
							wt2 = wt2 + str;
						}
						document.getElementById("zq" + num).className = "zhengquetishi show";
						document.getElementById("cw" + num).className = "cuowutishi hid";
						document.getElementById("mibaowenti1").innerHTML = wt1;
						document.getElementById("mibaowenti2").innerHTML = wt2;
					}
				}
			}

		} else {
			alert("请务必填写正确的用户名再继续下一步哦:)  ");
		}
	}
	if (x == 2) {
		var xing = document.querySelectorAll(".xing");
		var a = true;
		var num2 = num * 1 + 1;
		if (document.getElementById("zq" + num).className != "zhengquetishi show"
				|| xing[num].style.display != "none"
				|| xing[num2].style.display != "none"
				|| document.getElementById("zq" + num2).className != "zhengquetishi show") {
			a = false;
		}
		if (a == true) {
			document.getElementById("zhaohui_sangebuzhou2").style.display = "none";
			document.getElementById("zhaohui_sangebuzhou3").style.display = "block";
		} else {
			alert("答案错了,请您再仔细回想一下:)  ");
		}
	}
	if (x == 3) {
		var xing = document.querySelectorAll(".xing");
		var a = true;
		for ( var i = 0; i < 5; i++) {
			if (document.getElementById("zq" + i).className != "zhengquetishi show"
					|| xing[i].style.display != "none") {
				a = false;
			}
		}

		if (a == true) {
			window.location.href = "user.do?method=updatePassword&username="
					+ document.getElementById("yhm").value + "&password="
					+ document.getElementById("mm").value;
		} else {
			alert("请务必填写正确的信息再修改密码哦:)  ");
		}

	}
	if (x == 4) {
		document.getElementById("zhaohui_sangebuzhou1").style.display = "block";
		document.getElementById("zhaohui_sangebuzhou2").style.display = "none";
	}
	if (x == 5) {
		document.getElementById("zhaohui_sangebuzhou2").style.display = "block";
		document.getElementById("zhaohui_sangebuzhou3").style.display = "none";
	}
}

function shujukujiance(zhi, num) {
	var zhi_l = zhi.length;
	var xing = document.querySelectorAll(".xing");
	var request = new XMLHttpRequest();
	switch (num) {
	case 0:
		if (zhi_l < 6) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			xing[num].style.display = "none";

			request
					.open("post", "yanzheng.do?method=verifyUsername&username="
							+ zhi);

			request.send(null);
			request.onreadystatechange = function() {

				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					if (result == "true") {

						document.getElementById("cw" + num).className = "cuowutishi show";
						document.getElementById("zq" + num).className = "zhengquetishi hid";
					} else {
						document.getElementById("zq" + num).className = "zhengquetishi show";
						document.getElementById("cw" + num).className = "cuowutishi hid";

					}
				}
			}
		}
		break;
	case 1:
		if (zhi_l == 0) {
			
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			xing[num].style.display = "none";
			request.open("post", "yanzheng.do?method=verifyAnswer1&uDaan1=" +  encodeURI(encodeURI(zhi))
					+ "&username=" + document.getElementById("yhm").value);
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
	case 2:
		if (zhi_l == 0) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			xing[num].style.display = "none";
			request.open("post", "yanzheng.do?method=verifyAnswer2&uDaan2=" +  encodeURI(encodeURI(zhi))
					+ "&username=" + document.getElementById("yhm").value);
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
	case 3:
		if (zhi_l == 0) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else if (zhi_l <= 5 && zhi_l > 0) {
			xing[num].style.display = "none";
			document.getElementById("cw" + num).className = "cuowutishi show";
			document.getElementById("zq" + num).className = "zhengquetishi hid";

		} else {
			xing[num].style.display = "none";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi show";
		}
		break;
	case 4:
		if (zhi_l == 0) {
			xing[num].style.display = "block";
			document.getElementById("cw" + num).className = "cuowutishi hid";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else if (zhi_l <= 5 && zhi_l > 0) {
			xing[num].style.display = "none";
			document.getElementById("cw" + num).className = "cuowutishi show";
			document.getElementById("zq" + num).className = "zhengquetishi hid";
		} else {
			xing[num].style.display = "none";
			if (zhi != document.getElementById("mm").value) {

				document.getElementById("cw" + num).className = "cuowutishi show";
				document.getElementById("zq" + num).className = "zhengquetishi hid";
			} else {
				document.getElementById("cw" + num).className = "cuowutishi hid";
				document.getElementById("zq" + num).className = "zhengquetishi show";
			}
		}
		break;
	}
}

