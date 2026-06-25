package com.example.ems.projection;

public interface EmployeeView {

    Long getId();

    String getName();

    String getEmail();

    DepartmentInfo getDepartment();

    interface DepartmentInfo {
        String getName();
    }
}