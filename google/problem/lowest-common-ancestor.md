### Problem
Given values of two nodes in a Binary Search Tree, write a c program to find the Lowest Common Ancestor (LCA). You may assume that both the values exist in the tree.

### Reference
- [check here](http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/)

### Analysis
Time complexity: O(h) where h is the height of the BST

### Code
```java
/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		TreeNode root = new TreeNode(20);
		root.left = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		root.right = new TreeNode(22);
		
		TreeNode rnt = findLCA(root, 10,14);
		System.out.println(rnt.val);
	
	}
	
	public static TreeNode findLCA(TreeNode root, int num1, int num2){
		if(root==null) return root;
		if(root.val > num1 && root.val >num2)
			return findLCA(root.left, num1, num2);
		if(root.val < num1 && root.val <num2)
			return findLCA(root.right, num1, num2);
		return root;
	}
}

class TreeNode{
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(int val){
		this.val = val;
	}
}
```
