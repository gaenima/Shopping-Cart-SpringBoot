package com.springbootshoppingcart.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootshoppingcart.models.entity.City;
import com.springbootshoppingcart.models.repository.ICityRepository;

@Service
public class CityServiceImp implements ICityService {
@Autowired
private ICityRepository icityrepo;

	@Override
	public List<City> findAllCity() {
		return icityrepo.findAll();
	}

	@Override
	public City findCityById(Long id) {
		return icityrepo.findById(id).orElse(null);
	}

	@Override
	public void saveCity(City city) {
		icityrepo.save(city);
		
	}

	@Override
	public List<City> findCitiesByPovince(Long id) {
				return icityrepo.showCities(id);
	}
	
}