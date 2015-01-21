/**
 * Problem Statement: Lowest Common Ancestor
 * Ref: http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * 
 * /

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
 
 
 /**
  * 
  * Idea: traverse from bottom up
  * Traverse until a node either contains A or B
  * Then recursive determine whether a subtree contains A or B
  * 
  * For left and right subtree, if both contains either A or B, then current node is the result
  * Otherwise, A and B are in the same subtree, return the non-null one
  * 
  */
  
  
public class Solution {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root==null) return null;
        
        if(root.val == A.val || root.val== B.val) return root;
        
        TreeNode leftNode = lowestCommonAncestor(root.left, A, B);
        TreeNode rightNode = lowestCommonAncestor(root.right, A, B);
        
        if(leftNode!=null && rightNode!=null) return root;
        else return leftNode==null ? rightNode: leftNode;
        
    }
    
    
}
