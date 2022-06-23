package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.List;
/*
22. Generate Parentheses

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class LeetCode22 {

	private static List<String> result;

	public static void main(String[] args) {
		TestExecutor.execute(generateParenthesis(3), List.of("((()))","(()())","(())()","()(())","()()()"));
		TestExecutor.execute(generateParenthesis(1), List.of("()"));
		System.out.println("Success");
	}


	public static List<String> generateParenthesis(int n) {
		result = new ArrayList<>();
		if (n < 1) return result;

		buildCombinations(new StringBuilder(), n, n);
		return result;
	}

	private static void buildCombinations(StringBuilder resultString, int remainingOpen, int remainingClose) {

		if (remainingOpen <= 0 && remainingClose <= 0) {
			result.add(resultString.toString());
			return;
		}

		if (remainingOpen > 0) {
			resultString.append("(");
			buildCombinations(resultString, remainingOpen - 1, remainingClose);
			resultString.deleteCharAt(resultString.length() - 1);
		}

		if (remainingOpen < remainingClose) {
			resultString.append(")");
			buildCombinations(resultString, remainingOpen, remainingClose - 1);
			resultString.deleteCharAt(resultString.length() - 1);
		}
	}
}
