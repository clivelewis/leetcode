package io.github.clivelewis.problems.easy;

import io.github.clivelewis.testutils.TestExecutor;

/*
2269. Find the K-Beauty of a Number

The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:

It has a length of k.
It is a divisor of num.
Given integers num and k, return the k-beauty of num.

Note:

Leading zeros are allowed.
0 is not a divisor of any value.
A substring is a contiguous sequence of characters in a string.
https://leetcode.com/problems/find-the-k-beauty-of-a-number/
 */
public class LeetCode2269 {
	public static void main(String[] args) {
		TestExecutor.execute(divisorSubstrings(240, 2), 2);
		TestExecutor.execute(divisorSubstrings(430043, 2), 2);
		TestExecutor.execute(divisorSubstrings(1, 2), 0);
		TestExecutor.execute(divisorSubstrings(20, 2), 1);
		System.out.println("Success!");
	}

	public static int divisorSubstrings(int num, int k) {
		char[] s = String.valueOf(num).toCharArray();

		int left = 0;
		int right = k - 1;
		int result = 0;
		while (right < s.length) {
			String ss = "";
			for (int i = left; i <= right; i++) ss += s[i];

			if  (Integer.parseInt(ss) != 0 && num % Integer.parseInt(ss) == 0) result++;

			left++;
			right++;
		}

		return result;
	}
}
