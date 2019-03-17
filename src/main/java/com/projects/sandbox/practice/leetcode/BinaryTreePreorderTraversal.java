package com.projects.sandbox.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	TreeNode node;
	public BinaryTreePreorderTraversal() {
		node = null;
	}
	
	public static void main(String[] args) {
		BinaryTreePreorderTraversal tree = new BinaryTreePreorderTraversal();
		tree.node = new TreeNode(1);
		tree.node.left = null;
		tree.node.right = new TreeNode(2);
		tree.node.right.left = new TreeNode(3);
		
		
		System.out.println(tree.preorderTraversal(tree.node));
	}

	/**
	 
	Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,2,3]
	
	 */

	private List<Integer> preorder = new ArrayList<Integer>();
	
	public List<Integer> preorderTraversal(TreeNode root) {
		if(root == null) {
			return preorder;
		}
		preorder.add(root.val);
		
		preorderTraversal(root.left);
		preorderTraversal(root.right);
		
        return preorder;
        
	}
}
