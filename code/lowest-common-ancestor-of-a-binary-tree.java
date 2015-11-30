/**
* Lowest Common Ancestor of a Binary Tree
* 
* Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
*/

//////////////////////////////////////
// 2015/11/29
// Highlight: find in both left and right trees
// Time: O(n)

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        //special case
        if(root==null) return null;
        
        //terminate case
        if(root == p || root==q) return root;
        
        //find common ancestor in the left or right trees
        TreeNode leftCommon = lowestCommonAncestor(root.left, p, q);
        TreeNode rightCommon = lowestCommonAncestor(root.right, p, q);
        
        if(leftCommon!=null && rightCommon!=null) return root;
        
        return (leftCommon==null)? rightCommon: leftCommon;
    }
}
