package io.github.clivelewis.testutils;

import io.github.clivelewis.models.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestExecutor {


	public static void execute(List<String> result, List<String> correct) {
		if (result == null || correct == null) throw new RuntimeException("One of the values is null");
		else if (result.size() != correct.size() || !correct.containsAll(result))
			throw new RuntimeException("Result is not correct! Expected values - " + correct + ". Got - " + result);
	}

	public static void execute(int[] result, int[] correct) {
		if (result != null && correct != null && result.length == correct.length) {
			for (int i = 0; i < result.length; i++) {
				if (result[i] != correct[i]) throw new RuntimeException("Result is not correct! Values don't match");
			}
		} else {
			throw new RuntimeException("Result is not correct! Values don't match");
		}
	}

	public static <T> void execute(T result, T correctValue) {
		if (!result.equals(correctValue)) throw new RuntimeException("Expected answer - " + correctValue.toString() + ". Got - " + result.toString());
	}

	public static void execute(int result, int correctValue) {
		if (result != correctValue) throw new RuntimeException("Expected answer - " + correctValue + ". Got - " + result);
	}

}
