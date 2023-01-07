package com.crud.springbootCrud.service;

import com.crud.springbootCrud.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployeeByID(long id);

    Employee updateEmployee(Employee employee, long id);

    public void deleteEmployeeByID(long id);
}