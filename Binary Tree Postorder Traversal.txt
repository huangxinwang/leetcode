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
       
        if(root.left!=null) postorderTraversal(root.left);
        if(root.right!=null) postorderTraversal(root.right);
       
        
        rntList.add(root.val);
        return rntList;
    }
}