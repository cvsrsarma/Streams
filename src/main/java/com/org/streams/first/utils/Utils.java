package com.org.streams.first.utils;

import java.security.SecureRandom;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Utils {
	public static int[] arr = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
	public static String[] strAry = {"AWS" ,"Azure" ,"Google Cloud Platform - GCP)" ,"DevOps" ,"Full Stack","React" ,"Angular" ,"Serverless" ,"Programming", "Spring Boot"};
	public static int[] arr1 = { 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 3, 5, 6, 7, 8, 9,34,3,93,83,2,4,16,4,6,7,2,23,56,2,53,24,63,43};
	
	public static void findMissingNumber() {
		
        int N = arr.length;
        System.out.println(getMissingNo(arr,N));
	}
	public static int getMissingNo(int[] nums,int n)
    {
		System.out.println(n);
		
       int sum = 0;
        for(int i=0;i<n;i++){
            sum = sum + nums[i];
        }System.out.println(sum);
        n++;
        System.out.println((n* (n+1))/2);
        return ((n * (n+1))/2 - sum);
    }
	
	public static void printEven() {
		List<Integer>nList=list;
		System.out.println(nList+"\n\n");
		nList.stream().filter(e->e%2==0).forEach(System.out::print);
		System.out.println("\n\nFind even and do squre");
		nList.stream().filter(e -> e%2 ==0 ).map(e-> e*e).forEach(System.out::print);
		System.out.println("\n Find odd and do qube");
		nList.stream().filter(e -> e%2 ==1 ).map(e-> e*e*e)
		.forEach(System.out::println);
		
		System.out.println();
		System.out.println("\n\n Find sum of squeres");
		
		System.out.println(nList.stream().map(e -> e*e).reduce(0, Integer::sum));
		
		System.out.println();
		System.out.println("\n Find squres of the 5 multiples");
		System.out.println(nList.stream().filter(e-> e%5==0).map(e->e*e).reduce(0,Integer::sum));
	
				
	}
	
	public static void filterStrings() {
		List<String>nList=Arrays.asList(strAry);
		System.out.println("\n Find all String Contails Spring");
		nList.stream().filter(e-> e.toUpperCase().contains("SPRING")).forEach(System.out::println);
		System.out.println("\n Find all String lengths");
		nList.stream().map(e -> e+" "+e.length()).forEach(System.out::println);
		System.out.println("\nSort the strings");
		nList.stream().sorted().forEach(System.out::println);
		
		System.out.println("\nSort in reverse order strings");
		nList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	public static void addNumebrsList() {
		List<Integer> nList=list;
		System.out.println("\n Add all nunbers");
		System.out.println(nList.stream().reduce(0, Utils::add)+"\n");
		System.out.println("\n Add all nunbers");
		System.out.println(nList.stream().reduce(0, (x,y)-> x+y)+"\n");
		System.out.println("\n Add All odd nunbers");
		System.out.println(nList.stream().filter(e-> e%2==1).reduce(0, Integer::sum)+"\n");
		System.out.println("\n All even squeres nunbers");
		System.out.println(nList.stream().filter(e-> e%2==0).map(e -> e*e).reduce(0,Integer::sum)+"\n");
		System.out.println("\nRemove duplicates");
		
		nList=getListFromAry2();
		nList.stream().distinct().forEach(System.out::println);
		System.out.println("\nSort the numbers");
		nList.stream().sorted().forEach(System.out::println);
		System.out.println("\nRemove duplicates and Sort the numbers");
		nList.stream().distinct().sorted().forEach(System.out::println);
		
		
	}
	
	private static List<Integer> getListFromAry2() {
		return Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 3, 5, 6, 7, 8, 9,34,3,93,83,2,4,16,4,6,7,2,23,56,2,53,24,63,43);
	}
	public static int add(int a, int b) {return a+b;}
	
	
	
	public static void createStream() {
		
		IntStream.range(0,  25).filter(e->e%2==0).forEach(System.out::print);
		
	}
	
	public static void seprateOddAndEvenNumbers() {
		
		List<Integer> list= getIntegerList();
		System.out.println(list);
		System.out.println(list.stream().sorted().collect(Collectors.partitioningBy(e->e%2==0)));
		System.out.println("\n\nSort the List in Reverse order");
		List<Integer> l1= list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
		System.out.println(l1);
		System.out.println("\n\n");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		System.out.println("\n\n");
		
		System.out.println("Multiples of 3");
		System.out.println(list);
		List<Integer> mList=list.stream().filter(e->e>0).map(e->e*3).collect(Collectors.toList());
		System.out.println(mList);
		}
	
	public static void mergeUnsotred2Arrysto1Ary() {
		
		int[] l1= getIntArray();
		int[] l2= getIntArray();
		
		IntStream.concat(Arrays.stream(l1), Arrays.stream(l2)).sorted().distinct().forEach(System.out::print);
		System.out.println("\n\n");
		
		
	}
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static List<Integer> getIntegerList(){
		if(null!=list && list.size()>0)
			return list;
		Random ran = new Random();
		System.out.println("Enter an Integer");
		Scanner scan = new Scanner(System.in);
		int i= scan.nextInt();
		
		for(int j=0;j<i;j++) {
			list.add(ran.nextInt(200));
		}
		return  list;
	}
	public static int[] getIntArray(){
		Random ran = new Random();
		System.out.println("Enter an Integer");
		Scanner scan = new Scanner(System.in);
		int i= scan.nextInt();
		int[] list = new int[i];
		for(int j=0;j<i;j++) {
			list[j]=ran.nextInt(200);
		}
		return  list;
	}
	public static void divideList() {
		System.out.println("List of integers, separate odd and even numbers");
		List<Integer> iL=getIntegerList();
		Map<Boolean, List<Integer>> map=iL.stream().sorted().collect(Collectors.partitioningBy(e->e%2==0));
		System.out.println(map);
	}
	public static List<Double> decimalList=Arrays.asList(12.45,793.47,263.5697,26.593,42.5937,476.4592,36.93,49.82,273.427,27.36,49.82,472.48);
	
	public static void sortDecimalList() {
		System.out.println("\n\nSort Decimal list");
		System.out.println(decimalList);
		System.out.println(decimalList.stream().sorted().collect(Collectors.toList()));
		System.out.println("\n\nSort Decimal list reverse order");
		System.out.println(decimalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
	}
	public static void getFirstNMimndNMax() {
		System.out.println("\n\nget First N miminum and N maxmim numbers");
		System.out.println(decimalList);
		System.out.println("Please enter value of N between 1 to "+arr1.length);
		Scanner s= new Scanner(System.in);
		int i= s.nextInt();
		List<Integer> iL= getListFromAry2();
		System.out.println(iL);
		System.out.println(iL.stream().collect(Collectors.toSet()).stream().sorted().limit(i).collect(Collectors.toList()));
		//forEach(System.out::print);
		//.forEach(System.out::print);
		System.out.println("\n");
		System.out.println(iL.stream().sorted(Comparator.reverseOrder()).limit(i).collect(Collectors.toList()));
	}
	public static void sumOfAllDigist() {
		System.out.println("Enter a number");
		Scanner s = new Scanner(System.in);
		int i= s.nextInt();
		System.out.println(Stream.of(String.valueOf(i).split("")).collect(Collectors.summarizingInt(Integer::parseInt)));
	}
	static SecureRandom rnd = new SecureRandom();
	public static void findCommonNumbersFrom2Arys() {
		System.out.println("Enter a array size and range ");
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> l1=new ArrayList<Integer>(),l2=new ArrayList<Integer>();
		int i=s.nextInt();
		for(int j=0; j<i;j++) {
			l1.add(rnd.nextInt(30+i));
			l2.add(rnd.nextInt(35)+i);
		}
		System.out.println(l1);
		System.out.println(l2);
		System.out.println("common numbers");
		l1.stream().filter(l2::contains).forEach(System.out::print);
	}
	public static void highestFromGivenList() {
		System.out.println("\n\n highest number that exists on a list?");
		List<Integer> list= getListFromAry2();
		IntSummaryStatistics stats =list.stream().mapToInt(x->x).summaryStatistics();
		System.out.println(stats.toString());
	}
	
	public static void find2ndFridayOfNextMonth() {
		System.out.println("second Friday of next month");
		LocalDate l= LocalDate.now();
		System.out.println(l);
		LocalDate firstInYear = LocalDate.of(l.getYear(),l.getMonth(), 1);
		LocalDate nextMonth= LocalDate.now().plusMonths(1).with(TemporalAdjusters.dayOfWeekInMonth(2, DayOfWeek.FRIDAY));
		System.out.println(nextMonth);
	}
}
