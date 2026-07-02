package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;

@Repository
public class DepartmentDao {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentDao.class);

    private static ArrayList<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {

        LOGGER.info("START");

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        DEPARTMENT_LIST =
                (ArrayList<Department>) context.getBean("departmentList");

        context.close();

        LOGGER.debug("Department List Loaded : {}", DEPARTMENT_LIST);

        LOGGER.info("END");
    }

    public List<Department> getAllDepartments() {

        LOGGER.info("START");

        LOGGER.debug("Departments : {}", DEPARTMENT_LIST);

        LOGGER.info("END");

        return DEPARTMENT_LIST;
    }
}