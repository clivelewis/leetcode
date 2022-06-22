package io.github.clivelewis.problems.easy;

import io.github.clivelewis.models.TreeNode;
import io.github.clivelewis.testutils.TestExecutor;

/*
101. Symmetric Tree

Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class LeetCode101 {
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		n1.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		n1.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

		TreeNode n2 = new TreeNode(1);
		n2.left = new TreeNode(2, new TreeNode(3), new TreeNode(3));
		n2.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));

		TestExecutor.execute(isSymmetric(n1), true);
		TestExecutor.execute(isSymmetric(null), true);
		TestExecutor.execute(isSymmetric(null), true);
		TestExecutor.execute(isSymmetric(n2), false);
		System.out.println("Success!");
	}


	public static boolean isSymmetric(TreeNode root) {
		if (root == null) return true;

		return isSymmetric(root.left, root.right);
	}

	public static boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) return true;
		if (left == null || right == null) return false;
		if (left.val != right.val) return false;

		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}
