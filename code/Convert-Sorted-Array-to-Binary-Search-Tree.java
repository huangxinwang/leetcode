/**
 * Problem Statement
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        
        if(num.length==0) return null;
        
        int mid = num.length/2;
        TreeNode trn = new TreeNode(num[mid]);
		
		//recursive call left, right tree
        trn.left = subArrayToBST(0,mid-1,num);
        trn.right = subArrayToBST(mid+1,num.length-1,num);
        
        return trn;
        
    }
    
	/*
	 * recursive sub-procedure
	 */
    public TreeNode subArrayToBST(int left, int right, int[] num)
    {
        if(left>right) return null;
        if(left==right) return new TreeNode(num[left]);
        int mid = (left+right)/2;
        TreeNode trn = new TreeNode(num[mid]);
        trn.left = subArrayToBST(left,mid-1,num);
        trn.right = subArrayToBST(mid+1,right,num);
        return trn;
    }
}

/////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/14/2014
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num.length==0) return null;
        return helper(num, 0, num.length-1);
    }
    
    public TreeNode helper(int[] num, int lindex, int rindex){
        //terminate cases
        if(lindex > rindex) return null;
        if(lindex == rindex) return new TreeNode(num[lindex]);
        
        //find mid point, and recursively build left and right subtree
        int mid = (lindex+rindex)/2;
        TreeNode root= new TreeNode(num[mid]);
        root.left = helper(num, lindex, mid-1);
        root.right = helper(num, mid+1, rindex);
        return root;
    }
}
