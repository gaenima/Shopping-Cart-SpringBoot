package com.springbootshoppingcart.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Province;
import com.springbootshoppingcart.models.repository.IProvinceRepository;

@Service
public class ProvinceServiceImp implements IProvinceService{
@Autowired
private IProvinceRepository iprovincrepo;

	@Override
	@Transactional(readOnly=true)
	public List<Province> findAllProvince() {
		return iprovincrepo.findAll();
	}

	@Override
	public Province findProvinceById(Long id) {
		return iprovincrepo.findById(id).orElse(null);
	}

	@Override
	public void saveProvince(Province province) {
		iprovincrepo.save(province);		
	}

}
