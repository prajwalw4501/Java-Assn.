package com.app.tester;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.app.core.Employee;
import com.app.core.FullTimeEmployee;
import com.app.core.PartTimeEmployee;
import com.app.utils.EmployeeDao;
import com.app.utils.EmployeeDaoImpl;

public class EmployeeTester {
	static Map<Integer, Employee> employees = new HashMap<>();

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			EmployeeDao dao = new EmployeeDaoImpl();
			boolean exit = false;
			while (!exit)
				try {
					System.out.println("---CONSOLE---");
					System.out.println("1.Add FTE:" + "\n2.Add PTE:" + "\n3.Delete Employee(ID):"
							+ "\n4.Search by Aadhar No.:" + "\n5.Display All Employee Details:"
							+ "\n6.Display All Emp.(sorted by joining_date)" + "\n0.Exit");
					System.out.println("Enter KEY");
					switch (sc.nextInt()) {
					case 1:// add fte
						System.out.println("Enter Employee Detailss!!");
						System.out.println("name, date_of_joining, phone, aadhar_no,monthly sal");
						employees.put(Employee.counter,
								new FullTimeEmployee(Employee.counter, sc.next(), dao.validateDate(sc.next()),
										dao.validatePhone(sc.next()), dao.validateAadhar(sc.next(), employees),
										sc.nextDouble()));
						System.out.println("FTE Added Succesfully");
//						employees.values().stream().forEach(i -> System.out.println(i));

						break;
					case 2:
						System.out.println("Enter Employee Detailss!!");
						System.out.println("name, date_of_joining, phone, aadhar_no,Hourly sal");
						employees.put(Employee.counter,
								new PartTimeEmployee(Employee.counter, sc.next(), dao.validateDate(sc.next()),
										dao.validatePhone(sc.next()), dao.validateAadhar(sc.next(), employees),
										sc.nextDouble()));
						System.out.println("PTE Added Succesfully!!");
						break;
					case 3:
						System.out.println("Enter Id to Remove: ");
						int id = sc.nextInt();
						if (employees.containsKey(id))
							employees.remove(id);
						System.out.println("Employee Removed!!");
						break;
					case 4:
						System.out.println("Enter Aadhar No. to Search:");
						dao.searchEmployee(sc.next(), employees);
						break;
					case 5:
						employees.values().stream().forEach(i -> System.out.println(i));

						break;
					case 6:
						employees.values().stream().sorted(Comparator.comparing(Employee::getDate_of_joining))
								.forEach(i -> System.out.println(i));
						break;
					case 7:
						System.out.println("Enter FileName: ");
						dao.writeDetails(sc.next(), employees);
						System.out.println("Data Added Succesfully");
						break;
					case 8:
						System.out.println("Enter FileName: ");
						System.out.println(dao.readDetails(sc.next(), employees));
//						employees.values().stream().forEach(i -> System.out.println(i));
						System.out.println("Data Retrieved Succesfully!!");
						break;

					default:
						System.out.println("Invalid ID");
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}

		} catch (Exception e) {
			System.out.println(e);

		}

	}

}
