package com.org.streams.first.utils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringStreamEx {
	
	public static List<String> list;
	
	static {
		list=StringUtils2.getRandomSizeList();
	}

	public static void findCountEachCharInaString() {
		String s= "Find total occurence of each char in a String.";
		System.out.println(s);
		System.out.println(s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
	}

	public static void sortListOfStringInIncreasingOrder() {
		String s= "Sort list of String increasing order by length";
		System.out.println(list.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()));
	}
	
	public static void palindrome() {
		String s= "Find total occurence of each char in a arraylist of String.";
		System.out.println(s);
		list.stream().forEach(e->{
			e.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().forEach(System.out::println);
		});
		
		String s1= "Find total palindrome of in a string ja1va av1aj kava avak.";
		System.out.println(s1);
		String ary[]=s1.split(" ");
		for(int j=0;j<ary.length;j++) {
			String s0=ary[j];
			System.out.println(s0+" ");
			System.out.print(IntStream.range(0, s0.length()/2).noneMatch(i->s0.charAt(i)!=s0.charAt(s0.length()-i-1)));
		}
	}

	public static void findanagram() {
		System.out.println("\n\nAnagram example");
		String s1="javaIsgud";
		String s2="gudJavais";
		s1=Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		s2=Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
		if(s1.equals(s2)){
			System.out.println("its Anagram.");
		}
	}
	
	public static void reverseEachWord() {
		
		String s="reverse each string in this sentence";
		String s2= Arrays.stream(s.split(" ")).map(e-> new StringBuffer(e).reverse()).collect(Collectors.joining(" "));
		System.out.println(s);
		System.out.println(s2);
	}

}
