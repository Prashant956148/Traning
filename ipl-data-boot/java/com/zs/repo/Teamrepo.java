package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.Team;

public interface Teamrepo extends JpaRepository<Team, Integer> {

}
