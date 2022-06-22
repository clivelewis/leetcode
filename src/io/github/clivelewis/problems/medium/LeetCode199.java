package io.github.clivelewis.problems.medium;

import io.github.clivelewis.models.TreeNode;
import io.github.clivelewis.models.TreeNodeBuilder;
import io.github.clivelewis.testutils.TestExecutor;

import java.util.*;

/*
199. Binary Tree Right Side View

Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.
https://leetcode.com/problems/binary-tree-right-side-view/
 */
public class LeetCode199 {
	public static void main(String[] args) {
		TreeNode node = TreeNodeBuilder.build(new Integer[]{1, 2});
		TreeNode node2 = TreeNodeBuilder.build(new Integer[]{1, null, 3});
		TreeNode node3 = TreeNodeBuilder.build(new Integer[]{});
		TreeNode node4 = TreeNodeBuilder.build(new Integer[]{1,2,3,null,5,null,4});
		TestExecutor.execute(rightSideView(node), List.of(1,2));
		TestExecutor.execute(rightSideView(node2), List.of(1,3));
		TestExecutor.execute(rightSideView(node3), List.of());
		TestExecutor.execute(rightSideView(node4), List.of(1,3,4));
		System.out.println("Success!");
	}

	public static List<Integer> rightSideView(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			int size = nodes.size();
			result.add(nodes.peek().val);

			for (int i = 0; i < size; i++) {
				TreeNode n = nodes.poll();
				if (n.right != null) nodes.add(n.right);
				if (n.left != null) nodes.add(n.left);
			}
		}

		return result;

	}
}
