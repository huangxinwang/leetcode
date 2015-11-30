/**
* Problem: Count Complete Tree Nodes
*
*/


/////////////////////////////////////////
// 2015/11/30
// Highlight: recursive solution, does not make use of "complete" information
// Time: O(n), exceed time limit
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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return countNodes(root.left)+1+countNodes(root.right);
    }
}
