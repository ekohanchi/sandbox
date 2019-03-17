package com.projects.sandbox.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelorderTraversal {
	TreeNode node;
	public BinaryTreeLevelorderTraversal() {
		node = null;
	}
	
	public static void main(String[] args) {
		BinaryTreeLevelorderTraversal tree = new BinaryTreeLevelorderTraversal();
		tree.node = new TreeNode(3);
		tree.node.left = new TreeNode(9);
		tree.node.right = new TreeNode(20);
		tree.node.right.left = new TreeNode(15);
		tree.node.right.right = new TreeNode(7);
		
		
		System.out.println(tree.levelOrder(tree.node));
	}

	/**
	 Input:
	Given binary tree [3,9,20,null,null,15,7],
		3
	   / \
	  9  20
	    /  \
	   15   7
	

	Output:
	[
	  [3],
	  [9,20],
	  [15,7]
	]

	
	 */

	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        List<Integer> singleLevelOrderList = null;
        int h = height(root);
        
        for (int i=1; i<=h; i++) {
            singleLevelOrderList = new ArrayList<Integer>();
            levelOrderList.add(getGivenLevel(root, i, singleLevelOrderList));
        }
        
        return levelOrderList;
        
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            
            if (lheight > rheight) {
                return(lheight+1);
            } else {
                return(rheight+1);
            }
        }        
    }
    
    private List<Integer> getGivenLevel(TreeNode root, int level, List<Integer> levelOrderList) {
        if(root == null) {
            return levelOrderList;
        }
        if(level == 1) {
            levelOrderList.add(root.val);
        } else if (level > 1) {
            getGivenLevel(root.left, level-1, levelOrderList);
            getGivenLevel(root.right, level-1, levelOrderList);
        }
        return levelOrderList;
    }
}
