package com.example.SalaryManagementApplication.controller;

import com.example.SalaryManagementApplication.dto.EmployeeRequest;
import com.example.SalaryManagementApplication.dto.EmployeeResponse;
import com.example.SalaryManagementApplication.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping
	public ResponseEntity<EmployeeResponse> create(@Valid @RequestBody EmployeeRequest request) {
		EmployeeResponse created = employeeService.create(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(created);
	}
}
