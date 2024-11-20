package com.zs.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.dto.ProductDto;
import com.zs.entity.Product;
import com.zs.exception.ProductNotFoundException;
import com.zs.service.ProductService;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping(value = "/Product")
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping(value = "/save", consumes = "application/json")
	ResponseEntity<String> save(@RequestBody @Valid ProductDto p){
		service.save(p);
		return new ResponseEntity<String>("Product Saved", HttpStatus.CREATED);
	}

	@GetMapping(value = "/list", produces = "application/json")
	ResponseEntity<List<Product>> list() {
		return new ResponseEntity<List<Product>>(service.list(), HttpStatus.OK);
	}

	@GetMapping(value = "/fetch/{code}", produces = "application/json")
	ResponseEntity<Product> fetch(@PathVariable int code)  {
				return new ResponseEntity<Product>(service.getbycode(code), HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{code}", produces = "application/json")
	public void delete(@PathVariable int code) {
		service.delete(code);
	}

	@GetMapping(value = "/findbyprice/{min}/{max}", produces = "application/json")
	ResponseEntity<List<Product>> findbypricerange(@PathVariable Double min, @PathVariable double max) {
		return new ResponseEntity<List<Product>>(service.findbypricerange(min, max), HttpStatus.OK);
	}

	@GetMapping(value = "/fpbc/{category}", produces = "application/json")
	ResponseEntity<List<Product>> findbycatagory(@PathVariable String category) {
		return new ResponseEntity<List<Product>>(service.findbycatagory(category), HttpStatus.OK);
	}

	@GetMapping(value = "/fbplth", produces = "application/json")
	ResponseEntity<List<Product>> findbyPriceLowtoHogh() {
		return new ResponseEntity<List<Product>>(service.findbyPriceLowtoHogh(), HttpStatus.OK);
	}

}
