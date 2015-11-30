/**
 * Problem Statement
 * Given a binary tree, return the inorder traversal of its nodes' values.
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
    
    ArrayList<Integer> rnt = new ArrayList<Integer>();
    
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        if(root==null)
            return rnt;
            
        if(root.left!=null) 
            inorderTraversal(root.left);
            
        rnt.add(root.val);
        
        if(root.right!=null)
            inorderTraversal(root.right);
        
        return rnt;
    }
    
}


/////////////////////////////////////////////////////////////
//Round 2: 12/17/2014
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
    
    ArrayList<Integer> rnt = new ArrayList<Integer>();
    
    public List<Integer> inorderTraversal(TreeNode root) {
       
        if(root==null) return rnt;
        if(root.left!=null)
            inorderTraversal(root.left);
        rnt.add(root.val);
        if(root.right!=null)
            inorderTraversal(root.right);
        return rnt;
    }
}


/////////////////////////////////////////////////
// 2015/11/08
// Highlight: recursive
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rnt = new ArrayList<Integer>();
        help(rnt, root);
        return rnt;
    }
    
    public void help(List<Integer> rnt, TreeNode root){
        if(root==null) return;
        
        help(rnt, root.left);
        rnt.add(root.val);
        help(rnt, root.right);
    }
}


////////////////////////////////////////////
// 2015/11/30
// Highlight: iterative solution
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rnt = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(!stack.isEmpty() || p!=null){
            //go down the tree
            if(p!=null){
                stack.push(p);
                p = p.left;
            }
            //pop node from stack
            //add its right 
            else{
                p = stack.pop();
                rnt.add(p.val);
                p = p.right;
            }
        }
        
        return rnt;
    }
}
