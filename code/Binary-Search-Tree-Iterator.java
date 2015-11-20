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


///////////////////////////////////////////////////////////////
// 2015/11/19
// Highlight: use a stack to store the left branch of the tree, when a node is pop out, put its right branch in (left nodes in right branch)
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
    //use a stack to store the nodes in the left branch, when a node is pop put, store its right branch (left nodes in right branch) in
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
       
        TreeNode tmp = root;
        while(tmp!=null){
            stack.push(tmp);
            tmp = tmp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty()) return false;
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode curr = stack.pop();
        int rnt = curr.val;
        TreeNode node = curr.right;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        return rnt;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
