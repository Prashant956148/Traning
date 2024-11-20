package com.zs.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.zs.Exception.InvalidUerException;
import com.zs.entity.TODO;
import com.zs.service.TODOService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/TODO")
public class TODOController {
	@Autowired
	private TODOService service;

	@PostMapping(value = "/save/{id}", consumes = "application/json")
	public String save(@RequestBody @Valid TODO t, @PathVariable int id)  {
//		if (bindingResult.hasErrors()) {
//	        StringBuilder errorMessages = new StringBuilder("Validation failed: ");
//	        bindingResult.getAllErrors().forEach(error -> {
//	            errorMessages.append(error.getDefaultMessage()).append(", ");
//	        });
//	        // Remove the last comma and space
//	        String errors = errorMessages.toString().substring(0, errorMessages.length() - 2);
//	        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);  // Return validation errors
//	    }
		
		service.save(t, id);
		 return "TODO saved successfully";
	}

//	@ExceptionHandler(InvalidUerException.class)
//    public ResponseEntity<String> handleValidationExceptions(InvalidUerException ex) {
//        return new ResponseEntity<>("Validation failed: " + ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }

	@RequestMapping(value = "/fetch/{id}", produces = "application/json")
	public TODO fetch(@PathVariable int id) throws InvalidUerException {
		return service.fetch(id);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		service.Delete(id);
	}

	@PutMapping(value = "/update/{id}")
	public void update(@PathVariable int id) throws InvalidUerException {

		service.update(id);
	}

	@GetMapping(value = "/list/{id}", produces = "application/json")
	public List<TODO> finduserbyuserid(@PathVariable int id) {
		return service.findbyuserid(id);
	}

	@GetMapping(value = "/status/{status}", produces = "application/json")
	public List<TODO> finduserbystatus(@PathVariable String status) {
		return service.findByStatus(status);
	}
}
