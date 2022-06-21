package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

/*
209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target,
return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr]
of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.
https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class LeetCode209 {
	public static void main(String[] args) {
		TestExecutor.execute(minSubArrayLen(7, new int[]{2,3,1,2,4,3}), 2);
		TestExecutor.execute(minSubArrayLen(4, new int[]{1,4,4}), 1);
		TestExecutor.execute(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}), 0);
		System.out.println("Success!");
	}

	public static int minSubArrayLen(int target, int[] nums) {
		// O(N) time complexity. O(1) space complexity.
		int answer = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];

			while (sum >= target) {
				// Move left pointer until the sum gets < then target.
				// Calculate the answer before shifting left pointer.
				answer = Math.min(answer, i - left + 1);
				sum -= nums[left];
				left++;
			}
		}

		return answer == Integer.MAX_VALUE ? 0 : answer;
	}
}
