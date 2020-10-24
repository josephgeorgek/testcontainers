package com.jg.person.junit.testcontainers.testcontainers.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jg.person.junit.testcontainers.testcontainers.entity.Person;


public interface PersonService {
	
	List<Person> findAll();
	Person findbyId(Long id);
	Long create(Person person);
	

}
