package com.zs.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zs.entity.Player;
import com.zs.entity.Team;
import com.zs.service.PlayerService;
import com.zs.service.TeamService;
@RestController
@RequestMapping("/Player")
public class Playercontroller {
	@Autowired
	private PlayerService service;
	@PostMapping(value="/save",consumes = "application/json")
	public String save(@RequestBody Player p) {
		service.save(p);
		return "Player saved";
	}
	@GetMapping(value="/list",produces = "application/json")
	public List<Player> list(){
		return service.list();
	}
	@GetMapping(value="/fetch/{id}",produces = "application/json")
		public Player fetch(@PathVariable int id) {
		return service.fetch(id);
	}
	
	@PutMapping("/update/{id}")
	public List<Player> updatebyId(@PathVariable int id)
	{
		return service.updateById(id);
	}
	
	}

