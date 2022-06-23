package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.List;

/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].

You may return the answer in any order.
https://leetcode.com/problems/combinations/
 */
public class LeetCode77 {
	private static List<List<Integer>> result;

	public static void main(String[] args) {
		TestExecutor.execute(combine(4, 2), List.of(List.of(1,2), List.of(1,3), List.of(1,4), List.of(2,3), List.of(2,4), List.of(3,4)));
		TestExecutor.execute(combine(2, 4), List.of());
		System.out.println("Success!");
	}

	public static List<List<Integer>> combine(int n, int k) {
		result = new ArrayList<>();
		if (n < k) return result;

		int[] numbers = new int[n];
		for (int i = 1; i <= n; i++) {
			numbers[i - 1] = i;
		}


		// all possible combos of numbers[]. Max combo size - k
		backtrack(new ArrayList<>(), numbers, 0, k);
		return result;
	}

	private static void backtrack(List<Integer> list, int[] numbers, int index, int remainingSlots) {
		if (remainingSlots <= 0) {
			result.add(new ArrayList<>(list));
			return;
		}

		if (index >= numbers.length) return;


		for (int i = index; i < numbers.length; i++) {
			list.add(numbers[i]);
			backtrack(list, numbers, i + 1, remainingSlots - 1);
			list.remove(list.size() - 1);
		}
	}
}
