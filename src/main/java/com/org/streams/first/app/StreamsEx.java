package com.org.streams.first.app;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.org.streams.first.app.model.Course;
import com.org.streams.first.app.model.Employee;
import com.org.streams.first.app.model.ModelHelper;
import com.org.streams.first.utils.Utils;

public class StreamsEx {

	public static void main(String[] args) {
		Utils.printEven();
		Utils.filterStrings();
		Utils.addNumebrsList();
		
		Utils.findMissingNumber();
		
		loadEmp();
		loadCources();
		//createStream();
	}
	
	/*private static void createStream() {
		System.out.println("Create a stream");
		List<Integer> numberStream= List.of(12,23,384,4749,472,4638,2873,582,436);
		System.out.println(numberStream.stream().mapToInt(e->e).max());
	}*/

	private static void loadCources() {
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
	
}

