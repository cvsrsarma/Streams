package com.org.streams.first.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.hibernate.query.spi.Limit;

public class NbrStreamEx {
	
	public static List<Integer> list= null;
	public static int[] arr = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	static {
		list= Utils.getIntegerList();
	}
	public static int add(int a, int b) {return a+b;}
	public static int[] str1;
	static {
	str1= list.stream().mapToInt(Integer::intValue).toArray();
	}
	
	public static void seprateOddAndEvenNumbers() {
		
		System.out.println("Seprate only Even numbers "+list+"\n\n");
		System.out.println(list.stream().filter(e->e%2==0).collect(Collectors.toList()));
		System.out.println("\n\nSeprate only Odd numbers");
		System.out.println(list.stream().filter(e->e%2==1).collect(Collectors.toList()));
		System.out.println("\n\ngroup by even and odd numbers 2 different lists");
		System.out.println(list.stream().collect(Collectors.partitioningBy(e->e%2==0)));
		Map<Boolean, List<Integer>> map= list.stream().collect(Collectors.partitioningBy(e->e%2==0));
		System.out.println(map);
	}
	
	public static void findEvenAndAddAll() {
		System.out.println("\n\nFind Odd and all");
		System.out.println(list.stream().filter(e->e%2==1).map(e->e).reduce(0,Integer::sum));
		System.out.println("\n\nFind even and all");
		System.out.println(list.stream().filter(e->e%2==0).map(e->e).reduce(0,Integer::sum));
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

	public static void sortAndReverse() {
		System.out.println("\n\nSorting and Reverse number");
		System.out.println(list.stream().sorted().toList());
		System.out.println(Utils.getIntegerList().stream().sorted().collect(Collectors.toList()));
		System.out.println("\n\nReversing sorted numbers");
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
	}

	public static void mergeunSortedArryToOneSortedAry() {
		
		System.out.println("\n\nMerge and sort numbers");
		System.out.println(Arrays.stream(str1).boxed().toList()+"\nAnd\n"+Arrays.stream(arr).boxed().toList());
		System.out.println(IntStream.concat(Arrays.stream(str1),Arrays.stream(arr)).boxed().sorted().collect(Collectors.toList()));
		System.out.println("\n\nMerge remove duplicates and sort numbers");
		System.out.println(list+"\n"+Arrays.stream(arr).boxed().toList());
		System.out.println(IntStream.concat(Arrays.stream(str1),Arrays.stream(arr)).boxed().sorted().distinct().collect(Collectors.toList()));
		System.out.println("\n\nMerge and add all numbers");
		System.out.println(IntStream.concat(Arrays.stream(str1), Arrays.stream(arr)).boxed().reduce(NbrStreamEx::add));
		System.out.println("\n\nMerge Remove duplicartes and add all numbers");
		System.out.println(IntStream.concat(Arrays.stream(str1), Arrays.stream(arr)).boxed().distinct().reduce(NbrStreamEx::add));
	}

	public static void addAllNbrsInAlist() {
		System.out.println(list.stream().reduce(0, NbrStreamEx::add));
	}

	public static void highistGivenList() {
		System.out.println("\n\nHighist numbers from the list \n"+list);
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).findFirst());
		System.out.println(list.stream().mapToInt((x)->x).summaryStatistics());
	}

	public static void findCommonNbrsInALists() {
		Random r= new Random();
		for(int i=0; i<3;i++) {
			int k=r.nextInt(list.size());
			list.add(list.get(k));
		}
		System.out.println("\n\nFind duplicate numbers from the  list \n"+list+"\n");
		Set<Integer> items = new HashSet<>(); 
		System.out.println(list.stream().filter(n -> !items.add(n)).collect(Collectors.toSet()).stream().sorted().toList()); 
		findCommonNbrsIn2Lists();
	}
	public static void findCommonNbrsIn2Lists() {
		List<Integer> l2= Arrays.stream(arr).boxed().distinct().sorted().collect(Collectors.toList());
		System.out.println("\n\nFind common numbers from the  list \n"+list+"\n"+l2);
		l2.addAll(list.stream().sorted().distinct().collect(Collectors.toList()));
		Set<Integer> items = new HashSet<>(); 
		System.out.println(l2.stream().filter(n -> !items.add(n)).collect(Collectors.toSet())); 
		
	}

	public static void getFirstNMimndNMax() {
		System.out.println("\n\nFind nth smallest and Nth largest number\n"+list);
		System.out.println("Please enter value of N between 1 to "+list.size());
		Scanner s= new Scanner(System.in);
		int i= s.nextInt();
		System.out.print("\n\nFind nth smallest ");
		System.out.print(list.stream().distinct().sorted().skip(i).findFirst());
		System.out.print("\n\nFind nth largest ");
		System.out.print(list.stream().distinct().sorted(Comparator.reverseOrder()).skip(i).findFirst());
	}
	
	public static void fibonacciSeries() {
		System.out.println("\n\nFibonacci series, Please enter a number");
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		System.out.println(Stream.iterate(new int[] {0,1},f->new int[] {f[1],f[0]+f[1]}).limit(i).map(f->f[0]).toList());
	}


}
