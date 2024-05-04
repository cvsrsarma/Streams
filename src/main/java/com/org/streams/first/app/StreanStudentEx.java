package com.org.streams.first.app;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.org.streams.first.defEx.Student;

public class StreanStudentEx {
	public static List<Student> sList=Student.getStudentList();

	public static void main(String[] args) {
		getNameStartWithGivenChar();
		groupByStudentByDept();
		findTotalNumberOfStudents();
		findMaxAgeOfStudents();
		findAllDepartmentsNames();
		findStudentCountsByDepartmentNames();
		findStudentsFindAgeLessThanGivenNbr();
		findListStudentsBetweebRanks();
		findAvgAgeOfStudentsByGender();
		findDeptWithMaxStudents();
		findByCityAndSortByName();
		findAvgRankByDept();
		findHighestRankinEachDept();
		findAllStudentsSortByRank();
		findStudentNthRank();
	}
	
	
	private static void findStudentNthRank() {
		System.out.println("\n\nFind the student who has Nth rank");
		System.out.println("Please enater a Nth Rank number.");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		System.out.println(sList);
		System.out.println(sList.stream().sorted(Comparator.comparing(Student::getRank)).skip(i).findFirst());
	}


	private static void findAllStudentsSortByRank() {
		System.out.println("\n\nFind the list of students and sort them by their rank");
		System.out.println(sList);
		System.out.println(sList.stream().sorted(Comparator.comparing(Student::getRank)).collect(Collectors.toList()));
	}


	private static void findHighestRankinEachDept() {
		System.out.println("\n\nFind the highest rank in each department");
		System.out.println(sList);
		System.out.println(sList.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.maxBy(Comparator.comparing(Student::getRank)))));
	}


	private static void findAvgRankByDept() {
		System.out.println("\n\nFind the average rank in all departments");
		System.out.println(sList);
		System.out.println(sList.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.averagingInt(Student::getAge))));
	}


	private static void findByCityAndSortByName() {
		System.out.println("\n\nFind the Students who stays in Delhi and sort them by their names");
		System.out.println(sList);
		System.out.println(sList.stream().filter(e->e.getCity().contains("Delhi")).sorted(Comparator.comparing(Student::getFirstName)).toList());
	}


	private static void findDeptWithMaxStudents() {
		System.out.println("\n\nFind max students by Dept");
		System.out.println(sList);
		System.out.println(sList.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).get());
	}


	private static void findAvgAgeOfStudentsByGender() {
		System.out.println("\n\nFind the average age of male and female students");
		System.out.println(sList);
		System.out.println(sList.stream().collect(Collectors.groupingBy(Student::getGender,Collectors.averagingInt(Student::getAge))));
	}


	public static void getNameStartWithGivenChar() {
		System.out.println("Please enater a char, to Find out list of students whose first name starts with alphabet Given Char");
		Scanner s = new Scanner(System.in);
		String s1= ""+s.next().charAt(0);
		System.out.println(sList);
		System.out.println(sList.stream().filter(e->e.getFirstName().startsWith(s1)).toList());
		
	}
	public static void groupByStudentByDept() {
		System.out.println("\n\nGroup The Student By Department Names");
		System.out.println(sList);
		System.out.println(sList.stream().collect(Collectors.groupingBy(Student::getDepartmantName)));
	}
	public static void findTotalNumberOfStudents() {
		System.out.println("\n\nFind the total count of student using stream");
		System.out.println(sList);
		System.out.println(sList.stream().count());
	}
	public static void findMaxAgeOfStudents() {
		System.out.println("\n\nFind the max age of student");
		System.out.println(sList);
		System.out.println(sList.stream().max(Comparator.comparing(Student::getAge)));
	}
	public static void findAllDepartmentsNames() {
		System.out.println("\n\nFind all Department names");
		System.out.println(sList);
		System.out.println(sList.stream().map(e->e.getDepartmantName()).distinct().toList());
	}
	public static void findStudentCountsByDepartmentNames() {
		System.out.println("\n\nFind the count of student in each department");
		System.out.println(sList);
		System.out.println(sList.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())));
	}
	public static void findStudentsFindAgeLessThanGivenNbr() {
		System.out.println("\n\nFind the list of students whose age is less than given");
		System.out.println("Please enater a number.");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		System.out.println(sList);
		System.out.println(sList.stream().filter(e->e.getAge()<=i).toList());
		System.out.println("\n\nFind the list of students whose age is grater than given");
		System.out.println(sList.stream().filter(e->e.getAge()>=i).toList());
	}
	public static void findListStudentsBetweebRanks() {
		System.out.println("\n\nFind the list of students whose rank is in between 50 and 100");
		System.out.println(sList);
		System.out.println(sList.stream().filter(e->(e.getRank()>50 && e.getRank()<100)).toList());
	}
	/*public static void findStudentCountsByDepartmentNames() {
		System.out.println("\n\nFind the count of student in each department");
		System.out.println(sList);
		System.out.println(sList.stream().collect(Collectors.groupingBy(Student::getDepartmantName,Collectors.counting())));
	}
	*/
}
