package com.sporty_shoes.services;

import java.util.List;

import com.sporty_shoes.entities.Product;

public interface ProductService {

	public Product addProduct(Product product);

	public List<Product> getAllProducts();

	public Product getProductById(long productId);

	public Product updateProduct(Long productId, Product product);

	public Product deleteProduct(long productId);

}
