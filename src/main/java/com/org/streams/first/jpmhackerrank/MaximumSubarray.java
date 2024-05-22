package com.org.streams.first.jpmhackerrank;

public class MaximumSubarray {

	public static void main(String[] args) {
		int a[] = {5,4,-1,7,8};
		System.out.println(maximumSubarray(a));
	}
	
	public static int maximumSubarray(int [] nums) {
		if (nums == null || nums.length == 0)
            return 0;

        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
	}

}
