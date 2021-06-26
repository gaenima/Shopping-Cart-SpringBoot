package com.springbootshoppingcart.models.service;

import java.util.List;

import com.springbootshoppingcart.models.entity.Category;

public interface ICategoryService {
public List<Category> findAllCategory();
public Category findCateById(Long id);
public void saveCategory(Category category);
public void deleteCateById(Long id);
}
