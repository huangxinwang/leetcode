/**
 * Problem Statement
 * Given a binary tree, determine if it is height-balanced.
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
    public boolean isBalanced(TreeNode root) {
        
        if(root==null) return true;
        
        int leftHeight = 0;
        int rightHeight = 0;
        
        //calculate left child and right child
        if(root.left!=null)
            leftHeight = calHeight(root.left,1);
        if(root.right!=null)
            rightHeight = calHeight(root.right,1);
        
        //return false if different is more than 1
        if(leftHeight==-1 || rightHeight==-1) return false;
        if(leftHeight-rightHeight >1 || leftHeight-rightHeight <-1) return false;
        return true;
    }
    
    public int calHeight(TreeNode node, int currHeight)
    {
        //case 1
        if(node==null) return currHeight;
        
        //case 2
        if(node!=null && node.left==null && node.right==null) return currHeight;

        //case 3: calculate height of leftchild and rightchild
        int leftHeight = 0;
        int rightHeight = 0;
        if(node.left!=null)
            leftHeight = calHeight(node.left,currHeight+1);
        if(node.right!=null)
            rightHeight = calHeight(node.right,currHeight+1);
        
        //return -1 if difference of height is more than 1
        if(leftHeight-rightHeight <= 1 && leftHeight-rightHeight >= -1) 
            return leftHeight > rightHeight ? leftHeight : rightHeight;
        else return -1;
    }
    
   
}