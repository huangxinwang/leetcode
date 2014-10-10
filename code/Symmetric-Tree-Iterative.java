/**
 * Problem Statement: Symmetric Tree 
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
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) return true;
        
        //use to store left and right sub-tree
        LinkedList<TreeNode> leftStack = new LinkedList<TreeNode>();
        LinkedList<TreeNode> rightStack = new LinkedList<TreeNode>();
        
        //initialize
        leftStack.add(root.left);
        rightStack.add(root.right);
        
        //iteratively check symmetric
        while(!leftStack.isEmpty()){
            
            //pop value for check
            TreeNode l = leftStack.pop();
            TreeNode r = rightStack.pop();
            
            if((l==null && r!=null) || (r==null && l!=null))
                return false;
            if(l!=null){
                if(l.val!=r.val) return false;
                
                //iteratively add value
                leftStack.add(l.left);
                leftStack.add(l.right);
                rightStack.add(r.right);
                rightStack.add(r.left);
            }
            
        }
        
        return true;
    }
}