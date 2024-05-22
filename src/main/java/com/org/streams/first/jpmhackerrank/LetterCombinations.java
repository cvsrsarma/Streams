package com.org.streams.first.jpmhackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

	public static void main(String[] args) {
		System.out.println(letterCombinations("23"));

	}
	
	public static List<String> letterCombinations(String digits) {
		 List<String> result = new ArrayList<>();
	        if (digits == null || digits.length() == 0) {
	            return result;
	        }
	        Map<Character, String> map = new HashMap<>();
	        map.put('2', "abc");
	        map.put('3', "def");
	        map.put('4', "ghi");
	        map.put('5', "jkl");
	        map.put('6', "mno");
	        map.put('7', "pqrs");
	        map.put('8', "tuv");
	        map.put('9', "wxyz");
	        backtrack(result, map, digits, new StringBuilder(), 0);
	        
	        return result;
	        
	}
	        private static void backtrack(List<String> result, Map<Character, String> map, String digits, StringBuilder combination, int index) {
	            // Base case: If the combination's length is equal to the digits length, add it to the result
	            if (index == digits.length()) {
	                result.add(combination.toString());
	                return;
	            }

	            // Get the current digit
	            char digit = digits.charAt(index);

	            // Get the corresponding letters for the current digit
	            String letters = map.get(digit);

	            // Iterate through the letters and append each to the combination
	            for (int i = 0; i < letters.length(); i++) {
	                // Append the letter to the combination
	                combination.append(letters.charAt(i));
	                
	                // Recursively generate combinations for the remaining digits
	                backtrack(result, map, digits, combination, index + 1);
	                
	                // Backtrack: Remove the last character to explore other possibilities
	                combination.deleteCharAt(combination.length() - 1);
	            }
	        }


}
