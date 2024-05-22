package com.org.streams.first.jpmhackerrank;

public class PalindromeReplacement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String breakPalindrome(String palindrome) {
		int n = palindrome.length();

		if (n == 1)
			return "";

		char[] chars = palindrome.toCharArray();

		// Iterate through the first half of the string
		for (int i = 0; i < n / 2; i++) {
			// If the current character is not 'a', change it to 'a' and return the modified
			// string
			if (chars[i] != 'a') {
				chars[i] = 'a';
				return new String(chars);
			}
		}

		// If all characters in the first half are 'a', change the last character to 'b'
		chars[n - 1] = 'b';
		return new String(chars);
	}
	
	public static String breakPalindrome1(String palindrome) {
	     
	     char[] arr = palindrome.toCharArray();
	     int i=0;
	     if(arr.length == 1) return "";

	     int limit = arr.length/2 ;//+ (arr.length % 2 ==0?0:1);
	     while(i <  limit && arr[i] == 'a')i++;
	    //  System.out.println(limit+" "+i);
	     if(i< limit){
	        arr[i] = 'a';
	     }
	     else {
	        arr[arr.length-1] = 'b';
	     }

	     return new String(arr);

	    }


}
