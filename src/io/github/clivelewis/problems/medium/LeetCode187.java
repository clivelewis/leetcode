package io.github.clivelewis.problems.medium;

import io.github.clivelewis.testutils.TestExecutor;

import java.util.*;
/*
187. Repeated DNA Sequences

The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.

For example, "ACGAATTCCG" is a DNA sequence.
When studying DNA, it is useful to identify repeated sequences within the DNA.

Given a string s that represents a DNA sequence,
return all the 10-letter-long sequences (substrings)
that occur more than once in a DNA molecule. You may return the answer in any order.
https://leetcode.com/problems/repeated-dna-sequences/
 */
public class LeetCode187 {
	public static void main(String[] args) {
		TestExecutor.execute(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"),  List.of("AAAAACCCCC", "CCCCCAAAAA"));
		TestExecutor.execute(findRepeatedDnaSequences("AAAAAAAAAAAAA"),  List.of("AAAAAAAAAA"));
		System.out.println("Success!");
	}
	public static List<String> findRepeatedDnaSequences(String s) {
		Set<String> result = new HashSet<>();
		if (s.length() < 10) return Collections.emptyList();

		Set<String> sequences = new HashSet<>();

		for (int i = 0; i <= s.length() - 10; i++) {
			String sequence = s.substring(i, i + 10);
			if (!sequences.add(sequence)) {
				result.add(sequence);
			}
		}

		return new ArrayList<>(result);
	}
}
