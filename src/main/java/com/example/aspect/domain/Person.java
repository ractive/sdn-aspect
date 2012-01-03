package com.example.aspect.domain;

import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Uses an aspect to introduce a member "name" and its setter and getter.
 * <p>
 * The problem is that SDN's pointcuts that match all setters and getters do not match the introduced ones.
 */
@NodeEntity
public class Person implements Nameable {

}
