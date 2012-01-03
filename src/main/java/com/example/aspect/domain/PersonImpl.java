package com.example.aspect.domain;

import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Plain old @NodeEntity with a "normal" implementation. 
 */
@NodeEntity
public class PersonImpl {
	private String name;

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
