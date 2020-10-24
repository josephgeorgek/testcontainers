package com.jg.person.junit.testcontainers.testcontainers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jg.person.junit.testcontainers.testcontainers.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
	
	

}
