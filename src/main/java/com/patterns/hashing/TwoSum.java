package com.patterns.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

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
