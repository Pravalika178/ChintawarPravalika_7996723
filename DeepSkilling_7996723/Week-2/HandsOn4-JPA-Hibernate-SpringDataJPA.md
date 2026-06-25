# Difference Between JPA, Hibernate and Spring Data JPA

## JPA (Java Persistence API)

- JPA is a specification (JSR 338).
- It defines standards for ORM.
- It does not provide implementation.
- It provides annotations such as:
  - @Entity
  - @Table
  - @Id
  - @Column

Example:
@Entity
public class Employee {
}

---

## Hibernate

- Hibernate is an ORM framework.
- Hibernate implements JPA.
- Converts Java objects to database tables.
- Provides SessionFactory, Session, Transaction APIs.

Example:

Session session = factory.openSession();
Transaction tx = session.beginTransaction();
session.save(employee);
tx.commit();

---

## Spring Data JPA

- Built on top of JPA.
- Uses Hibernate internally.
- Reduces boilerplate code.
- Provides JpaRepository.

Example:

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee,Integer> {
}

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public void addEmployee(Employee employee){
        repository.save(employee);
    }
}

---

## Comparison Table

| Feature | JPA | Hibernate | Spring Data JPA |
|----------|----------|----------|----------|
| Type | Specification | Framework | Abstraction |
| Implementation | No | Yes | No |
| ORM Support | Standard | Yes | Uses Hibernate |
| Boilerplate Code | Medium | High | Low |
| Transactions | Manual | Manual | Managed |
| Repository Support | No | No | Yes |

---

## Conclusion

JPA is a specification.
Hibernate is an implementation of JPA.
Spring Data JPA is an abstraction layer over Hibernate that reduces coding effort.