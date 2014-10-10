/**
 * Problem Statement
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //special case
        if(p==null && q==null) return true;
        if(p==null && q!=null) return false;
        if(p!=null && q==null) return false;
       
        boolean flag = true;
        
        //check if value is the same
        flag = (p.val==q.val);
        
        //check left child existence(recursively)
        flag = flag && isSameTree(p.left,q.left);
        
        //check left child value(recursively)
        if(p.left!=null && q.left!=null)
        flag = flag && (p.left.val==q.left.val);
        
        //check right child existence(recursively)
        flag = flag && isSameTree(p.right,q.right);
        
        //check right child value(recursively)
        if(p.right!=null && q.right!=null)
        flag = flag && (p.right.val==q.right.val);
        
        return flag;
    }
    
    
}