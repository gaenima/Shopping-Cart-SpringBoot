package com.springbootshoppingcart.models.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Address;
import com.springbootshoppingcart.models.entity.Customer;
import com.springbootshoppingcart.models.entity.Rol;
import com.springbootshoppingcart.models.entity.User;
import com.springbootshoppingcart.models.repository.IAddressRepository;
import com.springbootshoppingcart.models.repository.ICustomerRepository;
import com.springbootshoppingcart.models.repository.IRolRepository;
import com.springbootshoppingcart.models.repository.IUserRepository;
@Service
public class UserServiceImp implements IUserService{
    @Autowired
    private IRolRepository irolrepo;
    @Autowired
    private ICustomerRepository icusterrepo;
    @Autowired
    private IUserRepository iuserrepo;
    @Autowired
    private IAddressRepository iaddressrepo;
	
	@Override
	@Transactional
	public void signupUser(User user, Customer customer, Address address) {
		Rol rol = irolrepo.findByName("CUSTOMER");
		//convertir una clase en Set. Set es una interface -> HasSet para instanciar
		Set<Rol> roles = new HashSet<Rol>(Arrays.asList(rol));
		user.setRoles(roles);
		iuserrepo.save(user);
		customer.setUser(user);
		icusterrepo.save(customer);
		address.setCustomer(customer);
		iaddressrepo.save(address);
		
	}

	

	
     
}
