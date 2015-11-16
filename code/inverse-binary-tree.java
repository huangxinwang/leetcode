/**
* Problem Statement: Invert Binary Tree
* Invert a binary tree.
* 
*     4
*   /   \
*  2     7
* / \   / \
*1   3 6   9
*to
*     4
*   /   \
*  7     2
* / \   / \
*9   6 3   1
*/



//////////////////////////////////////////////////
//2015/11/15
//Highlight: recursion
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
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        
        //swap left with right
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        
        return root;
    }
}
