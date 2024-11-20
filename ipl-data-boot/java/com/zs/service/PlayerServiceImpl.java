package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.entity.Player;
import com.zs.entity.Team;
import com.zs.repo.Playerrepo;
@Service
public class PlayerServiceImpl implements PlayerService {
@Autowired
private Playerrepo repo;
@Autowired
private TeamService service1;
	@Override
	public void save(Player p) {
//		Team t=service1.fetch(id);
//	p.setTeam(t);
		repo.save(p);
//		return "Player saved";
		
	}

	@Override
	public List<Player> list() {
		return repo.findAll();
		
	}

	@Override
	public Player fetch(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Player> updateById(int id) {
		// TODO Auto-generated method stub
		
		return repo.updateById(id);
	}

}
