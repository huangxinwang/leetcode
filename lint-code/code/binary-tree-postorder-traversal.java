/**
 * Binary Tree Postorder Traversal
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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        help(root, rnt);
        return rnt;
        
        
    }
    
    public void help(TreeNode root, ArrayList<Integer> rnt){
        if(root == null) return;
        
        if(root.left!=null)
            help(root.left, rnt);
            
        if(root.right!=null)
            help(root.right, rnt);
      
       
        
        rnt.add(root.val);
    }
}
