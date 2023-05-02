package com.patterns.subset;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0)
            return result;

        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // base case: if tempList size is equal to nums length
        if (tempList.size() == nums.length) {
            // add tempList to result
            result.add(new ArrayList<>(tempList));
        } else {
            // iterate over each element in nums
            for (int i = 0; i < nums.length; i++) {
                // skip if tempList already contains current element
                if (tempList.contains(nums[i])) continue;
                // add current element to tempList
                tempList.add(nums[i]);
                // recursively call backtrack with remaining elements
                backtrack(result, tempList, nums);
                // remove last element from tempList (backtracking)
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

