package com.crud.springbootCrud.repository;

import com.crud.springbootCrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}