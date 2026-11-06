# Design notes

- `EmploymentStatus` (`ACTIVE`, `ON_LEAVE`, `TERMINATED`) lives in the `enums` package. Request and response reuse it. The client does not send `id`, `employeeCode`, `createdAt`, or `updatedAt`.
- Entity and DTOs use Lombok `@Data` for getters, setters, `equals`, `hashCode`, and `toString`.
- Request string limits match the planned columns. Salary is `BigDecimal`, greater than 0, with at most 12 digits before the decimal and 2 after. Omitted status defaults to `ACTIVE`. `joinedOn` cannot be in the future.
- `createdAt` and `updatedAt` are filled in `@PrePersist` and `@PreUpdate`. The JPA API is on the classpath so the entity compiles; no datasource is configured yet.
- `POST /api/employees` returns 201 with `EmployeeResponse` after validation. `id`, `employeeCode`, and the `Location` header wait until a row is stored. Duplicate email is checked once the database exists.
- Controller and service use `@Autowired` fields. Trim, email lowercasing, default status, bean validation, and response mapping live in `EmployeeMapper`.
