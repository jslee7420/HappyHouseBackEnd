package com.ssafy.happyhouse.address.service;

import java.util.List;

import com.ssafy.happyhouse.address.model.dto.Address;


public interface AddressService {
	
	List<Address> findSido() throws Exception;
	List<Address> findGugunInSido(String sido) throws Exception;
	List<Address> findDongInGugun(String gugun) throws Exception;
}
