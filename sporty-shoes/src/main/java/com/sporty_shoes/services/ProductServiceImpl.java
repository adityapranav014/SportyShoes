package com.sporty_shoes.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sporty_shoes.entities.Product;

import com.sporty_shoes.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Override
	public Product addProduct(Product product) {
		productRepo.save(product);
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(long productId) {
		return productRepo.findById(productId).get();
	}

	@Override
	@Transactional
	public Product updateProduct(Long productId, Product product) {
		Product productToEdit = getProductById(productId);
		productToEdit.setName(product.getName());
		productToEdit.setDescription(product.getDescription());
		productToEdit.setPrice(product.getPrice());
		productToEdit.setCategory(product.getCategory());
		return productToEdit;
	}


	@Override
	public Product deleteProduct(long productId) {
		Product entity = productRepo.findById(productId).get();
		productRepo.delete(entity);
		return entity;
	}


}
