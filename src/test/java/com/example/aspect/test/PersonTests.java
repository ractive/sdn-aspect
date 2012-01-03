package com.example.aspect.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.aspect.domain.EnhancedPersonImpl;
import com.example.aspect.domain.Person;
import com.example.aspect.domain.PersonImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/applicationContext.xml" })
public class PersonTests {
	@Autowired
	private Neo4jTemplate neo4j;
	
	/**
	 * Shows that SDN is set up correctly. {@link PersonImpl} is a default implementation.
	 */
	@Test
	public void persistPersonImpl() {
		PersonImpl p = new PersonImpl();
		p.setName("james");
		p.persist();
		
		PersonImpl loaded = neo4j.findOne(p.getNodeId(), PersonImpl.class);
		assertEquals(p.getNodeId(), loaded.getNodeId());
		assertEquals(p.getName(), loaded.getName());
	}
	
	/**
	 * Shows that a member field that is introduced by an aspect, is not "catched" by the Spring Data Neo4j getter and setter pointcuts. 
	 */
	@Test
	public void persistPerson() {
		Person p = new Person();
		p.setName("james");
		p.persist();
		
		Person loaded = neo4j.findOne(p.getNodeId(), Person.class);
		assertEquals(p.getNodeId(), loaded.getNodeId());
		assertEquals(p.getName(), loaded.getName());
	}
	
	/**
	 * This test <i>should</i> call SDNs persist() in the saveMe() method...
	 */
	@Test
	public void persistEnhancedPersonImpl() {
		EnhancedPersonImpl p = new EnhancedPersonImpl();
		p.setName("james");
		p.saveMe();
		
		EnhancedPersonImpl loaded = neo4j.findOne(p.getNodeId(), EnhancedPersonImpl.class);
		assertEquals(p.getNodeId(), loaded.getNodeId());
		assertEquals(p.getName(), loaded.getName());
	}
}
