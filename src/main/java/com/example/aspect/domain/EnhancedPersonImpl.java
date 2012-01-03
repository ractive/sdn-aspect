package com.example.aspect.domain;

import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class EnhancedPersonImpl implements EnhancedPerson {
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
