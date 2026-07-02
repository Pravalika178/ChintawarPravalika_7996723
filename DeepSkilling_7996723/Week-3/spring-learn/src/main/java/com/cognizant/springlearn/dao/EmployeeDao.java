package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Employee;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeDao.class);

    private static ArrayList<Employee> EMPLOYEE_LIST;

    @SuppressWarnings("unchecked")
    public EmployeeDao() {

        LOGGER.info("START");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        EMPLOYEE_LIST =
                (ArrayList<Employee>) context.getBean("employeeList");

        context.close();

        LOGGER.debug("Employee List Loaded : {}", EMPLOYEE_LIST);

        LOGGER.info("END");
    }

    public List<Employee> getAllEmployees() {

        LOGGER.info("START");

        LOGGER.debug("Employees : {}", EMPLOYEE_LIST);

        LOGGER.info("END");

        return EMPLOYEE_LIST;
    }
}