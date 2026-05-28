package com.Employee.Management;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    // Add Employee
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee Added Successfully.");
    }

    // View All Employees
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Found.");
            return;
        }

        employees.forEach(System.out::println);
    }

    // Search Employee using Optional
    public Optional<Employee> searchEmployee(int id) {

        return employees.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst();
    }

    // Update Salary
    public void updateSalary(int id, double salary)
            throws EmployeeNotFoundException {

        Employee employee = searchEmployee(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee Not Found"));

        employee.setSalary(salary);

        System.out.println("Salary Updated Successfully.");
    }

    // Delete Employee
    public void deleteEmployee(int id)
            throws EmployeeNotFoundException {

        Employee employee = searchEmployee(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee Not Found"));

        employees.remove(employee);

        System.out.println("Employee Deleted Successfully.");
    }

    // Stream API Example
    public void employeesWithHighSalary() {

        List<Employee> highSalaryEmployees = employees.stream()
                .filter(emp -> emp.getSalary() > 50000)
                .collect(Collectors.toList());

        System.out.println("\nEmployees with Salary > 50000");

        highSalaryEmployees.forEach(System.out::println);
    }

    // Sort Employees by Salary
    public void sortEmployeesBySalary() {

        List<Employee> sortedList = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .collect(Collectors.toList());

        System.out.println("\nEmployees Sorted by Salary");

        sortedList.forEach(System.out::println);
    }

    // Count Employees
    public void countEmployees() {

        long count = employees.stream().count();

        System.out.println("\nTotal Employees: " + count);
    }
}