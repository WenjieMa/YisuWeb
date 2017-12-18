package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.InfoDepDAO;
import com.pojo.InfoDep;
@Service
public class DepService {
	@Autowired
	private InfoDepDAO depDAO;

	public List<InfoDep> findAll() {
		return depDAO.findAll();
	}

}
