package com.cognizant.springlearn.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.dao.EmployeeDao;

@Service
public class EmployeeService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeDao employeeDao;
    public List<Employee> getAllEmployees() {
    return employeeDao.getAllEmployees();
    }
}