# AI usage

## Folder structure

Prompt: ignore versions and database integration; create the folder structure only.

Created empty classes under `com.example.SalaryManagementApplication` (controller, service, repository, dto, entity, and matching tests), plus `application.yml`, `db/migration/V1__create_employee_table.sql`, and `docs/`. No business logic, schema, datasource, or dependency changes. The existing `SalaryManagementApplication` main class stays the entry point. Package `com.acme.salary` was removed.

## DTO and entity

Prompt: implement the DTO and entity.

Filled `Employee`, `EmployeeRequest`, and `EmployeeResponse`. Added `spring-boot-starter-validation` and `jakarta.persistence-api`. Did not add a datasource, Flyway SQL, or the data-jpa starter.

## Lombok and enum package

Prompt: create a separate folder for the enum, integrate Lombok, and replace getters and setters with `@Data`.

Moved `EmploymentStatus` to `enums`. Added the Lombok dependency and `@Data` on `Employee`, `EmployeeRequest`, and `EmployeeResponse`. Removed the handwritten getters and setters.

## Temporary create endpoint

Prompt: add a POST API that returns true after receiving the client request. Database comes later.

`POST /api/employees` accepts `EmployeeRequest` and returns `true`. No service or database call.

## Create through the service

Prompt: implement the controller and service with `ResponseEntity`, HTTP status, and validation. Do not write tests.

`EmployeeController.create` calls `EmployeeService.create` and returns 201 with `EmployeeResponse`. The service trims text, lowercases email, defaults status to `ACTIVE`, and runs bean validation. `GlobalExceptionHandler` returns 400 with field errors, 400 for a bad body, and 500 without a stack trace. Nothing is stored.

## Autowired and mapper

Prompt: use `@Autowired` instead of constructors, and move normalization, trim, response mapping, and custom validation into a separate file.

Replaced constructor injection in `EmployeeController` and `EmployeeService`. Added `EmployeeMapper` for trim, email lowercasing, default status, validation, and `EmployeeResponse` mapping.
