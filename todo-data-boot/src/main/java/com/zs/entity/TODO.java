package com.zs.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class TODO {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE)
private int tid;
@NotEmpty(message = "Task cannot be null")
@Size(min = 4,max = 10)
private String task;

private String priority;
private String status;
private LocalDate assigndate=LocalDate.now();
private LocalDate finishdate;
@JsonBackReference
@ManyToOne
@JoinColumn(name="user_id")
private User user;
public int getTid() {
	return tid;
}
public void setTid(int tid) {
	this.tid = tid;
}
public String getTask() {
	return task;
}
public void setTask(String task) {
	this.task = task;
}
public String getPriority() {
	return priority;
}
public void setPriority(String priority) {
	this.priority = priority;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public LocalDate getAssigndate() {
	return assigndate;
}
public void setAssigndate(LocalDate assigndate) {
	this.assigndate = assigndate;
}
public LocalDate getFinishdate() {
	return finishdate;
}
public void setFinishdate(LocalDate finishdate) {
	this.finishdate = finishdate;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}



}
