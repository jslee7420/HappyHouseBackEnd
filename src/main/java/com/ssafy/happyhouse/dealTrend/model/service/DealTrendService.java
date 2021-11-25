package com.ssafy.happyhouse.dealTrend.model.service;

import java.util.List;

import com.ssafy.happyhouse.dealTrend.model.dto.DealTrend;

public interface DealTrendService {

	List<DealTrend> findDealTrend() throws Exception;
	
}
