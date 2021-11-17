package com.ssafy.happyhouse.housedeal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.housedeal.model.dto.HouseDeal;
import com.ssafy.happyhouse.housedeal.model.dto.HouseInfo;
import com.ssafy.happyhouse.housedeal.model.mapper.HouseDealMapper;

@Service
public class HouseDealServiceImpl implements HouseDealService {
	
	private HouseDealMapper houseDealMapper;
	
	@Autowired
	public void setHouseDealMapper(HouseDealMapper houseDealMapper) {
		this.houseDealMapper = houseDealMapper;
	}

	@Override
	public List<HouseInfo> findAptInDong(String dong) throws Exception {
		return houseDealMapper.selectAptInDong(dong);
	}

	@Override
	public List<HouseDeal> findDealsByAptCode(int aptCode) throws Exception {
		return houseDealMapper.selectDealsByAptCode(aptCode);
	}

}
