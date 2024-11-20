package com.zs.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.entity.User;
import com.zs.service.UserService;

@RestController
@RequestMapping("/user")
public class userController {
@Autowired
private UserService service;
	@PostMapping(value="/save",consumes = "application/json")
	public String save(@RequestBody User u) {
	service.save(u);
	return "user saved";
	}
	@RequestMapping(value="/fetch{id}",produces = "application/json")
	public User fetch(@PathVariable int id) {
		return service.fetch(id);
	}
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		 service.Delete(id);
}
}
