/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        //special case
        if(root==null) return rnt;
        
        //date structure
        ArrayList<TreeNode> currLayer = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
        currLayer.add(root);
        
        //use to differentiate two neighbour layers
        boolean flag = true;
        
        while(currLayer.size()!=0){
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            int size = currLayer.size();
            
            //traverse layers
            for(int i=size-1; i>=0; i--){
                
                TreeNode currNode;
                currNode = currLayer.get(i);
               
                //add leftchild and rightchild in different order in two neighbour layers
                if(flag)
                {
                    if(currNode.left!=null) nextLayer.add(currNode.left);
                    if(currNode.right!=null) nextLayer.add(currNode.right);
                }else
                {
                    if(currNode.right!=null) nextLayer.add(currNode.right);
                    if(currNode.left!=null) nextLayer.add(currNode.left);
                }
                tmp.add(currNode.val);
            }
            
            //record value and update
            rnt.add(tmp);
            currLayer = new ArrayList<TreeNode>(nextLayer);
            nextLayer = new ArrayList<TreeNode>();
            //switch flag
            flag = (flag==true) ? false : true;
        }
        
        return rnt;
        
    }
}