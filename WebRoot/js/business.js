function yishang(x) {
	xuan[x].className = "yishang";
	xuanxianglan[x].style.display = "block";
}
function zoukai(x) {
	xuan[x].className = "zoukai";
	xuanxianglan[x].style.display = "none";
}
function searchAllGoodsByName_FromMenu(num) {
	var gName = document.querySelectorAll('.mulu');
	if (gName.length != 0) {
		document.getElementById("sousuoneirong").value = gName[num].innerHTML;
		document.getElementById("sousuobiaodan").submit();
		document.getElementById("sousuoneirong").value = "";
	} else {
		alert("请输入想搜索的内容再搜索哦:)");
	}
}
function searchAllGoodsByName() {
	var gName = document.getElementById("sousuoneirong").value;
	if (gName.length != 0) {
		var request = new XMLHttpRequest();
		request.open("get", "goods.do?method=searchAllGoodsByName&gName=" + encodeURI(encodeURI(gName)));
		request.send(null);
		request.onreadystatechange = function() {
			alert(1);
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					window.location = "adm_goods_search.jsp";
				} else {
					alert("哎呀！出了点小错误！");
				}
			}
		}
	} else {
		alert("请输入想搜索的内容再搜索哦:)");
	}
}
function searchAllGoodsByName_FromHeader() {
	var gName = document.getElementById("sousuoneirong_header").value;
	if (gName.length != 0) {
		var request = new XMLHttpRequest();
		request.open("get", "goods.do?method=searchAllGoodsByName&gName=" + encodeURI(encodeURI(gName)));
		request.send(null);
		request.onreadystatechange = function() {
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					window.location = "adm_goods_search.jsp";
				} else {
					alert("哎呀！出了点小错误！");
				}
			}
		}
	} else {
		alert("请输入想搜索的内容再搜索哦:)");
	}
}
function searchAllGoodsByExcistType(num) {
	var gName = document.querySelectorAll('.shouye_biao_xiala_li_word');
	if (gName.length != 0) {
		document.getElementById("sousuoneirong").value = gName[num].innerHTML;
		document.getElementById("sousuobiaodan").submit();
	} else {
		alert("请输入想搜索的内容再搜索哦:)");
	}
}
function searchAllGoodsByType(num) {
	var str = '穿';
	switch (num) {
	case 0:
		str = '穿';
		break;
	case 1:
		str = '吃';
		break;
	case 2:
		str = '玩';
		break;
	case 3:
		str = '物';
		break;
	}
	var gName = document.getElementsByName('dalei');
	window.location = "goods.do?searchAllGoodsByType&gType="
	+ encodeURI(encodeURI(str));
}
function searchAllCollection() {
	if (document.getElementById('yonghuming_shouye').innerHTML == "欢迎您进入易俗网") {
		alert("请登录再操作哦");
	} else {
		var request = new XMLHttpRequest();
		request.open("get", "goods.do?method=searchAllCollection");
		request.send(null);
		request.onreadystatechange = function() {
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					window.location = "adm_info_collection.jsp";
				} else {
					alert("哎呀！出了点小错误！");
				}
			}
		}
	}
}
function deleteSingleGoodsFromCollection(num) {
	if (confirm("确认要删除收藏的商品吗？")) {
		var anniu = document.querySelectorAll('.gId');
		var pro = document.querySelectorAll('.product');
		var img = document.querySelectorAll('.shanchushoucang_anniu_img');
		var request = new XMLHttpRequest();
		request.open("get",
			"goods.do?method=deleteSingleGoodsFromCollection&gId="
			+ anniu[num].innerHTML);
		request.send(null);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var result = request.responseText;
				if (result == "true") {
					searchAllCollection();
					pro[num].style.display = "none";
					img[num].style.display = "none";
				} else {
					alert("删除失败！");
				}
			}
		}
	} else {

	}
}
function searchAllOders() {
	if (document.getElementById('yonghuming_shouye').innerHTML == "欢迎您进入易俗网") {
		alert("请登录再操作哦");
	} else {
		var request = new XMLHttpRequest();
		request.open("get", "goods.do?method=searchAllOders");
		request.send(null);
		request.onreadystatechange = function() {
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					window.location.href = "adm_info_orders.jsp";
				} else {
					alert("出了点小错误");
				}
			}
		}
	}
}
function searchAllGoodsBuyInfos() {
	if (document.getElementById('yonghuming_shouye').innerHTML == "欢迎您进入易俗网") {
		alert("请登录再操作哦");
	} else {
		var request = new XMLHttpRequest();
		request.open("get", "pro.do?method=searchAllProvince");
		request.send(null);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var result = request.responseText;
				if (result == "true") {
					window.location.href = "adm_buy_shoppingcart.jsp";
				} else {
					alert("进入购物车失败");
				}
			}
		}

	}
}
function enterZhuye() {
	var request = new XMLHttpRequest();
	request.open("get", "goods.do?method=searchRandomGoodsIntoZhuye");
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "true") {
				window.location.href = "adm_zhuye.jsp";
			} else {
				alert("产生随机商品失败");
			}
		}
	}
}
function enterSetting(num) {
	if (document.getElementById('yonghuming_shouye').innerHTML == "欢迎您进入易俗网") {
		alert("请登录再操作哦");
	} else {
		switch (num) {
		case 1:
			window.location.href = "adm_userinfo_update.jsp";
			break;
		case 2:
			window.location.href = "adm_userinfo_security.jsp";
			break;
		case 3:
			window.location.href = "adm_userinfo_wallet.jsp";
			break;
		case 4:
			var request = new XMLHttpRequest();
			request.open("get", "re.do?method=searchAllFriends");
			request.send(null);
			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					if (result == "true") {
						window.location.href = "adm_chatting.jsp";
					} else {
						alert("聊天页面还在制作中：）");
					}
				}
			}
			break;
		}
	}
}

function logout() {
	var request = new XMLHttpRequest();
	request.open("get", "user.do?method=logout");
	request.send(null);
	request.onreadystatechange = function() {
		if (request.status == 200 && request.readyState == 4) {
			var result = request.responseText;
			if (result == "true") {
				window.location = "adm_user_login.jsp";
			} else {
				alert("注销失败:(");
			}
		}
	}
}
function addToShoppingCart() {
	if (document.getElementById('yonghuming_shouye').innerHTML == "欢迎您进入易俗网") {
		alert("请登录再操作哦");
	} else {
		var text_shuliang = document.getElementById("text_shuliang").value;
		if (text_shuliang.length != 0) {
			var request = new XMLHttpRequest();
			var id = document.getElementById("No").innerHTML;
			request.open("get", "goods.do?method=addToShoppingCart&gId=" + id
				+ "&shuliang=" + text_shuliang);
			request.send(null);

			request.onreadystatechange = function() {
				if (request.readyState == 4 && request.status == 200) {
					var result = request.responseText;
					if (result == "true+") {
						document.getElementById("gouwuche_shouye_shuliang").innerHTML = document
								.getElementById("gouwuche_shouye_shuliang").innerHTML * 1 + 1;

					} else if (result == "true") {
					} else {
						alert("加入失败了呢:(,库存不够了哦.");
					}
				}
			}
		} else {
			alert("请输入购买的数量哦:)");
		}
	}
}
function addToCollection() {
	if (document.getElementById('yonghuming_shouye').innerHTML == "欢迎您进入易俗网") {
		alert("请登录再操作哦");
	} else {
		var request = new XMLHttpRequest();
		var id = document.getElementById("No").innerHTML;
		request.open("get", "goods.do?method=addToCollection&gId=" + id);
		request.send(null);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var result = request.responseText;
				if (result == "true") {
					alert("收藏成功！");
				} else {
					alert("您已经收藏过该商品了！");
				}
			}
		}
	}
}
function pingjia() {
	var pingjia_eachtext = document.querySelectorAll('.pingjia_eachtext');
	var dingdanbianhao_small_each = document
		.querySelectorAll('.dingdanbianhao_small_each');
	var xingji1 = document.querySelectorAll('.xingji1');
	var xingji2 = document.querySelectorAll('.xingji2');
	var xingji3 = document.querySelectorAll('.xingji3');
	var xingji4 = document.querySelectorAll('.xingji4');
	var xingji5 = document.querySelectorAll('.xingji5');
	var haoping = document.querySelectorAll('.haoping');
	var zhongping = document.querySelectorAll('.zhongping');
	var chaping = document.querySelectorAll('.chaping');
	var request = new XMLHttpRequest();
	var str = "goods.do?method=commitAllGoods";
	var haozhongcha_num = new Array();
	var xingji_num = new Array();
	for (var q = 0; q < dingdanbianhao_small_each.length; q++) {
		if (xingji1[q].checked) {
			xingji_num[q] = 1;
		}
		if (xingji2[q].checked) {
			xingji_num[q] = 2;
		}
		if (xingji3[q].checked) {
			xingji_num[q] = 3;
		}
		if (xingji4[q].checked) {
			xingji_num[q] = 4;
		}
		if (xingji5[q].checked) {
			xingji_num[q] = 5;
		}
		if (haoping[q].checked) {
			haozhongcha_num[q] = 3;
		} else if (zhongping[q].checked) {
			haozhongcha_num[q] = 2;
		} else if (chaping[q].checked) {
			haozhongcha_num[q] = 1;
		}
		str = str + "&dId" + q + "=" + dingdanbianhao_small_each[q].innerHTML
		+ "&pingjia" + q + "="
		+ encodeURI(encodeURI(pingjia_eachtext[q].value))
		+ "&haozhongcha" + q + "=" + haozhongcha_num[q] + "&xingji" + q
		+ "=" + xingji_num[q];
	}
	str += "&changdu=" + dingdanbianhao_small_each.length;
	request.open("get", str);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.status == 200 && request.readyState == 4) {
			var result = request.responseText;
			if (result == "true") {
				var request2 = new XMLHttpRequest();
				request2.open("get", "goods.do?method=searchAllOders");
				request2.send(null);
				request2.onreadystatechange = function() {
					if (request2.status == 200 && request2.readyState == 4) {
						var result2 = request2.responseText;
						if (result2 == "true") {
							alert("评价成功，即将返回订单页面。");
							window.location = "adm_info_orders.jsp";
						} else {
							alert("评价失败。");
							window.location = "adm_info_orders.jsp";
						}
					}
				}
			} else {
			}
		}
	}
}

/*
 * function daxing() { var xingji_img =
 * document.getElementsByName('.xingji_img1'); var xingji =
 * document.querySelectorAll('.xingji1'); var xingji_img =
 * document.getElementsByName('.xingji_img2'); var xingji =
 * document.querySelectorAll('.xingji2'); var xingji_img =
 * document.getElementsByName('.xingji_img3'); var xingji =
 * document.querySelectorAll('.xingji3'); var xingji_img =
 * document.getElementsByName('.xingji_img4'); var xingji =
 * document.querySelectorAll('.xingji4'); var xingji_img =
 * document.getElementsByName('.xingji_img5'); var xingji =
 * document.querySelectorAll('.xingji5'); for (var i = 0; i < xingji1.length;
 * i++) { if (xingji1[i].checked) { xingji_img1[i].style.display = "block"; }
 * else { xingji_img1[i].style.display = "none"; } } for (var i = 0; i <
 * xingji2.length; i++) { if (xingji2[i].checked) { xingji_img2[i].style.display =
 * "block"; } else { xingji_img2[i].style.display = "none"; } } for (var i = 0;
 * i < xingji3.length; i++) { if (xingji3[i].checked) {
 * xingji_img3[i].style.display = "block"; } else { xingji_img3[i].style.display =
 * "none"; } } for (var i = 0; i < xingji4.length; i++) { if
 * (xingji1[i].checked) { xingji_img4[i].style.display = "block"; } else {
 * xingji_img4[i].style.display = "none"; } } for (var i = 0; i <
 * xingji5.length; i++) { if (xingji5[i].checked) { xingji_img5[i].style.display =
 * "block"; } else { xingji_img5[i].style.display = "none"; } }
 *  }
 */
function quanxuan() {
	fuxuankuang = document.getElementsByName("checkbox_name");
	fuxuankuang_all = document.getElementById("checkbox_all");
	if (fuxuankuang_all.checked) {
		for (var i = 0; i < fuxuankuang.length; i++) {
			fuxuankuang[i].checked = true;
		}
	} else {
		for (var i = 0; i < fuxuankuang.length; i++) {
			fuxuankuang[i].checked = false;
		}
	}
	jisuan();
}

function jisuan() {
	jiage_s = document.querySelectorAll(".jiage_class");
	shuliang_s = document.querySelectorAll(".shuliang_class");
	fuxuankuang = document.getElementsByName("checkbox_name");
	zongjia_s = document.getElementById("zongjia");
	zongjia_s.innerHTML = 0;
	for (var i = 0; i < jiage_s.length; i++) {
		if (fuxuankuang[i].checked) {
			zongjia_s.innerHTML = zongjia_s.innerHTML * 1
				+ jiage_s[i].innerHTML * 1 * shuliang_s[i].innerHTML * 1;
		}
	}
}

function tijiaodingdan() {
	if (confirm("确认提交订单信息吗？提交之后信息不可修改。")) {
		var shuliang = document.querySelectorAll('.shuliang_class');
		var xz_checkbox = document.querySelectorAll('.checkbox_class');
		var sc_gId = document.querySelectorAll('.checkbox_gId');
		var gId_String = "";
		var shuliang_String = "";
		var temp = 0;
		for (var i = 0; i < xz_checkbox.length; i++) {
			if (xz_checkbox[i].checked) {
				gId_String = gId_String + sc_gId[i].innerHTML + ',';
				shuliang_String = shuliang_String + shuliang[i].innerHTML + ',';
				temp = temp * 1 + 1;
			}
		}
		if (temp == 0) {
			alert("请选中商品再操作哦:)");
		} else {
			var request = new XMLHttpRequest();
			request.open("get", "goods.do?method=addSubmitOders&gId_string="
				+ gId_String + "&shuliang_string=" + shuliang_String);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.status == 200 && request.readyState == 4) {
					var result = request.responseText;
					if (result == "true") {
						window.location = "adm_buy_pay.jsp";
					} else {
					}
				}
			}
		}
	} else {

	}
}

function gouwuche_shanchu(e) {
	var theEvent = window.event || e;
	var a = theEvent.srcElement;
	if (!a) {
		a = theEvent.target;
	}
	var sc_gId = document.querySelectorAll('.checkbox_gId');
	var sc_anniu = document.querySelectorAll('.shanchu_anniu');
	for (var i = 0; i < sc_anniu.length; i++) {
		if (a == sc_anniu[i]) {
			var request = new XMLHttpRequest();
			request.open("get",
				"goods.do?method=deleteSingleGoodsFromShoppingCart&gId="
				+ sc_gId[i].innerHTML);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.status == 200 && request.readyState == 4) {
					var result = request.responseText;
					if (result == "true") {
						window.location.href = "adm_buy_shoppingcart.jsp";
					} else {
					}
				}
			}
		}
	}
}
function quanbushanchu() {
	var xz_checkbox = document.querySelectorAll('.checkbox_class');
	var sc_gId = document.querySelectorAll('.checkbox_gId');
	var gId_String = "";
	var temp = 0;
	for (var i = 0; i < xz_checkbox.length; i++) {
		if (xz_checkbox[i].checked) {
			gId_String = gId_String + sc_gId[i].innerHTML + ',';
			temp = temp * 1 + 1;
		}
	}
	if (temp == 0) {
		alert("请选中商品再操作哦:)");
	} else {
		var request = new XMLHttpRequest();
		request.open("get",
			"goods.do?method=deleteAllGoodsFromShoppingCart&gId_string="
			+ gId_String);
		request.send(null);
		request.onreadystatechange = function() {
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					window.location.href = "adm_buy_shoppingcart.jsp";
				} else {
				}
			}
		}
	}
}
function gouwuche_singel_jia(e) {
	var theEvent = window.event || e;
	var a = theEvent.srcElement;
	if (!a) {
		a = theEvent.target;
	}
	var shuliang = document.querySelectorAll('.shuliang_class');
	var sc_gId = document.querySelectorAll('.checkbox_gId');
	var sc_anniu = document.querySelectorAll('.shuliang_jia_anniu');
	for (var i = 0; i < sc_anniu.length; i++) {
		if (a == sc_anniu[i]) {
			var temp_shuliang = shuliang[i];
			var request = new XMLHttpRequest();
			request.open("get", "goods.do?method=addCountFromShoppingCart&gId="
				+ sc_gId[i].innerHTML + "&caozuo=jia");
			request.send(null);
			request.onreadystatechange = function() {
				if (request.status == 200 && request.readyState == 4) {
					var result = request.responseText;
					if (result == "true") {
						temp_shuliang.innerHTML = temp_shuliang.innerHTML * 1 + 1;
						jisuan();
					} else {
						alert("修改失败：(");
					}
				}
			}
		}
	}

}
function gouwuche_singel_jian(e) {
	var theEvent = window.event || e;
	var a = theEvent.srcElement;
	if (!a) {
		a = theEvent.target;
	}
	var sc_shanchuanniu = document.querySelectorAll('.shanchu_anniu');
	var shuliang = document.querySelectorAll('.shuliang_class');
	var sc_gId = document.querySelectorAll('.checkbox_gId');
	var sc_anniu = document.querySelectorAll('.shuliang_jian_anniu');
	for (var i = 0; i < sc_anniu.length; i++) {
		if (a == sc_anniu[i]) {
			var temp_shuliang = shuliang[i];
			var temp = temp_shuliang.innerHTML * 1 - 1;
			if (temp == 0) {
				if (confirm("确认要删除本商品吗？")) {
					sc_shanchuanniu[i].click();
				}
			} else {
				var request = new XMLHttpRequest();
				request.open("get",
					"goods.do?method=addCountFromShoppingCart&gId="
					+ sc_gId[i].innerHTML + "&caozuo=jian");
				request.send(null);
				request.onreadystatechange = function() {
					if (request.status == 200 && request.readyState == 4) {
						var result = request.responseText;
						if (result == "true") {
							temp_shuliang.innerHTML = temp_shuliang.innerHTML * 1 - 1;
							jisuan();
						} else {
							alert("修改失败:(");
						}
					}
				}
			}
		}
	}
}

function querengoumai_fromDingdan(e) {
	var theEvent = window.event || e;
	var a = theEvent.srcElement;
	if (!a) {
		a = theEvent.target;
	}
	var dingdanbianhao_big_each = document
		.querySelectorAll(".dingdanbianhao_big_each");
	var fk_anniu = document.querySelectorAll('.fukuan_anniu');
	for (var i = 0; i < fk_anniu.length; i++) {
		if (a == fk_anniu[i]) {
			alert(dingdanbianhao_big_each[i].innerHTML);
			var request = new XMLHttpRequest();
			request.open("get", "goods.do?method=payFromOder&bid="
				+ dingdanbianhao_big_each[i].innerHTML);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.status == 200 && request.readyState == 4) {
					var result = request.responseText;
					if (result == "true") {
						window.location.href = "adm_buy_pay.jsp";
					} else {
						alert("进入付款页面失败");
					}
				}
			}
		}
	}
}
function quxiaoDingdan(e) {
	var theEvent = window.event || e;
	var a = theEvent.srcElement;
	if (!a) {
		a = theEvent.target;
	}
	if (confirm("确认取消本订单吗？")) {
		var dingdanbianhao_big_each = document
			.querySelectorAll(".dingdanbianhao_big_each");
		var qx_anniu = document.querySelectorAll('.quxiao_anniu');
		for (var i = 0; i < qx_anniu.length; i++) {
			if (a == qx_anniu[i]) {
				alert(dingdanbianhao_big_each[i].innerHTML);
				var request = new XMLHttpRequest();
				request.open("get", "goods.do?method=delCancelOder&bid="
					+ dingdanbianhao_big_each[i].innerHTML);
				request.send(null);
				request.onreadystatechange = function() {
					if (request.status == 200 && request.readyState == 4) {
						var result = request.responseText;
						if (result == "true") {
							alert("取消成功:)");
							var request2 = new XMLHttpRequest();
							request2.open("get",
								"goods.do?method=searchAllOders");
							request2.send(null);
							request2.onreadystatechange = function() {
								if (request2.status == 200
									&& request2.readyState == 4) {
									var result = request2.responseText;
									if (result == "true") {
										window.location = "adm_info_orders.jsp";
									} else {
										window.location = "adm_info_orders.jsp";
									}
								}
							}
						} else {
							alert("取消订单失败");
						}
					}
				}
			}
		}
	} else {
		alert("明智的决定");
	}
}
function querengoumai(e) {
	var theEvent = window.event || e;
	var a = theEvent.srcElement;
	if (!a) {
		a = theEvent.target;
	}
	var dingdanbianhao_big_each = document
		.querySelectorAll(".dingdanbianhao_big_each");
	var fk_anniu = document.querySelectorAll('.fukuan_anniu');
	for (var i = 0; i < fk_anniu.length; i++) {
		if (a == fk_anniu[i]) {
			alert(dingdanbianhao_big_each[i].innerHTML);
			var request = new XMLHttpRequest();
			request.open("get", "goods.do?method=payOder&uZhifumima="
				+ document.getElementById("keyinputtext").value + "&bid="
				+ dingdanbianhao_big_each[i].innerHTML);
			request.send(null);
			request.onreadystatechange = function() {
				if (request.status == 200 && request.readyState == 4) {
					var result = request.responseText;
					if (result == "true") {
						window.location.href = "adm_buy_success.jsp";
					} else if (result == "nopsw") {
						window.location.href = "adm_userinfo_security.jsp";
					} else {
						alert("支付密码错误或者余额不足了:(");
					}
				}
			}
		}
	}
}
function querenshouhuo(e) {
	if (confirm("确认收货吗？")) {
		var theEvent = window.event || e;
		var a = theEvent.srcElement;
		if (!a) {
			a = theEvent.target;
		}
		var dingdanbianhao_big_each = document
			.querySelectorAll(".dingdanbianhao_big_each");
		var sh_anniu = document.querySelectorAll('.shouhuo_anniu');
		for (var i = 0; i < sh_anniu.length; i++) {
			if (a == sh_anniu[i]) {
				alert(dingdanbianhao_big_each[i].innerHTML);
				var request = new XMLHttpRequest();
				request.open("get", "goods.do?method=getGoods&bid="
					+ dingdanbianhao_big_each[i].innerHTML);

				request.send(null);
				request.onreadystatechange = function() {
					if (request.status == 200 && request.readyState == 4) {
						var result = request.responseText;
						if (result == "true") {
							window.location.href = "adm_buy_commit.jsp";
						} else {
							alert("收货失败");
						}
					}
				}
			}
		}
	}
}
function pingjiaSingleGoods(e) {
	var dingdanbianhao_big_each = document
		.querySelectorAll(".dingdanbianhao_big_each");
	var pj_anniu = document.querySelectorAll('.pingjia_anniu');
	for (var i = 0; i < pj_anniu.length; i++) {
		if (e.srcElement == pj_anniu[i]) {
			alert(dingdanbianhao_big_each[i].innerHTML);
			var request = new XMLHttpRequest();
			request.open("get", "goods.do?method=commitSingleGoods&bid="
				+ dingdanbianhao_big_each[i].innerHTML);

			request.send(null);
			request.onreadystatechange = function() {
				if (request.status == 200 && request.readyState == 4) {
					var result = request.responseText;
					if (result == "true") {
						window.location.href = "adm_buy_commit.jsp";
					} else {

					}
				}
			}
		}
	}

}
function chongzhi(num) {
	var zfbpic = document.querySelectorAll('.zfb_tupian');
	for (var i = 0; i < zfbpic.length; i++) {
		if (i == num) {
			zfbpic[num].style.display = 'block';
		} else {
			zfbpic[i].style.display = 'none';
		}
	}
}
function searchSingleProvince() {
	var json;
	var json2;
	var selectCity = document.getElementById("city");
	var selectDistrict = document.getElementById("district");
	var selectProvince = document.getElementById("province");
	var request = new XMLHttpRequest();
	request.open("get", "pro.do?method=searchSingleProvince&proId=" + selectProvince.options[selectProvince.selectedIndex].value);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.status == 200 && request.readyState == 4) {
			var result = request.responseText;
			selectCity.innerHTML = "";
			json = eval(result);
			var str;
			for (var i = 0; i < json.length; i++) {
				str += "<option value='" + json[i].cId + "'>" + json[i].cName + "</option>";
			}
			var request2 = new XMLHttpRequest();
			request2.open("get", "pro.do?method=searchSingleCity&cId=" + json[0].cId);
			request2.send(null);
			request2.onreadystatechange = function() {
				if (request2.status == 200 && request2.readyState == 4) {
					var result2 = request2.responseText;
					selectDistrict.innerHTML = "";
					json2 = eval(result2);
					var str2;
					for (var i = 0; i < json2.length; i++) {
						str2 += "<option value='" + json2[i].disId + "'>" + json2[i].disName + "</option>";
					}
					selectDistrict.innerHTML = str2;
				}
			}
			selectCity.innerHTML = str;

		}
	}
}
function searchSingleCity() {
	var selectProvince = document.getElementById("province");
	var selectCity = document.getElementById("city");
	var selectDistrict = document.getElementById("district");
	var request = new XMLHttpRequest();
	request.open("get", "pro.do?method=searchSingleCity&cId=" + selectCity.options[selectCity.selectedIndex].value);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.status == 200 && request.readyState == 4) {
			var result = request.responseText;
			selectDistrict.innerHTML = "";
			json = eval(result);
			var str;
			for (var i = 0; i < json.length; i++) {
				str += "<option value=" + json[i].disId + ">" + json[i].disName + "</option>";
			}
			selectDistrict.innerHTML = str;
		}
	}
}
function xiugaidizhi() {
	var selectCity = document.getElementById("city");
	var selectDistrict = document.getElementById("district");
	var selectProvince = document.getElementById("province");
	var request = new XMLHttpRequest();
	var str = selectProvince.options[selectProvince.selectedIndex].text + selectCity.options[selectCity.selectedIndex].text + selectDistrict.options[selectDistrict.selectedIndex].text + document.getElementById("shouhuodizhi_text").value;
	request.open("get", "user.do?method=updateAddress&changyongdizhi=" + str);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.status == 200 && request.readyState == 4) {
			var result = request.responseText;
			if (result == "true") {
				document.getElementById("shouhuodizhi").innerHTML = str;
				alert("修改成功：）");
			} else {
				alert("修改失败：（");
			}
		}
	}
}
function shezhi_yishang() {
	var shezhilan = document.getElementById("shezhilan");
	document.getElementById("shezhilan").style.display = "block";
}

function shezhi_zoukai() {
	var shezhilan = document.getElementById("shezhilan");
	document.getElementById("shezhilan").style.display = "none";
}
function haozhongchaZhanshi(num) {
	switch (num) {
	case 0:
		document.getElementById('allping_div').style.display = 'block';
		document.getElementById('haoping_div').style.display = 'none';
		document.getElementById('zhongping_div').style.display = 'none';
		document.getElementById('chaping_div').style.display = 'none';
		break;
	case 1:
		document.getElementById('allping_div').style.display = 'none';
		document.getElementById('haoping_div').style.display = 'block';
		document.getElementById('zhongping_div').style.display = 'none';
		document.getElementById('chaping_div').style.display = 'none';
		break;
	case 2:
		document.getElementById('allping_div').style.display = 'none';
		document.getElementById('haoping_div').style.display = 'none';
		document.getElementById('zhongping_div').style.display = 'block';
		document.getElementById('chaping_div').style.display = 'none';
		break;
	case 3:
		document.getElementById('allping_div').style.display = 'none';
		document.getElementById('haoping_div').style.display = 'none';
		document.getElementById('zhongping_div').style.display = 'none';
		document.getElementById('chaping_div').style.display = 'block';
		break;
	}
}
function setPayPsw() {
	var psw = document.getElementById("newpaypsw").value;
	if (psw.length < 6) {
		alert("密码长度不够哦：）");
	} else {
		var request = new XMLHttpRequest();
		request.open("get", "user.do?method=updatePayPassword&uZhifumima=" + psw);
		request.send(null);
		request.onreadystatechange = function() {
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					alert("设置成功");
					window.location.href = "adm_userinfo_security.jsp";
				} else {
					alert("设置失败");
				}
			}
		}
	}
}

function resetPayPsw() {
	var psw = document.getElementById("paypsw").value;
	if (psw.length < 6) {
		alert("密码长度不够哦：）");
	} else {
		var request = new XMLHttpRequest();
		request.open("get", "user.do?method=updatePayPassword&uZhifumima=" + psw);
		request.send(null);
		request.onreadystatechange = function() {
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					alert("修改成功");
					window.location.href = "adm_userinfo_security.jsp";
				} else {
					alert("修改失败");
				}
			}
		}
	}
}

function verifyPayPsw() {
	var request = new XMLHttpRequest();
	request.open("get", "yanzheng.do?method=verifyPayPassword&uZhifumima=" + document.getElementById("verify_paypsw").value);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.status == 200 && request.readyState == 4) {
			var result = request.responseText;
			if (result == "true") {
				alert("验证成功");
				document.getElementById("div_updatePayPsw").style.display = "block";
				document.getElementById("div_verifyPayPsw").style.display = "none";
			} else {
				alert("验证失败");
			}
		}
	}
}
function verifyUserPsw() {
	var request = new XMLHttpRequest();
	request.open("get", "yanzheng.do?method=verifyUserPassword&password=" + document.getElementById("userpsw").value);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.status == 200 && request.readyState == 4) {
			var result = request.responseText;
			if (result == "true") {
				alert("验证成功");
				document.getElementById("div_updatePayPsw").style.display = "block";
				document.getElementById("div_verifyUserPsw").style.display = "none";
			} else {
				alert("验证失败");
			}
		}
	}
}
function setUserPsw() {
	var newuserpsw1 = document.getElementById("newuserpsw1");
	var newuserpsw2 = document.getElementById("newuserpsw2");
	if (newuserpsw1.value != newuserpsw2.value) {
		alert("请确认两次输入的密码一样哦！");
	} else if (newuserpsw1.value.length > 16 || newuserpsw1.value.length < 6) {
		alert("请输入6-16位密码！");
	} else {
		var request = new XMLHttpRequest();
		request.open("get", "yanzheng.do?method=verifyUserPassword&password=" + document.getElementById("olduserpsw").value);
		request.send(null);
		request.onreadystatechange = function() {
			if (request.status == 200 && request.readyState == 4) {
				var result = request.responseText;
				if (result == "true") {
					var request2 = new XMLHttpRequest();
					request2.open("get", "user.do?method=updateUserPassword&password=" + newuserpsw1.value);
					request2.send(null);
					request2.onreadystatechange = function() {
						if (request2.status == 200 && request2.readyState == 4) {
							var result2 = request2.responseText;
							if (result2 == "true") {
								alert("设置新密码成功");
								window.location.href = "adm_userinfo_security.jsp"
							} else {
								alert("设置新密码失败");
							}
						}
					}
				} else {
					alert("请确认原密码正确！");
				}
			}
		}
	}
}