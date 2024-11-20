package com.zs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.entity.TODO;
import com.zs.entity.User;
import com.zs.repo.userrepo;
@Service
public class UserServiceImpl implements UserService {
@Autowired
 private userrepo repo;
	@Override
	public void save(User t) {
		repo.save(t);
		
	}

	@Override
	public User fetch(int id) {
		
		return repo.findById(id).get();
	}

	@Override
	public void Delete(int id) {
		repo.deleteById(id);
		
	}

}
