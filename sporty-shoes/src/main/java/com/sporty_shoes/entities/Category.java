 package com.sporty_shoes.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.sporty_shoes.dto.CategoryDto;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String name;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "category_id")
	private List<Product> products = new ArrayList<>();

	public Category() {
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void removeProduct(Product product) {
		products.remove(product);
	}

	public static Category from(CategoryDto categoryDto) {
		Category category = new Category();
		category.setName(categoryDto.getName());
		return category;
	}

	public Category(long id, String name, List<Product> products) {
		super();
		Id = id;
		this.name = name;
		this.products = products;
	}

	public long getId() {
		return Id;
	}
//
//	public void setId(long id) {
//		Id = id;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [Id=" + Id + ", name=" + name + ", products=" + products + "]";
	}
}
