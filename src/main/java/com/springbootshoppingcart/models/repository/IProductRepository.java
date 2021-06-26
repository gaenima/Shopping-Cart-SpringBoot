package com.springbootshoppingcart.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Long>{
@Transactional
@Modifying
@Query("DELETE FROM Product p WHERE p.id = ?1")
public void DeleteProductById(Long id);

@Transactional
@Modifying
@Query("Update Product p set p.status = ?1 where p.id = ?2")
public void updateProductSttus(boolean status, Long id);

}
