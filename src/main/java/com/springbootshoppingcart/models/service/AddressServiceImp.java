package com.springbootshoppingcart.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Address;
import com.springbootshoppingcart.models.repository.IAddressRepository;

@Service
public class AddressServiceImp implements IAddressService{
	@Autowired IAddressRepository iaddressrepo;

	@Override
	@Transactional(readOnly=true)
	public List<Address> findAllAddress() {
		return iaddressrepo.findAll();
	}

	@Override
	public Address findAddressById(Long id) {		
		return null;
	}

	@Override
	public void saveAddress(Address address) {
		iaddressrepo.save(address);
		
	}

}

