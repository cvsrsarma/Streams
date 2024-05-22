package com.org.streams.first.jpmhackerrank;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfArrays {

	public static void main(String[] args) {
		int a[] = {5,4,-1,7,8};
		int a1[]= {5,-1,9,0,8,-3};
		Arrays.stream(intersection(a,a1)).forEach(System.out::println);
	}
	
		public static int[] intersection(int[] nums1, int[] nums2) {
	        Set<Integer> set = new HashSet<>();
	        Set<Integer> intersect = new HashSet<>();

	        for (int num : nums1) {
	            set.add(num);
	        }

	        for (int num : nums2) {
	            if (set.contains(num)) {
	                intersect.add(num);
	            }
	        }

	        int[] result = new int[intersect.size()];
	        int i = 0;
	        for (int num : intersect) {
	            result[i++] = num;
	        }

	        return result;
	}
		
		public int[] intersection1(int[] nums1, int[] nums2) {
	        boolean[] flag = new boolean[1000];
	        for(int num: nums1){
	            flag[num] = true;
	        }
	        int[] res = new int[1000];
	        int i=0;
	        for(int num: nums2){
	            if(flag[num]){
	                res[i++] = num;
	                flag[num] =  false;
	            }
	        }
	        return Arrays.copyOfRange(res, 0, i);
	    }

}
