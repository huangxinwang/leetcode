/**
 * Problem Statement: Recover Binary Search Tree
 * Link: https://oj.leetcode.com/problems/recover-binary-search-tree/
 * 
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 */
 
 /**
  * Reference: http://yucoding.blogspot.com/2013/03/leetcode-question-75-recover-binary.html
  * 
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
 
 
//TODO: revisited
public class Solution {
    
    //keep record of the first element to switch
    TreeNode first; 
    TreeNode second;
    
    //inorder traverse the tree
    TreeNode pre;
    
    public void recoverTree(TreeNode root) {
        
        if(root==null) return;
        findWrongNode(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        
    }
    
    public void findWrongNode(TreeNode root){
        
        if(root==null) return;
        findWrongNode(root.left);
        if(pre!=null && pre.val > root.val){
            //record first element
            if(first==null)
                first = pre;
            //record second element, maybe change for once or twice regarding different wrong situation
            second = root;
        }
        pre = root;
        findWrongNode(root.right);
    }
}