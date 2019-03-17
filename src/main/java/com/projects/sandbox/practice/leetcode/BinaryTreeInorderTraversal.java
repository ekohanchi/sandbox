package com.projects.sandbox.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	TreeNode node;
	public BinaryTreeInorderTraversal() {
		node = null;
	}
	
	public static void main(String[] args) {
		BinaryTreeInorderTraversal tree = new BinaryTreeInorderTraversal();
		tree.node = new TreeNode(1);
		tree.node.left = null;
		tree.node.right = new TreeNode(2);
		tree.node.right.left = new TreeNode(3);
		
		
		System.out.println(tree.inorderTraversal(tree.node));
	}

	/**
	 
	Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
	
	 */

	private List<Integer> inorder = new ArrayList<Integer>();
	
	public List<Integer> inorderTraversal(TreeNode root) {
		if(root == null) {
            return inorder;
        }
        
        inorderTraversal(root.left);
        inorder.add(root.val);
        inorderTraversal(root.right);
        
        return inorder;
        
	}
}
