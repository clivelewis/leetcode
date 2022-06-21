package io.github.clivelewis.problems.easy;

import io.github.clivelewis.testutils.TestExecutor;

/**
 * 1876. Substrings of Size Three with Distinct Characters
 *
 * A string is good if there are no repeated characters.
 *
 * Given a string s, return the number of good substrings of length three in s.
 *
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 *
 * A substring is a contiguous sequence of characters in a string.
 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
 */
public class LeetCode1876 {
	public static void main(String[] args) {
		TestExecutor.execute(countGoodSubstrings(""), 0);
		TestExecutor.execute(countGoodSubstrings("a"), 0);
		TestExecutor.execute(countGoodSubstrings("ab"), 0);
		TestExecutor.execute(countGoodSubstrings("abc"), 1);
		TestExecutor.execute(countGoodSubstrings("xyzzaz"), 1);
		TestExecutor.execute(countGoodSubstrings("aababcabc"), 4);
		System.out.println("Success");
	}

	public static int countGoodSubstrings(String s) {
		if (s.length() < 3) return 0;

		int result = 0;
		for (int i = 0; i < s.length() - 3 + 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1) && s.charAt(i) != s.charAt(i + 2)
					&& s.charAt(i + 1) != s.charAt(i + 2)) {
				result++;
			}
		}

		return result;
	}
}
