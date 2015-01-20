/**
 * Problem Statement: Binary Tree Level Order Traversal II
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
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(root == null) return rnt;
        
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        
        while(curr.size()!=0){
            ArrayList<Integer> currVal = new ArrayList<Integer>();
            ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
            
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                currVal.add(node.val);
                if(node.left != null) nextLayer.add(node.left);
                if(node.right!= null)  nextLayer.add(node.right);
            }
            
            rnt.add(0, currVal);
            curr = nextLayer;
        }
        
        return rnt;
    }
}
