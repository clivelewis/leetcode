package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.List;

/*
78. Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.
https://leetcode.com/problems/subsets/
 */
public class LeetCode78 {
	private static List<List<Integer>> result;

	public static void main(String[] args) {
		TestExecutor.execute(subsets(new int[]{1,2,3}), List.of(List.of(), List.of(1), List.of(1,2), List.of(1,2,3), List.of(1,3), List.of(2), List.of(2,3), List.of(3)));
		TestExecutor.execute(subsets(new int[]{1,2}), List.of(List.of(), List.of(1), List.of(1,2), List.of(2)));
		TestExecutor.execute(subsets(new int[]{}), List.of());
		System.out.println("Success!");
	}

	public static List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<>();
		if (nums.length < 1) return result;

		result.add(List.of());
		backtrack(new ArrayList<>(), nums, 0);

		return result;
	}

	private static void backtrack(List<Integer> list, int[] nums, int index) {
		if (index >= nums.length) return;

		for (int i = index; i < nums.length; i++) {
			list.add(nums[i]);
			result.add(new ArrayList<>(list));

			backtrack(list, nums, i + 1);
			list.remove(list.size() - 1);
		}
	}
}
