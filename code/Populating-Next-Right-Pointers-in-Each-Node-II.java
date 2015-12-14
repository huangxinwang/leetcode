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
        
        //BFS traverse
        List<TreeLinkNode> curr = new ArrayList<TreeLinkNode>();
        List<TreeLinkNode> next = new ArrayList<TreeLinkNode>();
        curr.add(root);
        while(curr.size()>0){
            for(int i=0; i<curr.size(); i++){
                TreeLinkNode node = curr.get(i);
                if(node.left!=null){
                    next.add(node.left);
                }
                if(node.right!=null){
                    next.add(node.right);
                }
                if(i!=curr.size()-1){
                    node.next = curr.get(i+1);
                }else{
                    node.next = null;
                }
            }
            curr = new ArrayList<TreeLinkNode>(next);
            next = new ArrayList<TreeLinkNode>();
        }
    }
}
