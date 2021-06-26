package com.springbootshoppingcart.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Customer;
import com.springbootshoppingcart.models.repository.ICustomerRepository;
@Service
public class CustomerServiceImp implements ICustomerService{
	@Autowired
	private ICustomerRepository icustomerrepo ;

	@Override
	@Transactional(readOnly=true)
	public List<Customer> findAllCustomer() {
		return icustomerrepo.findAll();
	}

	@Override
	@Transactional
	public Customer findCustomerById(Long id) {		
		return icustomerrepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		icustomerrepo.save(customer);
		
	}

}
