package com.ssafy.happyhouse.dealTrend.controller;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.dealTrend.model.service.DealTrendService;
import com.ssafy.happyhouse.user.controller.UserContorller;

@CrossOrigin("*")
@RestController
@RequestMapping("/dealtrend")
public class DealTrendController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserContorller.class);
	
	@Autowired
	private DealTrendService dealTrendService;
	
	@GetMapping()
	public ResponseEntity<Object> dealTrendFind() throws Exception {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("dealTrend", dealTrendService.findDealTrend());
		map.put("message", "success");
		return ResponseEntity.ok(map);
	}
}
