package com.org.streams.first.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class StringUtils2 {
	
	public static List<String> sList = new ArrayList<>();
	public static final String AB="ABCDEFGHIJKLMNOPQRSRTUVWXYZ";
	public static final String ba="abcdefghijklmnopqrstuvwxyz";
	static {
		sList.add("java");
		
		Random rand= new Random();
		int i= rand.nextInt(AB.length());
		int j= rand.nextInt(10);
		if(j<5)
			j+=3;
		
		for(int o=0;o<j;o++) {
			String str= AB.charAt(i)+""+ba.charAt(i);
		for (int k=0; k<j;k++) {
			int temp= rand.nextInt(ba.length());
			str=str+""+ba.charAt(temp);
		}
		sList.add(str.toLowerCase());
		
		}
		int x= rand.nextInt(sList.size());
		String temp=sList.get(x);
				sList.add(temp);
		sList.add("ajav");
		System.out.println(temp);
				
	}
	public static void validateSameChars() {
		System.out.println(sList);
		Map<String, Double> map = new HashMap<>();
		sList.stream().forEach(e->{
			double asci=Arrays.stream(e.split("")).map(c->(int)c.toCharArray()[0]).reduce(0, (s1,s2)->s1+s2).doubleValue();
			map.put(e,asci);
					
		});
		System.out.println(map);
		Map<Double,List<String>> grpByAsci = map.entrySet().stream().
				collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		System.out.println(grpByAsci);
		
		
		Map<String, Double> m= new HashMap();
		sList.stream().forEach(e->{
			double as= Arrays.stream(e.split("")).map(c->(int)c.toCharArray()[0]).reduce(0, (s1,s2)->s1+s2).doubleValue();
			m.put(e,as);
		});
		System.out.println("\n\n"+m+"\n\n");
		Map<Double,List<String>> m1= m.entrySet().stream().collect(Collectors.groupingBy(Map.Entry::getValue,
				Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
		
		System.out.println("\n\n"+m1.values()+"\n\n");
	}
	
	public static void main(String [] args) {
		validateSameChars();
		
		String arr[] = { "abcd", "java", "dcba", "ajav", "xyz", "epam", "pame", "aepm" };
		//============================================================================= 
		 Map<String , Double> mapWithAscii =  new HashMap<>();
		  Arrays.stream(arr).forEach(a->{
		  double asci = Arrays.stream(a.split("")).map(cha->(int)cha.toCharArray()[0]).reduce(0 , (s1,s2)->s1+s2).doubleValue();
		  mapWithAscii.put(a, asci);
		 });
		 System.out.println(mapWithAscii+"\n\n");
		 Map<Double, List<String>> groupedBySameAsCIIValue = mapWithAscii.entrySet().stream().
		   collect(Collectors.groupingBy(Map.Entry::getValue 
		   , Collectors.mapping(Map.Entry::getKey, Collectors.toList())
		   ));
		
		  System.out.println("::::Answer::::::\n"+groupedBySameAsCIIValue.values());
		  ConcurrentHashMap<String, Integer> map1 = new ConcurrentHashMap<>();
		  map1.put(null, 43);
		  map1.put("", null);
		  
	}
	
	

}
