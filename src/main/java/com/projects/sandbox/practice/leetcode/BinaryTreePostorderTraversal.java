package com.projects.sandbox.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	TreeNode node;
	public BinaryTreePostorderTraversal() {
		node = null;
	}
	
	public static void main(String[] args) {
		BinaryTreePostorderTraversal tree = new BinaryTreePostorderTraversal();
		tree.node = new TreeNode(1);
		tree.node.left = null;
		tree.node.right = new TreeNode(2);
		tree.node.right.left = new TreeNode(3);
		
		
		System.out.println(tree.postorderTraversal(tree.node));
	}

	/**
	 
	Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]
	
	 */

	private List<Integer> postorder = new ArrayList<Integer>();
	
	public List<Integer> postorderTraversal(TreeNode root) {
		if(root == null) {
            return postorder;
        }
        
		postorderTraversal(root.left);
		postorderTraversal(root.right);
		postorder.add(root.val);
        
        return postorder;
        
	}
}
