package com.org.streams.first.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.yaml.snakeyaml.util.ArrayUtils;

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
		List<Integer>nList=getListFromAry(arr);
		System.out.println("Find even and do squre");
		nList.stream().filter(e -> e%2 ==0 ).map(e-> e*e)
		.forEach(System.out::println);
		System.out.println("\n Find odd and do qube");
		nList.stream().filter(e -> e%2 ==1 ).map(e-> e*e*e)
		.forEach(System.out::println);
		
		System.out.println();
		System.out.println("\n Find sum of squeres");
		
		System.out.println(nList.stream().map(e -> e*e).reduce(0, Integer::sum));
		
		System.out.println();
		System.out.println("\n Find squres of the 5 multiples");
		System.out.println(nList.stream().filter(e-> e%5==0).map(e->e*e).reduce(0,Integer::sum));
	
				
	}
	
	public static void filterStrings() {
		List<String>nList=Arrays.asList(strAry);
		System.out.println("\n Find all String Contails Spring");
		nList.stream().filter(e-> e.contains("Spring")).forEach(System.out::println);
		System.out.println("\n Find all String lengths");
		nList.stream().map(e -> e+" "+e.length()).forEach(System.out::println);
		System.out.println("\nSort the strings");
		nList.stream().sorted().forEach(System.out::println);
		
		System.out.println("\nSort in reverse order strings");
		nList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
	
	public static void addNumebrsList() {
		List<Integer> nList=getListFromAry(arr);
		System.out.println("\n Add all nunbers");
		System.out.println(nList.stream().reduce(0, Utils::add)+"\n");
		System.out.println("\n Add all nunbers");
		System.out.println(nList.stream().reduce(0, (x,y)-> x+y)+"\n");
		System.out.println("\n Add All odd nunbers");
		System.out.println(nList.stream().filter(e-> e%2==1).reduce(0, Integer::sum)+"\n");
		System.out.println("\n All even squeres nunbers");
		System.out.println(nList.stream().filter(e-> e%2==0).map(e -> e*e).reduce(0,Integer::sum)+"\n");
		System.out.println("\nRemove duplicates");
		
		nList=getListFromAry(arr1);
		nList.stream().distinct().forEach(System.out::println);
		System.out.println("\nSort the numbers");
		nList.stream().sorted().forEach(System.out::println);
		System.out.println("\nRemove duplicates and Sort the numbers");
		nList.stream().distinct().sorted().forEach(System.out::println);
		
		
	}
	
	public static int add(int a, int b) {return a+b;}
	
	public static List<Integer> getListFromAry(int[] intAry){
		return Arrays.stream(intAry).boxed().toList();
	}
	

}
