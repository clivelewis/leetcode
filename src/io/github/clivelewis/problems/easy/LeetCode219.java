package io.github.clivelewis.problems.easy;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.HashSet;
import java.util.Set;
/*
219. Contains Duplicate II
Given an integer array nums and an integer k,
return true if there are two distinct indices i and j in the array
such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class LeetCode219 {
	public static void main(String[] args) {
		TestExecutor.execute(containsNearbyDuplicate(new int[]{1,2,3,1}, 3), true);
		TestExecutor.execute(containsNearbyDuplicate(new int[]{1,0,1,1}, 1), true);
		TestExecutor.execute(containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2), false);
		TestExecutor.execute(containsNearbyDuplicate(new int[]{0}, 2), false);
		TestExecutor.execute(containsNearbyDuplicate(new int[]{1,2,3,4,1}, 0), false);
		System.out.println("Success!");
	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		if (k == 0 || nums.length < 2) return false;

		Set<Integer> set = new HashSet<>();
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > k) set.remove(nums[j++]);

			if (set.contains(nums[i])) return true;

			set.add(nums[i]);
		}

		return false;
	}
}
