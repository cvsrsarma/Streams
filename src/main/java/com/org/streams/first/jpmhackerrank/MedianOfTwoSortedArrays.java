package com.org.streams.first.jpmhackerrank;

public class MedianOfTwoSortedArrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        // Ensure nums1 is the smaller array
        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int left = 0;
        int right = m;
        int totalLength = m + n;
        
        while (left <= right) {
            int pX = left + (right - left) / 2;
            int pY = (totalLength + 1) / 2 - pX;
            
            // Calculate the maximum and minimum elements on the left and right sides for both arrays
            int minX = (pX == m) ? Integer.MAX_VALUE : nums1[pX];
            int maxX = (pX == 0) ? Integer.MIN_VALUE : nums1[pX - 1];
            int maxY = (pY == 0) ? Integer.MIN_VALUE : nums2[pY - 1];
            int minY = (pY == n) ? Integer.MAX_VALUE : nums2[pY];
            
            if (maxX <= minY && maxY <= minX) {
                // Found the correct partition positions
                if (totalLength % 2 == 0) {
                    // If the total length is even, return the average of the maximum element on the left and minimum element on the right
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    // If the total length is odd, return the maximum element on the left
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                // Move the partition towards the left side of nums1
                right = pX - 1;
            } else {
                // Move the partition towards the right side of nums1
                left = pX + 1;
            }
        }
        
        // Should never reach here
        throw new IllegalArgumentException("Input arrays are not sorted!");
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays solution = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Input: nums1 = [1, 3], nums2 = [2]");
        System.out.println("Output: " + solution.findMedianSortedArrays(nums1, nums2));
    }

}
