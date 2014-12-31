/**
 * Problem Statement: Binary Search Tree Iterator 
 * Link: https://oj.leetcode.com/problems/binary-search-tree-iterator/
 * Hardness: ***
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

public class BSTIterator {

    TreeNode root;
    //maintain stack to track all the parents when in the process of finding leftmost elment
    Stack<TreeNode> stack;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
        stack = new Stack<TreeNode>();
      
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(root==null) return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        
        //Case1: leftTree is not null, find the leftmost element
        //push all the parents nodes in the path of finding the leftmost lement
        if(root.left!=null){
            while(root.left!=null){
                stack.push(root);
                root = root.left;
            }
            int rnt = root.val;
            //update root
            if(root.right!=null)
                root = root.right;
            else{ 
                root = stack.pop();
                root.left=null;
            }
            return rnt;
        }
        
        //Case 2: leftTree is null, then output root value, and update root
        int rnt = root.val;
        if(root.right!=null)
            root = root.right;
        else{
            if(!stack.isEmpty()){
                root = stack.pop();
                root.left=null;
            }
            else root = null;
        }
        return rnt;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
