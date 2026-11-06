package com.example.SalaryManagementApplication.dto;

import com.example.SalaryManagementApplication.enums.EmploymentStatus;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;

@Data
public class EmployeeRequest {

	@NotBlank
	@Size(max = 100)
	private String firstName;

	@NotBlank
	@Size(max = 100)
	private String lastName;

	@NotBlank
	@Email
	@Size(max = 255)
	private String email;

	@NotBlank
	@Size(max = 80)
	private String department;

	@NotBlank
	@Size(max = 100)
	private String jobTitle;

	@NotBlank
	@Size(max = 80)
	private String country;

	@NotBlank
	@Pattern(regexp = "[A-Z]{3}")
	private String currency;

	@NotNull
	@Positive
	@Digits(integer = 12, fraction = 2)
	private BigDecimal salary;

	@NotNull
	private EmploymentStatus employmentStatus = EmploymentStatus.ACTIVE;

	@NotNull
	@PastOrPresent
	private LocalDate joinedOn;
}
