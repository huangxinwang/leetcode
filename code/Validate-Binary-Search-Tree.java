/**
 * Problem Statement: Validate Binary Search Tree 
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
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
    public boolean isValidBST(TreeNode root) {
        
        //note: besides of recursively check value of node and its left and right child
        //we also need to record the min and max value left and right child could be
        //Otherwise, we will fail the following instance, {10,5,15,#,#,6,20}
        return BSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
       
    }
    
    public boolean BSTHelper(TreeNode node, int low, int high){
        
        if(node==null) return true;
        
        if(low<node.val && node.val<high){
            return BSTHelper(node.left,low,node.val) && BSTHelper(node.right,node.val,high);
        }
        
        return false;
    }
}

///////////////////////////////////////////////////////////////////////////
//Round 2: 12/15/2014
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
    public boolean isValidBST(TreeNode root) {
        
        if(root==null) return true;
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, int low, int high){
        
        if(root==null) return true;

        //false cases
        if(root.val == Integer.MIN_VALUE && root.left!=null) return false;
        if(root.val == Integer.MAX_VALUE && root.right!=null) return false;

        if(low> root.val || root.val > high) return false;
        
        //recursive
        //update the upper bound of left tree, and lower bound of upper tree; 
        //to avoid the case that the node value equal to Integer.MIN_VALUE
        return helper(root.left, low, root.val-1) && helper(root.right, root.val+1, high);
       
     
    }
}
