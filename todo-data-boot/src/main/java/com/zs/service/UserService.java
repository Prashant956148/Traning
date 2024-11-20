package com.zs.service;

import com.zs.entity.TODO;
import com.zs.entity.User;

public interface UserService {
	void save(User t);
	public User fetch(int id);
	public void Delete(int id);

	

	
}
