package com.challenge.api.service.impl;

import com.challenge.api.model.Employee;
import com.challenge.api.service.EmployeeService;

import java.util.List;
import java.util.UUID;

public class EmployeeServiceImpl implements EmployeeService {
   @Override
   public List<Employee> getAllEmployees(){
       return null;
   }

   @Override
   public Employee getEmployeeByUUID(UUID uuid){
       return null;
   }

   @Override
    public Employee createEmployee(Employee employee){
       return employee;
   }

}
