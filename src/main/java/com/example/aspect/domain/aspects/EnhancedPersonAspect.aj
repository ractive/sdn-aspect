package com.example.aspect.domain.aspects;

import com.example.aspect.domain.EnhancedPerson;

public aspect EnhancedPersonAspect {
	public void EnhancedPerson.saveMe() {
		System.out.println("ASPECTJ!!!!");
		// How to call...
		// this.persist();
		// ???
	}
}
