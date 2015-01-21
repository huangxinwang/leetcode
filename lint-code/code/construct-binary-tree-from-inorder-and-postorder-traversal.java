/**
 * Problem Statement: Given inorder and postorder traversal of a tree, construct the binary tree.
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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        return helpBuildTree(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    //recursive build the tree
    public TreeNode helpBuildTree(int[] inorder, int[] postorder, int l1, int r1, int l2, int r2){
        if(l1 > r1) return null;
        if(l1 == r1) return new TreeNode(inorder[l1]);
        
        TreeNode node = new TreeNode(postorder[r2]);
        
        //find the root point in inorder array 
        //build left and right subtree seperately
        int i = 0;
        for(i=l1; i<=r1; i++){
            if(inorder[i] == postorder[r2])
                break;
        }
        
        node.left = helpBuildTree(inorder, postorder, l1, i-1, l2, l2+(i-l1-1));
        node.right = helpBuildTree(inorder, postorder, i+1, r1, l2+i-l1, r2-1);
        return node;
    }
}
