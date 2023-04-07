package com.patterns.hashing;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionBruteForce {
    // time: O(N*N)
    // space: O(1)
    public int[] twoSum(int[] nums, int target) {

        int n = nums.length-1;
        int[] result = new int[2];

        for(int j=0;j<n;j++){
            for(int i=j+1 ; i<=n ; i++){
                if(nums[j]+nums[i]==target){
                    result[0] = j;
                    result[1] = i;
                }
            }
        }
        return result;
    }
}

class Solution{
    // time: O(N)
    // space: O(N)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i=0; i< nums.length ; i++){
            int diff = (int)(target - nums[i]);
            if(map.containsKey(diff)){
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i] , i);
        }
        return new int[]{};
    }
}
class SolutionLambda{
    public int[] twoSum(int[] nums, int target) {
        return IntStream.range(0, nums.length)
                .boxed()
                .flatMap(i -> IntStream.range(i + 1, nums.length)
                        .filter(j -> nums[i] + nums[j] == target)
                        .mapToObj(j -> new int[]{i, j})
                )
                .findFirst()
                .orElse(new int[]{});
    }
}


class SolutionTest {
    @Test
    public void testTwoSum() {
        Solution solution = new Solution();
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        assertArrayEquals(new int[]{0, 1}, result1);

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        assertArrayEquals(new int[]{1, 2}, result2);

        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        assertArrayEquals(new int[]{0, 1}, result3);
    }
}
