package com.springbootshoppingcart.models.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.springbootshoppingcart.models.entity.Product;

public interface IProductService {
public Page <Product> findAllProducts(int pageNumber);
public Product findProdById(Long id);
public void saveProduct(Product product);
public void editStatus(boolean status, Long id);

}
