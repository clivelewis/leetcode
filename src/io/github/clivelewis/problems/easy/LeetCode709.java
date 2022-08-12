package io.github.clivelewis.problems.easy;

import io.github.clivelewis.testutils.TestExecutor;

/*
709. To Lower Case
Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.

https://leetcode.com/problems/to-lower-case/
 */
public class LeetCode709 {
    public static void main(String[] args) {
        TestExecutor.execute(toLowerCase("Hello"), "hello");
        TestExecutor.execute(toLowerCase("world"), "world");
        TestExecutor.execute(toLowerCase("BAZOOKA"), "bazooka");
        TestExecutor.execute(toLowerCase("123=-42304-"), "123=-42304-");
        System.out.println("Success!");
    }

    private static String toLowerCase(String s) {
        if (s == null) return null;

        char[] letters = s.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] >= 65 && letters[i] <= 90) {
                letters[i] = (char) (letters[i] + 32);
            }
        }

        return new String(letters);
    }
}
