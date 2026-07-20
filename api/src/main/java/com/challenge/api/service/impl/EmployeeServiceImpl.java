package com.challenge.api.service.impl;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import com.challenge.api.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    /**
     * @implNote Used Concurrent Hash Map to store employees.
     * Chose to do so because multiple HTTP requests can come in at once.
     * Normal Hash Map doesn't account for concurrency, and this does!
     */
    private final Map<UUID, Employee> employeeMap = new ConcurrentHashMap<>();

    /**
     * @implNote Constructor automatically creates some mock employees for testing.
     */
    public EmployeeServiceImpl(){
        createMockEmployee("Nicoletta", "Beltrante", "Associate Software Engineer", 60000, 25);
        createMockEmployee("Bruce", "Wayne", "CEO", 1000000, 32);
        createMockEmployee("Peter", "Parker", "Journalist", 55000, 19);
    }

    /**
     * Helper method to create mock employees to test API with.
     * @implNote All params are values that cannot be generated from other params.
     * @implNote I have email generating from first and last name, and hire date will be now temporarily.
     * @param firstName Employee's first name
     * @param lastName Employee's last name
     * @param title Employee's job title
     * @param salary Employee's salary
     * @param age Employee's age
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

    /**
     * @implNote  used ArrayList, since just using .values() with
     * HashMap returns a Collection.
     * @return List of all employees within company
     */
    @Override
   public List<Employee> getAllEmployees(){
       return new ArrayList<>(employeeMap.values());
   }

    /**
     * @param uuid UUID of desired employee
     * @return Employee
     */
   @Override
   public Employee getEmployeeByUuID(UUID uuid){
       Employee targetEmployee = employeeMap.get(uuid);
       if (targetEmployee == null) {
           throw new RuntimeException("Employee not found: " + uuid);
       }
       return targetEmployee;
   }

    /**
     *
     * @param employee Employee to be created
     * @return Employee that was created
     */
   @Override
    public Employee createEmployee(Employee employee){
        employee.setUuid(UUID.randomUUID());
        employeeMap.put(employee.getUuid(), employee);
        return employee;
   }

}
