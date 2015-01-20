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


/////////////////////////////////////////////////////////
//Approach 2: Iterative
/**
 * Problem Statement:Binary Tree Postorder Traversal
 * Ref: http://leetcode.com/2010/10/binary-tree-post-order-traversal.html
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
        if(root==null) return rnt;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        
        while(!stack.isEmpty()){
            
            TreeNode node = stack.peek();
            if(prev==null || prev.left== node || prev.right == node){
                if(node.left != null) stack.push(node.left);
                else if(node.right!= null) stack.push(node.right);
                
            }else if(node.left == prev){
                if(node.right!= null)
                    stack.push(node.right);
            }
            else{
                rnt.add(node.val);
                stack.pop();
            } 
            
            
            prev = node;
        }
        
        return rnt;
    }
}
