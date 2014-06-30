/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 /**
  * Reference
  * http://www.programcreek.com/2013/01/leetcode-flatten-binary-tree-to-linked-list/
  */
  
public class Solution {
    public void flatten(TreeNode root) {
       
       Stack<TreeNode> stack = new Stack<TreeNode>();
       TreeNode p = root;
       
       while(p!=null || !stack.empty()){
           
            //push right to stack
            if(p.right!=null)
                stack.push(p.right);
        
            //case1: assign left to right if left is not null
            if(p.left!=null){
                p.right = p.left;
                p.left=null;
            }
            //case 2: pop value to assign to right if left is null 
            else if(!stack.empty())
                p.right = stack.pop();
            //update p    
            p = p.right;
       }
    }
}