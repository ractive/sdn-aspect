package com.example.aspect.domain.aspects;

import com.example.aspect.domain.Nameable;

public aspect NameableAspect {
	private String Nameable.name;
	
	public void Nameable.setName(String name) {
		this.name = name;
	}
	
	public String Nameable.getName() {
		return this.name;
	}
}
