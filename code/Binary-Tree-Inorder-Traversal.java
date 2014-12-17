/**
 * Problem Statement
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
    
    ArrayList<Integer> rnt = new ArrayList<Integer>();
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        if(root==null)
            return rnt;
            
        if(root.left!=null) 
            inorderTraversal(root.left);
            
        rnt.add(root.val);
        
        if(root.right!=null)
            inorderTraversal(root.right);
        
        return rnt;
    }
    
}


/////////////////////////////////////////////////////////////
//Round 2: 12/17/2014
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
    
    public List<Integer> inorderTraversal(TreeNode root) {
       
        if(root==null) return rnt;
        if(root.left!=null)
            inorderTraversal(root.left);
        rnt.add(root.val);
        if(root.right!=null)
            inorderTraversal(root.right);
        return rnt;
    }
}
