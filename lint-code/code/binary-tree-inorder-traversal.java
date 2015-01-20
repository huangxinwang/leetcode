/**
 * Binary Tree Inorder Traversal
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        help(rnt, root);
        return rnt;
        
    }
    
    public void help(ArrayList<Integer> rnt, TreeNode root){
        if(root==null) return;
        if(root.left!=null)
        help(rnt, root.left);
        rnt.add(root.val);
        help(rnt, root.right);
    }
}


////////////////////////////////////////////////////
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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        if(root == null) return rnt;
        
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode p = root;
        
        while(!stk.isEmpty() || p!=null){
            
            //get the left most node
            if(p!=null){
                stk.push(p);
                p = p.left;
            }
            else{
                //process the left most node
                TreeNode node = stk.pop();
                rnt.add(node.val);
                //let p point to the right child of the left mostNode
                p = node.right;
            }
            
        }
        
        return rnt;
    }
}
