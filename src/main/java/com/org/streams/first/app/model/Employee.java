package com.org.streams.first.app.model;

import java.util.List;


public class Employee {
	
	private String empName;
	private int empId;
	private int age;
	private String gender;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int salary;
	private String address1;
	private String address2;
	private String zipCode;
	private String dept;
	
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	/*
	 * private List<String> aList; private AccessDetails accd; private
	 * List<AccessDetails> accDList;
	 */
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/*
	 * public List<String> getaList() { return aList; } public void
	 * setaList(List<String> aList) { this.aList = aList; } public AccessDetails
	 * getAccd() { return accd; } public void setAccd(AccessDetails accd) {
	 * this.accd = accd; } public List<AccessDetails> getAccDList() { return
	 * accDList; } public void setAccDList(List<AccessDetails> accDList) {
	 * this.accDList = accDList; }
	 */
	public Employee(String empName, int empId, int salary, String address1, String address2, String zipCode,
			List<String> aList, AccessDetails accd, List<AccessDetails> accDList) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.salary = salary;
		this.address1 = address1;
		this.address2 = address2;
		this.zipCode = zipCode;
	}
	public Employee(String empName, int empId, int salary, String address1, String address2, String zipCode, int age, String gender, String dept) {
		super();
		this.empName = empName;
		this.empId = empId;
		this.salary = salary;
		this.address1 = address1;
		this.address2 = address2;
		this.zipCode = zipCode;
		this.age= age;
		this.gender=gender;
		this.dept=dept;
	}
	
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empId=" + empId + ", age=" + age + ", gender=" + gender + ", salary="
				+ salary + ", address1=" + address1 + ", address2=" + address2 + ", zipCode=" + zipCode + ", dept="
				+ dept + "]";
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	

}
