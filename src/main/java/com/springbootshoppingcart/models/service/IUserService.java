package com.springbootshoppingcart.models.service;



import com.springbootshoppingcart.models.entity.Address;
import com.springbootshoppingcart.models.entity.Customer;
import com.springbootshoppingcart.models.entity.User;

public interface IUserService {
public void signupUser(User user, Customer customer, Address address); 

}