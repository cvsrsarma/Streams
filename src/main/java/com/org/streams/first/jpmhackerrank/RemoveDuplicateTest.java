package com.org.streams.first.jpmhackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class RemoveDuplicateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag=false;
		System.out.println("Enter a number");
		String s= sc.nextLine();
		
		String sAry[] = s.split(" ");
		String frist=sAry[0];
		LinkedHashMap<String, Boolean> map= new LinkedHashMap<String, Boolean>();
		
		Set<String> set = new HashSet<String>();
		
		System.out.println(Arrays.stream(s.split(" ")).map(e->e.toLowerCase()).filter(e->set.add(e)).collect(Collectors.toList()));
		Arrays.stream(s.split(" ")).map(e->e.toLowerCase().concat(" ")).filter(e->set.add(e)).forEach(System.out::print);
		
		for(int i=0; i<sAry.length;i++) {
			map.put(sAry[i], true);
		}
		
	}
	
}
