package com.management.employee.Repository;

import com.management.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends  CrudRepository<Employee,Integer>
{


}




