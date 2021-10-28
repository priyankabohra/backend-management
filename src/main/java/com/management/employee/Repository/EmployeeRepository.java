package com.management.employee.Repository;
import com.management.employee.model.Employee;
import  com.management.employee.rest.resource.EmployeeResource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends  CrudRepository<Employee,Integer>
{


}




