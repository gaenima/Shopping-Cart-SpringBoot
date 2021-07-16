package com.springbootshoppingcart.models.service;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import com.springbootshoppingcart.models.entity.Address;
import com.springbootshoppingcart.models.entity.Customer;
import com.springbootshoppingcart.models.entity.User;

public interface IUserService {
	public void signupUser(User user, Customer customer, Address address,String siteURL); 
	public String uniqueMail(String mailId);
	public void register(User user, String siteURL) throws UnsupportedEncodingException, MessagingException;
	public void sendVerificationEmail(User user, String siteURL) 
			throws MessagingException, UnsupportedEncodingException;
	      
}
