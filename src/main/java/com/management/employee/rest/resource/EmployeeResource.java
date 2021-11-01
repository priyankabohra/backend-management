package com.management.employee.rest.resource;


import com.management.employee.model.Employee;
import com.management.employee.rest.json.EmployeeJson;
import com.management.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class EmployeeResource {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    private ResponseEntity<List<Employee>> getAllEmployee() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/employee/{empId}")
    private ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId) {
        return new ResponseEntity<>(employeeService.getEmployeeById(empId)
                .orElseThrow(() -> new RuntimeException("Employee Not Found")), HttpStatus.OK);
    }

    @DeleteMapping("/employee/{empId}")
    private ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("empId") int empId) {
        employeeService.delete(empId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/employee/{empId}")
    private ResponseEntity<HttpStatus> update(@PathVariable("empId") int empId, @RequestBody EmployeeJson employeeJson) {
        employeeService.saveOrUpdate(employeeJson, empId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/employee")
    private ResponseEntity<HttpStatus> saveEmployee(@RequestBody EmployeeJson employeeJson) {
        employeeService.save(employeeJson);
        return new ResponseEntity<>(HttpStatus.CREATED);


    }
}



