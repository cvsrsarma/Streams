package com.org.streams.employee;

import java.util.*;

public class Employee {
    // Fields/Attributes
    private String name;
    private int age;
    private double salary;
    private List<String> skills;
    private Map<String, String> contactInfo;
    private Date hireDate;
    private boolean isActive;

    // Constructor
    public Employee(String name, int age, double salary, List<String> skills, Map<String, String> contactInfo, Date hireDate, boolean isActive) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.skills = skills;
        this.contactInfo = contactInfo;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Map<String, String> getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Map<String, String> contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // toString method to represent Employee object as a string
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", skills=" + skills +
                ", contactInfo=" + contactInfo +
                ", hireDate=" + hireDate +
                ", isActive=" + isActive +
                '}';
    }

    // Method to generate sample data for employees
    public static List<Employee> generateSampleData(int numberOfEmployees) {
        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        List<String> skills = Arrays.asList("Java", "Python", "SQL", "JavaScript", "C++", "HTML", "CSS");
        List<String> emails = Arrays.asList("gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com");
        List<String> phonePrefixes = Arrays.asList("123", "456", "789", "321", "654", "987");

        for (int i = 0; i < numberOfEmployees; i++) {
            String name = "Employee" + (i + 1);
            int age = random.nextInt(41) + 20; // Random age between 20 and 60
            double salary = 30000 + random.nextInt(70000); // Random salary between 30000 and 100000
            List<String> employeeSkills = new ArrayList<>();
            int numSkills = random.nextInt(5) + 1; // Random number of skills between 1 and 5
            for (int j = 0; j < numSkills; j++) {
                employeeSkills.add(skills.get(random.nextInt(skills.size())));
            }
            Map<String, String> contactInfo = new HashMap<>();
            contactInfo.put("email", "employee" + (i + 1) + "@" + emails.get(random.nextInt(emails.size())));
            contactInfo.put("phone", "+1-" + phonePrefixes.get(random.nextInt(phonePrefixes.size())) + "-" + String.format("%07d", random.nextInt(10000000)));
            contactInfo.put("address", "123 Main St, City, Country");
            Date hireDate = new Date(System.currentTimeMillis() - random.nextInt(365 * 24 * 60 * 60 * 1000)); // Random hire date within the past year
            boolean isActive = random.nextBoolean();

            employees.add(new Employee(name, age, salary, employeeSkills, contactInfo, hireDate, isActive));
        }
        return employees;
    }
}
