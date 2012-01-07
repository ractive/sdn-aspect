package com.example.aspect.domain.aspects;

import com.example.aspect.domain.EnhancedNode;
import com.example.aspect.domain.EnhancedNodeEntity;
import java.util.Set;

import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;
import org.springframework.data.neo4j.aspects.core.NodeBacked;

import com.example.aspect.domain.EnhancedPersonImpl;

public aspect EnhancedPersonAspect {
	// Create an interface that both extends from EnhancesPerson and NodeBacked
	// and make all classes that have an @EnhancesNodeEntity annotation implement this interface
	private interface EnhancedNodeBacked extends EnhancedNode, NodeBacked {};

	declare parents: (@EnhancedNodeEntity *) implements EnhancedNodeBacked;

	@RelatedTo(elementClass=EnhancedPersonImpl.class)
	private Set<EnhancedPersonImpl> EnhancedNodeBacked.friends;
	
	public void EnhancedNodeBacked.saveMe() {
		this.persist();
	}
	
	public void EnhancedNodeBacked.addFriend(EnhancedPersonImpl person) {
		this.friends.add(person);
	}
}
