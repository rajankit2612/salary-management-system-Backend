package com.example.SalaryManagementApplication.service;

import com.example.SalaryManagementApplication.dto.EmployeeRequest;
import com.example.SalaryManagementApplication.dto.EmployeeResponse;
import com.example.SalaryManagementApplication.enums.EmploymentStatus;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

	@Autowired
	private Validator validator;

	public EmployeeResponse toResponse(EmployeeRequest request) {
		if (request == null) {
			throw new IllegalArgumentException("Employee request is required");
		}
		normalize(request);
		validate(request);
		return map(request);
	}

	public void normalize(EmployeeRequest request) {
		request.setFirstName(trim(request.getFirstName()));
		request.setLastName(trim(request.getLastName()));
		request.setDepartment(trim(request.getDepartment()));
		request.setJobTitle(trim(request.getJobTitle()));
		request.setCountry(trim(request.getCountry()));
		request.setCurrency(trim(request.getCurrency()));
		String email = trim(request.getEmail());
		request.setEmail(email == null ? null : email.toLowerCase(Locale.ROOT));
		if (request.getEmploymentStatus() == null) {
			request.setEmploymentStatus(EmploymentStatus.ACTIVE);
		}
	}

	public void validate(EmployeeRequest request) {
		Set<ConstraintViolation<EmployeeRequest>> violations = validator.validate(request);
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}

	private EmployeeResponse map(EmployeeRequest request) {
		LocalDateTime now = LocalDateTime.now();
		EmployeeResponse response = new EmployeeResponse();
		response.setFirstName(request.getFirstName());
		response.setLastName(request.getLastName());
		response.setEmail(request.getEmail());
		response.setDepartment(request.getDepartment());
		response.setJobTitle(request.getJobTitle());
		response.setCountry(request.getCountry());
		response.setCurrency(request.getCurrency());
		response.setSalary(request.getSalary());
		response.setEmploymentStatus(request.getEmploymentStatus());
		response.setJoinedOn(request.getJoinedOn());
		response.setCreatedAt(now);
		response.setUpdatedAt(now);
		return response;
	}

	private String trim(String value) {
		return value == null ? null : value.trim();
	}
}
