package com.ssafy.happyhouse.dealTrend.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DealTrend {
	
	private String district;
	private QuarterlyDealVolume quarterlyDealVolume;
	private QuarterlyAveragePricePerPyeong quarterlyAveragePricePerPyeong;
	
}
