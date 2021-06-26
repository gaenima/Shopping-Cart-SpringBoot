package com.springbootshoppingcart.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long>{
	@Transactional
	@Modifying
	@Query("DELETE FROM Category c WHERE c.id = ?1")
	public void DeleteCategoryById(Long id);
}
