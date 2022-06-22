package io.github.clivelewis.models;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Build a tree structure from integer array input.
 */
public class TreeNodeBuilder {

	public static TreeNode build(Integer[] values) {
		if (values == null || values.length < 1) return null;
		//5,4,8,11,null,13,4,7,2,null,null,null,1
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < values.length; i++) queue.add(values[i]);

		Queue<TreeNode> nodes = new LinkedList<>();

		TreeNode root = new TreeNode(values[0]);
		nodes.add(root);

		while (!queue.isEmpty()) {
			TreeNode n = nodes.poll();
			Integer valueLeft = queue.poll();
			if (valueLeft != null ) n.left = new TreeNode(valueLeft);
			if (!queue.isEmpty()) {
				Integer valueRight = queue.poll();
				if (valueRight != null) n.right = new TreeNode(valueRight);
			}

			if (n.left != null) nodes.add(n.left);
			if (n.right != null) nodes.add(n.right);
		}
		return root;
	}
}
