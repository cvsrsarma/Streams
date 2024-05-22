package com.org.streams.first.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.org.streams.first.app.model.Course;
import com.org.streams.first.app.model.Employee;
import com.org.streams.first.app.model.ModelHelper;
import com.org.streams.first.app.model.Student;

public class StringUtils {
	
	public static void loadCources() {
		try {
			Predicate<Course> reviewScoreGreaterThan95Predicate 
			= course -> course.getReviews() > 89;
			
			List<Course> empList= ModelHelper.getCourcesList();
			System.out.println(empList);
			
			Comparator<Course> compringByStdsAndNoReviews= Comparator.comparingInt(Course::getNumberOfStds).reversed().reversed().
					thenComparing(Course::getReviews);
			System.out.println(empList.stream().max(compringByStdsAndNoReviews));
			
			System.out.println("Find reivews >89 and avg and count of number of the Stds");
			System.out.println(empList.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStds).sum());
			System.out.println("Find reivews >89 and avg and display");
			System.out.println(empList.stream().filter(reviewScoreGreaterThan95Predicate).collect(Collectors.toList()));
			System.out.println("Find reivews >89 and avg and count of number of the Stds number for each Course");
			empList.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStds).forEach(System.out::println);
			System.out.println("Find reivews >89 and avg and Avg Stds number for each Course");
			System.out.println(empList.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStds).average());
			System.out.println("Find reivews >89 and avg and max stds");
			System.out.println(empList.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStds).max());
			System.out.println("Find reivews >89 and avg and min stds");
			System.out.println(empList.stream().filter(reviewScoreGreaterThan95Predicate).mapToInt(Course::getNumberOfStds).min());
			System.out.println("\n\n\n");
			System.out.println("Group by coursetype");
			System.out.println(empList.stream().collect(Collectors.groupingBy(Course::getCoursetype)));
			System.out.println("Group by coursetype and total count each type");
			System.out.println(empList.stream().collect(Collectors.groupingBy(Course::getCoursetype,Collectors.counting())));
			System.out.println("\n\nGroup by coursetype and hights reviews");
			System.out.println(empList.stream().collect(Collectors.groupingBy(Course::getCoursetype,Collectors.maxBy(Comparator.comparing(Course::getReviews)))));
			System.out.println("\n\n\n");
			System.out.println("Group by list of course and group by Course type");
			System.out.println(empList.stream().collect(Collectors.groupingBy(Course::getCoursetype, Collectors.mapping(Course::getCourseName, Collectors.toList()))));
			System.out.println(empList.stream().collect(Collectors.groupingBy(Course::getCoursetype, Collectors.mapping(Course::getCourseName,Collectors.toSet()))));
		} catch (Exception e) {
			e.printStackTrace();
		};
		
	}

	public static void loadEmp() {
		List<Employee> empList= ModelHelper.getEmployeeList();
		System.out.println(empList);
		try {
		List<Employee> empL= empList.stream().
				filter(e -> e.getAge()>45).limit(3)
				
				.collect(Collectors.toList());
		System.out.println(empL);
		Comparator<Employee> comp = Comparator.comparing(Employee::getAge);
		Comparator<Employee> cmp = Comparator.comparing(Employee::getSalary).reversed();
		Comparator<Employee> compar= Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getSalary).reversed();
		System.out.println("\n");
		System.out.println(empList.stream().sorted(comp).collect(Collectors.toList()));
		System.out.println(empList.stream().sorted(compar).collect(Collectors.toList()));
		
		System.out.println("Print top 5 salary");
		System.out.println(empList.stream().sorted(cmp).limit(5).collect(Collectors.toList()));
		
		
		System.out.println(empList.stream().anyMatch(e->e.getAge()>80));
		System.out.println("\n");
		System.out.println(empList);
		System.out.println("Print all age > 67");
		Comparator<Employee> compRe = Comparator.comparing(Employee::getAge).reversed();
		//System.out.println(empList.stream().sorted(compRe).takeWhile(e -> e.getAge()>67).collect(Collectors.toList()));
		System.out.println("Print all age < 67");
		//System.out.println(empList.stream().sorted(compRe).dropWhile(e -> e.getAge()<67).collect(Collectors.toList()));
		
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	static final String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	static final String AB1="abcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	static List<String> sList= new ArrayList<String>();

	public static void findNumberOfFrequencyChars() {
		System.out.println("Find number of Ferquency of chars");
		System.out.println("Enter number chars for a String followed by number of strings");
		Scanner scan= new Scanner(System.in);
		int numberOfCharsinaStr= scan.nextInt();
		int numberOfWords= scan.nextInt();
		StringBuilder sb= new StringBuilder();
		String s="";
		for(int i=0; i< numberOfWords;i++) {
			for(int j=0; j<numberOfCharsinaStr;j++) {
				if(j==0) {
					sb.append(AB.charAt(rnd.nextInt(AB.length())));
					s=AB.charAt(rnd.nextInt(AB.length()))+"";
				}
			else
				sb.append(AB1.charAt(rnd.nextInt(AB1.length())));
				s=s+AB1.charAt(rnd.nextInt(AB1.length()))+"";
			}
			sb.append(" ");
			sList.add(s);
		}
		String s1= sb.toString();
		
		System.out.println(s1);
		System.out.println(s1.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
		
		System.out.println("adads239alksdjfoi23u09u23kjasdlkjfaoseur0293iualksjdflaksdhjfioquywefoiasjdfkljasdhfklasdhfiopuasydfkjahdsfkjashdfiuaysdfiuhasdkfjhao9wulkhjasdf".chars()
				.mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
	}
	
	public static void findMaleNdFemals() {
		List<Employee> empL = ModelHelper.getEmployeeList();
		System.out.println(empL);
		System.out.println("Find number of M and F employees");
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.counting())));
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getGender())));
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.toList())));
		System.out.println("\n\n");
	}

	public static void findNumberOFEmpsFromEachDept() {
		List <Employee> empL = ModelHelper.getEmployeeList();
		System.out.println(empL);
		System.out.println("number of employees in each department");
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getDept(),Collectors.counting())));
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getDept(),Collectors.toList())));
		System.out.println("\n\n");
	}
	
	public static void findYongestEmp() {
		List <Employee> empL = ModelHelper.getEmployeeList();
		System.out.println(empL);
		System.out.println("Find Youngest employee from org");
		
		System.out.println(empL.stream().min(Comparator.comparingInt(Employee::getAge)));
		System.out.println(empL.stream().sorted(Comparator.comparingInt(Employee::getAge)).findFirst());
		System.out.println("Find olderst employee from org");
		System.out.println(empL.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).findFirst());
		
		System.out.println("\n\n");
	}
	
	public static void findOldestEmp() {
		List <Employee> empL = ModelHelper.getEmployeeList();
		System.out.println(empL);
		System.out.println("Find Seniour most employee");
		System.out.println(empL.stream().max(Comparator.comparingInt(Employee::getAge)));
		System.out.println("\n\n");
	}

	public static void findAvgAgeInDept() {
		List <Employee> empL = ModelHelper.getEmployeeList();
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getDept())));
		System.out.println(" the average age of each department ");
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getDept(),Collectors.averagingInt(Employee::getAge))));
		System.out.println("Find average salary of each department");
		System.out.println("\n\n");
	}
	
	public static void findHightPaid() {
		List <Employee> empL = ModelHelper.getEmployeeList();
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getDept())));
		System.out.println("highest paid employee in the organization ");
		System.out.println(empL.stream().max(Comparator.comparingInt(e->e.getSalary())));
		System.out.println("\n\n");
		System.out.println(empL.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)))));
	}
	public static void findAvgSalarMndF() {
		List <Employee> empL = ModelHelper.getEmployeeList();
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getGender())));
		System.out.println("the average salary of male and female employees");
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getGender(),Collectors.averagingInt(Employee::getSalary))));
		System.out.println("\n\n");
	}
	
	public static void findLowestPaidInEachDept() {
		List <Employee> empL = ModelHelper.getEmployeeList();
		System.out.println(empL);
		System.out.println("Lowest paid employee in the organization ");
		System.out.println(empL.stream().sorted(Comparator.comparingInt(Employee::getSalary)).limit(1).toList());
		System.out.println(empL.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.minBy(Comparator.comparingInt(Employee::getSalary)))));
	}

	public static void findTtlNbrStdsForSbjct() {
		// TODO Auto-generated method stub
		
	}

	public static void printStudents() {
		List<Student> sList = ModelHelper.getSList();
		System.out.println(sList);
	}

	public static void sortListOfString() {
		
		System.out.println("Soring strings");
		System.out.println(sList);
		System.out.println(sList.stream().sorted().collect(Collectors.toList()));
		System.out.println("\n\n");
	}

	public static void findFndMs() {
		List<Employee> empL = ModelHelper.getEmployeeList();
		System.out.println("Find mails and females");
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getGender())));
		System.out.println("\n\n find my department");
		System.out.println(empL.stream().collect(Collectors.groupingBy(e->e.getDept())));
		System.out.println("\n\n Find by Oldest emp");
		System.out.println(empL.stream().min(Comparator.comparingInt(Employee::getAge).reversed()));
		System.out.println("\n\n Find Youngest emp");
		System.out.println(empL.stream().max(Comparator.comparingInt(Employee::getAge).reversed()));
		System.out.println("\n\n Ave Age in each dept");
		System.out.println(empL.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.averagingInt(Employee::getAge))));
		System.out.println("\n\n Find ave salary by gender");
		System.out.println(empL.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getSalary))));
		System.out.println("\n\nsort Employee by name");
		empL.stream().sorted(Comparator.comparing(Employee::getEmpName)).forEach(System.out::println);
		System.out.println("\n\nSort by Dept name");
		empL.stream().sorted(Comparator.comparing(Employee::getDept)).forEach(System.out::println);
		System.out.println("\n\nSort by name and salary");
		System.out.println(empL);
		empL.stream().sorted(Comparator.comparing(Employee::getEmpName).thenComparing(Employee::getSalary)).forEach(System.out::println);
		System.out.println("\n\nSort employee by dept, id and salary and dept");
		empL.stream().sorted(Comparator.comparing(Employee::getDept).thenComparing(Employee::getEmpId).thenComparing(Employee::getSalary)).
			forEach(System.out::println);
	}

	public static void removeDuplicates() {
		System.out.println("\n\nremove duplicate elements from a list");
		int i= rnd.nextInt(sList.size()/2);
		i+=3;
		for (int j=0;j<i;j++) {
			String s= sList.get(rnd.nextInt(sList.size()));
					sList.add(s);
		}
		System.out.println(sList.stream().sorted().collect(Collectors.toList()));
		System.out.println("Removed Duplicates");
		System.out.println(sList.stream().collect(Collectors.toSet()));
		System.out.println("Removed Dup[licates and sorted");
		System.out.println(sList.stream().collect(Collectors.toSet()).stream().sorted().collect(Collectors.toList()));
		System.out.println("Removed Duplicates and revers sorted");
		System.out.println(sList.stream().collect(Collectors.toSet()).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
		System.out.println("frequency of each element in an array or a list");
		System.out.println(sList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
		System.out.println("\n\n join the strings with ‘{‘ as prefix, ‘}’ as suffix and ‘,’ as delimiter");
		System.out.println(sList);
		System.out.println(sList.stream().collect(Collectors.joining("prefix, "," {", "}")));
		}

	public static void findAnagrams() {
		System.out.println("CarRace and RaceCar is an anagaram");
		String s1="RaceCar",s2="CarRace";
		System.out.println(s1);
		System.out.println("Enter an anagram");
		Scanner stringScanner = new Scanner(System.in); 
		
			  s1 = stringScanner.next(); 
			  s2= stringScanner.next(); 
		s1=Stream.of(s1.split("")).map(e->e.toUpperCase()).sorted().collect(Collectors.joining());
		System.out.println(s1);
		s2=Stream.of(s2.split("")).map(e->e.toUpperCase()).sorted().collect(Collectors.joining());
		System.out.println(s2);
		if(s1.equals(s2)) {
			System.out.println("givenString are anagrams");
		} else {
			System.out.println("givenString are not anagrams");
		}
	}
	
	public static void strRevAllWords() {
		String s="Reverse each word of a string";
		System.out.println(s);
		String revS=Arrays.stream(s.split(" ")).map(w-> new StringBuffer(w).reverse()).collect(Collectors.joining(" "));
		System.out.println(revS);
		
		
	}
	
	public static String strReverse() {
		Scanner s = new Scanner(System.in);
		String s1=s.nextLine();
		System.out.println(s1);
		System.out.println(Arrays.stream(s1.split(" ")).map(e->org.apache.commons.lang3.StringUtils.reverse(e)).collect(Collectors.toList()));
		return "";
	}

	
	
	

}