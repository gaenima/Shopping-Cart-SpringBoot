package com.springbootshoppingcart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootshoppingcart.models.entity.Category;
import com.springbootshoppingcart.models.service.ICategoryService;

@Controller
public class CategoryController {
	@Autowired
	private ICategoryService icateser;
@GetMapping("/category/list")
public String categoryList(Model model) {
	model.addAttribute("categories", icateser.findAllCategory());
	return "category/list";
}
@GetMapping("/category/form")
public String categoryForm(Model model) {
	model.addAttribute("category", new Category());
	return "category/form";
}
@PostMapping("/category/save")
public String categorySave(Category category) {
	icateser.saveCategory(category);
	return "redirect:/category/list";
}
@GetMapping("/category/edit/{idCate}")
public String categoryEdit(@PathVariable(name="idCate") Long idCate, Model model) {
    Category categ = icateser.findCateById(idCate);
    if(categ == null) {
    	return "redirect:/category/list";
    }
    model.addAttribute("category", categ);
	return "category/form";
}
@GetMapping("/category/delete/{id}")
public String categoryDelete(@PathVariable(name="id") Long id) {
	if(id > 0) {
		icateser.deleteCateById(id);
	}
	return "redirect:/category/list";
}

@GetMapping("/category/detail/{idCate}")
public String categoryDetail(Model model, @PathVariable(name="idCate") Long idCate) {
	Category category = icateser.findCateById(idCate);
	if(category == null) {
		return "redirect:/category/list";
	}
	model.addAttribute("cateModel", category);
	return "category/detail";
}
}










