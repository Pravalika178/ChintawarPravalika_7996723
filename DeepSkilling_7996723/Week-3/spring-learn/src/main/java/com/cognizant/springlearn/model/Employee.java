package com.cognizant.springlearn.model;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cognizant.springlearn.model.Skill;
import com.cognizant.springlearn.model.Department;
public class Employee {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Employee.class);

    private int id;
    private String name;
    private double salary;
    private boolean permanent;
    private Date dateOfBirth;
    private Department department;
    private List<Skill> skills;

    // Default Constructor
    public Employee() {
        LOGGER.debug("Inside Employee Constructor.");
    }

    // Parameterized Constructor
    public Employee(int id, String name, double salary, boolean permanent,
            Date dateOfBirth, Department department, List<Skill> skills) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.permanent = permanent;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
        this.skills = skills;
    }

    public int getId() {
        LOGGER.debug("Inside getId()");
        return id;
    }

    public void setId(int id) {
        LOGGER.debug("Inside setId()");
        this.id = id;
    }

    public String getName() {
        LOGGER.debug("Inside getName()");
        return name;
    }

    public void setName(String name) {
        LOGGER.debug("Inside setName()");
        this.name = name;
    }

    public double getSalary() {
        LOGGER.debug("Inside getSalary()");
        return salary;
    }

    public void setSalary(double salary) {
        LOGGER.debug("Inside setSalary()");
        this.salary = salary;
    }

    public boolean isPermanent() {
        LOGGER.debug("Inside isPermanent()");
        return permanent;
    }

    public void setPermanent(boolean permanent) {
        LOGGER.debug("Inside setPermanent()");
        this.permanent = permanent;
    }

    public Date getDateOfBirth() {
        LOGGER.debug("Inside getDateOfBirth()");
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        LOGGER.debug("Inside setDateOfBirth()");
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        LOGGER.debug("Inside getDepartment()");
        return department;
    }

    public void setDepartment(Department department) {
        LOGGER.debug("Inside setDepartment()");
        this.department = department;
    }

    public List<Skill> getSkills() {
        LOGGER.debug("Inside getSkills()");
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        LOGGER.debug("Inside setSkills()");
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id
                + ", name=" + name
                + ", salary=" + salary
                + ", permanent=" + permanent
                + ", dateOfBirth=" + dateOfBirth
                + ", department=" + department
                + ", skills=" + skills + "]";
    }
}