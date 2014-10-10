/**
 * Problem Statement
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * See:https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
        //data structure
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<TreeNode> currLayer = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
        
        //special case
        if(root==null) return rnt;
        currLayer.add(root);
        
        //BFS traverse nodes
        while(currLayer.size()!=0){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            
            for(int i=0; i<currLayer.size();i++){
                TreeNode currNode = currLayer.get(i);
                tmp.add(currNode.val);
                if(currNode.left!=null)
                    nextLayer.add(currNode.left);
                if(currNode.right!=null)
                    nextLayer.add(currNode.right);
            }
            
            //update
            rnt.add(tmp);
            currLayer = new ArrayList<TreeNode>(nextLayer);
            nextLayer = new ArrayList<TreeNode>();
        }
        
        return rnt;
        
    }
}