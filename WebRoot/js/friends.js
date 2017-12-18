function checkEnter(e) {
	var theEvent = window.event || e;
	var chatcode = theEvent.keyCode || theEvent.charCode;
	if (chatcode == 13) {
		theEvent.returnValue = false;
	}
}
function nowHideObj(obj) {
	obj.style.display = "none";
}
function nowShowObj(obj) {
	obj.style.display = "block";
}
function showHide(obj) {
	if (isHide(obj) == true) {
		obj.style.display = "block";
	}
}
function myEncodeURI(str){
	return encodeURI(encodeURI(str));
}
function closeSearchFriendsList() {
	var obj=document.getElementById("searchfriendslist");
	obj.innerHTML="";
	nowHideObj(obj);
}
function closeSearchAcceptanceList() {
	var obj=document.getElementById("searchacceptancelist");
	obj.innerHTML="";
	nowHideObj(obj);
}
function searchFriendsByUsername() {
	var searchfriendslist = document.getElementById("searchfriendslist");
	var text = document.getElementById("friendusername").value;
	if (text.length == 0) {
		alert("请输入内容再查找哦");
	} else {
		var json;
		showHide(searchfriendslist);
		var request = new XMLHttpRequest();
		request.open("post", "re.do?method=searchFriendsByUsername&username="
				+ myEncodeURI(text));
		request.send(null);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var result = request.responseText;
				if (result == "false") {
					alert("没有找到用户:(");
				} else {
					alert("找到了");
					json = eval(result);
					var str = "<table border='1px solid gray'><tr><input type='button' value='X' onclick='closeSearchFriendsList()' style='float: right;'/></tr>";
					for (var i = 0; i < json.length; i++) {
						str += "<tr><td id='"
								+ json[i].friId
								+ "'>用户名:"
								+ json[i].friName
								+ "</td><br><td><img class='headpic_td' src='"
								+ json[i].friPicPath
								+ "'></td><br><td>昵称:"
								+ decodeURI(json[i].friuNicheng)
								+ "</td><br><td><input type='button' onclick='sendAcceptance("
								+ json[i].friId
								+ ")' value='发送好友请求'></td><br></tr>";
					}
					str += "</table>"
					searchfriendslist.innerHTML = str;
				}
			}
		}
	}
}
function searchFriendsByuNicheng() {
	var searchfriendslist = document.getElementById("searchfriendslist");
	var text = document.getElementById("frienduNicheng").value;
	if (text.length == 0) {
		alert("请输入内容再查找哦");
	} else {
		var json;
		showHide(searchfriendslist);
		var request = new XMLHttpRequest();
		request.open("post",
				"re.do?method=searchFriendsByuNicheng&friuNicheng=" + myEncodeURI(text));
		request.send(null);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var result = request.responseText;
				if (result == "false") {
					alert("没有找到用户:(");
				} else {
					json = eval(result);
					var str = "<table border='1px solid gray'><tr><input type='button' value='X' onclick='closeSearchFriendsList()' style='float: right;'/></tr>";
					for (var i = 0; i < json.length; i++) {
						str += "<tr><td id='"
								+ json[i].friId
								+ "'>用户名:"
								+ json[i].friName
								+ "</td><br><td><img class='headpic_td' src='"
								+ json[i].friPicPath
								+ "'></td><br><td>昵称:"
								+ decodeURI(json[i].friuNicheng)
								+ "</td><br><td><input type='button' onclick='sendAcceptance("
								+ json[i].friId
								+ ")' value='发送好友请求'></td><br></tr>";
					}
					str += "</table>"
					searchfriendslist.innerHTML = str;
				}
			}
		}
	}
}
function sendAcceptance(friId) {
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=addInsertAcceptance&acGetuId=" + friId);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "true") {
				alert("发送好友请求成功！");
			} else {
				alert("发送好友请求失败！");
			}
		}
	}
}

function updateAcceptAcceptance(acId, friId) {
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=updateAcceptAcceptance&acId=" + acId
			+ "&friId=" + friId);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "true") {
				alert("接受好友请求成功！请刷新好友列表：）");
			} else {
				alert("接受好友请求失败！");
			}
		}
	}
	refreshFriendsList();
}

function updateRefuseAcceptance(acId) {
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=updateRefuseAcceptance&acId=" + acId);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "true") {
				alert("拒绝好友请求成功！");
			} else {
				alert("拒绝好友请求失败！");
			}
		}
	}
}

function searchAcceptedAcceptance() {
	var searchacceptancelist = document.getElementById("searchacceptancelist");
	var json;
	showHide(searchacceptancelist);
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=searchAcceptedAcceptance");
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "false") {
				alert("没有找到消息:(");
			} else {
				json = eval(result);
				var str = "<table border='1px solid gray'><tr><input type='button' value='X' onclick='closeSearchAcceptanceList()' style='float: right;'/></tr>";
				for (var i = 0; i < json.length; i++) {
					str += "<tr><td id='" + json[i].friId + "'>用户名:"
							+ json[i].friName
							+ "</td><br><td><img class='headpic_td' src='"
							+ json[i].friPicPath + "'></td><br><td>昵称:"
							+ decodeURI(json[i].friuNicheng)
							+ "</td><td>已接受请求</td><br></tr>";
				}
				str += "</table>"
				searchacceptancelist.innerHTML = str;
			}
		}
	}
}

function searchRefusedAcceptance() {
	var searchacceptancelist = document.getElementById("searchacceptancelist");
	var json;
	showHide(searchacceptancelist);
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=searchRefusedAcceptance");
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "false") {
				alert("没有找到消息:(");
			} else {
				json = eval(result);
				var str = "<table border='1px solid gray'><tr><input type='button' value='X' onclick='closeSearchAcceptanceList()' style='float: right;'/></tr>";
				for (var i = 0; i < json.length; i++) {
					str += "<tr><td id='" + json[i].friId + "'>用户名:"
							+ json[i].friName
							+ "</td><br><td><img class='headpic_td' src='"
							+ json[i].friPicPath + "'></td><br><td>昵称:"
							+ decodeURI(json[i].friuNicheng)
							+ "</td><td>已拒绝请求</td><br></tr>";
				}
				str += "</table>";
				searchacceptancelist.innerHTML = str;
			}
		}
	}
}

function searchUnreadAcceptance() {
	var searchacceptancelist = document.getElementById("searchacceptancelist");
	var json;
	showHide(searchacceptancelist);
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=searchUnreadAcceptance");
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			if (result == "false") {
				alert("没有找到消息:(");
			} else {
				json = eval(result);
				var str = "<table border='1px solid gray'><tr><input type='button' value='X' onclick='closeSearchFriendsList()' style='float: right;'/></tr>";
				for (var i = 0; i < json.length; i++) {
					str += "<tr><td id='"
							+ json[i].friId
							+ "'>用户名:"
							+ json[i].friName
							+ "</td><br><td><img class='headpic_td' src='"
							+ json[i].friPicPath
							+ "'></td><br><td>昵称:"
							+ decodeURI(json[i].friuNicheng)
							+ "</td><br><td><input type='button' onclick='updateAcceptAcceptance("
							+ json[i].friacId
							+ ","
							+ json[i].friId
							+ ")' value='接受好友请求'></td><td><input type='button' onclick='updateRefuseAcceptance("
							+ json[i].friacId
							+ ")' value='拒绝好友请求'></td><br></tr>";
				}
				str += "</table>"
				searchacceptancelist.innerHTML = str;
			}
		}
	}
}
function refreshFriendsList() {
	var friends = document.getElementById("friends");
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=refreshFriendsList");
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			var json;
			if (result == "false") {
				alert("没有找到用户:(");
			} else {
				json = eval(result);
				var str = "";
				for (var i = 0; i < json.length; i++) {
					str += "<tr><td><a href=\"javascript:startChating('"
							+ json[i].friId + "','" + decodeURI(json[i].friuNicheng)
							+ "')\"><span>" + decodeURI(json[i].friuNicheng)
							+ "</span> <img src='" + json[i].friPicPath
							+ "' class='headpic_td' /></a></td></tr>"
				}
				friends.innerHTML = str;
			}
		}
	}
}

function startChating(a, b) {
	var friId = a;
	var uNicheng = b;
	var obj = document.getElementById("getuNichengSpan");
	obj.innerHTML = "接收方:" + uNicheng;
	var chatingTable = document.getElementById("chatingTable");
	var chatingDiv = document.getElementById("chatingDiv");
	var friends = document.getElementById("friends");
	if (isHide(chatingDiv) == true) {
		nowShowObj(chatingDiv);
	}
	nowHideObj(document.getElementById("friends"));
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=startChating&friId=" + friId);
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			var json;
			if (result == "false") {
				alert("出错啦！打开聊天窗口失败：（");
			} else {
				json = eval(result);
				var str = "";
				for (var i = 0; i < json.length; i++) {
					str += "<tr><td><span>" + json[i].chatTime
							+ "</span></td><td><span>发送人:" + decodeURI(json[i].chatPerson)
							+ "</span></td><td><span> :" + decodeURI(json[i].chatText)
							+ "</span><br></td></tr>";
				}
				chatingTable.innerHTML = str;
			}
		}
	}

	tt = window.setInterval("refreshChating()", 5000);
}
function hideChatingDiv() {
	var obj = document.getElementById("chatingDiv");
	nowHideObj(obj);
	window.clearInterval(tt);
	document.getElementById("chatingTable").innerHTML = "";
	document.getElementById("getuNichengSpan").innerHTML = "";
	var friends = document.getElementById("friends");
	nowShowObj(friends);
}
function addSendChating() {
	var text = document.getElementById("chatingInput").value;
	if (text.length > 140) {
		alert("输入的内容请限制在140个字以内哦：）");
	} else if (text.length == 0) {
		alert("不能发送空内容哦");
	} else {
		var request = new XMLHttpRequest();
		request.open("get", "re.do?method=addSendChating&text="
				+ encodeURI(encodeURI(text)));
		request.send("null");
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var result = request.responseText;
				var json;
				if (result == "false") {
					alert("发送失败");
				} else {
					json = eval(result);
					var str = chatingTable.innerHTML;
					for (var i = 0; i < json.length; i++) {
						str = str + "<tr><td><span>" + json[i].chatTime
								+ "</span></td><td><span>发送人:"
								+ decodeURI(json[i].chatPerson)
								+ "</span></td><td><span> :" + decodeURI(json[i].chatText)
								+ "</span><br></td></tr>";
					}
					chatingTable.innerHTML = str;
					document.getElementById("chatingInput").value = "";
				}
			}
		}
	}
}

function refreshChating() {
	var chatingTable = document.getElementById("chatingTable");
	var request = new XMLHttpRequest();
	request.open("post", "re.do?method=refreshChating");
	request.send(null);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			var result = request.responseText;
			var json;
			if (result == "false") {
				alert("出错啦！打开聊天窗口失败：（");
			} else {
				json = eval(result);
				var str = "";
				for (var i = 0; i < json.length; i++) {
					str += "<tr><td><span>" + json[i].chatTime
							+ "</span></td><td><span>发送人:" + decodeURI(json[i].chatPerson)
							+ "</span></td><td><span> :" + decodeURI(json[i].chatText)
							+ "</span><br></td></tr>";
				}
				chatingTable.innerHTML = str;
			}
		}
	}
}
