package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;
/*
2024. Maximize the Confusion of an Exam
A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false.
He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).

You are given a string answerKey, where answerKey[i] is the original answer to the ith question.
In addition, you are given an integer k, the maximum number of times you may perform the following operation:

Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
 */
public class LeetCode2024 {

	public static void main(String[] args) {
		TestExecutor.execute(maxConsecutiveAnswers("TTFF", 2), 4);
		TestExecutor.execute(maxConsecutiveAnswers("TFFT", 1), 3);
		TestExecutor.execute(maxConsecutiveAnswers("TTFTTFTT", 1), 5);
		System.out.println("Success!");
	}

	public static int maxConsecutiveAnswers(String answerKey, int k) {

		return Math.max(maxConsecutive(answerKey, k, 'F'), maxConsecutive(answerKey, k, 'T'));
	}

	private static int maxConsecutive(String answerKey, int k, char charToReplace) {
		int i = 0;
		int j = 0;

		// Trick here is that j will continue moving if k < 0. This way we will always preserve
		// maximum size of subarray.
		for (; i < answerKey.length(); i++) {
			if (answerKey.charAt(i) == charToReplace) k--;
			if (k < 0) {
				if (answerKey.charAt(j) == charToReplace) k++;
				j++;
			}
		}

		return i - j;

	}
}
