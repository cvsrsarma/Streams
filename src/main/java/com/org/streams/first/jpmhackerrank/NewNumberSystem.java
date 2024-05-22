package com.org.streams.first.jpmhackerrank;

import java.util.Scanner;

public class NewNumberSystem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag=false;
		do {
			System.out.println("Enter a number a to t");
		String s= sc.next();
		int value=findDecValue(s, s.length()-1,0);
		System.out.println(value);
		flag= sc.next().equals("y");
		}while(flag);
		
	}

	private static int findDecValue(String s, int n, int i) {
		if(n<0)
			return 0;
		else
			return(s.charAt(n)-'a'+1)*(int)Math.pow(20, i)+findDecValue(s,n-1,i+1);
	}

}
