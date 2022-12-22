package com.reto.retofinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="clients")

public class client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String IdentificationType;
	private String IdentificationNumber;
	private String Name;
	private String LastName;
	private String Email;
	private String BirthDate;
	private String CreationDate;
	private String UserCreation;
	private String ModificationDate;
	private String UserModification;
	
	public client() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentificationType() {
		return IdentificationType;
	}

	public void setIdentificationType(String identificationType) {
		IdentificationType = identificationType;
	}

	public String getIdentificationNumber() {
		return IdentificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		IdentificationNumber = identificationNumber;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}

	public String getCreationDate() {
		return CreationDate;
	}

	public void setCreationDate(String creationDate) {
		CreationDate = creationDate;
	}

	public String getUserCreation() {
		return UserCreation;
	}

	public void setUserCreation(String userCreation) {
		UserCreation = userCreation;
	}

	public String getModificationDate() {
		return ModificationDate;
	}

	public void setModificationDate(String modificationDate) {
		ModificationDate = modificationDate;
	}

	public String getUserModification() {
		return UserModification;
	}

	public void setUserModification(String userModification) {
		UserModification = userModification;
	}
	
	
	
}


