package com.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getFilteredAndSortedProducts(String category, Double minPrice, Double maxPrice,
			Boolean inStock, String sortField, String sortOrder) {

		String order = (sortOrder.equalsIgnoreCase("desc") ? "desc" : "asc");
		List<Product> products = productRepository.findFilteredProducts(category, minPrice, maxPrice, inStock);

		Comparator<Product> comparator = Comparator.comparing(Product::getCreatedAt); // Default sorting by createdAt
        if ("price".equalsIgnoreCase(sortField)) {
            comparator = Comparator.comparing(Product::getPrice);
        } else if ("rating".equalsIgnoreCase(sortField)) {
            comparator = Comparator.comparing(Product::getRating);
        }

        if ("desc".equalsIgnoreCase(sortOrder)) {
            comparator = comparator.reversed();
        }

        products.sort(comparator);

        return products;

	}

	@Override
	public Product save(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	};

}
