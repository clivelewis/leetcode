package io.github.clivelewis.problems.easy;

import io.github.clivelewis.testutils.TestExecutor;

/*
896. Monotonic Array

An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.
https://leetcode.com/problems/monotonic-array/

 */
public class LeetCode896 {
    public static void main(String[] args) {
        TestExecutor.execute(isMonotonic(new int[]{1,2,2,3}), true);
        TestExecutor.execute(isMonotonic(new int[]{1,2,1}), false);
        TestExecutor.execute(isMonotonic(new int[]{}), true);
        System.out.println("Success!");
    }

    private static boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) return true;

        int index = 1;
        while (index < nums.length && nums[index] == nums[0]) index++;

        if (index < nums.length) {
            boolean isIncreasing = nums[index] > nums[0];

            for (int i = index; i < nums.length; i++) {
                if (isIncreasing && nums[i] < nums[i - 1]) return false;
                if (!isIncreasing && nums[i] > nums[i - 1]) return false;
            }
        }
        return true;
    }
}
