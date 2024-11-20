package com.zs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.zs.entity.Player;

public interface Playerrepo extends JpaRepository<Player, Integer> {
	@Query("FROM Player WHERE team.tid=:tid")
List<Player> findbyTeam(@Param("tid")int  tid);
	@Query("FROM Player WHERE team.tid=:tid")
	List<Player> updateById(@PathVariable("tid") int tid);
}
