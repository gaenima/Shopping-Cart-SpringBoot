package com.springbootshoppingcart.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.City;
@Repository
public interface ICityRepository extends JpaRepository<City, Long>{

	@Transactional
	@Modifying
	@Query("select  c from City c where c.province.id = ?1")
public List<City> showCities(Long id);
	

}
