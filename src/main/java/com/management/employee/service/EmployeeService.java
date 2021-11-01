package com.management.employee.service;

import com.management.employee.Repository.EmployeeRepository;
import com.management.employee.model.Employee;
import com.management.employee.rest.json.EmployeeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employees::add);
        return employees;
    }

    public Optional<Employee> getEmployeeById(int empId) {
        return employeeRepository.findById(empId);
    }

    public void saveOrUpdate(EmployeeJson employeeJson, int empId) {
        Employee existingEmployee = getEmployeeById(empId)
                .orElseThrow(() -> new RuntimeException("Employee Not found"));
        existingEmployee.setEmpDesignation(employeeJson.getEmpDesignation());
        existingEmployee.setEmpName(employeeJson.getEmpName());
        existingEmployee.setEmpEmail(employeeJson.getEmpEmail());
        employeeRepository.save(existingEmployee);
    }


    public void delete(int empId) {
        getEmployeeById(empId)
                .orElseThrow(() -> new RuntimeException("Employee Not found"));
        employeeRepository.deleteById(empId);

    }

    public void save(EmployeeJson employeeJson) {
        Employee employee = new Employee();
        employee.setEmpId(employeeJson.getEmpId());
        employee.setEmpEmail(employeeJson.getEmpEmail());
        employee.setEmpName(employeeJson.getEmpName());
        employee.setEmpDesignation(employeeJson.getEmpDesignation());
        employeeRepository.save(employee);
    }


}


