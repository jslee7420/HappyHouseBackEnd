package com.ssafy.happyhouse.housedeal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.housedeal.model.dto.HouseDeal;
import com.ssafy.happyhouse.housedeal.model.dto.HouseInfo;
import com.ssafy.happyhouse.housedeal.service.HouseDealService;

@CrossOrigin("*")
@RestController
@RequestMapping("/housedeal")
public class HouseDealController {
	
	private HouseDealService houseDealService;
	public static final Logger logger = LoggerFactory.getLogger(HouseDealController.class);
	
	
	@Autowired
	public void setHouseDealService(HouseDealService houseDealService) {
		this.houseDealService = houseDealService;
	}

	// 아파트 매매 상세 페이지로 이동(레거시 코드)
//	private Object searchDealInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String dong = request.getParameter("dong");
//		request.setAttribute("dong", dong);
//		HttpSession session = request.getSession();
//		session.setAttribute("dong", dong);
//		return new PageInfo("/portfolio_details.jsp", false);
//	}
	
	@GetMapping("/apts/dongs/{dong}")
	public ResponseEntity<List<HouseInfo>> apt(@PathVariable String dong, @RequestParam(value="buildYear", defaultValue="0") int buildYear) throws Exception{
		HouseInfo houseInfo = new HouseInfo();
		houseInfo.setDongCode(dong);
		houseInfo.setBuildYear(buildYear);
		if(houseDealService.findAptInDong(houseInfo).size()==0) {
			return ResponseEntity.notFound().build();
		}
		
		System.out.println(houseDealService.findAptInDong(houseInfo).get(0).getPricePerPyeong());
		
		return new ResponseEntity<List<HouseInfo>>(houseDealService.findAptInDong(houseInfo), HttpStatus.OK);
	}
	
	@GetMapping("/apts/{aptCode}")
	public ResponseEntity<List<HouseDeal>> deals(@PathVariable String aptCode) throws Exception{
		if(houseDealService.findDealsByAptCode(Integer.parseInt(aptCode)).size()==0) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<HouseDeal>>(houseDealService.findDealsByAptCode(Integer.parseInt(aptCode)), HttpStatus.OK);
	}
	
	@GetMapping("users/{userId}/apts")
	public ResponseEntity<List<HouseInfo>> aptByBookmark(@PathVariable String userId) throws Exception{
		return new ResponseEntity<List<HouseInfo>>(houseDealService.findAptByBookmark(userId), HttpStatus.OK);
	}
}
