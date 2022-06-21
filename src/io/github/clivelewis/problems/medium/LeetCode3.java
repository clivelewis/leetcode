package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without repeating characters.
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3
 */
public class LeetCode3 {
	public static void main(String[] args) {
		TestExecutor.execute(lengthOfLongestSubstring(""), 0);
		TestExecutor.execute(lengthOfLongestSubstring("a"), 1);
		TestExecutor.execute(lengthOfLongestSubstring("abcabcbb"), 3);
		TestExecutor.execute(lengthOfLongestSubstring("bbbbb"), 1);
		TestExecutor.execute(lengthOfLongestSubstring("pwwkew"), 3);

		System.out.println("Success!");
	}

	public static int lengthOfLongestSubstring(String s) {
		if (s.length() <= 1) return s.length();

		int left = 0;
		int right = 0;
		int max = 0;

		Set<Character> set = new HashSet<>();

		while (right < s.length()) {
			while (set.contains(s.charAt(right))) {
				set.remove(s.charAt(left));
				left++;
			}

			max = Math.max(max, right - left + 1);
			set.add(s.charAt(right));
			right++;

		}

		return max;
	}
}
