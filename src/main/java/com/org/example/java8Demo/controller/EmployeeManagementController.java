package com.org.example.java8Demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.example.java8Demo.dto.DnacCandidate;
import com.org.example.java8Demo.dto.EmployeeDto;
import com.org.example.java8Demo.dto.EmployeeResponseDto;
import com.org.example.java8Demo.model.Employee;
import com.org.example.java8Demo.service.EmployeeManagementService;

@RestController
public class EmployeeManagementController {
	@Autowired
	private EmployeeManagementService employeeManagementService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping("/create/employee")
	public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
		return ResponseEntity.ok(mapper.map(employeeManagementService.createEmployee(mapper.map(employeeDto, Employee.class)), EmployeeResponseDto.class));
	}
	
	@GetMapping("fetch/top/nth/employee")
	public ResponseEntity<List<Employee>> fetchTopNthEmployee(@RequestParam int size) {
		return ResponseEntity.ok(employeeManagementService.fetchTopNthEmployee(size));
	}
	
	@GetMapping("/get/employee/details")
	public ResponseEntity<List<Employee>> getEmployeeDetailsBasedOnJoiningDate(String joiningDate) {
		return ResponseEntity.ok(employeeManagementService.getEmployeeDetailsBasedOnJoiningDate(joiningDate));
	}
	
	@GetMapping("/print")
	public ResponseEntity<int[]> print(@RequestParam int startInclusive, @RequestParam int endExclusive) {
		return ResponseEntity.ok(employeeManagementService.print(startInclusive, endExclusive));
	}
	
	@GetMapping("/get/next/weekdays")
	public ResponseEntity<Stream<LocalDate>> getNextWeekWorkingDays() {
		return ResponseEntity.ok(employeeManagementService.getNextWeekWorkingDays());
	}
	
	@GetMapping("/categorize/employee")
	public ResponseEntity<Map<String, List<Employee>>> categorizeEmployee() {
		return ResponseEntity.ok(employeeManagementService.categorizeEmployee());
	}
	
	@GetMapping("/get/dnac/candidate")
	public ResponseEntity<List<DnacCandidate>> getDNACCandidate() {
		
		return ResponseEntity.ok(mapper.map(employeeManagementService.getDNACCandidate(), new TypeToken<List<DnacCandidate>>(){}.getType()));
	}
}
