package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AddressCityDAO;
import com.dao.AddressDistrictDAO;
import com.dao.AddressProvinceDAO;
import com.dao.HqlDAO;
import com.pojo.AddressCity;
import com.pojo.AddressDistrict;
import com.pojo.AddressProvince;
import com.pojo.InfoGoods;
@Service
public class ProvinceService {
	@Autowired
	private HqlDAO hqlDAO;
	@Autowired
	private AddressCityDAO cityDAO;
	@Autowired
	private AddressDistrictDAO districtDAO;
	@Autowired
	private AddressProvinceDAO provinceDAO;
	
	public List<AddressProvince> searchAllProvince(){
		return provinceDAO.findAll();
	}
	public AddressProvince searchSingleProvinceByproId(int proId){
		return provinceDAO.findById(proId);
	}
	public List<AddressCity> searchAllCity(){
		return cityDAO.findAll();
	}
	public List<AddressDistrict> searchAllDistrict(){
		return districtDAO.findAll();
	}
	public List<AddressCity> searchAllCityByproId(int proId){
		String sql="from AddressCity a where a.addressProvince.proId=?";
		List<AddressCity> strings=hqlDAO.findByHql(sql,proId);
		if(strings.size()==0){
			return null;
		}
		return strings;
	}
	
	public List<AddressDistrict> searchAllDistrictBycid(int cid){
		String sql="from AddressDistrict d where d.addressCity.cid=?";
		List<AddressDistrict> strings=hqlDAO.findByHql(sql,cid);
		if(strings.size()==0){
			return null;
		}
		return strings;
	}
	public AddressCity searchSingleCityBycid(int cid) {
		return cityDAO.findById(cid);
	}
}
