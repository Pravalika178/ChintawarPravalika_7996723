package com.cognizant.springlearn.model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Department {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Department.class);

    private int id;
    private String name;

    // Default Constructor
    public Department() {
        LOGGER.debug("Inside Department Constructor.");
    }

    // Parameterized Constructor
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}