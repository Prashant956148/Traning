package com.zs.service;

import java.util.List;

import com.zs.entity.Player;
import com.zs.entity.Team;

public interface TeamService {

	 void save(Team p);
	 List<Team> list();
	 Team fetch(int tid);
	 
	 
}
