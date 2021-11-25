package com.ssafy.happyhouse.housedeal.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.housedeal.model.dto.HouseDeal;
import com.ssafy.happyhouse.housedeal.model.dto.HouseInfo;

@Mapper
public interface HouseDealMapper {
	
	List<HouseInfo> selectAptInDong(HouseInfo houseInfo);
	List<HouseDeal> selectDealsByAptCode(int aptCode);
	List<HouseInfo> selectAptByBookmark(String userId);
	
}
