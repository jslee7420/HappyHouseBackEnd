package com.ssafy.happyhouse.address.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.address.model.dto.Address;

@Mapper
public interface AddressMapper {
	
	List<Address> selectSido();
	List<Address> selectGugunInSido(String sido);
	List<Address> selectDongInGugun(String gugun);
	
}
