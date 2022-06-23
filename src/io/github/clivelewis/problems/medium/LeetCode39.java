package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
39. Combination Sum

Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to
target is less than 150 combinations for the given input.
https://leetcode.com/problems/combination-sum/
 */
public class LeetCode39 {

	private static List<List<Integer>> result;

	public static void main(String[] args) {
		TestExecutor.execute(combinationSum(new int[]{2,3,6,7}, 7), List.of(List.of(2,2,3), List.of(7)));
		TestExecutor.execute(combinationSum(new int[]{7}, 7), List.of(List.of(7)));
		TestExecutor.execute(combinationSum(new int[]{}, 1), List.of());
		System.out.println("Success!");
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<>();
		if (candidates.length == 0) return result;

		// In constrains we can see that candidates value cannot be negative.
		// Because of that we can sort array and stop if candidates[i] > target.
		Arrays.sort(candidates);

		for (int i = 0; i < candidates.length; i++) {
			if (candidates[i] > target) break;

			List<Integer> list = new ArrayList<>();
			list.add(candidates[i]);

			backtrack(list, candidates[i], candidates, i, target);
		}

		return result;
	}

	private static void backtrack(List<Integer> list, int currSum, int[] candidates, int index, int target) {
		if (currSum == target) {
			result.add(new ArrayList<>(list));
			return;
		}

		if (currSum > target || index >= candidates.length) return;

		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) break;
			list.add(candidates[i]);
			backtrack(list, currSum + candidates[i], candidates, i, target);
			list.remove(list.size() - 1);
		}
	}
}
