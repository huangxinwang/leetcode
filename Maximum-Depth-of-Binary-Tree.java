/**
 * Problem Statement
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        
        //special case
        if(root==null) return 0;
        
        //calculate maximum height of leftchild and rightchild
        int leftHeight = 1;
        int rightHeight = 1;
        if(root.left!=null)
        leftHeight = calHeight(root.left,1);
        if(root.right!=null)
        rightHeight = calHeight(root.right,1);
        
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
    
    public int calHeight(TreeNode node, int currHeight){
        
        //special case
        if(node==null) return currHeight;
        
        //init value, note if both leftchild and rightchild are null, then return currHeight
        int leftHeight = currHeight+1;
        int rightHeight = currHeight+1;
        
        if(node.left!=null)
            leftHeight = calHeight(node.left, currHeight+1);
        if(node.right!=null)
            rightHeight = calHeight(node.right, currHeight+1);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}