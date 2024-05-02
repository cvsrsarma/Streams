package com.org.streams.employee;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EmployeeEx {

	public static List<Employee> employees=null;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int i= s.nextInt();
		employees=Employee.generateSampleData(i);
		//calcAvgSalaryForAllActiveEmps();
	}
	public static void calcAvgSalaryForAllActiveEmps() {
		System.out.println("Calculate the average salary of all active employees");
	double averageSalaryOfActiveEmployees = employees.stream()
	        .filter(Employee::isActive)
	        .mapToDouble(Employee::getSalary)
	        .average()
	        .orElse(0.0);
	System.out.println("Average salary of active employees: " + averageSalaryOfActiveEmployees);
	
	Optional<Employee> employeeWithHighestSalary = employees.stream()
	        .max(Comparator.comparingDouble(Employee::getSalary));
	employeeWithHighestSalary.ifPresent(emp -> System.out.println("Employee with highest salary: " + emp));
	List<String> contactEmails = employees.stream()
	        .flatMap(emp -> emp.getContactInfo().values().stream())
	        .filter(info -> info.contains("@"))
	        .collect(Collectors.toList());
	System.out.println("Contact emails for all employees: " + contactEmails);
	boolean hasJavaSkill = employees.stream()
	        .anyMatch(emp -> emp.getSkills().contains("Java"));
	System.out.println("Any employee has 'Java' skill: " + hasJavaSkill);
	long totalSkillsCount = employees.stream()
	        .flatMap(emp -> emp.getSkills().stream())
	        .distinct()
	        .count();
	System.out.println("Total number of skills across all employees: " + totalSkillsCount);
	double totalSalaryExpense = employees.stream()
	        .mapToDouble(Employee::getSalary)
	        .sum();
	System.out.println("Total salary expense for all employees: " + totalSalaryExpense);
	Map<Integer, List<Employee>> employeesByAge = employees.stream()
	        .collect(Collectors.groupingBy(Employee::getAge));
	System.out.println("Employees grouped by age: " + employeesByAge);
	boolean allEmployeesHaveEmail = employees.stream()
	        .allMatch(emp -> emp.getContactInfo().containsKey("email"));
	System.out.println("All employees have email address: " + allEmployeesHaveEmail);
	Optional<Employee> oldestActiveEmployee = employees.stream()
	        .filter(Employee::isActive)
	        .min(Comparator.comparingInt(Employee::getAge));
	oldestActiveEmployee.ifPresent(emp -> System.out.println("Oldest active employee: " + emp));
	List<Employee> employeesSortedByHireDateDesc = employees.stream()
	        .sorted(Comparator.comparing(Employee::getHireDate).reversed())
	        .collect(Collectors.toList());
	System.out.println("Employees sorted by hire date (descending): " + employeesSortedByHireDateDesc);
	List<Employee> employeesAbove30 = employees.stream()
	        .filter(emp -> emp.getAge() > 30)
	        .collect(Collectors.toList());
	System.out.println("Name sorted");
	List<String> employeeNames = employees.stream()
	        .map(Employee::getName)
	        .collect(Collectors.toList());
	System.out.println("Salary list sorted revierse");
	List<Employee> employeesSortedBySalaryDesc = employees.stream()
	        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
	        .collect(Collectors.toList());
	Map<String, List<Employee>> employeesBySkill = employees.stream()
	        .flatMap(emp -> emp.getSkills().stream().map(skill -> new AbstractMap.SimpleEntry<>(skill, emp)))
	        .collect(Collectors.groupingBy(AbstractMap.SimpleEntry::getKey, 
	                                         Collectors.mapping(AbstractMap.SimpleEntry::getValue, 
	                                                            Collectors.toList())));
	double totalSalaryExpense1 = employees.stream()
	        .mapToDouble(Employee::getSalary)
	        .sum();
	boolean anyEmployeeWithHighSalary = employees.stream()
	        .anyMatch(emp -> emp.getSalary() > 100000);
	long activeEmployeesCount = employees.stream()
	        .filter(Employee::isActive)
	        .count();


	}
	
	
       
}
