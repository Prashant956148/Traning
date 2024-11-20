package com.zs.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
public class Player {
@Id

private int jno;
private String pname;
private String genre;
private String bidamt;
//@JsonBackReference
@ManyToOne(fetch=FetchType.LAZY)

@JoinColumn(name="Team_id")
private Team team;
public int getJno() {
	return jno;
}
public void setJno(int jno) {
	this.jno = jno;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getBidamt() {
	return bidamt;
}
public void setBidamt(String bidamt) {
	this.bidamt = bidamt;
}
public Team getTeam() {
	return team;
}
public void setTeam(Team team) {
	this.team = team;
}





}
