package com.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.AddressProvinceDAO;
import com.pojo.AddressCity;
import com.pojo.AddressDistrict;
import com.pojo.AddressProvince;
import com.service.ProvinceService;
@Controller
@RequestMapping("pro.do")
public class ProvinceAction extends HttpServlet {
	@Autowired
	private ProvinceService provinceService;
	@RequestMapping(params="method=searchSingleCity")
	private void doSearchSingleCity(HttpServletRequest request,
			HttpServletResponse response) {
		int cId = Integer.parseInt(request.getParameter("cId"));
		List<AddressDistrict> districtInfos = provinceService
				.searchAllDistrictBycid(cId);
		try {
			if (districtInfos != null) {
				StringBuffer str = new StringBuffer("[");
				if (districtInfos.size() == 0) {
					response.getWriter().print("[]");
					return;
				}
				for (AddressDistrict info : districtInfos) {
					str.append("{'disId':").append(info.getDisId())
							.append(",'disName':'").append(info.getDisName())
							.append("'},");
				} // [{'empid':1,'empname':'张三'},{'empid':2 , 'empname':'李四'}]
				str.replace(str.length() - 1, str.length(), "]");
				response.getWriter().print(str.toString());

			} else {
				System.out.println("查找城市出错");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@RequestMapping(params="method=searchSingleProvince")
	private void doSearchSingleProvince(HttpServletRequest request,
			HttpServletResponse response) {
		int proId = Integer.parseInt(request.getParameter("proId"));
		List<AddressCity> cityInfos = provinceService.searchAllCityByproId(proId);
		try {
			if (cityInfos != null) {
				StringBuffer str = new StringBuffer("[");
				for (AddressCity info : cityInfos) {
					str.append("{'cId':").append(info.getCid())
							.append(",'cName':'").append(info.getCname())
							.append("'},");
				}
				str.replace(str.length() - 1, str.length(), "]");
				response.getWriter().print(str);
			} else {
				response.getWriter().print("[]");
				System.out.println("查找省份出错");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@RequestMapping(params="method=searchAllDistrict")
	private void doSearchAllDistrict(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	@RequestMapping(params="method=searchAllCity")
	private void doSearchAllCity(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}
	@RequestMapping(params="method=searchAllProvince")
	private void doSearchAllProvince(HttpServletRequest request,
			HttpServletResponse response) {
		List<AddressProvince> provinceInfos = provinceService.searchAllProvince();
		List<AddressCity> cityInfos = provinceService
				.searchAllCityByproId(provinceInfos.get(0).getProId());
		List<AddressDistrict> districtInfos = provinceService
				.searchAllDistrictBycid(cityInfos.get(0).getCid());
		/*
		 * for (AddressProvince provinceInfo : provinceInfos) {
		 * System.out.println(provinceInfo.getProName()); } for (AddressCity
		 * cityInfo : cityInfos) { System.out.println(cityInfo.getcName()); }
		 * for (AddressDistrict districtInfo : districtInfos) {
		 * System.out.println(districtInfo.getDisName()); }
		 */
		try {
			if (districtInfos != null) {
				request.getSession().setAttribute("provinceInfos",
						provinceInfos);
				request.getSession().setAttribute("cityInfos", cityInfos);
				request.getSession().setAttribute("districtInfos",
						districtInfos);
				response.getWriter().print("true");
			} else {
				response.getWriter().print("false");
				System.out.println("查找出错");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
