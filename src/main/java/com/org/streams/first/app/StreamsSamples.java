package com.org.streams.first.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import com.org.streams.first.defEx.Student;
import com.org.streams.first.utils.Utils;

public class StreamsSamples {
	public static List<Integer> list= Utils.getIntegerList();
	public static List<Student> sList=Student.getStudentList();

	public static void main(String[] args) {
		findOutAllNbrsStartsWithGivenNbr();
		findDuplicates();
		tryAggregateFunctions();
		printEachCharinAString();
	}

	

	private static void printEachCharinAString() {
		System.out.println("Print the count of each character in a String");
		String s="string data to count each character";
		System.out.println(s);
		System.out.println(Arrays.stream(s.split("")).map(String::toLowerCase).collect(Collectors.groupingBy(str->str,LinkedHashMap::new,Collectors.counting())));
	}

	private static void tryAggregateFunctions() {
		System.out.println("aggregate function examples");
		System.out.println("Sum");
		System.out.println(list.stream().reduce(0,Integer::sum));
		System.out.println("Max");
		System.out.println(list.stream().max(Integer::compareTo));
		System.out.println("Min");
		System.out.println(list.stream().min(Integer::compareTo));
	}

	private static void findDuplicates() {
		System.out.println("\n\nFind duplicate elements in a given integers list");
		Set<Integer> s= new HashSet<Integer>();
		System.out.println(list.stream().filter(e->!s.add(e)).toList());
			
		
	}

	private static void findOutAllNbrsStartsWithGivenNbr() {
		System.out.println("Find out all the numbers starting with given number");
		Scanner s= new Scanner(System.in);
		System.out.println("Please enter a number 1 to 9");
		System.out.println(list);
		String i = s.nextInt()+"";
		System.out.println(list.stream().map(e->e+"").filter(e->e.startsWith(i)).toList());
	}

}
