package com.org.streams.first.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberStreamExamples {
	
	public static List<Integer> list= null;
	public static int[] arr = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	static {
		list= Utils.getIntegerList();
	}

	public static void seprateOddAndEvenNumbers() {
		
		System.out.println("Seprate only Even numbers "+list+"\n\n");
		System.out.println(list.stream().filter(e->e%2==0).collect(Collectors.toList()));
		System.out.println("Seprate only Odd numbers \n\n");
		System.out.println(list.stream().filter(e->e%2==1).collect(Collectors.toList()));
		System.out.println(list.stream().
				collect(Collectors.partitioningBy(e->e%2==0)));
		Map<Boolean, List<Integer>> map= list.stream().collect(Collectors.partitioningBy(e->e%2==0));
		System.out.println(map);
	}
	
	public static void findEvenAndAddAll() {
		System.out.println("\n\nFind even and do squre");
		List<Integer> list= Utils.getIntegerList();
		System.out.println(list.stream().filter(e->e%2==0).map(e->e*e).collect(Collectors.toList()));
	}
	public static void findEvenAddSquers() {
		System.out.println("\n\nFind Even and squers and add all of them");
		List<Integer> list= Utils.getIntegerList();
		System.out.println(list.stream().filter(e->e%2==0).map(e->e*e).reduce(0,Integer::sum));
		addAllNumbers();
	}
	public static void addAllNumbers() {
		System.out.println("\n\nAdd all nunbers");
		System.out.println(list.stream().reduce(0,Integer::sum));
		list.stream().collect(Collectors.toList());
		findTheMissingNumber();
	}

	private static void findTheMissingNumber() {
		System.out.println("\n\nFind the missing number");
		System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
		int length = arr.length;
		int sum=0;
		sum=Arrays.stream(arr).reduce(0,Integer::sum);
		length++;
		System.out.println((length*(length+1)/2)-sum);
	}

}
