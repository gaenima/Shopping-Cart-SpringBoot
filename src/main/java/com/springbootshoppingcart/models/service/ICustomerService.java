package com.springbootshoppingcart.models.service;

import java.util.List;

import com.springbootshoppingcart.models.entity.Customer;

public interface ICustomerService {
	public List<Customer> findAllCustomer();
	public Customer findCustomerById(Long id);
	public void saveCustomer(Customer customer);

}
