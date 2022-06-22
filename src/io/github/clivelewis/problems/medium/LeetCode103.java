package io.github.clivelewis.problems.medium;

import io.github.clivelewis.models.TreeNode;
import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
103. Binary Tree Zigzag Level Order Traversal

Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
(i.e., from left to right, then right to left for the next level and alternate between).
 */
public class LeetCode103 {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		node1.left = new TreeNode(9);
		node1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

		TestExecutor.execute(zigzagLevelOrder(node1), List.of(List.of(3), List.of(20, 9), List.of(15, 7)));
		TestExecutor.execute(zigzagLevelOrder(null), List.of());
		System.out.println("Success!");
	}

	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		boolean isRtl = false;

		while (!nodes.isEmpty()) {
			List<Integer> res = new ArrayList<>();
			int size = nodes.size();

			for (int i = 0; i < size; i++) {
				TreeNode n = nodes.poll();

				if (isRtl) res.add(0, n.val);
				else res.add(n.val);

				if (n.left != null) nodes.add(n.left);
				if (n.right != null) nodes.add(n.right);
			}

			isRtl = !isRtl;
			result.add(res);
		}
		return result;
	}
}
