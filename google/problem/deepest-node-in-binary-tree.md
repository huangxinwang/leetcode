### Problem
Return deepest node in binary tree
If the tree is complete, having two same depth of node, return the rightmost node

### Checked
- not yet

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
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(6);
		
		TreeNode node = deepestTreeLeaf(root);
		System.out.println(node.val);
	}
	
	public static TreeNode deepestTreeLeaf(TreeNode root){
		if(root == null) return root;
		ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
		
		
		curr.add(root);
		while(curr.size()!=0){
			ArrayList<TreeNode> next = new ArrayList<TreeNode>();
			for(int i=0; i<curr.size(); i++){
				TreeNode node = curr.get(i);
				if(node.left!=null) next.add(node.left);
				if(node.right!=null) next.add(node.right);
			}
			//when next layers has no elements, then current layers contians the deepest leaves
			if(next.size()==0) return curr.get(curr.size()-1);
			else{
				curr = new ArrayList<TreeNode>(next);
			}
		}
		
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
