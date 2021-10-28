package com.management.employee.rest.resource;


import com.management.employee.Repository.EmployeeRepository;
import com.management.employee.model.Employee;
import com.management.employee.rest.json.EmployeeJson;
import com.management.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
public class EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    private List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employee/{empid}")
    private Employee getEmployee(@PathVariable("empid") int empid) {
        return employeeService.getEmployeeById(empid);
    }

    @DeleteMapping("/employee/{empid}")
    private void deleteEmployee(@PathVariable("empid") int empid) {
        employeeService.delete(empid);
    }

    @PutMapping("/employee")
    private String update(@RequestBody EmployeeJson employeeJson) {
        Employee existingEmployee = employeeRepository.findById(employeeJson.getEmpId())
                .orElseThrow(() -> new RuntimeException("Employee Not found"));
        existingEmployee.setEmpDesignation(employeeJson.getEmpDesignation());
        existingEmployee.setEmpName(employeeJson.getEmpName());
        existingEmployee.setEmpEmail(employeeJson.getEmpEmail());
        employeeService.saveOrUpdate(existingEmployee);
        return "Suceess";
    }

    @PostMapping("/employee")
    private String saveEmployee(@RequestBody EmployeeJson employeeJson) {
        Employee employee = new Employee();
        employee.setEmpId(employeeJson.getEmpId());
        employee.setEmpEmail(employeeJson.getEmpEmail());
        employee.setEmpName(employeeJson.getEmpName());
        employee.setEmpDesignation(employeeJson.getEmpDesignation());
        employeeService.save(employee);
        return "Success";


    }
}



