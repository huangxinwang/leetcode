/**
 * Problem Statement
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
 
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int minDepth(TreeNode root) {
        
        if(root==null) return 0;
        
        ArrayList<TreeNode> currLayer = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
        
        currLayer.add(root);
        int layer = 1;
        
        //using BFS to find the first leaf that has minimum height
        while(currLayer.size()!=0){
            
            for(int i=0; i<currLayer.size(); i++){
                TreeNode currNode = currLayer.get(i);
                //leaf found
                if(currNode.left==null && currNode.right==null)
                    return layer;
                //BFS left child and right child
                if(currNode.left!=null)
                    nextLayer.add(currNode.left);
                if(currNode.right!=null)
                    nextLayer.add(currNode.right);
                    
            }
            //update current layer and next layer
            currLayer = new ArrayList<TreeNode>(nextLayer);
            nextLayer = new ArrayList<TreeNode>();
            layer++;
        }
        
        return layer;
        
    }
    
    
}