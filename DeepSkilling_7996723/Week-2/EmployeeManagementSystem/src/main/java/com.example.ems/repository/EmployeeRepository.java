package com.example.ems.repository;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeView;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);

    List<Employee> findByDepartmentName(String departmentName);

    Page<Employee> findAll(Pageable pageable);

    List<EmployeeView> findBy();

    List<EmployeeView> findAllProjectedBy();

    @Query("SELECT e FROM Employee e WHERE e.email=?1")
    Employee getEmployeeByEmail(String email);
}