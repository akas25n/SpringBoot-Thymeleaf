package com.test.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.test.project.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer>{

	

}
