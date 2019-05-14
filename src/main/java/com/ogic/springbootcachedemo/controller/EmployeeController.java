package com.ogic.springbootcachedemo.controller;

import com.ogic.springbootcachedemo.bean.Employee;
import com.ogic.springbootcachedemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp/{id}")
    public Employee getEmpById(@PathVariable("id") Integer id){
        return employeeService.getEmpById(id);
    }

    @GetMapping("/emp")
    public Employee updateEmp(Employee employee){
        employeeService.updateEmp(employee);
        return employee;
    }
}
