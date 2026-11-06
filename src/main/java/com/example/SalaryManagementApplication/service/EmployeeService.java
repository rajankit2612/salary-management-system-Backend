package com.example.SalaryManagementApplication.service;

import com.example.SalaryManagementApplication.dto.EmployeeRequest;
import com.example.SalaryManagementApplication.dto.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeMapper employeeMapper;

	public EmployeeResponse create(EmployeeRequest request) {
		return employeeMapper.toResponse(request);
	}
}
