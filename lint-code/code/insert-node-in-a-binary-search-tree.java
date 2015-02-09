//Approach 1: recursive
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root==null) return node;
        if(node.val <= root.val)
            root.left = insertNode(root.left, node);
        else root.right = insertNode(root.right, node);
        return root;
    }
}


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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root==null) return node;
        TreeNode parent = root;
        while(parent!=null){
            if(node.val <= parent.val){
                if(parent.left==null){
                    parent.left = node;
                    return root;
                }
                parent = parent.left;
            }else{
                if(parent.right==null){
                    parent.right = node;
                    return root;
                }
                parent = parent.right;
            }
        }
        
        return root;
    }
}

