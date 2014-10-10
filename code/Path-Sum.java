/**
 * Problem Statement
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up 
 * all the values along the path equals the given sum.
 * 
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
    public boolean hasPathSum(TreeNode root, int sum) {
        
        //special case
        if(root==null) return false;
        
        //no left child nor right child
        if(root!=null && root.left==null && root.right==null && root.val==sum) return true;
        
        boolean flag = false;
        //has left child
        if(root.left!=null) flag = hasPathSum(root.left, sum - root.val);
        if(flag==true) return true;
        //has right child
        if(root.right!=null) flag = hasPathSum(root.right, sum - root.val);
        
        return flag;
        
    }
    
}