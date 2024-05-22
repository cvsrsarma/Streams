package com.org.streams.first.jpmhackerrank;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static void main(String[] args) {
		int arr[]= new int[4];
		arr[0]=2;arr[1]=7;
		arr[2]=11;arr[3]=15;
		Arrays.stream(twoSum(arr,9)).forEach(System.out::print);

	}
	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
	}

}
