package com.Employee.Management;

import java.util.ArrayList;
import java.util.Optional;

public class EmployeeService {

    ArrayList<Employee> employees = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee emp) {

        employees.add(emp);

        System.out.println("Employee added successfully");
    }

    // View Employees
    public void viewEmployees() {

        if (employees.isEmpty()) {

            System.out.println("No employees found");
            return;
        }

        for (Employee e : employees) {

            e.display();
        }
    }

  
    public Employee searchEmployee(int id)
            throws EmployeeNotFoundException {

        Optional<Employee> employee = employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst();

        if (employee.isPresent()) {

            return employee.get();
        }

        else {

            throw new EmployeeNotFoundException(
                    "Employee not found");
        }
    }
}
