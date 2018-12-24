package com.test.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="person_table")
public class Person {
	
	@Id
	@NotNull
	@Column(name="person_id", length=11)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int person_id;
	
	@Column(name="first_name", length=255)
	private String firstName;
	
	@Column(name="last_name", length=255)
	private String lastName;	
	
	@Column(name="email", length=255)
	private String email;

	public Person() {
		
	}

	public Person(@NotNull int person_id, String firstName, String lastName, String email) {
		this.person_id = person_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getPerson_id() {
		return person_id;
	}

	public void setPerson_id(int person_id) {
		this.person_id = person_id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
