package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * You are given an integer array heights representing the heights of buildings, some bricks, and some ladders.
 *
 * You start your journey from building 0 and move to the next building by possibly using bricks or ladders.
 *
 * While moving from building i to building i+1 (0-indexed),
 *
 * If the current building's height is greater than or equal to the next building's height, you do not need a ladder or bricks.
 * If the current building's height is less than the next building's height, you can either use one ladder or (h[i+1] - h[i]) bricks.
 * Return the furthest building index (0-indexed) you can reach if you use the given ladders and bricks optimally.
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 */
public class LeetCode1642 {
	public static void main(String[] args) {
		TestExecutor.execute(furthestBuilding(new int[]{4,2,7,6,9,14,12}, 5, 1), 4);
		TestExecutor.execute(furthestBuilding(new int[]{4,12,2,7,3,18,20,3,19}, 10, 2), 7);
		TestExecutor.execute(furthestBuilding(new int[]{4,100}, 10, 0), 0);
		TestExecutor.execute(furthestBuilding(new int[]{4}, 0, 100), 0);
		System.out.println("Success!");
	}

	public static int furthestBuilding(int[] heights, int bricks, int ladders) {
		if (heights == null) return 0;

//		return climbRecursive(heights, 0, bricks, ladders); // Works on small datasets. Timeout on larger ones.
		return climbWithPriorityQueue(heights, bricks, ladders);
	}

	private static int climbRecursive(int[] heights, int index, int remBricks, int remLadders) {
		if (index == heights.length - 1) return index; // reached the end

		if (heights[index] >= heights[index + 1]) {
			// current building higher than next. We don't need to waste resources.
			return climbRecursive(heights, index + 1, remBricks, remLadders);
		}
		else {
			int difference = heights[index + 1] - heights[index];
			if (remLadders <= 0 && difference > remBricks) return index; // We can't climb further.

			int result1 = 0;
			if (remLadders > 0) result1 = climbRecursive(heights, index + 1, remBricks, remLadders - 1);

			int result2 = 0;
			if (remBricks >= difference) result2 = climbRecursive(heights, index + 1, remBricks - difference, remLadders);
			return Math.max(result1, result2);
		}
	}

	private static int climbWithPriorityQueue(int[] heights, int bricks, int ladders) {
		final PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < heights.length - 1; i++) {
			if (heights[i] >= heights[i + 1]) continue; // Current building equals or higher. We can just jump.

			bricks = bricks - (heights[i + 1] - heights[i]);
			pq.add(heights[i + 1] - heights[i]); // Add height difference to PQ.

			if (bricks < 0) {
				// If we are out of bricks - replace the highest difference with a ladder.
				if (ladders > 0) {
					bricks = bricks + pq.poll();
					ladders--;
				} else {
					return i; // If we are also out of ladders - return.
				}
			}
		}

		return heights.length - 1;
	}
}
