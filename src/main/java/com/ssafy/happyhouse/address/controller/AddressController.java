package com.ssafy.happyhouse.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.address.model.dto.Address;
import com.ssafy.happyhouse.address.service.AddressService;

@CrossOrigin("*")
@RestController
@RequestMapping("/address")
public class AddressController {
	
	private AddressService addressService;
	
	@Autowired
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	@GetMapping("/sidos")
	public ResponseEntity<List<Address>> sidoList() throws Exception{
		if(addressService.findSido().size()==0) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Address>>(addressService.findSido(), HttpStatus.OK);
	}
	
	@GetMapping("/sidos/{sido}/guguns")
	public ResponseEntity<List<Address>> gugnList(@PathVariable String sido) throws Exception{
		if(addressService.findGugunInSido(sido).size()==0) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Address>>(addressService.findGugunInSido(sido), HttpStatus.OK);
	}
	
	@GetMapping("/sidos/{sido}/guguns/{gugun}/dongs")
	public ResponseEntity<List<Address>> dongList(@PathVariable String gugun) throws Exception{
		if(addressService.findDongInGugun(gugun).size()==0) {
			return ResponseEntity.notFound().build();
		}
		return new ResponseEntity<List<Address>>(addressService.findDongInGugun(gugun), HttpStatus.OK);
	}
	
}
