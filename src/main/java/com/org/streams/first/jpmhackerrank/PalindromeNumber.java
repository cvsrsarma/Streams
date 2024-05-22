package com.org.streams.first.jpmhackerrank;

import com.org.streams.first.utils.StringUtils;

public class PalindromeNumber {

	public static void main(String[] args) {
		isPalindromeNumber(121);
		
	}

	private static boolean isPalindromeNumber(int x) {
		int sum = 0, target =x;;
        while(x>0){
            int temp = x%10;
            x=x/10;
            sum = sum*10 + temp;
        }
    return sum==target ;
	}
	private static boolean isPalindromeNumber1(int x) {
		String s=String.valueOf(x);
		String s1="";
		for(int i=s.length()-1; i>=0;i--) {
			s1=s1+s.charAt(i);
		}
		return s.equals(s1);
	}

}
