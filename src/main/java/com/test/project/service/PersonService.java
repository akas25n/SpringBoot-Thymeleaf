package com.test.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.project.entity.Person;
import com.test.project.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepo;
	

	
	public Person savePerson(Person person) {
		person.setFirstName(person.getFirstName());
		person.setLastName(person.getLastName());
		person.setEmail(person.getEmail());
		
		return personRepo.save(person);
	}
	
}
