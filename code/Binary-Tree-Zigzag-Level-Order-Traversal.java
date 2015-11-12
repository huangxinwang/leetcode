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

//////////////////////////////////////////////////////////////////////////
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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        
        //two layer BFS traverse
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        curr.add(root);
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(root==null) return rnt;
        //keep a flag to decide the order of traverse, i.e., start to end, or end to start
        boolean reverse = false;
        
        //construct next layer using current layer
        //and also keep record of the value of the node to put to the return result
        while(curr.size()>0){
            ArrayList<Integer> currVal = new ArrayList<Integer>();
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                if(reverse)
                    currVal.add(0,node.val);
                else 
                    currVal.add(node.val);
                if(node.left!=null)
                    next.add(node.left);
                if(node.right!=null)
                    next.add(node.right);
            }
            
            //update curr and next layer
            rnt.add(new ArrayList<Integer>(currVal));
            curr = new ArrayList<TreeNode>(next);
            next = new ArrayList<TreeNode>();
            if(reverse) reverse = false;
            else reverse = true;
        }
        
        return rnt;
    }
}


//////////////////////////////////////////////////////////
// 2015/11/12
// Highlight: inter-play of two arraylists
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        if(root==null) return rnt;
        
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        curr.add(root);
        
        boolean reverse = false;
        while(curr.size()>0){
            ArrayList<Integer> vals = new ArrayList<Integer>();
            for(TreeNode t: curr){
                vals.add(t.val);
                if(t.left!=null) next.add(t.left);
                if(t.right!=null) next.add(t.right);
            }
            
            //reverse listsa
            if(reverse){
                Collections.reverse(vals);
            }
            reverse = !reverse;
            rnt.add(vals);
            curr= new ArrayList<TreeNode>(next);
            next = new ArrayList<TreeNode>();
        }
        
        return rnt;
        
    }
}
