package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.entity.Team;
import com.zs.repo.Teamrepo;
@Service
public class TeamServiceImpl implements TeamService {
@Autowired
private Teamrepo repo;
	@Override
	public void save(Team p) {
		repo.save(p);
		
		
	}

	@Override
	public List<Team> list() {
		repo.findAll();
		return list();
	}

	@Override
	public Team fetch(int tid) {
		return repo.findById(tid).orElse(null);
		
	}
	

}
