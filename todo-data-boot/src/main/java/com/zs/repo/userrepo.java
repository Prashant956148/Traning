package com.zs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zs.entity.User;

public interface userrepo extends JpaRepository<User, Integer> {

}
