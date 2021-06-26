package com.springbootshoppingcart.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springbootshoppingcart.models.entity.Address;
import com.springbootshoppingcart.models.entity.City;
import com.springbootshoppingcart.models.entity.Customer;
import com.springbootshoppingcart.models.entity.User;
import com.springbootshoppingcart.models.repository.ICityRepository;
import com.springbootshoppingcart.models.service.IAddressService;
import com.springbootshoppingcart.models.service.ICityService;
import com.springbootshoppingcart.models.service.ICustomerService;
import com.springbootshoppingcart.models.service.IProvinceService;
import com.springbootshoppingcart.models.service.IUserService;

@Controller
public class AccessController {
@Autowired
private IUserService iuserservice;
@Autowired
private IAddressService iaddresservice;
@Autowired
private ICustomerService icustomser;
@Autowired
private IProvinceService iprovinser;
@Autowired
private ICityService icityser;
@Autowired
private ICityRepository icityrepo;

@GetMapping("/signup")
public String signup(Model model) {
	model.addAttribute("provinces", iprovinser.findAllProvince());
	model.addAttribute("cities", icityser.findAllCity());
	model.addAttribute("user", new User());
	model.addAttribute("customer", new Customer());
	model.addAttribute("address", new Address());	
	return "frontend/access/form";
}
@PostMapping("/signup/save")
public String signupSave(User user, Customer customer, Address address) {
	//icustomser.saveCustomer(customer);
	//iaddresservice.saveAddress(address);
	iuserservice.signupUser(user, customer, address);
	
	return "redirect:/signup";
}

@GetMapping("/get_cities/{id}")
@ResponseBody
public List<City> getCities(@PathVariable(name="id")Long id, Model model) {
	return icityrepo.showCities(id);
}
}