package com.org.streams.first.jpmhackerrank;

public class ReverseInteger {

	public static void main(String[] args) {
		System.out.println(reverseInteger(123));
		System.out.println(reverseInteger(-321));
		System.out.println(reverseInteger(1534236469));
	}
	
	public static int reverseInteger(int x) {
		
		
		String numStr = Integer.toString(x);
		 
        // Reverse the string using the substring method
        String reversedStr = new StringBuilder(numStr)
                                 .reverse()
                                 .toString();
 
        // Convert the reversed string back to an integer
        int reversedNum = Integer.parseInt(reversedStr);
        
        if(x<0) {
        	reversedNum=reversedNum*(-1);
        }
 
        return reversedNum;
	}
	
	public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            negative = true;
        }

        long rev = 0;

        while (0 != x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        if(rev < -2147483648 || 2147483647 < rev) {
            return 0;
        }
        return (int) rev;  
	}

}
