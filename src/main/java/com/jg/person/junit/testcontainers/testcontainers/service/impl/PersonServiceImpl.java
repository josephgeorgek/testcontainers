package com.jg.person.junit.testcontainers.testcontainers.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jg.person.junit.testcontainers.testcontainers.controller.exception.NoPersonFoundException;
import com.jg.person.junit.testcontainers.testcontainers.entity.Person;
import com.jg.person.junit.testcontainers.testcontainers.repository.PersonRepository;
import com.jg.person.junit.testcontainers.testcontainers.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Override
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	@Override
	public Person findbyId(Long id) {
		// TODO Auto-generated method stub
		return personRepository.findById(id).get();

	}

	@Override
	public Long create(Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person).getId();
	}
	
	

}
