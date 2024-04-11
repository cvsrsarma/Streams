package com.org.streams.first.app;

import com.org.streams.first.utils.StringUtils;
import com.org.streams.first.utils.Utils;

public class StreamsEx {

	public static void main(String[] args) {
		StreamsEx.main(args, 1);
		Utils.seprateOddAndEvenNumbers();
		Utils.printEven();
		Utils.filterStrings();
		Utils.addNumebrsList();
		Utils.createStream();
		Utils.findMissingNumber();
		
		StringUtils.loadEmp();
		StringUtils.loadCources();
		StringUtils.findNumberOfFrequencyChars();
		Utils.mergeUnsotred2Arrysto1Ary();
		StringUtils.findMaleNdFemals();
		
		StringUtils.findNumberOFEmpsFromEachDept();
		StringUtils.findYongestEmp();
		StringUtils.findOldestEmp();
		StringUtils.findAvgAgeInDept();
		StringUtils.findHightPaid();
		StringUtils.findAvgSalarMndF();
		StringUtils.findTtlNbrStdsForSbjct();
		
		StringUtils.printStudents();
		
		StringUtils.sortListOfString();
		
		StringUtils.findFndMs();
		
		Utils.divideList();
		
		StringUtils.removeDuplicates();
		Utils.sortDecimalList();
		Utils.getFirstNMimndNMax();
		StringUtils.findAnagrams();
		
		Utils.sumOfAllDigist();
		Utils.findCommonNumbersFrom2Arys();
		StringUtils.strRevAllWords();
		Utils.highestFromGivenList();
	}
	
	public static void main(String rags[],int i) {
		System.out.println("over load Main");
	}
	


	
}

