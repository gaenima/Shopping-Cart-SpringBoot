package com.springbootshoppingcart.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbootshoppingcart.models.entity.Category;
import com.springbootshoppingcart.models.repository.ICategoryRepository;
@Service
public class CategoryServiceImp implements ICategoryService{
    @Autowired
    private ICategoryRepository icaterepo;
	@Override
	@Transactional(readOnly = true)
	public List<Category> findAllCategory() {
		return icaterepo.findAll();
	}
	@Override
	@Transactional
	public void saveCategory(Category category) {
		icaterepo.save(category);
		
	}
	@Override
	@Transactional(readOnly = true)
	public Category findCateById(Long id) {	
		return icaterepo.findById(id).orElse(null);
	}
	@Override
	@Transactional()
	public void deleteCateById(Long id) {
		icaterepo.DeleteCategoryById(id);
		
	}
 
}
