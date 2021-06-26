package com.springbootshoppingcart.models.service;

import java.util.List;

import com.springbootshoppingcart.models.entity.Address;

public interface IAddressService {
  public List<Address> findAllAddress();
  public Address findAddressById(Long id);
  public void saveAddress(Address address);
}
