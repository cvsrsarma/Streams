package com.org.streams.first.jpmhackerrank;

import java.util.Scanner;

public class VowelEncryption {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String vowel = "aeiou";
		char arr[] = new char[10];
		arr[0]= ' ';
        arr[2] = 'a';
        arr[3] = 'e';
        arr[5] = 'i';
        arr[7] = 'o';
        char ch = 'b';
        
        System.out.println(isHappy(1111111));
       
        
		System.out.println("Enter a number with out a zero");
		String n= sc.next();
		if (!(n.matches("[0-9]+") && n.length() >1)) {
			System.out.println(n +" is not a valid number");
		} else {
		for(int i=1; i<arr.length;i++) {
			if(arr[i]==0) {
				arr[i]=ch;
				ch++;
			} 
			
		}
		String encStr="";
		int rev=0;
		int temp=Integer.parseInt(n);
		while(temp!=0) {
			rev=rev*10+temp%10;
			temp=temp/10;
		}
		while(rev!=0) {
			System.out.print(arr[rev%10]);
			rev= rev/10;
		}
	}
	}
	
	public static boolean isHappy(int n) {
        while (true) 
       {
           if (n == 1)
               return true;
   
           n = sumDigitSquare(n);
           if (n == 4)
               return false;
       }
       
   }

   static int sumDigitSquare(int n)
   {
       int sq = 0;
       while (n != 0) 
       {
           int digit = n % 10;
           sq += digit * digit;
           n = n / 10;
       }
       return sq;
   }

}
