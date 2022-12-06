package com.sporty_shoes.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sporty_shoes.entities.Category;

public class CategoryDto {

	private long Id;
	private String name;
	private List<ProductDto> productsDto = new ArrayList<>();

	public static CategoryDto from(Category category) {
		CategoryDto categoryDto = new CategoryDto();
		categoryDto.setId(category.getId());
		categoryDto.setName(category.getName());
		categoryDto.setProductsDto(category.getProducts().stream().map(ProductDto::from).collect(Collectors.toList()));
		return categoryDto;
	}

	public CategoryDto() {
	}

	public CategoryDto(long id, String name, List<ProductDto> productsDto) {
		super();
		Id = id;
		this.name = name;
		this.productsDto = productsDto;
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

	public List<ProductDto> getProductsDto() {
		return productsDto;
	}

	public void setProductsDto(List<ProductDto> productsDto) {
		this.productsDto = productsDto;
	}

	@Override
	public String toString() {
		return "CategoryDto [Id=" + Id + ", name=" + name + ", productsDto=" + productsDto + "]";
	}

}
