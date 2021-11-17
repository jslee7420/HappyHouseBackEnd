package com.ssafy.happyhouse.address.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ssafy.happyhouse.address.model.dto.Address;
import com.ssafy.happyhouse.address.model.mapper.AddressMapper;

@Service
public class AddressServiceImpl implements AddressService {
	
	private AddressMapper addressMapper;
	
	@Autowired
	public void setAddressMapper(AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}

	@Override
	public List<Address> findSido() throws Exception {
		return addressMapper.selectSido();
	}

	@Override
	public List<Address> findGugunInSido(String sido) throws Exception {
		return addressMapper.selectGugunInSido(sido);
	}

	@Override
	public List<Address> findDongInGugun(String gugun) throws Exception {
		return addressMapper.selectDongInGugun(gugun);
	}

}
