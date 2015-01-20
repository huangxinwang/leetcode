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


///////////////////////////////////////////////////
//Approach 2: Iterative 

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
        if(root==null) return rnt;
        
        //use a stack to store the elements that will be visited in the future
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        
        //note need to push right child before left child
        //since stack will pop left child first
        while(!stk.isEmpty()){
            TreeNode node = stk.pop();
            rnt.add(node.val);
            if(node.right!=null)
                stk.push(node.right);
            if(node.left != null)
                stk.push(node.left);
        }
        
        return rnt;
    }
}
