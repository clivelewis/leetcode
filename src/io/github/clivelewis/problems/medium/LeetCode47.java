package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47. Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
https://leetcode.com/problems/permutations-ii/
 */
public class LeetCode47 {
	private static List<List<Integer>> result;

	public static void main(String[] args) {
		TestExecutor.execute(permuteUnique(new int[]{1,1,2}), List.of(List.of(1,1,2), List.of(1,2,1), List.of(2,1,1)));
		TestExecutor.execute(permuteUnique(new int[]{1,2,3}), List.of(List.of(1,2,3), List.of(1,3,2), List.of(2,1,3), List.of(2,3,1), List.of(3,1,2), List.of(3,2,1)));
		System.out.println("Success!");
	}


	public static List<List<Integer>> permuteUnique(int[] nums) {
		result = new ArrayList<>();
		if (nums.length < 1) return result;
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		backtrack(new ArrayList<>(), nums, used);
		return result;
	}

	private static void backtrack(List<Integer> list, int[] nums, boolean[] used) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

			used[i] = true;
			list.add(nums[i]);
			backtrack(list, nums, used);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}
}
