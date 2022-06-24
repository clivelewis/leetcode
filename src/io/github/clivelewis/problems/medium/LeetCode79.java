package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;

/*
79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells,
where adjacent cells are horizontally or vertically neighboring.
The same letter cell may not be used more than once.
https://leetcode.com/problems/word-search/
 */
public class LeetCode79 {
	private static char[][] board;
	private static String word;

	public static void main(String[] args) {
		char[][] brd = new char[][]{
				{'A','B','C','E'},
				{'S', 'F', 'C', 'S'},
				{'A','D','E','E'}
		};

		TestExecutor.execute(exist(brd, "ABCB"), false);
		System.out.println("Success!");
	}

	public static boolean exist(char[][] b, String w) {
		if (w == null || w.isEmpty()) return false;

		board = b;
		word = w;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != word.charAt(0)) continue; // Skip if first letter doesn't match

				boolean[][] visited = new boolean[board.length][board[0].length];
				boolean found = backtrack(visited, i, j, 0);
				if (found) return true;
			}
		}

		return false;
	}

	private static boolean backtrack(boolean[][] visited, int row, int col, int wordCharIndex) {
		if (wordCharIndex == word.length()) return true;

		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return false;
		if (visited[row][col]) return false;
		if (board[row][col] != word.charAt(wordCharIndex)) return false;


		visited[row][col] = true;
		if (backtrack(visited, row + 1, col, wordCharIndex + 1) ||
				backtrack(visited, row - 1, col, wordCharIndex + 1) ||
				backtrack(visited, row, col + 1, wordCharIndex + 1) ||
				backtrack(visited, row, col - 1, wordCharIndex + 1)) {
			return true;
		}
		ArrayList<Object> objects = new ArrayList<>();
		visited[row][col] = false;
		return false;
	}
}
