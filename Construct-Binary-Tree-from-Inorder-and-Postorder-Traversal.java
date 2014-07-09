/**
 * Problem Statement: Construct Binary Tree from Inorder and Postorder Traversal 
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 */
 
/**
 * Link: https://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length==0) return null;
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] inorder, int[] postorder, int iLeft, int iRight, int pLeft, int pRight)
    {
        //special case
        if(iLeft > iRight || pLeft>pRight) return null;
        
        //get root node from postorder
        //and indentify rootnode in inorder
        int rootVal = postorder[pRight];
        int rootIndex = 0;
        for(int i=iLeft; i<=iRight; i++){
            if(inorder[i]==rootVal)
                rootIndex = i;
        }
        
        //recursive split inorder and postorder into left and right parts
        //to create left and right child
        TreeNode rnt = new TreeNode(rootVal);
        rnt.left = helper(inorder, postorder, iLeft, rootIndex-1, pLeft, pLeft+(rootIndex-iLeft)-1);
        rnt.right = helper(inorder, postorder, rootIndex+1, iRight, pLeft+(rootIndex-iLeft), pRight-1);
        return rnt;
    }
}