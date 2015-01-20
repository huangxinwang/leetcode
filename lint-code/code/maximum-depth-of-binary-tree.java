/**
 * Problem Statement: Maximum Depth of Binary Tree
 * 
 * 
 */


/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        
        int l = 0;
        int r = 0;
        if(root.left!=null){
            l = maxDepth(root.left);
        }
        if(root.right!=null){
            r = maxDepth(root.right);
        }
        
        return 1 + Math.max(l, r);
    }
}
