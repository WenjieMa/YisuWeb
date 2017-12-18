<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.pojo.InfoGoods"%>
<%@page import="com.pojo.InfoUser"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>易俗</title>
<link rel="shortcut icon" href="pic/wangzhantubiao_jianyi.jpg" />
<link rel="stylesheet" type="text/css" href="css/body.css" />
<link rel="stylesheet" type="text/css" href="css/zhuye.css" />
<link rel="stylesheet" type="text/css" href="css/wordfly.css" />
<script type="text/JavaScript" src="js/time.js"></script>
<script type="text/JavaScript" src="js/business.js"></script>
<script type="text/JavaScript" src="js/zhuye.js"></script>


</head>
<body><jsp:include page="adm_headfoot_header.jsp"></jsp:include>
	<div id="all">
		<div class="morning">Morning:) Dear ${userinfo.unicheng }</div>
		<div class="morning">上午好哇:) Dear ${userinfo.unicheng }</div>
		<div class="morning">午安哦 Dear ${userinfo.unicheng }</div>
		<div class="morning">下午好哦，坐下来休息一下吧:) Dear ${userinfo.unicheng }</div>
		<div class="morning">出去看看美丽的晚霞吧 Dear ${userinfo.unicheng }</div>
		<div class="morning">晚上好哇 Dear ${userinfo.unicheng }</div>
		<div class="morning">Wish you a good night.Dear
			${userinfo.unicheng }</div>
		<div class="morning">这么晚了还没休息吗，是正在努力地打代码还是有心事呢？</div>
		<div class="morning">生日快乐！亲爱的 ${userinfo.unicheng }</div>
		<div id="Biggest">

			<div id="shouye_zhongbu">
				<div id="huanyin">
						<img src="pic/search.jpg" id="sousuotu"></img> <input type="text"
							placeholder="喜欢收藏画？试试搜索'梵高'。" class="sousuo" name="gName"
							id="sousuoneirong" maxlength="20" /> <a
							href="javascript:searchAllGoodsByName()"><div id="sousuo_anniu"></div>
						</a>
					<section class="col-1-1">
					<div class="playground grid">
						<div class="col-1-1 viewport">
							<div class="tlt" style="font-size: 50px;">
								<ul class="texts">
									<li>Find what you love :)</li>
									<li>Value whom you are fond of:)</li>
									<li>Treasure what you own :)</li>
								</ul>
							</div>
						</div>
						<style>
.zhuye_zuoce_mulu_li {
	height: 30px;
	margin-left: -20px;
}
</style>
						<div
							style="	width: 220px;float:left;text-align: left;margin-top: 60px;background-color:white;">
							<ul id="zhuye_zuoce_mulu_ul">
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(0)"><span class="mulu">家用电器</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(1)"><span class="mulu">手机</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(2)"><span class="mulu">电脑</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(3)"><span class="mulu">家居</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(4)"><span class="mulu">男装</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(5)"><span class="mulu">美妆个护</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(6)"><span class="mulu">鞋靴</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(7)"><span class="mulu">运动</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(8)"><span class="mulu">汽车</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(9)"><span class="mulu">母婴</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(10)"><span class="mulu">食品</span></a></li>
								<li class="zhuye_zuoce_mulu_li"><a href="#"
									onclick="javascript:searchAllGoodsByName_FromMenu(11)"><span class="mulu">图书</span></a></li>
							</ul>
						</div>
						<div
							style="position:absolute; width: 220px;height:400px; float:left;text-align: left;margin-left:1424px;  margin-top: 60px;background-color:white;">
							<c:if test="${userinfo==null}" var="t">
								<a href="javascript:logout()">点我登录哦</a>
							</c:if>
							<c:if test="${not t}">欢迎您：）<br>
								<a href="javascript:enterSetting(1)"><img
									src="${pageContext.request.contextPath }/pic/headpic/${userinfo.utouxiang}"
									id="zhuye_touxiang" />${userinfo.unicheng} </a>
							</c:if>
						</div>
						<div class="col-1-1 controls"
							style="display:none;position: absolute;">
							<form class="grid grid-pad"></form>
						</div>
					</div>
					</section>
				</div>
				<div class="carousel content-main">
					<ul class="list">
						<c:forEach items="${goodslist_sj_from_big_pic}" var="cl_big">
							<li><a
								href="goods.do?method=searchSingleGoods&gId=${cl_big.gid}">
									<img
									src="${pageContext.request.contextPath }/pic/goods/${cl_big.gbigPic}"
									class="img_gundongxuanchuan" />
							</a></li>
						</c:forEach>
					</ul>
				</div>
				<ul class="shouye_biao">
					<a href="javascript:searchAllGoodsByType(0)"><li class="zoukai"
						onmouseover="yishang(0)" onmouseout="zoukai(0)" name="dalei">
							穿</li> </a>
					<a href="javascript:searchAllGoodsByType(1)"><li class="zoukai"
						onmouseover="yishang(1)" onmouseout="zoukai(1)" name="dalei">
							吃</li> </a>
					<a href="javascript:searchAllGoodsByType(2)"><li class="zoukai"
						onmouseover="yishang(2)" onmouseout="zoukai(2)" name="dalei">
							玩</li> </a>
					<a href="javascript:searchAllGoodsByType(3)"><li class="zoukai"
						onmouseover="yishang(3)" onmouseout="zoukai(3)" name="dalei">
							物</li> </a>
			</div>
			<div id="xuanxiang0" class="shouye_biao_xuanxiang"
				onmouseover="yishang(0)" onmouseout="zoukai(0)">
				<ul class="shouye_biao_xiala_ul">
					<a href="javascript:searchAllGoodsByExcistType(0)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/shoes/shoes_01.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">鞋</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(1)"><li
						class="shouye_biao_xiala_li"><img src="pic/goods/cloth.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">衣服</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(2)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/bags/lv_handbags_02.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">包</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(3)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/hat/Hat-straw-derby.png"
							class="shouye_biao_xiala_li_img"></img> </img> <span
							class="shouye_biao_xiala_li_word">帽子</span></li> </a>
				</ul>
			</div>
			<div id="xuanxiang1" class="shouye_biao_xuanxiang"
				onmouseover="yishang(1)" onmouseout="zoukai(1)">
				<ul class="shouye_biao_xiala_ul">
					<a href="javascript:searchAllGoodsByExcistType(4)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/cocacola/coca_icon_02.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">饮料</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(5)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/food/steak.png" class="shouye_biao_xiala_li_img"></img>
							<span class="shouye_biao_xiala_li_word">熟食</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(6)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/food/pork-chop.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">快餐</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(7)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/smoke/smoke-10.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">烟</span></li> </a>
				</ul>
			</div>
			<div id="xuanxiang2" class="shouye_biao_xuanxiang"
				onmouseover="yishang(2)" onmouseout="zoukai(2)">
				<ul class="shouye_biao_xiala_ul">
					<a href="javascript:searchAllGoodsByExcistType(8)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/game/betman.png" class="shouye_biao_xiala_li_img"></img>
							<span class="shouye_biao_xiala_li_word">游戏</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(9)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/uDrivers/datatraveler-2.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">数码</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(10)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/macComputer/W_MAC-03.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">电脑</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(11)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/macComputer/W_MAC-05.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">手机</span></li> </a>
				</ul>
			</div>
			<div id="xuanxiang3" class="shouye_biao_xuanxiang"
				onmouseover="yishang(3)" onmouseout="zoukai(3)">
				<ul class="shouye_biao_xiala_ul">
					<a href="javascript:searchAllGoodsByExcistType(12)""><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/plants/Wunderland-02.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">植物</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(13)""><li
						class="shouye_biao_xiala_li"><img
							src="pic/png/Pet/chameleon_mb5ucom.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">宠物</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(14)"><li
						class="shouye_biao_xiala_li"><img
							src="pic/goods/creatures/Charles-II.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">画</span></li> </a>
					<a href="javascript:searchAllGoodsByExcistType(15)""><li
						class="shouye_biao_xiala_li"><img
							src="pic/png/wooden/itunes-10-wooden.png"
							class="shouye_biao_xiala_li_img"></img> <span
							class="shouye_biao_xiala_li_word">音乐</span></li> </a>
				</ul>
			</div>
		</div>

		<div id="shouye_xiabu">
			<span id="xiabuspan"> <span id="shouye_xiabu_cainixihuan_text">猜你喜欢:</span>
				<a style="font-size: 25px;" href="javascript:replaceRandomGoods()">换一批</a>


				<div class="shouye_xiabu_goods_div" style="position: absolute;">
					<c:forEach items="${goodslist_sj}" var="cl" varStatus="seq">
						<c:set var="panduan" value="${seq.count%3}"></c:set>
						<c:if test="${panduan==1}">
							<div class="wrapper">
						</c:if>
						<div class="box">
							<a href="goods.do?method=searchSingleGoods&gId=${cl.gid}">
								<div class="product">
									<span class="mingzi">${cl.gname}</span> <img
										src="${pageContext.request.contextPath }/pic/goods/${cl.gpic}"
										120
									class="goods_single" /> <span
										class="description">${cl.gjianjie}<br>
									</span>
								</div>
							</a>
						</div>
						<span class="price">${cl.gprice}</span>
						<c:if test="${panduan==0}">
				</div> </c:if> </c:forEach>
		</div>



		<div class="shouye_xiabu_goods_div"
			style="position: absolute;display: none;">
			<c:forEach items="${goodslist_sj2}" var="cl" varStatus="seq">
				<c:set var="panduan" value="${seq.count%3}"></c:set>
				<c:if test="${panduan==1}">
					<div class="wrapper">
				</c:if>
				<div class="box">
					<a href="goods.do?method=showsinglegoods&gId=${cl.gid}">
						<div class="product">
							<span class="mingzi">${cl.gname}</span> <img
								src="${pageContext.request.contextPath }/pic/goods/${cl.gpic}"
								120
									class="goods_single" /> <span class="description">${cl.gjianjie}<br>
							</span>
						</div>
					</a>
				</div>
				<span class="price">${cl.gprice}</span>
				<c:if test="${panduan==0}">
		</div>
		</c:if>
		</c:forEach>
	</div>




	<div class="shouye_xiabu_goods_div"
		style="display: none;position: absolute;">
		<c:forEach items="${goodslist_sj3}" var="cl" varStatus="seq">
			<c:set var="panduan" value="${seq.count%3}"></c:set>
			<c:if test="${panduan==1}">
				<div class="wrapper">
			</c:if>
			<div class="box">
				<a href="goods.do?method=showsinglegoods&gId=${cl.gid}">
					<div class="product">
						<span class="mingzi">${cl.gname}</span> <img
							src="${pageContext.request.contextPath }/pic/goods/${cl.gpic}"
							120
									class="goods_single" /> <span class="description">${cl.gjianjie}<br>
						</span>
					</div>
				</a>
			</div>
			<span class="price">${cl.gprice}</span>
			<c:if test="${panduan==0}">
	</div>
	</c:if>
	</c:forEach>
	</div>
	</div>
	</span>
	<script>
		function replaceRandomGoods() {
			var divs = document.querySelectorAll(".shouye_xiabu_goods_div");
			if (cainixihuan >= 3) {
				cainixihuan = 0;
			}
			if (cainixihuan % 3 == 0) {
				divs[0].style.display = "none";
				divs[1].style.display = "block";
				divs[2].style.display = "none";
				cainixihuan = cainixihuan * 1 + 1;
			} else if (cainixihuan % 3 == 1) {
				divs[0].style.display = "none";
				divs[1].style.display = "none";
				divs[2].style.display = "block";
				cainixihuan = cainixihuan * 1 + 1;
			} else if (cainixihuan % 3 == 2) {
				divs[0].style.display = "block";
				divs[1].style.display = "none";
				divs[2].style.display = "none";
				cainixihuan = cainixihuan * 1 + 1;
			}
		}
	</script>
	</div>
</body>
<%@include file="rocket.html"%>
<%@include file="adm_headfoot_footer.html"%>
</html>
