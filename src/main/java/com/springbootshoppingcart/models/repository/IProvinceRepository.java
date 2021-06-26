package com.springbootshoppingcart.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootshoppingcart.models.entity.Province;
@Repository
public interface IProvinceRepository extends JpaRepository<Province, Long>{

}
