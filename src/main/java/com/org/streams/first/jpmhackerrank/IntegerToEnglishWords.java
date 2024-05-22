package com.org.streams.first.jpmhackerrank;

public class IntegerToEnglishWords {
	
	private final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] thousands = {"", "Thousand", "Million", "Billion"};

    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        int i = 0; // Index for thousands array
        String words = "";
        
        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }
        
        return words.trim();
    }

    private String helper(int num) {
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return ones[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + helper(num % 10);
        } else {
            return ones[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public static void main(String[] args) {
        IntegerToEnglishWords solution = new IntegerToEnglishWords();
        int num = 123;
        System.out.println("Input: num = " + num);
        System.out.println("Output: " + solution.numberToWords(num));
    }

}

class Solution {

    private final String[] belowTwenty = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if(num==0){
            return "Zero";
        }
        return helper(num);
    }

        String helper(int num){
            String result = new String();
            if(num < 20 ){
                result = belowTwenty[num];
            }
            else if(num < 100 ){
                result = belowHundred[num/10] + " " +  helper(num%10);
            }
            else if(num < 1000 ){
                result = helper(num/100) + " Hundred " +  helper(num%100);
            }
            else if(num < 1000000 ){
                result = helper(num/1000) + " Thousand " +  helper(num%1000);
            }
            else if(num < 1000000000 ){
                result = helper(num/1000000) + " Million " +  helper(num%1000000);
            }
            else {
                result = helper(num/1000000000) + " Billion " +  helper(num%1000000000);
            }

            return result.trim();
            
        }
    }
