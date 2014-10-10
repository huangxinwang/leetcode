/**
 * Problem Statement: Construct Binary Tree from Preorder and Inorder Traversal
 * 
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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
    
    TreeNode root;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
        
    }
    
    public TreeNode helper(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight){
        
        //terminate case
        if(pLeft>pRight || preorder.length==0) return null;
        
        //get root value
        int rootVal = preorder[pLeft];
        int iRootIndex = 0;
        for(int i=iLeft; i<=iRight; i++){
            if(rootVal==inorder[i])
                iRootIndex = i;
        }
        
        //recursively get left and right child
        TreeNode rnt = new TreeNode(rootVal);
        rnt.left = helper(preorder, inorder, pLeft+1, pLeft+(iRootIndex-iLeft), iLeft, iRootIndex-1);
        rnt.right = helper(preorder, inorder, pLeft+(iRootIndex-iLeft)+1, pRight, iRootIndex+1, iRight);
        return rnt;
    }
    
}