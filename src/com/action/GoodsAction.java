package com.action;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.InfoGoodsDAO;
import com.dao.InfoUserDAO;
import com.pojo.InfoGoods;
import com.pojo.InfoUser;
import com.pojo.OrderBig;
import com.pojo.OrderSmall;
import com.pojo.arranged.GoodsBuyInfo;
import com.pojo.arranged.GoodsShowInfo;
import com.pojo.arranged.OrderInfo_Oders;
import com.service.GoodsService;
import com.service.UserService;
import com.util.MD5Util;

@Controller
@RequestMapping("/goods.do")
public class GoodsAction {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;

	public int createRandomNum(int numb) {
		Random random = new Random();
		numb = random.nextInt(numb);
		return numb;
	}

	@RequestMapping(params = "method=searchRandomGoodsIntoZhuye")
	public void doSearchRandomGoodsIntoZhuye(HttpServletRequest request, HttpServletResponse response) {
		List<InfoGoods> goodslist_sj = new ArrayList<InfoGoods>();
		List<InfoGoods> goodslist_sj_from_big_pic = new ArrayList<InfoGoods>();
		List integers = goodsService.searchRandomGoodsgid();
		int[] array = new int[30];
		int[] array_from_big_pic = new int[5];
		List<InfoGoods> goodslist_sj2 = new ArrayList<InfoGoods>();
		List<InfoGoods> goodslist_sj_from_big_pic2 = new ArrayList<InfoGoods>();
		int[] array2 = new int[30];
		List<InfoGoods> goodslist_sj3 = new ArrayList<InfoGoods>();
		List<InfoGoods> goodslist_sj_from_big_pic3 = new ArrayList<InfoGoods>();
		int[] array3 = new int[30];

		for (int i = 0; i < 30; i++) {
			array[i] = createRandomNum(integers.size());
			for (int j = 0; j < i; j++) {
				if (array[i] == array[j]) {
					array[i] = createRandomNum(integers.size());
				}
			}
			array2[i] = createRandomNum(integers.size());
			for (int j = 0; j < i; j++) {
				if (array2[i] == array2[j]) {
					array2[i] = createRandomNum(integers.size());
				}
			}
			array3[i] = createRandomNum(integers.size());
			for (int j = 0; j < i; j++) {
				if (array3[i] == array3[j]) {
					array3[i] = createRandomNum(integers.size());
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			array_from_big_pic[i] = createRandomNum(integers.size());
			for (int j = 0; j < i; j++) {
				if (array_from_big_pic[i] == array_from_big_pic[j]) {
					array_from_big_pic[i] = createRandomNum(integers.size());
				}
			}
		}
		for (int j = 0; j < 30; j++) {
			InfoGoods info = goodsService.findById(Integer.parseInt(integers.get(array[j]).toString()));
			goodslist_sj.add(info);
			InfoGoods info3 = goodsService.findById(Integer.parseInt(integers.get(array3[j]).toString()));
			goodslist_sj3.add(info3);
			InfoGoods info2 = goodsService.findById(Integer.parseInt(integers.get(array2[j]).toString()));
			goodslist_sj2.add(info2);

		}
		for (int j = 0; j < 5; j++) {
			InfoGoods info = goodsService.findById(Integer.parseInt(integers.get(array_from_big_pic[j]).toString()));
			goodslist_sj_from_big_pic.add(info);
		}
		try {
			if (goodslist_sj != null && goodslist_sj_from_big_pic != null && goodslist_sj2 != null
					&& goodslist_sj_from_big_pic2 != null && goodslist_sj3 != null
					&& goodslist_sj_from_big_pic3 != null) {
				request.getSession().setAttribute("goodslist_sj", goodslist_sj);
				request.getSession().setAttribute("goodslist_sj_from_big_pic", goodslist_sj_from_big_pic);
				request.getSession().setAttribute("goodslist_sj2", goodslist_sj2);
				request.getSession().setAttribute("goodslist_sj3", goodslist_sj3);
				response.getWriter().print("true");
				System.out.println("找到了");
				return;
			} else {
				System.out.println("没找到");
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=searchAllOders")
	private void doSearchAllOders(HttpServletRequest request, HttpServletResponse response) {
		InfoUser userInfo = (InfoUser) request.getSession().getAttribute("userinfo");
		try {
			if (userInfo != null) {
				int uid = userInfo.getUid();
				List<OrderSmall> infoSmalls = goodsService.searchSmallOrdersByuid(uid);
				List<OrderBig> infoBigs = goodsService.searchBigOrdersByuid(uid);
				List<OrderInfo_Oders> zhengli_infos = new ArrayList<OrderInfo_Oders>();
				if (infoSmalls == null || infoBigs == null) {
				} else {

					for (int j = 0; j < infoBigs.size(); j++) {
						OrderInfo_Oders tempList = new OrderInfo_Oders();
						List<OrderSmall> temp_small_infos = new ArrayList<OrderSmall>();
						for (int i = 0; i < infoSmalls.size(); i++) {
							if (infoSmalls.get(i).getOrderBig().getBid() == infoBigs.get(j).getBid()) {
								temp_small_infos.add(infoSmalls.get(i));
							}
						}
						tempList.setList(temp_small_infos);
						tempList.setFukuanjine(infoBigs.get(j).getFukuanjine());
						if (infoBigs.get(j).getBshifoufukuan() == false) {
							tempList.setbShifoufukuan("未付款");
						} else if (infoBigs.get(j).getBshifoufukuan() == true) {
							if (infoBigs.get(j).getBshifoushouhuo() == true) {
								tempList.setbShifoufukuan("交易成功");
							} else if (infoBigs.get(j).getBshifoushouhuo() == false) {
								tempList.setbShifoufukuan("已付款");
							}
						}
						zhengli_infos.add(tempList);
					}
					for (int i = 0; i < zhengli_infos.size(); i++) {
						Boolean tempBoolean = true;
						for (int j = 0; j < zhengli_infos.get(i).getList().size(); j++) {
							if (zhengli_infos.get(i).getList().get(j).getShifoupingjia() == false) {
								tempBoolean = false;
							}
						}
						if (tempBoolean == true) {
							zhengli_infos.get(i).setbShifoupingjia(true);
						} else {
							zhengli_infos.get(i).setbShifoupingjia(false);
						}
					}
				}
				request.getSession().setAttribute("zhengli_infos", zhengli_infos);
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=searchSingleGoods")
	private void doSearchSingleGoods(HttpServletRequest request, HttpServletResponse response) {
		GoodsShowInfo showInfo = new GoodsShowInfo();
		List<OrderSmall> infoSmall_hao = new ArrayList<OrderSmall>();
		List<OrderSmall> infoSmall_zhong = new ArrayList<OrderSmall>();
		List<OrderSmall> infoSmall_cha = new ArrayList<OrderSmall>();
		Double xingji_num = 0.00;
		String xingji = "";
		int hao = 0;
		int zhong = 0;
		int cha = 0;
		int gid = Integer.parseInt(request.getParameter("gId"));
		InfoGoods goodsInfo = goodsService.findById(gid);
		try {
			if (goodsInfo != null) {
				request.getSession().setAttribute("goodsInfo", goodsInfo);
				List<OrderSmall> infoSmall = goodsService.searchSmallOrderBygid(gid);
				if (infoSmall != null) {
					int i = 0;

					for (i = 0; i < infoSmall.size(); i++) {
						xingji_num += Double.parseDouble(infoSmall.get(i).getXingji() + "");
						switch (infoSmall.get(i).getHaozhongcha()) {
						case 1:
							cha++;
							infoSmall_cha.add(infoSmall.get(i));
							break;
						case 2:
							zhong++;
							infoSmall_zhong.add(infoSmall.get(i));
							break;
						case 3:
							hao++;
							infoSmall_hao.add(infoSmall.get(i));
							break;
						}
					}
					xingji_num = Double.parseDouble(xingji_num / infoSmall.size() + "");
					xingji = new DecimalFormat("########.00").format(xingji_num);

				} else {
					xingji = "0.00";
				}
				showInfo.setCha(cha);
				showInfo.setgId(gid);
				showInfo.setHao(hao);
				showInfo.setZhong(zhong);
				showInfo.setXingji(xingji);
				showInfo.setInfoSmall_cha(infoSmall_cha);
				showInfo.setInfoSmall(infoSmall);
				showInfo.setInfoSmall_zhong(infoSmall_zhong);
				showInfo.setInfoSmall_hao(infoSmall_hao);
				request.getSession().setAttribute("showInfo", showInfo);
				request.getRequestDispatcher("adm_goods_singlegoods.jsp").forward(request, response);
			} else {
				response.getWriter().print("<script>alert('商品已下架:(');</script>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=searchAllGoodsByType")
	private void doSearchAllGoodsByType(HttpServletRequest request, HttpServletResponse response) {
		String gType = request.getParameter("gType");
		List<InfoGoods> goodslist = null;
		try {
			goodslist = goodsService.searchInfoGoodsByType(URLDecoder.decode(gType, "utf-8"));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			if (goodslist != null) {
				request.getSession().setAttribute("goodslist", goodslist);
				request.getRequestDispatcher("adm_goods_search.jsp").forward(request, response);

			} else {
				response.getWriter().print("<script>alert('商品没有搜索到呢:(');</script>");

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=searchAllGoodsByName")
	private void doSearchAllGoodsByName(HttpServletRequest request, HttpServletResponse response) {
		String gname = "";
		try {
			gname = URLDecoder.decode(request.getParameter("gName"), "UTF-8");
			System.out.println(gname);
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<InfoGoods> goodslist = goodsService.searchInfoGoodsBygname(gname);
		try {
			request.getSession().setAttribute("goodslist", goodslist);
			response.getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=searchAllCollection")
	private void doSearchAllCollection(HttpServletRequest request, HttpServletResponse response) {
		InfoUser userInfo = (InfoUser) request.getSession().getAttribute("userinfo");
		try {
			if (userInfo != null) {
				int uid = userInfo.getUid();
				List<InfoGoods> shoucanglist = goodsService.searchCollectionInfoGoodsByuid(uid);
				request.getSession().setAttribute("shoucanglist", shoucanglist);

				response.getWriter().print("true");

			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=payFromOder")
	private void doPayFromOder(HttpServletRequest request, HttpServletResponse response) {
		try {
			try {
				int bid = Integer.parseInt(request.getParameter("bid"));
				OrderBig infoBig = goodsService.searchBigOrderBybid(bid);
				List<OrderSmall> infoSmalls = goodsService.searchSmallOrdersBybid(bid);
				request.getSession().setAttribute("infoSmalls", infoSmalls);
				request.getSession().setAttribute("infoBig", infoBig);
			} catch (Exception e) {
				response.getWriter().print("false");
			}
			response.getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=addToShoppingCart")
	private void doAddToShoppingCart(HttpServletRequest request, HttpServletResponse response) {
		int gid = Integer.parseInt(request.getParameter("gId"));
		List<GoodsBuyInfo> goodsBuyInfo_list = (List<GoodsBuyInfo>) request.getSession()
				.getAttribute("goodsBuyInfo_list");
		int shuliang = Integer.parseInt(request.getParameter("shuliang"));
		GoodsBuyInfo goodsBuyInfo = goodsService.verifyStock(gid, shuliang);

		try {
			if (goodsBuyInfo != null) {
				Boolean panduan = false;
				int i = 0;
				if (goodsBuyInfo_list == null) {
					goodsBuyInfo_list = new ArrayList<GoodsBuyInfo>();
				} else {
					while (i < goodsBuyInfo_list.size()) {
						if (gid == goodsBuyInfo_list.get(i).getGid()) {
							panduan = true;
							break;
						}
						i++;
					}

				}
				if (panduan == true) {
					int shuliang_temp = shuliang + goodsBuyInfo_list.get(i).getShuliang();
					goodsBuyInfo_list.get(i).setShuliang(shuliang_temp);
					request.getSession().setAttribute("goodsBuyInfo_list", goodsBuyInfo_list);

					response.getWriter().print("true");

				} else {
					goodsBuyInfo_list.add(goodsBuyInfo);
					request.getSession().setAttribute("gouwuche_shuliang",
							1 + Integer.parseInt(request.getSession().getAttribute("gouwuche_shuliang").toString()));
					request.getSession().setAttribute("goodsBuyInfo_list", goodsBuyInfo_list);

					response.getWriter().print("true+");
				}

			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=addCountFromShoppingCart")
	private void doAddCountFromShoppingCart(HttpServletRequest request, HttpServletResponse response) {
		String caozuo = request.getParameter("caozuo");
		List<GoodsBuyInfo> goodsBuyInfos = (List<GoodsBuyInfo>) request.getSession().getAttribute("goodsBuyInfo_list");
		int gid = Integer.parseInt(request.getParameter("gId"));
		for (int i = 0; i < goodsBuyInfos.size(); i++) {
			if (goodsBuyInfos.get(i).getGid() == gid) {
				if (caozuo.equals("jia")) {
					goodsBuyInfos.get(i).setShuliang(goodsBuyInfos.get(i).getShuliang() + 1);
				} else {
					goodsBuyInfos.get(i).setShuliang(goodsBuyInfos.get(i).getShuliang() - 1);
				}
				request.getSession().setAttribute("goodsBuyInfo_list", goodsBuyInfos);
				try {
					response.getWriter().print("true");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
		}
	}

	@RequestMapping(params = "method=deleteAllGoodsFromShoppingCart")
	private void doDeleteAllGoodsFromShoppingCart(HttpServletRequest request, HttpServletResponse response) {
		List<OrderSmall> goodsBuyInfos = (List<OrderSmall>) request.getSession().getAttribute("goodsBuyInfo_list");
		String gid_string = request.getParameter("gId_string");
		List<Integer> gid_array = new ArrayList<Integer>();
		StringBuffer str = new StringBuffer();
		int i = 0;
		while (i < gid_string.length()) {
			while (gid_string.charAt(i) != ',') {
				str.append(gid_string.charAt(i));
				i++;
			}
			gid_array.add(Integer.parseInt(str.toString()));
			str = new StringBuffer();
			i++;
		}
		int j = 0;
		String gouwuche_shuliang = request.getSession().getAttribute("gouwuche_shuliang").toString();
		while (goodsBuyInfos.size() > goodsBuyInfos.size() - gid_array.size()) {
			if (goodsBuyInfos.get(j).getId().getDid() == gid_array.get(0)) {
				gid_array.remove(0);
				goodsBuyInfos.remove(j);
				gouwuche_shuliang = (Integer.parseInt(gouwuche_shuliang) - 1) + "";
			} else {
				j++;
			}
		}
		request.getSession().setAttribute("gouwuche_shuliang", gouwuche_shuliang);
		request.getSession().setAttribute("goodsBuyInfo_list", goodsBuyInfos);
		try {
			response.getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=addToCollection")
	private void doAddToCollection(HttpServletRequest request, HttpServletResponse response) {
		int gid = Integer.parseInt(request.getParameter("gId"));
		InfoUser userInfo = (InfoUser) request.getSession().getAttribute("userinfo");
		try {
			if (userInfo != null) {
				int uid = userInfo.getUid();
				int n = goodsService.searchCollections(uid, gid);
				if (n == 1) {
					response.getWriter().print("false");
				} else {
					int b = goodsService.addToCollection(uid, gid);
					if (b == 1) {
						response.getWriter().print("true");
					} else {
						response.getWriter().print("false");
					}
				}

			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=deleteSingleGoodsFromShoppingCart")
	private void doDeleteSingleGoodsFromShoppingCart(HttpServletRequest request, HttpServletResponse response) {
		int gid = Integer.parseInt(request.getParameter("gId"));
		List<GoodsBuyInfo> goodsBuyInfos = (List<GoodsBuyInfo>) request.getSession().getAttribute("goodsBuyInfo_list");
		for (int i = 0; i < goodsBuyInfos.size(); i++) {
			if (goodsBuyInfos.get(i).getGid() == gid) {
				goodsBuyInfos.remove(i);
				String gouwuche_shuliang = request.getSession().getAttribute("gouwuche_shuliang").toString();
				gouwuche_shuliang = (Integer.parseInt(gouwuche_shuliang) - 1) + "";
				request.getSession().setAttribute("gouwuche_shuliang", gouwuche_shuliang);
				break;
			}
		}

		request.getSession().setAttribute("goodsBuyInfo_list", goodsBuyInfos);
		try {
			response.getWriter().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=deleteSingleGoodsFromCollection")
	private void doDeleteSingleGoodsFromCollection(HttpServletRequest request, HttpServletResponse response) {
		InfoUser userInfo = (InfoUser) request.getSession().getAttribute("userinfo");
		try {
			if (userInfo != null) {
				int uid = userInfo.getUid();
				int gid = Integer.parseInt(request.getParameter("gId"));
				int n = goodsService.deleteCollection(gid, uid);

				if (n == 1) {
					response.getWriter().print("true");

				} else {
					response.getWriter().print("false");
				}

			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=addSubmitOders")
	private void doAddSubmitOders(HttpServletRequest request, HttpServletResponse response) {
		List<GoodsBuyInfo> goodsBuyInfos = (List<GoodsBuyInfo>) request.getSession().getAttribute("goodsBuyInfo_list");
		InfoUser userInfo = (InfoUser) request.getSession().getAttribute("userinfo");
		int uid = userInfo.getUid();
		String bShouhuodizhi = userInfo.getUchangyongdizhi1();
		String shuliang_string = request.getParameter("shuliang_string");
		String gid_string = request.getParameter("gId_string");
		List<Integer> gid_array = new ArrayList<Integer>();
		List<Integer> shuliang_array = new ArrayList<Integer>();
		String str = "";
		String str2 = "";
		int i = 0;
		while (i < gid_string.length()) {
			while (gid_string.charAt(i) != ',') {
				str += gid_string.charAt(i);
				i++;
			}
			gid_array.add(Integer.parseInt(str));
			str = "";
			i++;
		}
		i = 0;
		while (i < shuliang_string.length()) {
			while (shuliang_string.charAt(i) != ',') {
				str2 += shuliang_string.charAt(i);
				i++;
			}
			shuliang_array.add(Integer.parseInt(str2));
			str2 = "";
			i++;
		}

		int j = 0;
		int bid = goodsService.addCreateBigOrder(uid, bShouhuodizhi, goodsBuyInfos);
		for (int m = 0; m < gid_array.size(); m++) {
			goodsService.addCreateSmallOrder(gid_array.get(m), shuliang_array.get(m), bid, uid);
		}
		try {
			String gouwuche_shuliang = request.getSession().getAttribute("gouwuche_shuliang").toString();
			while (gid_array.size() > 0) {
				if (goodsBuyInfos.get(j).getGid().equals(gid_array.get(0))) {
					gid_array.remove(0);
					goodsBuyInfos.remove(j);
					gouwuche_shuliang = (Integer.parseInt(gouwuche_shuliang) - 1) + "";
				} else {
					j++;
				}
			}
			request.getSession().setAttribute("gouwuche_shuliang", gouwuche_shuliang);
			request.getSession().setAttribute("goodsBuyInfo_list", goodsBuyInfos);

			List<OrderSmall> infoSmalls = goodsService.searchSmallOrdersBybid(bid);
			OrderBig infoBig = goodsService.searchBigOrderBybid(bid);
			request.getSession().setAttribute("infoSmalls", infoSmalls);
			request.getSession().setAttribute("infoBig", infoBig);
			response.getWriter().print("true");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=delCancelOder")
	private void doDelCancelOder(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		int n = goodsService.deleteBigOrder(bid);
		try {
			if (n == 1) {
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=payOder")
	private void doPayOder(HttpServletRequest request, HttpServletResponse response) {
		InfoUser userInfo = (InfoUser) request.getSession().getAttribute("userinfo");
		int uid = userInfo.getUid();
		String uZhifumima = request.getParameter("uZhifumima");
		String verifyuZhifumima = userService.searchPayPassword(uid);
		if (verifyuZhifumima != null) {
			boolean zfmm = userService.verifyPayPassword(MD5Util.getMD5(MD5Util.getMD5(uZhifumima)), uid);
			try {
				if (zfmm == true) {
					int bid = Integer.parseInt(request.getParameter("bid"));
					OrderBig infoBig = goodsService.searchBigOrderBybid(bid);

					if (infoBig != null) {
						boolean b = goodsService.updatePayOrder(uid, Double.parseDouble(infoBig.getFukuanjine()), bid);
						if (b == true) {
							InfoUser userinfo = (InfoUser) request.getSession().getAttribute("userinfo");
							if (userinfo != null) {
								InfoUser userinfo2 = userService.login(userinfo.getUsername(), userinfo.getPassword());
								if (userinfo2 != null) {
									request.getSession().setAttribute("userinfo", userinfo2);
								} else {
									System.out.println("用户2存入失败");
								}
							} else {
								System.out.println("用户检测出错");
							}
							int n = goodsService.updatePayOrderSuccessfully(bid);
							if (n == 1) {
								response.getWriter().print("true");
							} else {
								System.out.println("修改付款状态失败");
								response.getWriter().print("false");
							}
						} else {
							response.getWriter().print("false");
						}

					} else {
						System.out.println("没找到大订单");
						response.getWriter().print("false");
					}

				} else {
					System.out.println("支付密码错误");
					response.getWriter().print("false");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				response.getWriter().print("nopsw");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@RequestMapping(params = "method=getGoods")
	private void doGetGoods(HttpServletRequest request, HttpServletResponse response) {
		int bid = Integer.parseInt(request.getParameter("bid"));
		OrderBig infoBig = goodsService.searchBigOrderBybid(bid);
		List<OrderSmall> infoSmalls = goodsService.searchSmallOrdersBybid(bid);
		try {
			if (infoBig != null) {
				int b = goodsService.updateGetGoods(bid);
				if (b == 1) {
					request.getSession().setAttribute("infoBig", infoBig);
					request.getSession().setAttribute("infoSmalls", infoSmalls);
					response.getWriter().print("true");
				} else {
					response.getWriter().print("false");
				}

			} else {
				System.out.println("没找到大订单");
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(params = "method=commitAllGoods")
	private void doCommitAllGoods(HttpServletRequest request, HttpServletResponse response) {
		int changdu = Integer.parseInt(request.getParameter("changdu"));
		int[] dids = new int[changdu];
		int[] haozhongchas = new int[changdu];
		int[] xingjis = new int[changdu];
		String[] pingjias = new String[changdu];
		int[] n = new int[changdu];
		Boolean panduan = true;
		for (int i = 0; i < changdu; i++) {
			dids[i] = Integer.parseInt(request.getParameter("dId" + i));
			try {
				pingjias[i] = URLDecoder.decode(request.getParameter("pingjia" + i), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			haozhongchas[i] = Integer.parseInt(request.getParameter("haozhongcha" + i));
			xingjis[i] = Integer.parseInt(request.getParameter("xingji" + i));
			n[i] = goodsService.updateCommitSingleGoods(dids[i], haozhongchas[i], xingjis[i], pingjias[i]);
			if (n[i] != 1) {
				panduan = false;
			}
		}
		try {
			if (panduan == true) {
				OrderSmall infoSmall = goodsService.searchSmallOrderBydid(dids[0]);
				if (infoSmall != null) {
					int n1 = goodsService.updateCommitSingleGoodsThenBigOrder(infoSmall.getOrderBig().getBid());
					if (n1 == 1) {
						response.getWriter().print("true");
					} else {
						response.getWriter().print("false");
					}
				} else {
					response.getWriter().print("false");
				}
			} else {
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(params = "method=commitSingleGoods")
	private void doCommitSingleGoods(HttpServletRequest request, HttpServletResponse response) {
		InfoUser userInfo = (InfoUser) request.getSession().getAttribute("userinfo");
		int uid = userInfo.getUid();
		int bid = Integer.parseInt(request.getParameter("bid"));
		OrderBig infoBig = goodsService.searchBigOrderBybid(bid);
		List<OrderSmall> infoSmalls = goodsService.searchSmallOrdersBybid(bid);
		try {
			if (infoBig != null) {
				int b = goodsService.updateGetGoods(bid);
				if (b == 1) {
					request.getSession().setAttribute("infoBig", infoBig);
					request.getSession().setAttribute("infoSmalls", infoSmalls);
					response.getWriter().print("true");
				} else {
					response.getWriter().print("false");
				}

			} else {
				System.out.println("没找到大订单");
				response.getWriter().print("false");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
