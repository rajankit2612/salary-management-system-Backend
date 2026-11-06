# AI usage

## Folder structure

Prompt: ignore versions and database integration; create the folder structure only.

Created empty classes under `com.example.SalaryManagementApplication` (controller, service, repository, dto, entity, and matching tests), plus `application.yml`, `db/migration/V1__create_employee_table.sql`, and `docs/`. No business logic, schema, datasource, or dependency changes. The existing `SalaryManagementApplication` main class stays the entry point. Package `com.acme.salary` was removed.

## DTO and entity

Prompt: implement the DTO and entity.

Filled `Employee`, `EmployeeRequest`, and `EmployeeResponse`. Added `spring-boot-starter-validation` and `jakarta.persistence-api`. Did not add a datasource, Flyway SQL, or the data-jpa starter.
