### Problem
give a binary search tree and a target, find the closest number to the target

### Analysis 
- binary search


### Code
- return object
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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(9);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(13);
		
		TreeNode rnt = getCloest(root, 7);
		System.out.println(rnt.val);
		
	}
	
	//Binary search
	public static TreeNode getCloest(TreeNode root, int k){
		if(root==null) return root;
		if(root.left==null && root.right==null) return root;
		TreeNode left = getMax(root.left);
		TreeNode right = getMin(root.right);
		System.out.println(" leftval "+left.val + " rightVal "+right.val);
		if(left.val >k && left.val!=root.val) return getCloest(root.left,k);
		if(right.val <k && right.val != root.val) return getCloest(root.right,k);
		TreeNode rnt = Math.abs(left.val-k) <= Math.abs(right.val-k)? left : right;
		rnt = Math.abs(rnt.val-k) <= Math.abs(root.val-k) ? rnt : root;
		return rnt;
	}
	
	public static TreeNode getMin(TreeNode root){
		if(root.left!=null) return getMin(root.left);
		else return root;
	}
	
	public static TreeNode getMax(TreeNode root){
		if(root.right!=null) return getMax(root.right);
		else return root;
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


### Code 
- return target value
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
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.right.left = new TreeNode(3);
        root.right.left.right = new TreeNode(8);
        root.right.right = new TreeNode(13);

        int[] rnt = new int[1];
        int diff = Integer.MAX_VALUE;
	    getCloest(root, 7, diff, rnt);
        System.out.println(rnt[0]);
	}
	
	public static void getCloest(TreeNode root, int k, int diff, int[] rnt){
		if(root==null) return;
		if(Math.abs(root.val-k) < diff){
			rnt[0] = root.val;
			diff = Math.abs(root.val-k);
		}
		
		if(root.val <= k) getCloest(root.right, k, diff, rnt);
		else getCloest(root.left, k, diff, rnt);
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
