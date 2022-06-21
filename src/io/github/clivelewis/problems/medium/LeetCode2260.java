package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.HashMap;

public class LeetCode2260 {
	public static void main(String[] args) {
		TestExecutor.execute(minimumCardPickup(new int[]{3,4,2,3,4,7}), 4);
		TestExecutor.execute(minimumCardPickup(new int[]{1,0,5,3}), -1);
		TestExecutor.execute(minimumCardPickup(new int[]{1}), -1);
		TestExecutor.execute(minimumCardPickup(new int[]{}), -1);
		System.out.println("Success!");
	}

	public static int minimumCardPickup(int[] cards) {
		if (cards.length <= 1) return -1;

		HashMap<Integer, Integer> cardLastIndex = new HashMap<>();

		int minimum = Integer.MAX_VALUE;

		for (int i = 0; i < cards.length; i++) {
			if (cardLastIndex.containsKey(cards[i])) {
				minimum = Math.min(minimum, i - cardLastIndex.get(cards[i]) + 1);
			}

			cardLastIndex.put(cards[i], i);
		}

		return minimum == Integer.MAX_VALUE ? -1 : minimum;
	}
}
