package com.org.streams.first.jpmhackerrank;

public class LongestPalindrome {

	public static void main(String[] args) {
        String s = "babad";
        String longestPalindrome = longestPalindrome(s);
        s= "cbba";
        System.out.println("Longest palindromic substring: " + longestPalindrome);
        longestPalindrome = longestPalindrome(s);
        System.out.println("Longest palindromic substring: " + longestPalindrome);

	}
	
	private static int start;
	private static int maxLength;

    public static String longestPalindrome(String s) {
    	if (s == null || s.length() == 0) {
        return "";
    }

    int start = 0, maxLength = 0;
    for (int i = 0; i < s.length(); i++) {
        int len1 = expandAroundCenter(s, i, i); // For odd length palindromes
        int len2 = expandAroundCenter(s, i, i + 1); // For even length palindromes
        int len = Math.max(len1, len2);
        if (len > maxLength) {
            maxLength = len;
            start = i - (len - 1) / 2;
        }
    }
    return s.substring(start, start + maxLength);
    }
    
    private static int expandAroundCenter(String s, int left, int right) {
    	while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
        left--;
        right++;
    }
    return right - left - 1;
    }


}
