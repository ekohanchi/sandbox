package com.projects.sandbox.practice;

public class BinaryTree {
	Node root;
	public BinaryTree() {
		root = null;
	}
	
	/**
	 * Given a binary tree, print its nodes according to the  "bottom-up" postorder traversal.
	 * (left, right, root)
	 * @param node
	 */
	void printPostorder(Node node) {
		if(node == null) {
			return;
		}
		// first recur on left subtree 
		printPostorder(node.left);
		// second recur on the right subtree
		printPostorder(node.right);
		// now deal with the node
		System.out.println(node.key + " ");
	}
    /**
     * Given a binary tree, print its nodes in inorder
     * (left, root, right)
     * @param node
     */
	void printInorder(Node node) {
    	if(node == null) {
    		return;
    	}
    	// first recur on left child
    	printInorder(node.left);
    	// second print the data of the node
    	System.out.println(node.key + " ");
    	// now recur on the right child
    	printInorder(node.right);
    }
	/**
	 * Given a binary tree, print its nodes in preorder
	 * (root, left, right)
	 * @param node
	 */
	void printPreorder(Node node) {
		if(node == null) {
			return;
		}
		// first print data of first node
		System.out.println(node.key + " ");
		// second recur on left subtree
		printPreorder(node.left);
		// now recur on right subtree
		printPreorder(node.right);
		
	}
	
	void printPreorder() {
		printPreorder(root);
	}
	void printInorder() {
		printInorder(root);
	}
	void printPostorder() {
		printPostorder(root);
	}
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        /**
         	 1
         	/ \
           2   3
          / \
         4   5
         
         */
        
        System.out.println("Preorder traversal of binary tree is "); 
        tree.printPreorder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.printInorder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.printPostorder(); 

	}
}

class Node {
	int key;
	Node left, right;
	
	public Node(int item) {
		key = item;
		left = null;
		right = null;
	}
}
