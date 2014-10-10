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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(root==null) return rnt;
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<Integer> currInteger = new ArrayList<Integer>();
        
        //build current layer
        curr.add(root);
        currInteger.add(root.val);
        rnt.add(0,new ArrayList<Integer>(currInteger));
        
        //BFS recursive build next layer
        while(curr.size()!=0){
            ArrayList<TreeNode> next = new ArrayList<TreeNode>();
            ArrayList<Integer> nextInteger = new ArrayList<Integer>();
            //record both node and value
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                if(node.left!=null){
                    next.add(node.left);
                    nextInteger.add(node.left.val);
                } 
                if(node.right!=null){
                    next.add(node.right);
                    nextInteger.add(node.right.val);
                } 
            }
            if(nextInteger.size()!=0)
            rnt.add(0, new ArrayList<Integer>(nextInteger));
            curr = new ArrayList<TreeNode>(next);
        }
        
        return rnt;
        
    }
}