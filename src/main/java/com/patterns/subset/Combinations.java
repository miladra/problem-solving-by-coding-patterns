package com.patterns.subset;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), 1, n, k);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
            // base case
            if (current.size() == k) {
                result.add(new ArrayList<>(current));
                return;
            }
            // iterate over remaining numbers
            for (int i = start; i <= n; i++) {
                // choose number
                current.add(i);
                // explore next level
                backtrack(result, current, i + 1, n, k);
                // unchoose number
                current.remove(current.size() - 1);
            }
        }
}
