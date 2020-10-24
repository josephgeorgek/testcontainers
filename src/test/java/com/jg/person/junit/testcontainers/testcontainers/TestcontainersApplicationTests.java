package com.jg.person.junit.testcontainers.testcontainers;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.jg.person.junit.testcontainers.testcontainers.entity.Person;
import com.jg.person.junit.testcontainers.testcontainers.service.PersonService;




@Testcontainers
@SpringBootTest
public class TestcontainersApplicationTests {

	
	@Autowired
	PersonService personService;
	
	@Autowired
	public TestRestTemplate testRestTemplate;

	 @Container
	  public static PostgreSQLContainer container = new PostgreSQLContainer()
	    .withPassword("lord")
	    .withUsername("save");

	 @DynamicPropertySource
	  static void properties(DynamicPropertyRegistry registry) {
	    registry.add("spring.datasource.url", container::getJdbcUrl);
	    registry.add("spring.datasource.password", container::getPassword);
	    registry.add("spring.datasource.username", container::getUsername);
	  }

	
	 
	@Test
	public void contextLoads() {
		Person person = new Person();
		person.setName("Duke");

		personService.create(person);

		assertTrue(personService.findbyId((long) 1).getName().contains("Duke"));

		assertEquals(1, personService.findAll().size());
		
		Person requestBody = new Person();
		 requestBody.setName("Joseph1");
		 ResponseEntity<Person> response=  testRestTemplate.postForEntity("/api/persons", requestBody, Person.class);
			
			assertNotNull(response);

	}
}



