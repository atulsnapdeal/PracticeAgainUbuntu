package com.snapdeal;

class Node3 {
	int data;
	Node3 left,right;
	
	Node3(int data) {
		this.data = data;
		this.left = this.right = null;
	}
}

public class PrintBoundaryOfTree {
	
	Node3 root;
	
	public static void main(String[] args) {
		
		PrintBoundaryOfTree pbt = new PrintBoundaryOfTree();
		pbt.root = new Node3(1);
		pbt.root.left = new Node3(2);
		pbt.root.left.left = new Node3(3);
		pbt.root.right = new Node3(4);
		pbt.root.right = new Node3(5);
		pbt.root.right.left = new Node3(6);
		
		
	}
	
	

}
