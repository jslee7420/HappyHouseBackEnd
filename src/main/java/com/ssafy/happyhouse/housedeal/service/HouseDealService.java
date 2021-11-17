package com.ssafy.happyhouse.housedeal.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.housedeal.model.dto.HouseDeal;
import com.ssafy.happyhouse.housedeal.model.dto.HouseInfo;

public interface HouseDealService {
	List<HouseInfo> findAptInDong(String dong) throws Exception;
	List<HouseDeal> findDealsByAptCode(int aptCode) throws Exception;
}
