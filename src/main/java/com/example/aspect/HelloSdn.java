package com.example.aspect;

import com.example.aspect.domain.Person;

public class HelloSdn {
	public void helloSdn() {
		Person p = new Person();
		p.setName("james");
		p.persist();
	}
}
