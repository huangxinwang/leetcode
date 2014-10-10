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