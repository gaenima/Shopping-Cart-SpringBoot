package com.springbootshoppingcart.models.service;

import java.util.List;

import com.springbootshoppingcart.models.entity.Province;

public interface IProvinceService {
public List<Province> findAllProvince();
public Province findProvinceById(Long id);
public void saveProvince(Province province);
}
