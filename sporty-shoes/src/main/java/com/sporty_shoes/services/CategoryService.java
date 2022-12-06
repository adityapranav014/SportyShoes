package com.sporty_shoes.services;

import java.util.List;

import com.sporty_shoes.entities.Category;

public interface CategoryService {

	Category addCategory(Category category);

	List<Category> getAllCategory();

	Category getCategoryById(long categoryId);

	Category deleteCategory(long categoryId);

	Category updateCategory(Long categoryId, Category category);

	Category addProductToCategory(long categoryId, Long productId);

	Category removeProductFromCategory(long categoryId, Long productId);

}
