package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zs.dto.ProductDto;
import com.zs.entity.Product;
import com.zs.exception.ProductNotFoundException;
import com.zs.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repo;

	@Override
	public void save(ProductDto p) {
		Product prod = new Product();
		prod.setCode(p.getCode());
		prod.setName(p.getName());
		prod.setPrice(p.getPrice());
		prod.setCategory(p.getCategory());
		repo.save(prod);

	}

	@Override
	public List<Product> list() {

		return repo.findAll();
	}

	@Override
	public Product getbycode(int code) {

		return repo.findById(code)
				.orElseThrow(()->new RuntimeException("No product found for the code:"+code));
	}

	@Override
	public void delete(int code) {

		repo.deleteById(code);

	}

	@Override
	public List<Product> findbypricerange(Double min, double max) {

		return repo.findByPriceBetween(min, max);
	}

	@Override
	public List<Product> findbycatagory(String category) {

		return repo.findByCategory(category);
	}

	@Override
	public List<Product> findbyPriceLowtoHogh() {

		return repo.findbyPriceasc();
	}

}
