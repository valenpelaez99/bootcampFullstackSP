package com.reto.retofinal.entity;


import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clients")

public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
	
	@Column(name= "identificationType")
	private String identificationType;
	
	@Column(name= "identificationNumber")
	private String identificationNumber;
	
	@Column(name= "name")
	private String name;
	
	@Column(name= "lastName")
	private String lastName;
	
	@Column(name= "email")
	private String email;
	
	@JsonFormat(pattern = "dd/MM/yyyy") 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name= "birthDate")
	private LocalDate birthDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy") 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name= "creationDate")
	private LocalDate creationDate;
	
	@Column(name= "userCreation")
	private String userCreation;
	
	@JsonFormat(pattern = "dd/MM/yyyy") 
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name= "modificationDate")
	private LocalDate modificationDate;
	
	@Column(name= "userModification")
	private String userModification;
	
	public Client() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserCreation() {
		return userCreation;
	}

	public void setUserCreation(String userCreation) {
		this.userCreation = userCreation;
	}

	public LocalDate getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(LocalDate modificationDate) {
		this.modificationDate = modificationDate;
	}

	public String getUserModification() {
		return userModification;
	}

	public void setUserModification(String userModification) {
		this.userModification = userModification;
	}

	
	
	
}


