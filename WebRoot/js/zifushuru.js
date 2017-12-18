function shuruyonghu(key_s) {
	var e = key_s || event;
	var temps = e.keyCode || e.charCode;
	if (temps >= 48 && temps <= 57) {
		key_s.returnValue = true;
	} else if (temps >= 65 && temps <= 90) {
		key_s.returnValue = true;
	} else if (temps >= 97 && temps <= 122) {
		key_s.returnValue = true;
	} else if (temps == 95) {
		key_s.returnValue = true;
	} else {
		key_s.returnValue = false;
	}
}
function youxiang(key_s) {
	var e = key_s || event;
	var temps = e.keyCode || e.charCode;
	if (temps >= 48 && temps <= 57) {
		key_s.returnValue = true;
	} else if (temps >= 65 && temps <= 90) {
		key_s.returnValue = true;
	} else if (temps >= 97 && temps <= 122) {
		key_s.returnValue = true;
	} else if (temps == 95 || temps == 46 || temps == 64) {
		key_s.returnValue = true;
	} else {
		key_s.returnValue = false;
	}
}
function shuzi(key_s) {
	var e = key_s || event;
	var temps = e.keyCode || e.charCode;
	if (temps >= 48 && temps <= 57) {
		key_s.returnValue = true;
	} else {
		key_s.returnValue = false;
	}
}

function check(e) {
	var a = e || event;
	var temps = a.keyCode || a.charCode;
	if (a.srcElement.id == 'sjh') {
		if (temps >= 48 && temps <= 57||temps==37||temps==39) {
			a.returnValue = true;
		} else {
			
			var temp = "";
			var str = a.srcElement.value;
			for ( var i = 0; i < str.length; i++) {
				if (str.charCodeAt(i) >= 48 && str.charCodeAt(i) <= 57) {
					temp = temp + str.charAt(i);
				}
			}
			a.srcElement.value = temp;
			a.returnValue = false;
		}

	} else {
		if (temps >= 48 && temps <= 57) {
		} else if (temps >= 65 && temps <= 90) {
		} else if (temps >= 97 && temps <= 122) {
		} else if (temps == 95 || temps == 37 || temps == 39||temps == 46 || temps == 64) {
		} else {
			var temp = "";
			var str = a.srcElement.value;
			for ( var i = 0; i < str.length; i++) {
				if (str.charCodeAt(i) > 0 && str.charCodeAt(i) < 255) {
					temp = temp + str.charAt(i);
				}
			}
			a.srcElement.value = temp;
		}
	}

}

function qiangdu(zhi) {
	var ruo = document.querySelectorAll(".qiangdu");
	if (zhi.length >=6) {
		var numcount = 0;
		var smallcharcount = 0;
		var bigcharcount = 0;
		var specialcount = 0;
		for ( var i = 0; i < zhi.length; i++) {
			var temp = zhi.charAt(i);
			if (temp >= 'a' && temp <= 'z') {
				bigcharcount = 1;
			} else if (temp >= "A" && temp <= "Z") {
				smallcharcount = 1
			} else if (temp >= "0" && temp <= "9") {
				numcount = 1;
			} else {
				specialcount = 1;
			}
		}
		var count = numcount * 1 + smallcharcount * 1 + bigcharcount * 1
				+ specialcount * 1;
		switch (count) {
		case 1:
			ruo[0].style.display = "block";
			ruo[1].style.display = "none";
			ruo[2].style.display = "none";
			break;
		case 2:
			ruo[0].style.display = "none";
			ruo[1].style.display = "block";
			ruo[2].style.display = "none";
			break;
		case 3:
			ruo[0].style.display = "none";
			ruo[1].style.display = "none";
			ruo[2].style.display = "block";
			break;
		case 4:
			ruo[0].style.display = "none";
			ruo[1].style.display = "none";
			ruo[2].style.display = "block";
			break;
		}
	} else {
		ruo[0].style.display = "none";
		ruo[1].style.display = "none";
		ruo[2].style.display = "none";
	}
	
	
}