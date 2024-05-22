package com.org.streams.first.jpmhackerrank;

public class HappyNumber {

	public static void main(String[] args) {
		isHappy(1111111);
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
