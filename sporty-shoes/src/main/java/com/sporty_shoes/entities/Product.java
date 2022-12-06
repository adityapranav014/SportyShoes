package com.sporty_shoes.entities;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.sporty_shoes.dto.ProductDto;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Id;
	private String name;
	private String description;
	private BigDecimal price;
	@ManyToOne
	private Category category;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public static Product from(ProductDto productDto) {
		Product product = new Product();
		product.setName(productDto.getName());
		product.setDescription(productDto.getDescription());
		product.setPrice(productDto.getPrice());
		return product;
	}

	public Product(long id, String name, String description, BigDecimal price, Category category) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.category = category;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [Id=" + Id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", category=" + category + "]";
	}

}
