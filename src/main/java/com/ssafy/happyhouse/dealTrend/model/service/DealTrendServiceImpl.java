package com.ssafy.happyhouse.dealTrend.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dealTrend.model.dto.DealTrend;
import com.ssafy.happyhouse.dealTrend.model.mapper.DealTrendMapper;

@Service
public class DealTrendServiceImpl implements DealTrendService{
	
	@Autowired
	private DealTrendMapper dealTrendMapper;
	
	@Override
	public List<DealTrend> findDealTrend() throws Exception {
		return dealTrendMapper.selectDealTrendList();
	}

}
