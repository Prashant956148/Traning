package com.zs.service;

import java.util.List;

import com.zs.dto.ProductDto;
import com.zs.entity.Product;
import com.zs.exception.ProductNotFoundException;

public interface ProductService {

	void save(ProductDto p);

	List<Product> list();

	Product getbycode(int code);

	void delete(int code);

	List<Product> findbypricerange(Double min, double max);

	List<Product> findbycatagory(String category);

	List<Product> findbyPriceLowtoHogh();
}
