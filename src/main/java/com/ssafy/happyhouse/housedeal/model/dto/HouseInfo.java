package com.ssafy.happyhouse.housedeal.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class HouseInfo {
	private String aptCode;
	private String aptName;
	private String dongCode;
	private String dongName;
	private String sidoName;
	private String gugunName;
	private int buildYear;
	private String jibun;
	private String lat;
	private String lng;
	private String img;
	private String recentPrice;
	private int pricePerPyeong; 
	
}