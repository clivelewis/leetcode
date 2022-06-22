package io.github.clivelewis.problems.easy;

import io.github.clivelewis.models.TreeNode;
import io.github.clivelewis.testutils.TestExecutor;

import java.util.LinkedList;
import java.util.Queue;

/*
100. Same Tree
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class LeetCode100 {
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		node1.left = new TreeNode(2);
		node1.right = new TreeNode(3);

		TreeNode node2 = new TreeNode(1);
		node2.left = new TreeNode(3);
		node2.right = new TreeNode(2);

		TestExecutor.execute(isSameTree(node1, node1), true);
		TestExecutor.execute(isSameTree(node2, node2), true);
		TestExecutor.execute(isSameTree(node1, node2), false);
		TestExecutor.execute(isSameTree(node1, null), false);
		TestExecutor.execute(isSameTree(null, null), true);
		System.out.println("Success!");
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		else if (p == null || q == null) return false;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(p);
		queue.offer(q);

		while (!queue.isEmpty()) {
			TreeNode node1 = queue.poll();
			TreeNode node2 = queue.poll();

			if (node1 == null && node2 == null) continue;
			if (node1 == null || node2 == null) return false;
			if (node1.val != node2.val) return false;

			queue.offer(node1.left);
			queue.offer(node2.left);
			queue.offer(node1.right);
			queue.offer(node2.right);
		}

		return true;

	}
}
