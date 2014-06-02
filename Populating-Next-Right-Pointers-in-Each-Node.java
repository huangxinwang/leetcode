/**
 * Problem Statement
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 */
 
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        
        //special case
        if(root==null) return;
        
        //use BFS traversal
        //use currLayer to keep nodes in current layer
        //use nextLayer to keep nodes in next layer
        ArrayList<TreeLinkNode> currLayer = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> nextLayer = new ArrayList<TreeLinkNode>();
        
        currLayer.add(root);
        
        //do while current layer is not null
        while(currLayer.size()!=0){
            int length = currLayer.size();
            
            for(int i=0; i<currLayer.size(); i++)
            {
                //set next pointer
                TreeLinkNode node = currLayer.get(i);
                if(i+1 == currLayer.size()) node.next=null;
                else node.next = currLayer.get(i+1);
                
                //add node to next layer using BFS 
                if(node.left!=null) nextLayer.add(node.left);
                if(node.right!=null) nextLayer.add(node.right);
            }
            
            //reset currentlayer and nextlayer
            currLayer = new ArrayList<TreeLinkNode>(nextLayer);
            nextLayer = new ArrayList<TreeLinkNode>();
        }
    }
}