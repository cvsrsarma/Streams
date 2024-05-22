package com.org.streams.first.jpmhackerrank;

public class RotatedSortedArraySearch {

	public static void main(String[] args) {
		RotatedSortedArraySearch solution = new RotatedSortedArraySearch();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int index = solution.search(nums, target);
        System.out.println("Index of target " + target + ": " + index);

	}
	
	public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        // Binary search to find the rotation pivot
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        int pivot = left;
        left = 0;
        right = nums.length - 1;

        // Decide which subarray to search based on the target and pivot
        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot;
        }

        // Binary search on the appropriate subarray
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Target not found
    }

}
