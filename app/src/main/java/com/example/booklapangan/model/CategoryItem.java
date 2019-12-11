package com.example.booklapangan.model;

import com.google.gson.annotations.SerializedName;

public class CategoryItem{
	@SerializedName("category_name")
	private String category_name;

	public void setCategory_name(String category_name){
		this.category_name = category_name;
	}

	public String getCategory_name(){
		return category_name;
	}

	@Override
 	public String toString(){
		return 
			"CategoryItem{" + 
			"category_name = '" + category_name + '\'' +
			"}";
		}
}
