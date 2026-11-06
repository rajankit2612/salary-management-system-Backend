# Design notes

- `EmploymentStatus` (`ACTIVE`, `ON_LEAVE`, `TERMINATED`) is nested on `Employee`. Request and response reuse it. The client does not send `id`, `employeeCode`, `createdAt`, or `updatedAt`.
- Request string limits match the planned columns. Salary is `BigDecimal`, greater than 0, with at most 12 digits before the decimal and 2 after. Omitted status defaults to `ACTIVE`. `joinedOn` cannot be in the future.
- `createdAt` and `updatedAt` are filled in `@PrePersist` and `@PreUpdate`. The JPA API is on the classpath so the entity compiles; no datasource is configured yet.
