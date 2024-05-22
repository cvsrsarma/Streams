package com.org.streams.first.jpmhackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class NextPermutation {
    public int[] nextPermutation(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        
        // Step 1: Find the pivot
        int pivot = n - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        // Step 2: Find the rightmost element greater than the pivot
        if (pivot >= 0) {
            int successor = n - 1;
            while (nums[successor] <= nums[pivot]) {
                successor--;
            }
            // Step 3: Swap the pivot with the rightmost element greater than the pivot
            swap(nums, pivot, successor);
        }

        // Step 4: Reverse the subarray to the right of the pivot
        reverse(nums, pivot + 1, n - 1);
        result.add(Arrays.stream(nums).boxed().toList());
        return nums;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        NextPermutation np = new NextPermutation();
        int[] arr = {1, 2, 3};
        int[] nextPerm = np.nextPermutation(arr);
        System.out.println("Next permutation of [1, 2, 3]: " + Arrays.toString(nextPerm));
    }
}
