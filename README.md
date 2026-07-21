# ReliaQuest's Entry-Level Java Challenge

Please keep the following in mind while working on this challenge:
* Code implementations will not be graded for **correctness** but rather on practicality
* Articulate clear and concise design methodologies, if necessary
* Use clean coding etiquette
  * E.g. avoid liberal use of new-lines, odd variable and method names, random indentation, etc...
* Test cases are not required

## Problem Statement

Your employer has recently purchased a license to top-tier SaaS platform, Employees-R-US, to off-load all employee management responsibilities.
Unfortunately, your company's product has an existing employee management solution that is tightly coupled to other services and therefore 
cannot be replaced whole-cloth. Product and Development leads in your department have decided it would be best to interface
the existing employee management solution with the commercial offering from Employees-R-US for the time being until all employees can be
migrated to the new SaaS platform.

Your ask is to expose employee information as a protected, secure REST API for consumption by Employees-R-US web hooks.
The initial REST API will consist of 3 endpoints, listed in the following section. If for any reason the implementation 
of an endpoint is problematic, the team lead will accept **pseudo-code** and a pertinent description (e.g. java-doc) of intent.

Good luck!

## Endpoints to implement (API module)

_See `com.challenge.api.controller.EmployeeController` for details._

getAllEmployees()

    output - list of employees
    description - this should return all employees, unfiltered

getEmployeeByUuid(...)

    path variable - employee UUID
    output - employee
    description - this should return a single employee based on the provided employee UUID

createEmployee(...)

    request body - attributes necessary to create an employee
    output - employee
    description - this should return a single employee, if created, otherwise error

## Code Formatting

This project utilizes Gradle plugin [Diffplug Spotless](https://github.com/diffplug/spotless/tree/main/plugin-gradle) to enforce format
and style guidelines with every build.

To format code according to style guidelines, you can run **spotlessApply** task.
`./gradlew spotlessApply`

The spotless plugin will also execute check-and-validation tasks as part of the gradle **build** task.
`./gradlew build`

# Notes on My Implementation

## Model
I created a file called EmployeeImpl to implement the Employee interface. I overrode all of the functions within it and declared the relevant variables.

## Controller
I kept the controller file intentionally minimal, with each function calling the service to actually run business logic. 

Since this assessment was only with three APIs, I only created a path for the getEmployeeByUuid function, as that needed a parameter. A GET request without a parameter would automatically map to getAllEmployees, and a POST request would automatically map to createEmployee.

I used EmployeeImpl as a RequestBody within the createEmployee parameter to convert the incoming data into its existing structure.

## Service
I created a service interface that defined all functions, and then I created a separate implementation file that implemented them. 

Within the impl file, I created a ConcurrentHashMap to store employees locally. I made this decision because multiple HTTP requests can be received at once, and a ConcurrentHashMap protects against this, while a regular HashMap would not. 

I created a helper method called createMockEmployees to populate the employee ConcurrentHashMap for testing if my APIs worked. I had the constructor call this method three times with hardcoded values to test against. 

The implementation of the functions themselves were simple:

I returned an ArrayList of the employee map's values for getAllEmployees. I chose to use ArrayList instead of just using employeeMap.values() because ConcurrentHashMap returns a Collection and not the expected List. 

I used employeeMap.get(uuid) to implement getEmployeeByUuID, and I checked if the value was null before returning. 

For createEmployee, I set the UUID using the setUuid function within the Employee model with UUID.randomUUID() as a parameter. I then used employeeMap.put to put in the UUID and the Employee object within the map as a key-value pair.



