package io.github.clivelewis.problems.easy;

import io.github.clivelewis.models.TreeNode;
import io.github.clivelewis.models.TreeNodeBuilder;
import io.github.clivelewis.testutils.TestExecutor;

/*
112. Path Sum

Given the root of a binary tree and an integer targetSum,
return true if the tree has a root-to-leaf path such that adding
up all the values along the path equals targetSum.

A leaf is a node with no children.
https://leetcode.com/problems/path-sum/
 */
public class LeetCode112 {
	public static void main(String[] args) {
		TreeNode node = TreeNodeBuilder.build(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
		TestExecutor.execute(hasPathSum(node, 22), true);
		TestExecutor.execute(hasPathSum(null, 22), false);
		System.out.println("Success!");
	}

	public static boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) return false;
		if (root.left == null && root.right == null) return root.val == targetSum;

		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
	}
}
