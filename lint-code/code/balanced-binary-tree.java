/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        int rnt = help(root);
        if(rnt==-1) return false;
        return true;
    }
    
    public int help(TreeNode root){
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        
        //check left and right subtree seperately
        int left = 0;
        int right = 0;
        if(root.left!=null) left = help(root.left);
        if(left==-1) return -1;
        if(root.right!=null) right = help(root.right);
        if(right==-1) return -1;
        
        //determine if current tree is balanced
        if(Math.abs(left-right)>1) return -1;
        return Math.max(left,right)+1;
    }
}
