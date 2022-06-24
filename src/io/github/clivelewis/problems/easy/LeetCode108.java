package io.github.clivelewis.problems.easy;

import io.github.clivelewis.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
108. Convert Sorted Array to Binary Search Tree

Given an integer array nums where the elements are sorted in ascending order,
convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees
of every node never differs by more than one.
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class LeetCode108 {
	public static void main(String[] args) {
		sortedArrayToBST(new int[]{-10,-3,0,5,9});
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length < 1) return null;
		List<String> list = new ArrayList<>();
		list.toArray(String[]::new);
		return buildTree(nums, 0, nums.length - 1);

	}

	public static TreeNode buildTree(int[] nums, int left, int right) {
		if (left > right) return null;
		int mid = left + (right - left) / 2;

		TreeNode node = new TreeNode(nums[mid]);
		node.left = buildTree(nums, left, mid - 1);
		node.right = buildTree(nums, mid + 1, right);
		return node;
	}
}
