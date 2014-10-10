/**
 * Problem Statement
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
    
    ArrayList<Integer> rntList = new ArrayList<Integer>();
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return rntList;
       
	    //order: left-child, right-child, parent
        if(root.left!=null) postorderTraversal(root.left);
        if(root.right!=null) postorderTraversal(root.right);
       
        
        rntList.add(root.val);
        return rntList;
    }
}