package com.zs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	private int code;
	@Column(name = "Name", length = 30)
	private String name;
	private Double price;
	@Column(length = 30)
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Product(int code, String name, Double price, String category) {
		super();
		this.code = code;
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public Product() {

	}

}
