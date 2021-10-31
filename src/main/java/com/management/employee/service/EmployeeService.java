package com.management.employee.service;

import com.management.employee.Repository.EmployeeRepository;
import com.management.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        List<Employee> employee = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employee1 -> employee.add(employee1));
        return employee;
    }
       public Employee getEmployeeById(int empId)
       {
            return employeeRepository.findById(empId).get();
        }

        public void saveOrUpdate(Employee employee)
        {
            employeeRepository.save(employee);
        }

        //deleting a specific record by using the method deleteById() of CrudRepository
        public  void delete(int empId) {
            employeeRepository.deleteById(empId);

        }

        public void save(Employee employee) {
            employeeRepository.save(employee);
        }


}


