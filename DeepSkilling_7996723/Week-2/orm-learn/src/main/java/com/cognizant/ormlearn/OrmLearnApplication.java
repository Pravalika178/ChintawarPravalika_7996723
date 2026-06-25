package com.cognizant.ormlearn;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.service.EmployeeService;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private final EmployeeService employeeService;

    public OrmLearnApplication(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrmLearnApplication.class, args);
    }

    @Override
    public void run(String... args) {

        testGetAllPermanentEmployees();
    }

    private void testGetAllPermanentEmployees() {

        List<Employee> employees =
                employeeService.getAllPermanentEmployees();

        System.out.println("Permanent Employees");

        employees.forEach(System.out::println);

        employees.forEach(
                e -> System.out.println(e.getSkillList())
        );
    }
}