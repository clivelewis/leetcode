package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
40. Combination Sum II

Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.
https://leetcode.com/problems/combination-sum-ii/
 */
public class LeetCode40 {
	private static List<List<Integer>> result;

	public static void main(String[] args) {
		TestExecutor.execute(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8), List.of(List.of(1,1,6), List.of(1,2,5), List.of(1,7), List.of(2,6)));
		TestExecutor.execute(combinationSum2(new int[]{}, 5), List.of());
		TestExecutor.execute(combinationSum2(new int[]{2,5,2,1,2}, 5), List.of(List.of(1,2,2), List.of(5)));
		System.out.println("Success!");
	}


	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		result = new ArrayList<>();
		if (candidates.length < 1) return result;

		Arrays.sort(candidates);

		backtrack(new ArrayList<>(), 0, 0, candidates, target);
		return result;
	}

	private static void backtrack(List<Integer> list, int currSum, int index, int[] candidates, int target) {

		if (currSum == target) {
			result.add(new ArrayList<>(list));
			return;
		}

		if (currSum > target || index >= candidates.length) return;

		for (int i = index; i < candidates.length; i++) {
			if (candidates[i] > target) continue;
			if (i > index && candidates[i] == candidates[i - 1]) continue;

			list.add(candidates[i]);
			backtrack(list, currSum + candidates[i], i + 1, candidates, target);
			list.remove(list.size() - 1);
		}

	}
}
