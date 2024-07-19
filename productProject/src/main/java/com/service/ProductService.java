package com.service;

import java.util.List;

import com.entity.Product;

public interface ProductService {
	
	
	Product save(Product p);
	
	List<Product> getFilteredAndSortedProducts(String category, Double minPrice, Double maxPrice, Boolean inStock, String sortField, String sortOrder) ;

}
