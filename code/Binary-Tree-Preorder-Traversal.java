/**
 * Problem Statement
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * /

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
    
    ArrayList rnt = new ArrayList();
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        if(root==null) return rnt;
       
        rnt.add(root.val);
        
        if(root.left!=null) preorderTraversal(root.left);
        if(root.right!=null) preorderTraversal(root.right);
        
        return rnt;
        
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

//time complexity O(n)
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
    
    ArrayList<Integer> rnt = new ArrayList<Integer>();
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        //special case
        if(root==null) return rnt;
        
        //preorder traversal
        rnt.add(root.val);
        if(root.left!=null) preorderTraversal(root.left);
        if(root.right!=null) preorderTraversal(root.right);
        
        return rnt;
    }
}
