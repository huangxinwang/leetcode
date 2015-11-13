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

///////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/14/2014
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        int preleft = 0;
        int preright = preorder.length-1;
        int inleft = 0;
        int inright = inorder.length-1;
        return help(preleft, preright, inleft, inright, preorder, inorder);
    }
    
    public TreeNode help(int preleft, int preright, int inleft, int inright, int[] preorder, int[] inorder){
        
        //terminate case
        if(preleft > preright || inleft > inright) return null;
        
        //find root, it is at hte head of preorder, but need to find its position in in order
        int midnode = preorder[preleft];
        
        int firstend = inleft;
        for(firstend = inleft; firstend <=inright; firstend++){
            if(inorder[firstend] == midnode) break;
        }
        
        //recusively build left and right subtree
        TreeNode rnt = new TreeNode(midnode);
        rnt.left = help(preleft+1, preleft+firstend-inleft, inleft, firstend-1, preorder, inorder);
        rnt.right = help(preleft+firstend-inleft+1, preright, firstend+1, inright, preorder, inorder);
        
        return rnt;
    }
}


///////////////////////////////////////////////////////////////
// 2015/11/12
// Highlight: recursive build the tree
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        return help(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode help(int[] preorder, int pleft, int pright, int[] inorder, int ileft, int iright){
        if(pleft>pright) return null;
        TreeNode root = new TreeNode(preorder[pleft]);
        int count = 0;
        while(inorder[ileft+count]!=preorder[pleft]){
            count++;
        }
        
        //decide left and right node
        TreeNode left = help(preorder, pleft+1, pleft+count, inorder, ileft, ileft+count);
        TreeNode right = help(preorder, pleft+count+1, pright, inorder, ileft+count+1, iright);
        root.left = left;
        root.right = right;
        return root;
    }
}
