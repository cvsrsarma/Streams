package com.org.streams.first.jpmhackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class GudPrimeNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean flag=false;
		System.out.println("Enter a number");
		int n= sc.nextInt();
		int k= sc.nextInt();
		System.out.println(getNthPrime(n,k));
	}

	private static int getNthPrime(int n, int k) {
		int c=0;
		ArrayList<Integer> list= new ArrayList<Integer>();
		for(int i=n; c<=k; i++) {
			int temp=i;
			int sum=0;
			while(temp!=0) {
				sum=sum+temp%10;
				temp=temp/10;
			}
			if(isPrime(sum)) {
				list.add(i);
				c++;
			}
		}
		return list.get(k-1);
	}

	private static boolean isPrime(int sum) {
		if(sum<=1)
			return false;
		if(sum<=3)
			return true;
		if(sum%2==0 || sum %3==0)
			return false;
		for(int i=5; i*i<sum; i+=6) {
			if(sum%i==0 ||(sum%(i+2)==0)) {
				return false;
			}
			
		}
		return true;
	}

}
