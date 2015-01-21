/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
 */
public class Solution {
    //@param root: The root of binary tree.
    
    //curr denotes the current traversed node (int the ascending order)
    TreeNode curr;
    //put all the intermidiate node when traversing to the left most node into stack
    Stack<TreeNode> stack;
    
    
    //In the initiaization, put curr to the leftMost node
    public Solution(TreeNode root) {
        // write your code here
        this.curr = root;
        stack = new Stack<TreeNode>();
        
        //init
        if(curr!=null){
            while(curr.left!=null){
                stack.push(curr);
                curr = curr.left;
            }
        }
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        // write your code here
        if(curr!=null) return true;
        else return false;
    }
    
    //@return: return next node
    public TreeNode next() {
        // write your code here
        TreeNode rnt = curr;
        
        //update currNode
        //Case 1: right is null, then pop a node from stack (it is curr node's parent)
        if(curr.right == null){
            if(stack.isEmpty()) curr = null;
            else curr = stack.pop();
        }
        //Case 2: right is not null, then set curr as right child, and go to left most node
        else{
            curr = curr.right;
            while(curr.left!=null){
                stack.push(curr);
                curr = curr.left;
            }
        }
        
        return rnt;
    }
    
   
}
