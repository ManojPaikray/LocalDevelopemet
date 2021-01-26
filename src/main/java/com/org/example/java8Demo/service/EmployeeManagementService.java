package com.org.example.java8Demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.org.example.java8Demo.model.Employee;

public interface EmployeeManagementService {
	public Employee createEmployee(Employee employee);
	public List<Employee> fetchTopNthEmployee(int size);
	public int[] print(int startInclusive, int endExclusive);
	public Stream<LocalDate> getNextWeekWorkingDays();
	public List<Employee> getEmployeeDetailsBasedOnJoiningDate(String joiningDate);
	public Map<String, List<Employee>> categorizeEmployee();
	public List<Employee> getDNACCandidate();
}
