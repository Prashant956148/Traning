package com.zs.service;

import java.util.List;

import com.zs.Exception.InvalidUerException;
import com.zs.entity.TODO;

public interface TODOService {
void save(TODO t,int id);
public void update(int id) throws InvalidUerException;
public TODO fetch(int id) throws InvalidUerException;
public void Delete(int id);

List<TODO> findbyuserid(int id);
List<TODO> findByStatus(String status);
	
}
