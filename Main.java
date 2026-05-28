package com.Employee.Management;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeService service = new EmployeeService();

        while (true) {

            System.out.println("\n===== Employee Management System =====");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Salary");
            System.out.println("5. Delete Employee");
            System.out.println("6. Employees Salary > 50000");
            System.out.println("7. Sort Employees by Salary");
            System.out.println("8. Count Employees");
            System.out.println("9. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();

                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();

                        service.addEmployee(
                                new Employee(id, name, dept, salary));

                        break;

                    case 2:

                        service.viewEmployees();

                        break;

                    case 3:

                        System.out.print("Enter Employee ID: ");
                        int searchId = sc.nextInt();

                        Optional<Employee> employee =
                                service.searchEmployee(searchId);

                        if (employee.isPresent()) {
                            System.out.println(employee.get());
                        } else {
                            System.out.println("Employee Not Found");
                        }

                        break;

                    case 4:

                        System.out.print("Enter Employee ID: ");
                        int updateId = sc.nextInt();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        service.updateSalary(updateId, newSalary);

                        break;

                    case 5:

                        System.out.print("Enter Employee ID: ");
                        int deleteId = sc.nextInt();

                        service.deleteEmployee(deleteId);

                        break;

                    case 6:

                        service.employeesWithHighSalary();

                        break;

                    case 7:

                        service.sortEmployeesBySalary();

                        break;

                    case 8:

                        service.countEmployees();

                        break;

                    case 9:

                        System.out.println("Application Closed.");
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice");
                }

            } catch (EmployeeNotFoundException e) {

                System.out.println(e.getMessage());
            }
        }
    }
}