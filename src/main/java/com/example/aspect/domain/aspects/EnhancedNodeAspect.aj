package com.example.aspect.domain.aspects;

import com.example.aspect.domain.EnhancedNode;
import com.example.aspect.domain.EnhancedNodeEntity;
import org.springframework.data.neo4j.aspects.core.NodeBacked;


public aspect EnhancedNodeAspect {
	// Create an interface that both extends from EnhancesPerson and NodeBacked
	// and make all classes that have an @EnhancesNodeEntity annotation implement this interface
	private interface EnhancedNodeBacked extends EnhancedNode, NodeBacked {};

	declare parents: (@EnhancedNodeEntity *) implements EnhancedNodeBacked;

	public void EnhancedNodeBacked.saveMe() {
		this.persist();
	}
}
