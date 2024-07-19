package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Product;
import com.service.ProductService;

@RestController
public class ProductController {
	
	
    @Autowired
    private ProductService productService;
    
    
    
    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product p) {
    	
    	return productService.save(p);
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(required = false) String category,
                                     @RequestParam(required = false) Double minPrice,
                                     @RequestParam(required = false) Double maxPrice,
                                     @RequestParam(required = false) Boolean inStock,
                                     @RequestParam(required = false, defaultValue = "createdAt") String sortField,
                                     @RequestParam(required = false, defaultValue = "asc") String sortOrder) {
        return productService.getFilteredAndSortedProducts(category, minPrice, maxPrice, inStock, sortField, sortOrder);
    }
}