package com.org.streams.first.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class StringsAssign {

	public static String StringChallenge(String strArr) {
	    System.out.println();
	    return strArr;
	  }

	  public static void main1 (String[] args) {  
	    // keep this function call here     
	   
	   
	    
	    System.out.print(arrayChallenge()); 
	  }
	  
	  
	  public static String arrayChallenge() {
		  Scanner s = new Scanner(System.in);
		    String s1= s.nextLine();
		    String s2=s.next();
		    System.out.println(s1);
		    System.out.println(s2);
		    String[] wordToSplit = s1.toLowerCase().split("");
		    
		    
		    boolean[] myArray = new boolean[s2.length()];
		    int index0=0,indexn=0;
		    String[] dictionaryWords=s2.toLowerCase().split("");
		    //List<String> dictionaryWords = Arrays.stream(s2.split("")).collect(Collectors.toList());
		    System.out.println("adfasdf"+dictionaryWords);
		    for(int i=0;i<s1.length();i++) {
		    	for(int j=0;j<s2.length();j++) {
		    		System.out.println(wordToSplit[i].contains(dictionaryWords[j])+"  "+wordToSplit[i]+"   "+dictionaryWords[j]);
		    		if(wordToSplit[i].contains(dictionaryWords[j])){
		    			if(index0==0) {
		    				index0=i;
		    				indexn=i;
		    			}
		    			
		    			indexn=i;
		    			myArray[j]=true;
		    		}
		    	}}
		    	for(int o=0;o<myArray.length ;o++) {
		    		System.out.println(myArray[o]);
		    		if(!myArray[o]) {
		    			
		    			
		    			return "not possible";
		    		}
		    	}
		    	return s1.substring(index0,indexn);
		    
		   
		}

	  public static String arrayChallenge(String[] strArr) {

		    String wordToSplit = strArr[0];
		    Set<String> dictionaryWords = Arrays.stream(strArr[1].split(",")).collect(Collectors.toSet());

		    for (int i = wordToSplit.length() - 1; i > 0; i--) {
		        String firstWord = wordToSplit.substring(0, i);
		        String lastWord = wordToSplit.substring(i);

		        if (dictionaryWords.contains(firstWord) && dictionaryWords.contains(lastWord)) {
		            return firstWord + "," + lastWord;
		        }
		    }
		    return "not possible";
		}
	  public static int NumberOfways(int N, int K)
	    {
	        // Base case
	        if (N == 0)
	            return 1;
	        if (N < 0 || K <= 0)
	            return 0;
	 
	        // including and not including K in sum
	        return NumberOfways(N - K, K)
	            + NumberOfways(N, K - 1);
	    }
	 
	    // Driver code
	    public static void main(String[] args)
	    {
	        int N = 8;
	        int K = 2;
	 
	        // function call
	        System.out.println(NumberOfways(N, K));
	    }
}
