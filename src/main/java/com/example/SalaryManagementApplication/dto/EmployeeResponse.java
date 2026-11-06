package com.example.SalaryManagementApplication.dto;

import com.example.SalaryManagementApplication.enums.EmploymentStatus;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class EmployeeResponse {

	private Long id;
	private String employeeCode;
	private String firstName;
	private String lastName;
	private String email;
	private String department;
	private String jobTitle;
	private String country;
	private String currency;
	private BigDecimal salary;
	private EmploymentStatus employmentStatus;
	private LocalDate joinedOn;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
