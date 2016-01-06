/**
 * Problem Statement
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left = 1 + minDepth(root.left);
        int right = 1 + minDepth(root.right);
        
        //special case, e.g., [1,2], the depth should be 2 rather than 1
        if(left==1) return right;
        if(right==1) return left;
        
        else return Math.min(left,right);
    }
}
