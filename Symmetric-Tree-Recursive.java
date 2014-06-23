/**
 * Problem Statement: Symmetric Tree 
 * 
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree is symmetric:
 *       1
 *      / \
 *     2   2
 *    / \ / \
 *   3  4 4  3
 * 
 * 
 * But the following is not:
 *  1
 * / \
 *2   2
 * \   \
 * 3    3
 * 
 * 
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 */

/**
 * Reference
 * http://fisherlei.blogspot.com/2013/01/leetcode-symmetric-tree.html
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
    public boolean isSymmetric(TreeNode root) {
        
        //special case
        if(root==null) return true;

        //recursively check wheter left subtree is symmetric with right subtree
        return isSym(root.left,root.right);
        
    }
    
    //recursively check symmetric
    public boolean isSym(TreeNode left, TreeNode right){
        //special case
        if(left==null && right==null) return true;
        if(left==null) return right==null;
        if(right==null) return left==null;
        if(left.val!=right.val) return false;
        
        //recursive check
        if(!isSym(left.right, right.left))
            return false;
        if(!isSym(left.left, right.right))
            return false;
        //symmetric
        return true;
    }
}