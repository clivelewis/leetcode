package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

/*
2090. K Radius Subarray Averages
You are given a 0-indexed array nums of n integers, and an integer k.

The k-radius average for a subarray of nums centered at some index i with the radius k
is the average of all elements in nums between the indices i - k and i + k (inclusive).
If there are less than k elements before or after the index i, then the k-radius average is -1.

Build and return an array avgs of length n where avgs[i]
is the k-radius average for the subarray centered at index i.

The average of x elements is the sum of the x elements divided by x,
using integer division. The integer division truncates toward zero, which means losing its fractional part.

For example, the average of four elements 2, 3, 1, and 5 is (2 + 3 + 1 + 5) / 4 = 11 / 4 = 2.75, which truncates to 2.
https://leetcode.com/problems/k-radius-subarray-averages/
 */
public class LeetCode2090 {
	public static void main(String[] args) {
		TestExecutor.execute(getAverages(new int[]{7,4,3,9,1,8,5,2,6}, 3), new int[]{-1,-1,-1,5,4,4,-1,-1,-1});
		TestExecutor.execute(getAverages(new int[]{100000}, 0), new int[]{100000});
		TestExecutor.execute(getAverages(new int[]{8}, 10), new int[]{-1});
		System.out.println("Success!");
	}

	public static int[] getAverages(int[] nums, int k) {
		if (k == 0 || nums == null) return nums; // If k == 0 we don't need to do anything.
		int[] result = new int[nums.length];

		// Store sum at each index in separate array.
		// We use long because integer can overflow.
		long[] sums = new long[nums.length];
		sums[0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			sums[i] = sums[i - 1] + nums[i];
		}


		// Sum of current subarray = sum at largest index - sum at index before current smallest index
		for (int i = 0; i < nums.length; i++) {
			if (i - k < 0 || i + k >= nums.length) result[i] = -1;
			else {
				long totalSum = sums[i + k];
				if (i - k > 0) totalSum -= sums[i - k - 1];
				result[i] = (int) (totalSum / (k * 2 + 1));
			}
		}

		return result;
	}
}
