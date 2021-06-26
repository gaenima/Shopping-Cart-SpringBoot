package com.springbootshoppingcart.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Product;
import com.springbootshoppingcart.models.repository.IProductRepository;
@Service
public class ProductServiceImp implements IProductService{
    @Autowired
    private IProductRepository iprodrepo;
	@Override
	@Transactional(readOnly = true)
	public Page<Product> findAllProducts(int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber -1, 2);
		return iprodrepo.findAll(pageable);
	}
	@Override
	@Transactional()
	public void saveProduct(Product product) {
		product.setStatus(true);
		iprodrepo.save(product);
	}
	@Override
	@Transactional(readOnly = true)
	public Product findProdById(Long id) {
		return iprodrepo.findById(id).orElse(null);
	}
	@Override
	@Transactional
	public void editStatus(boolean status, Long id) {
		iprodrepo.updateProductSttus(status, id);
		
	}

}
