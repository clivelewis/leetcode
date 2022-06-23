package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
17. Letter Combinations of a Phone Number

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LeetCode17 {
	private static Map<Integer, String> buttons;
	private static List<String> result;

	public static void main(String[] args) {
		TestExecutor.execute(letterCombinations("23"), List.of("ad","ae","af","bd","be","bf","cd","ce","cf"));
		TestExecutor.execute(letterCombinations(""), List.of());
		TestExecutor.execute(letterCombinations("2"), List.of("a","b","c"));
		System.out.println("Success!");
	}
	public static List<String> letterCombinations(String digits) {
		result = new ArrayList<>();
		if (digits == null || digits.isEmpty()) return result;

		buttons = new HashMap<>();
		buttons.put(2, "abc");
		buttons.put(3, "def");
		buttons.put(4, "ghi");
		buttons.put(5, "jkl");
		buttons.put(6, "mno");
		buttons.put(7, "pqrs");
		buttons.put(8, "tuv");
		buttons.put(9, "wxyz");

		combine("", digits, 0);
		return result;
	}

	private static void combine(String resultString, String digits, int index) {
		if (index >= digits.length()) {
			result.add(resultString);
			return;
		}

		String letters = buttons.get(Character.getNumericValue(digits.charAt(index)));
		for (char letter : letters.toCharArray()) {
			combine(resultString + letter, digits, index + 1);
		}
	}
}
