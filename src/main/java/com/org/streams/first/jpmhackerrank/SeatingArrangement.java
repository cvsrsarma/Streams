package com.org.streams.first.jpmhackerrank;

import java.util.Scanner;

public class SeatingArrangement {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag=false;
		System.out.println("Enter a number of sitting arrangments");
		int arraySize= sc.nextInt();
		
		int intary[]=new int[arraySize];
		for(int i=0; i<arraySize;i++) {
			intary[i]=sc.nextInt();
		}
		for(int i=0; i<arraySize;i++) {
			possibilites(intary[i]);
		}
	}

	private static void possibilites(int n) {
		int c=0;
		String b="";
		for(int i=0; n!=c;i++) {
			String s=Integer.toString(i,2);
			if(!s.contains("11")) {
				c++;
				b=s;
			}
		}
		
	}

}
