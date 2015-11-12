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

///////////////////////////////////////////////////////////////////
//Round 2: 12/14/2014
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
        
        //two layers, BFS traverse
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        curr.add(root);
       
        while(curr.size()>0){
          
            ArrayList<Integer> currVal = new ArrayList<Integer>();
            
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                currVal.add(node.val);
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            
            //add to the head of list
            rnt.add(0,currVal);
            
            curr = new ArrayList<TreeNode>(next);
            next = new ArrayList<TreeNode>();
        }
        
        return rnt;
    
        
    }
}


////////////////////////////////////////////////////////////////
// 2015/11/11
// Highlight: inter-play of two array lists
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        if(root==null) return rnt;
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        
        while(curr.size()!=0){
            ArrayList<Integer> vals = new ArrayList<Integer>();
            for(TreeNode t: curr){
                vals.add(t.val);
                if(t.left!=null) next.add(t.left);
                if(t.right!=null) next.add(t.right);
            }
            
            rnt.add(0, vals);
            curr = new ArrayList<TreeNode>(next);
            next = new ArrayList<TreeNode>();
        }
         
        return rnt;
        
    }
}
