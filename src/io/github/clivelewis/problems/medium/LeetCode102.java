package io.github.clivelewis.problems.medium;

import io.github.clivelewis.models.TreeNode;
import io.github.clivelewis.testutils.TestExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
102. Binary Tree Level Order Traversal
Given the root of a binary tree,
return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class LeetCode102 {
	public static void main(String[] args) {
		//3,9,20,null,null,15,7
		TreeNode node1 = new TreeNode(3);
		node1.left = new TreeNode(9);
		node1.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

		TestExecutor.execute(levelOrder(node1), List.of(List.of(3), List.of(9, 20), List.of(15, 7)));
		System.out.println("Success!");
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			List<Integer> res = new ArrayList<>();
			int size = nodes.size();

			for (int i = 0; i < size; i++) {
				TreeNode n = nodes.poll();
				if (n.left != null) nodes.add(n.left);
				if (n.right != null) nodes.add(n.right);
				res.add(n.val);
			}


			result.add(res);
		}

		return result;
	}
}
