/**
 * Problem Statement: Binary Tree Level Order Traversal
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level)
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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(root==null) return rnt;
        
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        
        while(curr.size()!=0){
            ArrayList<Integer> currval = new ArrayList<Integer>();
            ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                currval.add(node.val);
                if(node.left!=null)
                    nextLayer.add(node.left);
                if(node.right!=null)
                    nextLayer.add(node.right);
            }
            
            // rnt.add(new ArrayList<Integer>(currval));
            // curr = new ArrayList<TreeNode>(nextLayer);
            
            rnt.add(currval);
            curr =nextLayer;
            
        }
        
        return rnt;
    }
}
