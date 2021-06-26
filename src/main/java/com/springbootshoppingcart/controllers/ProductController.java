package com.springbootshoppingcart.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springbootshoppingcart.models.entity.Product;
import com.springbootshoppingcart.models.service.ICategoryService;
import com.springbootshoppingcart.models.service.IProductService;

@Controller
public class ProductController {
	@Autowired
	private IProductService iprodser;
	@Autowired
	private ICategoryService icateser;

	@GetMapping("/product/list")
	public String productList(Model model) {
		//model.addAttribute("products", iprodser.findAllProducts());
		//return "product/list";
		return productPagination(1, model);
	}

	@GetMapping("/page/{pageNumber}")
	public String productPagination(@PathVariable(name = "pageNumber") int pageCurrent, Model model) {
        Page<Product> page= iprodser.findAllProducts(pageCurrent);
        long totalitems = page.getTotalElements();
        int totalpages = page.getTotalPages();
        List<Product> listProducts = page.getContent();
        model.addAttribute("products", listProducts);
        model.addAttribute("totalitems", totalitems);
        model.addAttribute("totalpages", totalpages);
		model.addAttribute("pageCurrent", pageCurrent);
        return "product/list";
	}

	@GetMapping("/product/form")
	public String productForm(Model model) {
		model.addAttribute("category", icateser.findAllCategory());
		model.addAttribute("product", new Product());
		return "product/form";
	}

	@PostMapping("/product/save")
	public String productSave(Product product) {
		iprodser.saveProduct(product);
		return "redirect:/product/list";
	}

	@GetMapping("/product/edit/{idProd}")
	public String productEdit(@PathVariable(name = "idProd") Long idProd, Model model) {
		Product produ = iprodser.findProdById(idProd);
		if (produ == null) {
			return "redirect:/product/list";
		}
		model.addAttribute("product", produ);
		return "product/form";
	}

	@GetMapping("/editProdStatus/{status}/{idprod}")
	public String editProdutStatus(@PathVariable(name = "status") boolean status,
			@PathVariable(name = "idprod") Long idprod) {
		iprodser.editStatus(status, idprod);
		return "redirect:/product/list";
	}

	@GetMapping("/product/detail/{idprod}")
	public String productDetail(Model model, @PathVariable(name = "idprod") Long idprod) {
		Product prodDetail = iprodser.findProdById(idprod);
		if (prodDetail == null) {
			return "redirect:/product/list";
		}
		model.addAttribute("product", prodDetail);
		return "product/detail";
	}

}
