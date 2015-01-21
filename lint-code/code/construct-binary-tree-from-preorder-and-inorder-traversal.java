/**
 * 
 * Problem Statement: Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * 
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution {
    /**
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        return helpBuildTree(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    //recursive build subtree
    public TreeNode helpBuildTree(int[] preorder, int[] inorder, int l1, int r1, int l2, int r2){
        if(l1 > r1) return null;
        if(l1 == r1) return new TreeNode(preorder[l1]);
        
        TreeNode node = new TreeNode(preorder[l1]);
        int i=0;
        
        //seperate inorder into left and right part
        for( i=l2; i<=r2; i++){
            if(inorder[i] == preorder[l1])
                break;
        }
        
        int len = i-l2; 
        
        //build left and right subtree recursively
        node.left = helpBuildTree(preorder, inorder, l1+1, l1+i-l2, l2, i-1);
        node.right = helpBuildTree(preorder, inorder, l1+i-l2+1, r1, i+1, r2);
        
        return node;
    }
}
