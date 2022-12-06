package com.sporty_shoes.dto;

import com.sporty_shoes.entities.Category;

public class PlainCategoryDto {

	private long Id;
	private String name;

	public static PlainCategoryDto from(Category category) {
		PlainCategoryDto plainCategoryDto = new PlainCategoryDto();
		plainCategoryDto.setId(category.getId());
		plainCategoryDto.setName(category.getName());
		return plainCategoryDto;
	}
	
	public PlainCategoryDto() {
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

	
	public PlainCategoryDto(long id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "PlainCategoryDto [Id=" + Id + ", name=" + name + "]";
	}
}
