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

/////////////////////////////////////////////////////
//Round 2: 12/15/2014
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
        
        //BFS traverse
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        
        //keep two layers to do the traverse
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        if(root == null) return rnt;
        curr.add(root);
        
        //use curr layer to build next layer
        //extract the value in currvalue and add to rnt
        while(curr.size()>0){
            ArrayList<Integer> currVal = new ArrayList<Integer>();
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                currVal.add(node.val);
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            
            rnt.add(new ArrayList<Integer>(currVal));
            curr = new ArrayList<TreeNode>(next);
            next = new ArrayList<TreeNode>();
        }
        
        return rnt;
    }
}


/////////////////////////////////////////////
// 2015/11/11
// Highlight: inter-play of two arraylist
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        if(root==null) return rnt;
        
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        
        while(curr.size()!=0){
            next = new ArrayList<TreeNode>();
            ArrayList<Integer> vals = new ArrayList<Integer>();
            for(TreeNode t : curr){
                vals.add(t.val);
                if(t.left!=null) next.add(t.left);
                if(t.right!=null) next.add(t.right);
            }
            curr = new ArrayList<TreeNode>(next);
            if(vals.size()!=0) rnt.add(vals);
        }
        
        return rnt;
    }
}
