package com.patterns.binarysearch;

public class SearchRotatedSorted {
        public int search(int[] nums, int target) {
            if(nums.length == 0)
                return -1;

            int n = nums.length;
            int left = 0, right = n - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                // pivot is to the right of mid
                if (nums[mid] > nums[right]) {
                    left = mid + 1;
                // pivot is to the left of mid
                } else {
                    right = mid;
                }
            }
            // left and right now point to the same element - the pivot
            int pivot = left;

            // reset left and right pointers for binary search on the appropriate subarray
            left = 0;
            right = n - 1;
            // target lies in the right subarray
            if (target >= nums[pivot] && target <= nums[right]) {
                left = pivot;
            // target lies in the left subarray
            } else {
                right = pivot - 1;
            }

            // standard binary search on the appropriate subarray
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // target not found
            return -1;
        }
}

