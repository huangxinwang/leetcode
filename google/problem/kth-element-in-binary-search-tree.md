### Problem
- find the kth element in binary search tree

### Analysis
- using inorder traverse, and keep track of current visited count

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
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		
		int[] count = new int[1];
		int k =3;
		inorder(root, count, k);
		
	}
	
	public static void inorder(TreeNode root, int[] count, int k){
		
		if(root.left!=null)
			inorder(root.left, count, k);
	    
		count[0]++;
		
		if(count[0]==k){
			System.out.println(root.val);
			return;
		}
		
		if(root.right!=null) 
			inorder(root.right,count, k);
		
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


### code
- improve by makeing return TreeNode vailable
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
		root.right = new TreeNode(22);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(12);
		root.left.right.left = new TreeNode(10);
		root.left.right.right = new TreeNode(14);
		
		int[] count = new int[1];
		int k =3;
		TreeNode rnt = inorder(root, count, k);
		System.out.println(rnt.val);
	}
	
	public static TreeNode inorder(TreeNode root, int[] count, int k){
		
		if(root==null) return null;
		TreeNode left = inorder(root.left, count, k);
	    if(left!=null) return left;
	    
		count[0]++;
		if(count[0]==k) return root;

		return inorder(root.right,count, k);
		
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
