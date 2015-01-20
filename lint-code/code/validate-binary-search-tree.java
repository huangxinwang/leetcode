/**
 * Problem Statement: Validate Binary Search Tree
 * 
 * 
 */

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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root==null) return true;
        
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return help(root, min, max);
    }
    
    public boolean help(TreeNode root, int min, int max){
        if(root.val > max || root.val <min) return false;
        
        //special case
        //Note: the test cases in lintcode is not complete, it doesn't check the following cases
        if(root.val == Integer.MAX_VALUE && root.right!=null) return false;
        if(root.val == Integer.MIN_VALUE && root.left !=null) return false;
        
        
        if(root.left !=null){
            if( !help(root.left, min, root.val-1)) return false;
        }
        if(root.right !=null){
            if(!help(root.right, root.val+1, max)) return false;
        }
        
        return true;
    }
}
