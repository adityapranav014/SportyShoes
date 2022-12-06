package com.sporty_shoes.dto;

import java.math.BigDecimal;
import java.util.Objects;

import com.sporty_shoes.entities.Product;

public class ProductDto {

	private long Id;
	private String name;
	private String description;
	private BigDecimal price;
	private PlainCategoryDto plainCategoryDto;

	public static ProductDto from(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setDescription(product.getDescription());
		productDto.setPrice(product.getPrice());
		if (Objects.nonNull(product.getCategory())) {
			productDto.setPlainCategoryDto(PlainCategoryDto.from(product.getCategory()));
		}
		return productDto;
	}

	public ProductDto() {
	}

	public ProductDto(long id, String name, String description, BigDecimal price, PlainCategoryDto plainCategoryDto) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.plainCategoryDto = plainCategoryDto;
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

	public PlainCategoryDto getPlainCategoryDto() {
		return plainCategoryDto;
	}

	public void setPlainCategoryDto(PlainCategoryDto plainCategoryDto) {
		this.plainCategoryDto = plainCategoryDto;
	}

	@Override
	public String toString() {
		return "ProductDto [Id=" + Id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", plainCategoryDto=" + plainCategoryDto + "]";
	}

}
