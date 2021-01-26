package com.org.example.java8Demo.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EmployeeResponseDto {
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
