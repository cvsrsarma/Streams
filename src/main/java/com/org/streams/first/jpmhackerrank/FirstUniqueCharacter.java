package com.org.streams.first.jpmhackerrank;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
        String s = "leetcode"; // Example string
        int index = firstUniqChar1(s);
        System.out.println("Index of first non-repeating character: " + index);

	}
	
	public static int firstUniqChar(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Find the first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (frequencyMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1; // If no unique character found
    }
	
	public static int firstUniqChar1(String s) {
	        int[] arr = new int[26];
	        for(char x : s.toCharArray()){
	            arr[x -'a']++;
	        }
	        
	        int ans = 0;
	        
	        for(int i = 0 ; i < s.length() ; i++){
	            char x = s.charAt(i);
	            if(arr[x-'a'] == 1){
	                return i;
	            }
	        }
	        
	        return -1;
	    }
}
