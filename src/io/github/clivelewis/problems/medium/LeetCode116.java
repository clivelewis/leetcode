package io.github.clivelewis.problems.medium;


import io.github.clivelewis.models.Node;

import java.util.LinkedList;
import java.util.Queue;

/*
116. Populating Next Right Pointers in Each Node

You are given a perfect binary tree where all leaves are on the same level,
and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node.
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class LeetCode116 {
	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2, new Node(4), new Node(5), null);
		n.right = new Node(3, new Node(6), new Node(7), null);
		connect(n);
	}

	public static Node connect(Node root) {
		if (root == null) return root;

		Queue<Node> nodes = new LinkedList<>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			int size = nodes.size();

			Node prev = null;

			for (int i = 0; i < size; i++) {
				Node n = nodes.poll();
				if (prev != null) prev.next = n;
				prev = n;

				if (n.left != null) nodes.add(n.left);
				if (n.right != null) nodes.add(n.right);
			}
		}
		return root;
	}
}
