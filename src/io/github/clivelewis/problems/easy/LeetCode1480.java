package io.github.clivelewis.problems.easy;

import io.github.clivelewis.testutils.TestExecutor;
/*
1480. Running Sum of 1d Array
Given an array nums. We define a running sum of an array as
runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.
 */
public class LeetCode1480 {
	public static void main(String[] args) {
		TestExecutor.execute(runningSum(new int[]{1,2,3,4}), new int[]{1,3,6,10});
		TestExecutor.execute(runningSum(new int[]{1,1,1,1,1}), new int[]{1,2,3,4,5});
		TestExecutor.execute(runningSum(new int[]{1}), new int[]{1});
		TestExecutor.execute(runningSum(new int[]{}), new int[]{});
		System.out.println("Success!");
	}

	public static int[] runningSum(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			nums[i] = nums[i] + nums[i - 1];
		}

		return nums;
	}
}
