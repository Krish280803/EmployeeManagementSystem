package com.Employee.Management;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeService service = new EmployeeService();

        while (true) {

            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Exit");

            System.out.print("Enter choice : ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Employee ID : ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Employee Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Employee Salary : ");
                    double salary = sc.nextDouble();

                    Employee emp =
                            new Employee(id, name, salary);

                    service.addEmployee(emp);

                    break;

                case 2:

                    service.viewEmployees();

                    break;

                case 3:

                    System.out.print("Enter Employee ID to Search : ");

                    int searchId = sc.nextInt();

                    try {

                        Employee e =
                                service.searchEmployee(searchId);

                        System.out.println("\nEmployee Found");
                        e.display();

                    } catch (EmployeeNotFoundException ex) {

                        System.out.println(ex.getMessage());
                    }

                    break;

                case 4:

                    System.out.println("Program Ended");

                    sc.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}
