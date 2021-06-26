package com.springbootshoppingcart.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootshoppingcart.models.entity.Address;
@Repository
public interface IAddressRepository extends JpaRepository<Address, Long>{

	

}
