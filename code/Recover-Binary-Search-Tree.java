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

////////////////////////////////////////////////////////////////////////
//Round 2: 12/15/2014
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
    
    TreeNode first;
    TreeNode second;
    TreeNode pre;
    
    public void recoverTree(TreeNode root) {
        
        if(root==null) return;
        findWrongNode(root);
        int tmp = second.val;
        second.val = first.val;
        first.val = tmp;
        
    }
    
    //in order traverse to find the wrong value
    public void findWrongNode(TreeNode root){
        
        if(root==null) return;
        
        findWrongNode(root.left);
        if(pre!=null && pre.val > root.val){
            if(first==null)
                first = pre;
            //record wrong node
            //note that when pre.val < root.val; for first, it is pre; for second, it is root
            second = root;
        }
        
        pre = root;
        findWrongNode(root.right);
    }
}
