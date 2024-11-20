package com.zs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.Exception.InvalidUerException;
import com.zs.entity.TODO;

import com.zs.entity.User;
import com.zs.repo.Todorepo;

import jakarta.transaction.Transactional;

@Service
public class TODOserviceImpl implements TODOService {
@Autowired
private Todorepo repo;
@Autowired
private UserService users;
	@Override
	
	public void save(TODO t,int id) {
		User u=users.fetch(id);
		t.setUser(u);
		
		t.setStatus("pending");
			repo.save(t);
		

	}

	@Override
	
	public void update(int id) throws InvalidUerException {
		TODO t=fetch(id);
		t.setStatus("completed");
		
		repo.save(t);
		
	}

	@Override
	public TODO fetch(int id) throws InvalidUerException {
		return repo.findById(id).orElseThrow(()-> new InvalidUerException("TODO with "+id+" not found"));
		
	}

	@Override
	public void Delete(int id) {
		 repo.deleteById(id);
		
	}

	@Override
	public List<TODO> findbyuserid(int id) {
		return repo.findByuser(id);
		
	}

	@Override
	public List<TODO> findByStatus(String status) {
		
		return repo.findByStatus(status);
	}

	

}
