package com.zs.dto;

import org.hibernate.annotations.BatchSize;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProductDto {
	@Min(value = 99, message = "Code value must be greater than 99")
	private int code;
	@Size(min = 5, message = "name must contains atleast 5 characters")
	private String name;
	@DecimalMin(value = "99.00", message = "price must be greater than 99.00")
	@DecimalMax(value = "999.99", message = "price mut be less than 999.99")
	private double price;
	@NotNull(message = "category must contains somthing it is not null")
	private String category;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
