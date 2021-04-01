package com.example.Ahmed.Pi.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
@Entity
public class Visite {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Status status;
	private Date date;
	
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Agent agent;
	
	public Visite() {}
	public Visite(long id, Status status, Date date) {
		super();
		this.id = id;
		this.status = status;
		this.date = date;
	}
	
	
	public Visite(long id, Status status, Date date, Agent agent) {
		super();
		this.id = id;
		this.status = status;
		this.date = date;
		this.agent = agent;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	@Override
	public String toString() {
		return "Visite [id=" + id + ", status=" + status + ", date=" + date + ", agent=" + agent + "]";
	}
	
	
	
}
