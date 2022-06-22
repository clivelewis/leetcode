package io.github.clivelewis.problems.easy;

import io.github.clivelewis.models.TreeNode;
import io.github.clivelewis.testutils.TestExecutor;

import java.util.LinkedList;
import java.util.Queue;

/*
111. Minimum Depth of Binary Tree

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
https://leetcode.com/problems/minimum-depth-of-binary-tree/
 */
public class LeetCode111 {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		node1.left = new TreeNode(9);
		node1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
		TestExecutor.execute(minDepth(node1), 2);
		TestExecutor.execute(minDepth(null), 0);
		TestExecutor.execute(minDepth(new TreeNode(1)), 1);
		System.out.println("Success!");
	}

	public static int minDepth(TreeNode root) {
		if (root == null) return 0;
		int level = 0;

		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			level++;
			int size = nodes.size();

			for (int i = 0; i < size; i++) {
				TreeNode n = nodes.poll();
				if (n.left == null && n.right == null) return level;

				if (n.left != null) nodes.add(n.left);
				if (n.right != null) nodes.add(n.right);
			}
		}

		return level;
	}
}
