package com.ssafy.happyhouse.dealTrend.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dealTrend.model.dto.DealTrend;

@Mapper
public interface DealTrendMapper {
	
	List<DealTrend> selectDealTrendList();
	
}
