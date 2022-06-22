package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water),
return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.
https://leetcode.com/problems/number-of-islands/
 */
public class LeetCode200 {
	public static void main(String[] args) {
		char[][] grid = new char[][]{
				{'1', '1', '1', '1', '0'},
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '0'},
				{'0', '0', '0', '0', '0'}};

		TestExecutor.execute(numIslands(grid), 1);
	}

	public static int numIslands(char[][] grid) {

		int islands = 0;
		boolean[][] visited = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					bfs(grid, visited, i, j);
					islands++;
				}
			}
		}

		return islands;
	}

	private static void bfs(char[][] grid, boolean[][] visited, int row, int col) {
		Queue<List<Integer>> queue = new LinkedList<>();
		queue.add(List.of(row, col));
		visited[row][col] = true;

		while (!queue.isEmpty()) {
			List<Integer> coords = queue.poll();
			int r = coords.get(0);
			int c = coords.get(1);

			if (r - 1 >= 0 && !visited[r - 1][c] && grid[r - 1][c] == '1') {
				queue.add(List.of(r - 1, c));
				visited[r - 1][c] = true;
			}

			if (r + 1 < grid.length && !visited[r + 1][c] && grid[r + 1][c] == '1') {
				queue.add(List.of(r + 1, c));
				visited[r + 1][c] = true;
			}

			if (c - 1 >= 0 && !visited[r][c - 1] && grid[r][c - 1] == '1') {
				queue.add(List.of(r, c - 1));
				visited[r][c - 1] = true;
			}

			if (c + 1 < grid[0].length && !visited[r][c + 1] && grid[r][c + 1] == '1') {
				queue.add(List.of(r, c + 1));
				visited[r][c + 1] = true;
			}
		}
	}
}
