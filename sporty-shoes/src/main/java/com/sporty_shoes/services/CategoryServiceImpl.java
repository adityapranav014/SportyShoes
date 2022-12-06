package com.sporty_shoes.services;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sporty_shoes.entities.Category;
import com.sporty_shoes.entities.Product;
import com.sporty_shoes.repository.CategoryRepository;
import com.sporty_shoes.repository.ProductRepository;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ProductRepository productRepo;

	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);

	}

	@Override
	public List<Category> getAllCategory() {
		return StreamSupport.stream(categoryRepo.findAll().spliterator(), false).collect(Collectors.toList());
	}

	@Override
	public Category getCategoryById(long categoryId) {
		return categoryRepo.findById(categoryId).get();
	}

	@Override
	public Category deleteCategory(long categoryId) {
		Category entity = categoryRepo.findById(categoryId).get();
		categoryRepo.delete(entity);
		return entity;
	}

	@Transactional
	@Override
	public Category updateCategory(Long categoryId, Category category) {
		Category categoryToEdit = getCategoryById(categoryId);
		categoryToEdit.setName(category.getName());
		return categoryToEdit;
	}

	@Override
	@Transactional
	public Category addProductToCategory(long categoryId, Long productId) {
		Category category = getCategoryById(categoryId);
		Product product = productRepo.findById(productId).get();
		category.addProduct(product);
		product.setCategory(category);
		return category;
	}

	@Override
	@Transactional
	public Category removeProductFromCategory(long categoryId, Long productId) {
		Category category = getCategoryById(categoryId);
		Product product = productRepo.findById(productId).get();
		category.removeProduct(product);
		return category;
	}

}
