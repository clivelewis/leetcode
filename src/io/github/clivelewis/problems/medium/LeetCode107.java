package io.github.clivelewis.problems.medium;

import io.github.clivelewis.models.TreeNode;
import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
107. Binary Tree Level Order Traversal II

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
(i.e., from left to right, level by level from leaf to root).
 */
public class LeetCode107 {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		node1.left = new TreeNode(9);
		node1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

		TestExecutor.execute(levelOrderBottom(node1), List.of(List.of(15,7), List.of(9, 20), List.of(3)));
		TestExecutor.execute(levelOrderBottom(null), List.of());
		System.out.println("Success!");
	}

	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			List<Integer> res = new ArrayList<>();
			int size = nodes.size();

			for (int i = 0; i < size; i++) {
				TreeNode n = nodes.poll();
				res.add(n.val);

				if (n.left != null) nodes.add(n.left);
				if (n.right != null) nodes.add(n.right);
			}

			result.add(0, res);
		}

		return result;
	}
}
