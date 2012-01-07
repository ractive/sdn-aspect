package com.example.aspect.domain.aspects;

import org.springframework.data.neo4j.aspects.core.NodeBacked;

import com.example.aspect.domain.EnhancedPerson;

public aspect EnhancedPersonAspect {
	public void EnhancedPerson.saveMe() {
		// How to get rid of the cast here?
		//
		// When "EnhancedPerson extends NodeBacked", an java.lang.AbstractMethodError happens:
		// java.lang.AbstractMethodError
		//    at org.springframework.data.neo4j.support.mapping.EntityStateHandler.getPersistentState(EntityStateHandler.java:82)
		//    at org.springframework.data.neo4j.support.mapping.Neo4jEntityPersister.getPersistentState(Neo4jEntityPersister.java:218)
		//    ...
		((NodeBacked)this).persist();
	}
}
