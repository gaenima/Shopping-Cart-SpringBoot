package com.springbootshoppingcart.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootshoppingcart.models.entity.Customer;
@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long>{

}
