package com.org.streams.first.jpmhackerrank;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        // Base case: If the target becomes zero, add the current combination to the result
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        // Explore all possible candidates starting from the 'start' index
        for (int i = start; i < candidates.length; i++) {
            // Check if the current candidate can be part of the solution
            if (candidates[i] <= target) {
                // Choose the current candidate
                combination.add(candidates[i]);
                // Explore recursively with the updated target and the same start index
                backtrack(candidates, target - candidates[i], i, combination, result);
                // Backtrack: Remove the last added candidate
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinations = solution.combinationSum(candidates, target);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}


