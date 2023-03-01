package com.patterns.slidingwindow;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        int res = 0, i = 0;
        for (int j = 0; j < tree.length; ++j) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            while (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                if (count.get(tree[i]) == 0) count.remove(tree[i]);
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    @Test
    public void testTotalFruit() {
        FruitIntoBaskets solution = new FruitIntoBaskets();
        int[] tree1 = {1, 2, 1};
        int[] tree2 = {0, 1, 2, 2};
        int[] tree3 = {1, 2, 3, 2, 2};

        assertEquals(3, solution.totalFruit(tree1));
        assertEquals(3, solution.totalFruit(tree2));
        assertEquals(4, solution.totalFruit(tree3));

    }

}


