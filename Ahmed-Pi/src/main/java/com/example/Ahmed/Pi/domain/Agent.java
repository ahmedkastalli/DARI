package com.example.Ahmed.Pi.domain;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component

@Entity
public class Agent {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String photo;
	private String password;
	private Date ContractValidDate;
	private String contract;
	
	@OneToMany(mappedBy = "agent", fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Visite> visites;
	
	public Agent() {}

	
	public Agent(long id, String firstName, String lastName, String emailAddress, String photo, String password,
			Date contractValidDate, String contract, List<Visite> visites) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.photo = photo;
		this.password = password;
		ContractValidDate = contractValidDate;
		this.contract = contract;
		this.visites = visites;
	}


	public Agent(long id, String firstName, String lastName, String emailAddress, String photo, String password,
			Date contractValidDate, String contract) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.photo = photo;
		this.password = password;
		ContractValidDate = contractValidDate;
		this.contract = contract;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getContractValidDate() {
		return ContractValidDate;
	}

	public void setContractValidDate(Date contractValidDate) {
		ContractValidDate = contractValidDate;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	
	
	

}
