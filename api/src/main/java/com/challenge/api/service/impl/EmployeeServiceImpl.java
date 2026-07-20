package com.challenge.api.service.impl;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import com.challenge.api.service.EmployeeService;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class EmployeeServiceImpl implements EmployeeService {

    /**
     * Used Concurrent Hash Map to store employees.
     * Chose to do so because multiple HTTP requests can come in at once.
     * Normal Hash Map doesn't account for concurrency, and this does!
     */
    private final Map<UUID, Employee> employeeMap = new ConcurrentHashMap<>();

    /**
     * Constructor automatically creates some mock employees for testing.
     */
    public EmployeeServiceImpl(){
        createMockEmployee("Nicoletta", "Beltrante", "Associate Software Engineer", 60000, 25);
        createMockEmployee("Bruce", "Wayne", "CEO", 1000000, 32);
        createMockEmployee("Peter", "Parker", "Journalist", 55000, 19);
    }

    /**
     * Helper method to create mock employees to test API with.
     * All params are values that cannot be generated from other params.
     * @param firstName     Employee's first name
     * @param lastName      Employee's last name
     * @param title         Employee's job title
     * @param salary        Employee's salary
     * @param age           Employee's age
     * I have email generating from first and last name, and hire date will be now temporarily.
     */
    private void createMockEmployee(String firstName, String lastName, String title, int salary, int age) {
        Employee emp = new EmployeeImpl();
        emp.setUuid(UUID.randomUUID());
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setFullName(firstName + " " + lastName);
        emp.setSalary(salary);
        emp.setAge(age);
        emp.setJobTitle(title);
        emp.setEmail(firstName + "_" + lastName + "@companyname.com");
        emp.setContractHireDate(Instant.now());
        employeeMap.put(emp.getUuid(), emp);
    }

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
