package com.crud.springbootCrud.service.imp;

import com.crud.springbootCrud.exception.NoDataFoundException;
import com.crud.springbootCrud.model.Employee;
import com.crud.springbootCrud.repository.EmployeeRepo;
import com.crud.springbootCrud.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImp(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployeeByID(long id) {
       /* Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        else throw new NoDataFoundException("Employee","Id",id);*/

        return employeeRepo.findById(id).orElseThrow(()-> new NoDataFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        Employee employee1 = employeeRepo.findById(id).orElseThrow(()-> new NoDataFoundException("Employee","Id",id));
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        employeeRepo.save(employee1);
        return employee1;

    }

    @Override
    public void deleteEmployeeByID(long id) {
         employeeRepo.deleteById(id);
    }


}