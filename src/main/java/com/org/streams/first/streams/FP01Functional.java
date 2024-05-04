package com.org.streams.first.streams;

import java.util.List;

public class FP01Functional {
	
	static List<Integer> aList= List.of(0,28,48,59,78,126,537,636,353,426,547,-2);
	static List<String> sList=List.of("Spring","Springt boot","Spring JPA","API","MicroServices","AWS","PCF","Docker");

	public static void main(String[] args) {
		step1();
		step2();
	}
	
	private static void step2() {
		System.out.println("Add all numbers and display total");
		System.out.println(aList.stream().reduce(0,FP01Functional::add));
		System.out.println(aList.stream().reduce(0,(x,y)->x+y));
		System.out.println("Diaplay max number");
		System.out.println(aList.stream().reduce(0,(x,y)->x>y?x:y));
		System.out.println("Diaplay Min number");
		System.out.println(aList.stream().reduce(0,(x,y)->x<y?x:y));
		System.out.println("Sum of squears number");
		System.out.println(aList.stream().map(e->e*e).reduce(0,(x,y)->x>y?x:y));
		System.out.println(aList.stream().map(e->e*e).reduce(0,(Integer::sum)));
	}
	
	public static int add(int i, int j) {
		return i+j;
	}

	public static void step1() {
		aList.stream().forEach(FP01Functional::print);
		System.out.println("Print even");
		aList.stream().filter(e->e%2==0).forEach(System.out::println);
		System.out.println("Print Odd");
		aList.stream().filter(e->e%2==1).forEach(System.out::println);
		System.out.println("Print All Courses");
		sList.stream().forEach(System.out::println);
		System.out.println("Print All Courses which contains Spring");
		sList.stream().filter(e->e.contains("Spring")).forEach(System.out::println);
		System.out.println("Print All Courses which contains more than 4 chars");
		sList.stream().filter(e->e.length()>4).forEach(System.out::println);
		System.out.println("Print All numbers are squares");
		aList.stream().map(e->e*e).forEach(System.out::println);
		System.out.println("Print All odd numbers are squares");
		aList.stream().filter(e->e%2==1).map(e->e*e).forEach(System.out::println);
		System.out.println("Print number of chars in each course");
		sList.stream().map(e->e+"-->"+e.length()).forEach(System.out::println);
	}
	
	public static void print(int i) {
		System.out.println(i);
	}


}
