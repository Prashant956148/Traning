package com.zs.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="users")
public class User {
	@Id
	private int uid;
	@Column(length=50)
	private String Name;
	@JsonManagedReference
	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
	private List<TODO>list;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public List<TODO> getList() {
		return list;
	}
	public void setList(List<TODO> list) {
		this.list = list;
	}
	public User(int uid, String name, List<TODO> list) {
		super();
		this.uid = uid;
		Name = name;
		this.list = list;
	}
	public User() {
		
	}
	public User(int uid, String name) {
		super();
		this.uid = uid;
		Name = name;
	}
	
	
	
	
	
	
	
	

}
