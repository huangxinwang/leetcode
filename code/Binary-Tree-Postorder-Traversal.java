/**
 * Problem Statement
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
    
    ArrayList<Integer> rntList = new ArrayList<Integer>();
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return rntList;
       
	    //order: left-child, right-child, parent
        if(root.left!=null) postorderTraversal(root.left);
        if(root.right!=null) postorderTraversal(root.right);
       
        
        rntList.add(root.val);
        return rntList;
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

//time complexity: O(n)
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
    
    ArrayList<Integer> rnt = new ArrayList<Integer>();
    
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        //special case
        if(root==null) return rnt;
        
        //post order traverse
        if(root.left!=null) postorderTraversal(root.left);
        if(root.right!=null) postorderTraversal(root.right);
        rnt.add(root.val);
        
        return rnt;
    }

}


/////////////////////////////////////////////////////////////
// 2015/11/09
// Highlight: recursive
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        postorder(rnt, root);
        return rnt;
    }
    
    public void postorder(ArrayList<Integer> rnt, TreeNode root){
        if(root==null) return;
        
        postorder(rnt, root.left);
        postorder(rnt, root.right);
        rnt.add(root.val);
    }
}


////////////////////////////////////////////////////////
// 2015/11/30
// Highlight: iterative approach
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rnt = new ArrayList<Integer>();
        if(root==null) return rnt;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode curr = root;
        TreeNode prev = null;
        
        while(!stack.isEmpty()){
            
            curr = stack.peek();
            
            //go down the tree
            //check if current node is leave, if so, process it and pop the stack
            //otherwise, keep going down
            if(prev==null || prev.left==curr || prev.right==curr){
                if(curr.left!=null){
                    stack.push(curr.left);
                }
                else if(curr.right!=null){
                    stack.push(curr.right);
                }
                else{
                    rnt.add(curr.val);
                    stack.pop();
                }
            }
            
            //go up the tree from left node
            //need to check if it has a right child
            //if yes, push it to the stack
            //otherwise, process it and pop it
            else if(curr.left == prev){
                if(curr.right!=null){
                    stack.push(curr.right);
                }else{
                    rnt.add(curr.val);
                    stack.pop();
                }
            }
            
            //go up the tree from right node
            //process it and pop it
            else if(curr.right == prev){
                rnt.add(curr.val);
                stack.pop();
            }
            
            prev = curr;
        }
        
        return rnt;
    }
}
