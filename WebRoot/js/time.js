window.onload=function(){
	var arr = [ 'images/0.png', 'images/1.png', 'images/2.png', 'images/3.png',
	    		'images/4.png', 'images/5.png', 'images/6.png', 'images/7.png',
	    		'images/8.png', 'images/9.png', 'images/mao.png', ]
	    var panel = document.getElementById("panel");
	    var aLi = panel.getElementsByTagName("li");
	    var nTime = null;
	    var str = null;
	    var nstr;
	    for (var i = 0; i < aLi.length; i++) {
	    	aLi[i].style.left = 12 * i + 'px';
	    }
	    function showTime1() {
	    	var iNow = new Date();
	    	var nHours = iNow.getHours();
	    	var nMinutes = iNow.getMinutes();
	    	var nSecondes = iNow.getSeconds();
	    	str = toTwo(nHours) + ':' + toTwo(nMinutes) + ':' + toTwo(nSecondes);
	    }
	    function showTime2() {
	    	var iNow = new Date();
	    	nTime = iNow.getTime() + 1000;
	    	iNew = new Date(nTime);
	    	var tHours = iNew.getHours();
	    	var tMinutes = iNew.getMinutes();
	    	var tSecondes = iNew.getSeconds();
	    	nstr = toTwo(tHours) + ':' + toTwo(tMinutes) + ':' + toTwo(tSecondes);
	    }
	    showTime1();
	    showTime2();
	    setInterval(function() {
	    	showTime1();
	    	showTime2();
	    	var now = new Date();
	    	var x = document.getElementById("now");
	    	var year = now.getFullYear();
	    	var month = now.getMonth() + 1;
	    	var date = now.getDate();
	    	var day = now.getDay();
	    	switch (day) {
	    	case 1:
	    		day = '一';
	    		break;
	    	case 2:
	    		day = '二';
	    		break;
	    	case 3:
	    		day = '三';
	    		break;
	    	case 4:
	    		day = '四';
	    		break;
	    	case 5:
	    		day = '五';
	    		break;
	    	case 6:
	    		day = '六';
	    		break;
	    	case 0:
	    		day = '日';
	    		break;
	    	}
	    	var shijian = year + "年" + month + "月" + date + "日" + "&nbsp" + "星期" + day;
	    	x.innerHTML = shijian;
	    }, 1000);
	    function initial(aLi) {
	    	for (var i = 0; i < aLi.length; i++) {
	    		if (i != 2 && i != 5) {
	    			aLi[i].getElementsByTagName("img")[0].src = arr[str.charAt(i)];
	    			aLi[i].getElementsByTagName("img")[1].src = arr[nstr.charAt(i)];
	    		} else {
	    			aLi[i].getElementsByTagName("img")[0].src = arr[10];
	    		}
	    	}
	    }
	    initial(aLi);
	    timeRoll(aLi, 0);
	    timeRoll(aLi, 1);
	    timeRoll(aLi, 3);
	    timeRoll(aLi, 4);
	    timeRoll(aLi, 6);
	    timeRoll(aLi, 7);
	    function timeRoll(obj, i) {
	    	setInterval(function() {
	    		var pNumber = str.charAt(i);
	    		var tNumber = nstr.charAt(i);
	    		var pImg = obj[i].getElementsByTagName("img")[0];
	    		var nImg = obj[i].getElementsByTagName("img")[1];
	    		if (pNumber !== tNumber && parseInt(getStyle(nImg, 'top')) == 21) {
	    			nImg.src = arr[nstr.charAt(i)];
	    			doMove(nImg, 'top', 5, 0, function() {
	    			});
	    			doMove(pImg, 'top', 5, -21, function() {
	    				pImg.style.top = '21px';
	    				pImg.src = arr[str.charAt(i)];
	    			});
	    		} else if (pNumber !== tNumber
	    				&& parseInt(getStyle(pImg, 'top')) == 21) {
	    			pImg.src = arr[nstr.charAt(i)];
	    			doMove(pImg, 'top', 5, 0, function() {
	    			});
	    			doMove(nImg, 'top', 5, -21, function() {
	    				nImg.style.top = '21px';
	    				nImg.src = arr[str.charAt(i)];
	    			});
	    		}
	    	}, 1000)
	    }
	    ;
}


function $(v) {
	if (typeof v === 'function') {
		window.onload = v;
	} else if (typeof v === 'string') {
		return document.getElementById(v);
	} else if (typeof v === 'object') {
		return v;
	}
	}

	function getStyle(obj, attr) {
	return obj.currentStyle ? obj.currentStyle[attr]
			: getComputedStyle(obj)[attr];
	}
	function doMove(obj, attr, dir, target, endFn) {
	dir = parseInt(getStyle(obj, attr)) < target ? dir : -dir;
	clearInterval(obj.timer);
	obj.timer = setInterval(function() {
		var speed = parseInt(getStyle(obj, attr)) + dir;
		if (speed > target && dir > 0 || speed < target && dir < 0) {
			speed = target;// 往前跑
		}
		obj.style[attr] = speed + 'px';
		if (speed == target) {
			clearInterval(obj.timer);
			endFn && endFn();
		}
	}, 30)
	}
	function shake(obj, attr, endFn) {
	if (obj.onOff) {
		return;
	}
	obj.onOff = true;
	clearInterval(obj.shake);
	var pos = parseInt(getStyle(obj, attr));
	var arr = [];
	var num = 0;
	obj.shake = null;
	for (var i = 10; i > 0; i -= 2) {
		arr.push(i, -i);
	}
	arr.push(0);
	obj.shake = setInterval(function() {
		num = num % (arr.length)
		obj.style[attr] = pos + arr[num] + "px";
		num++;
		if (num === arr.length) {
			clearInterval(obj.shake);
			endFn && endFn();
			obj.onOff = false;
		}
	}, 50)
	}
	function opacity(obj, dir, target) {
	// 判断当前的位置是不是大于目标点，小于dir就是正值，大于dir就是负值
	dir = Number(getStyle(obj, 'opacity')) < target ? dir : -dir
	// alert(dir)
	clearInterval(obj.opaTimer);
	obj.opaTimer = setInterval(function() {
		var speed = Number(getStyle(obj, 'opacity')) + dir
		// alert(speed)
		if (speed < target && dir < 0 || speed > target && dir > 0) {
			speed = target;
		}
		obj.style.opacity = speed;
		// alert(speed)
		if (speed === target) {
			clearInterval(obj.opaTimer);
		}
	}, 100);
	}
	function toTwo(n) {
	return n < 10 ? '0' + n : '' + n;
	}