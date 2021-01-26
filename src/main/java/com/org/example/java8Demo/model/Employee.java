package com.org.example.java8Demo.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {
	@Id
	@GeneratedValue
	@EqualsAndHashCode.Include
	private UUID employeeId;
    
	private String name;
     
	private int age;
     
	private String gender;
	
	private double salary;
     
	private String department;
     
	private LocalDateTime dateOfJoining;
	
	private String desgination;
	
	private String experience;
}
