package com.zs.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.entity.Team;
import com.zs.service.TeamService;

@RestController
@RequestMapping("/Team")
public class Teamcontroller {
@Autowired
private TeamService service;
@PostMapping(value="/save",consumes = "application/json")
public String save(@RequestBody Team t) {
	service.save(t);
	return "Team saved";
}
@GetMapping(value="/list",produces = "application/json")
public List<Team>list(){
	return service.list();
}
@GetMapping(value="/fetch/{id}",produces = "application/json")
	public Team fetch(@PathVariable int id) {
	return service.fetch(id);
}
}
