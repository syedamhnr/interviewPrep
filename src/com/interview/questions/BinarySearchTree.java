package com.interview.questions;

/*
 * adding a node 
 * find if a given number is there is a binary search tree
 * find nearest number to a given number in a BST
 * reverse a tree mirror image 
 * inorder, preorder, postorder
 */
public class BinarySearchTree {

	static class Node {
		int data;
		Node leftChild;
		Node rightChild;

		public Node(int data) {
			this.data = data;
			this.leftChild = null;
			this.rightChild = null;
		}
	}

	static Node root;

	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int data) {

		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
			return;
		}
		Node currNode = root;
		Node parentNode = null;
		while (true) {
			parentNode = currNode;

			if (data < currNode.data) {
				currNode = currNode.leftChild;
				if (currNode == null) {
					parentNode.leftChild = newNode;
					return;
				}

			} else {
				currNode = currNode.rightChild;
				if (currNode == null) {
					parentNode.rightChild = newNode;
					return;
				}

			}

		}

	}

	public Node find(int data) {
		Node currnode = root;
		if (currnode.data == data) {
			return currnode;
		}
		while (currnode.data != data) {
			if (data < currnode.data) {
				currnode = currnode.leftChild;
			} else
				currnode = currnode.rightChild;

		}
		
		return currnode;
	}

	public void inOrderTraversal(Node root) {
		if (root != null) {
			inOrderTraversal(root.leftChild);
			System.out.println(root.data);
			inOrderTraversal(root.rightChild);
		}

	}

	public void preOrderTraversal(Node root) {
		if (root != null) {
			System.out.println(root.data);
			preOrderTraversal(root.leftChild);
			preOrderTraversal(root.rightChild);
		}

	}

	public void postOrderTraversal(Node root) {
		if (root != null) {
			postOrderTraversal(root.leftChild);
			postOrderTraversal(root.rightChild);
			System.out.println(root.data);
		}

	}

	public static void main(String[] args) {

		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(7);
		bst.insert(5);
		bst.insert(12);
		bst.insert(6);
		bst.insert(9);
		bst.insert(3);
		bst.insert(30);
		bst.insert(45);
		bst.insert(18);
		bst.insert(24);
		bst.insert(44);

		System.out.println("inorder : ");
		bst.inOrderTraversal(root);
		System.out.println("preorder : ");
		bst.preOrderTraversal(root);
		System.out.println("postorder : ");
		bst.postOrderTraversal(root);
		
		Node foundNode = bst.find(45);
		if(foundNode != null )
			System.out.println("node found " +foundNode.data);
		else
			System.out.println("node not found");

	}
}
