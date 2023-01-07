package com.crud.springbootCrud.controller;

import com.crud.springbootCrud.model.Employee;
import com.crud.springbootCrud.repository.EmployeeRepo;
import com.crud.springbootCrud.service.imp.EmployeeServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/emp")
public class EmployeeController {
    private EmployeeServiceImp employeeServiceImp;
    private final EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeServiceImp employeeServiceImp,
                              EmployeeRepo employeeRepo) {
        this.employeeServiceImp = employeeServiceImp;
        this.employeeRepo = employeeRepo;
    }
    @PostMapping("/addEmp")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeServiceImp.saveEmployee(employee), HttpStatus.CREATED);
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeServiceImp.getAllEmployee();
    }
    @GetMapping("/employees/{id}")
   public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeServiceImp.getEmployeeByID(employeeId),HttpStatus.OK);
    }
   @PutMapping("/employees/{id}")
    public ResponseEntity<Employee>updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeServiceImp.updateEmployee(employee,id),HttpStatus.OK);
   }
   @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable("id") long employeeId){
      employeeServiceImp.deleteEmployeeByID(employeeId);
      }
}