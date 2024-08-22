package com.bank.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "bank")
	@JsonManagedReference("bank-branches")
	private List<Branch> branches;
	
	@OneToMany(mappedBy = "bank")
	@JsonManagedReference("bank-services") 
	private List<Services> services;
}
