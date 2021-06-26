package com.springbootshoppingcart.models.service;

import java.util.List;

import com.springbootshoppingcart.models.entity.City;

public interface ICityService {
	
	public List<City> findAllCity();
	public City findCityById(Long id);
	public void saveCity(City city);

}
