package com.org.streams.first.jpmhackerrank;

import java.util.PriorityQueue;

public class KthLargestElement {
	   public int findKthLargest(int[] nums, int k) {
	        // Create a min heap of size k
	        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	        
	        // Add the first k elements to the min heap
	        for (int i = 0; i < k; i++) {
	            minHeap.offer(nums[i]);
	        }
	        
	        // Iterate through the remaining elements in the array
	        for (int i = k; i < nums.length; i++) {
	            // If the current element is greater than the smallest element in the min heap,
	            // remove the smallest element and add the current element to the min heap
	            if (nums[i] > minHeap.peek()) {
	                minHeap.poll();
	                minHeap.offer(nums[i]);
	            }
	        }
	        
	        // The root of the min heap will be the kth largest element
	        return minHeap.peek();
	    }

	    public static void main(String[] args) {
	        KthLargestElement solution = new KthLargestElement();
	        
	        int[] nums1 = {3, 2, 1, 5, 6, 4};
	        int k1 = 2;
	        System.out.println("Kth largest element for nums1: " + solution.findKthLargest(nums1, k1));
	        
	        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
	        int k2 = 4;
	        System.out.println("Kth largest element for nums2: " + solution.findKthLargest(nums2, k2));
	    }
	    
	    /*
	     * Sol 2
	     */
	    
	    class Solution {
	        public int findKthLargest(int[] nums, int k) {
	            PriorityQueue<Integer> pri = new PriorityQueue<>((a,b)-> b-a);
	            for(int i: nums){
	                pri.add(i);
	            }
	            int large = 0;
	            System.out.println(pri);
	            while(k>0){
	                large = pri.poll();
	                k--;
	                
	            }
	            return large;
	        }
	    }
}
