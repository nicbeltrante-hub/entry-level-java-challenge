package com.challenge.api.model;

import java.time.Instant;
import java.util.UUID;

public class EmployeeImpl implements Employee {

    private UUID uuid;
    private String firstName;
    private String lastName;
    private String fullName;
    private int salary;
    private int age;
    private String jobTitle;
    private String email;
    private Instant hireDate;
    private Instant terminationDate;

    @Override
    public UUID getUuid() {
        return uuid;
    }

    @Override
    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public void setFirstName(String name) {
        this.firstName = name;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public void setLastName(String name) {
        this.lastName = name;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public void setFullName(String name) {
        this.fullName = name;
    }

    @Override
    public Integer getSalary() {
        return salary;
    }

    @Override
    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    @Override
    public Integer getAge() {
        return age;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    @Override
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Instant getContractHireDate() {
        return hireDate;
    }

    @Override
    public void setContractHireDate(Instant date) {
        this.hireDate = date;
    }

    /**
     * Assessment Note: should be null by default if not given a value.
     * @return null, if Employee has not been terminated.
     */
    @Override
    public Instant getContractTerminationDate() {
        return terminationDate;
    }

    @Override
    public void setContractTerminationDate(Instant date) {
        this.terminationDate = date;
    }
}
