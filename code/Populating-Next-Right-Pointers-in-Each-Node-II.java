/**
 * Problem Statement
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
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
        
        //use curr and next to keep track of neighour layers
        ArrayList<TreeLinkNode> curr = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
        curr.add(root);
        
        //BFS traversal
        while(curr.size()!=0){
            
            for(int i=0; i<curr.size();i++){
                TreeLinkNode currNode = curr.get(i);
                if(currNode.left!=null) next.add(currNode.left);
                if(currNode.right!=null) next.add(currNode.right);
                if(i!=curr.size()-1) currNode.next = curr.get(i+1);
                else currNode.next = null;
            }
            
            //update curr and next layer
            curr = new ArrayList<TreeLinkNode>(next);
            next = new ArrayList<TreeLinkNode>();
        }
        
    }
}


/////////////////////////////////////////////////////////////////////////////
//Round 2: 12/10/2014
public void connect(TreeLinkNode root) {
        
        //use BFS
        //two layers to keep track of current and next
        ArrayList<TreeLinkNode> curr = new ArrayList<TreeLinkNode>();
        ArrayList<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
        if(root==null) return;
        
        curr.add(root);
        while(curr.size()!=0){
            for(int i=0; i<=curr.size()-1; i++){
                TreeLinkNode currNode = curr.get(i);
                if(i<curr.size()-1)
                    currNode.next = curr.get(i+1);
                if(currNode.left!=null) next.add(currNode.left);
                if(currNode.right!=null) next.add(currNode.right);;
            }
            curr.get(curr.size()-1).next = null;
            curr = new ArrayList<TreeLinkNode>(next);
            next = new ArrayList<TreeLinkNode>();
        }
    }
