/**
 * Problem Statement: Binary Tree Preorder Traversal
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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        help(rnt, root);
        return rnt;
    }
    
    public void help(ArrayList<Integer> rnt, TreeNode root){
        if(root==null) return;
        rnt.add(root.val);
        if(root.left!=null)
            help(rnt, root.left);
        if(root.right!=null)
            help(rnt, root.right);
            
    }
}
