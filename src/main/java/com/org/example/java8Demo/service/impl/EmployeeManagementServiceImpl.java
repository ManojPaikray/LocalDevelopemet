package com.org.example.java8Demo.service.impl;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.example.java8Demo.dto.DnacCandidate;
import com.org.example.java8Demo.model.Employee;
import com.org.example.java8Demo.repository.EmployeeRepository;
import com.org.example.java8Demo.service.EmployeeManagementService;

@Service
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee createEmployee(Employee employee) {
		employee.setDateOfJoining(LocalDateTime.now());
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchTopNthEmployee(int size) {
		Iterable<Employee> employees = employeeRepository.findAll();
		List<Employee> empList= ((Collection<Employee>) employees).stream().sorted((e1, e2) -> e2.getDateOfJoining().compareTo(e1.getDateOfJoining())).limit(size).collect(Collectors.toList());
		
		return empList;
	}
	
	@Override
	public int[] print(int startInclusive, int endExclusive) {
		return IntStream.range(1, 100).toArray();
	}

	@Override
	public Stream<LocalDate> getNextWeekWorkingDays() {
		DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();
		
		switch (dayOfWeek) {
	      case THURSDAY: {
	    	  return print(LocalDate.now().plusDays(4));
	      }
	      case FRIDAY: {
	    	  return print(LocalDate.now().plusDays(3));
	      }
	      case SATURDAY: {
	    	  return print(LocalDate.now().plusDays(2));
	      }
	      case SUNDAY: {
	    	  return print(LocalDate.now().plusDays(1));
	      }
	      case MONDAY: {
	    	  return print(LocalDate.now().plusDays(7));
	      }
	      case TUESDAY: {
	    	  return print(LocalDate.now().plusDays(6));
	      }
	      case WEDNESDAY: {
	    	  return print(LocalDate.now().plusDays(5));
	      }
		default:
			break;
	    }
		return null;
	}
	
	public  Stream<LocalDate> print(LocalDate date) { 
		//IntStream.range(0, 5).filter(n -> { System.out.println("Working day: " + date.plusDays(n))
		return IntStream.range(0, 5).mapToObj(n -> date.plusDays(n));
	}

	@Override
	public List<Employee> getEmployeeDetailsBasedOnJoiningDate(String joiningDate) {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return employees.stream().filter(e -> e.getDateOfJoining().format(dateTimeFormatter).equalsIgnoreCase(joiningDate)).collect(Collectors.toList());
	}

	@Override
	public Map<String, List<Employee>> categorizeEmployee() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		
		Map<String, List<Employee>> e = employees.stream().collect(Collectors.groupingBy(Employee::getDesgination));
		return e;
	}

	@Override
	public List<Employee> getDNACCandidate() {
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		
		return employees.stream().filter(e -> Double.valueOf(e.getExperience()) > Double.valueOf(7) ).collect(Collectors.toList());
	}
}
