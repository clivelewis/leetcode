package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.List;

/*
46. Permutations

Given an array nums of distinct integers, return all the possible permutations.
You can return the answer in any order.

https://leetcode.com/problems/permutations/
 */
public class LeetCode46 {
	private static List<List<Integer>> result;

	public static void main(String[] args) {
		TestExecutor.execute(permute(new int[]{1,2,3}), List.of(List.of(1,2,3), List.of(1,3,2), List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1)));
		TestExecutor.execute(permute(new int[]{1,3}), List.of(List.of(1,3), List.of(3,1)));
		TestExecutor.execute(permute(new int[]{}), List.of());
		System.out.println("Success!");
	}


	public static List<List<Integer>> permute(int[] nums) {
		result = new ArrayList<>();

		if (nums == null || nums.length < 1) return result;

		backtrack(new ArrayList<>(), nums);
		return result;
	}

	private static void backtrack(List<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (list.contains(nums[i])) continue;

			list.add(nums[i]);
			backtrack(list, nums);
			list.remove(list.size() - 1);
		}
	}
}
