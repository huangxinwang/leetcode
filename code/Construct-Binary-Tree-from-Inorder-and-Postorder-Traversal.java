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

///////////////////////////////////////////////////////////////////////////////////////////////
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length==0) return null;
        
        int inleft =0;
        int inright = inorder.length-1;
        int postleft = 0;
        int postright = postorder.length-1;
        return help(inleft, inright, postleft, postright, inorder, postorder);
    }
    
    public TreeNode help(int inleft, int inright, int postleft, int postright, int[] inorder, int[] postorder){
        
        //terminate case
        if(inleft > inright || postleft>postright) return  null;

        //find root, it is at the end of post order, need to find its position in inorder array
        int midnode = postorder[postright];
        
        int firstend = inleft;
        for(firstend=inleft; firstend<=inright; firstend++){
            if(inorder[firstend] == midnode)
                break;
        }
        
        //recursively construct left and right subtree
        TreeNode rnt = new TreeNode(midnode);
        rnt.left = help(inleft, firstend -1, postleft, postleft+firstend-1-inleft, inorder, postorder);
        rnt.right = help(firstend+1, inright, postleft+firstend-inleft, postright-1, inorder, postorder);
        return rnt;
        
    }
}


/////////////////////////////////////////////
// 2015/11/12
// Highlight: recursive, deal with corner by using simple example such as [1 2 3]
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        return help(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public TreeNode help(int[] inorder, int ileft, int iright, int[] postorder, int pleft, int pright){
        if(ileft>iright) return null;
        TreeNode root = new TreeNode(postorder[pright]);
        int count = 0;
        while(inorder[ileft+count]!=postorder[pright]){
            count++;
        }
        
        TreeNode left = help(inorder, ileft, ileft+count-1, postorder, pleft, pleft+count-1);
        TreeNode right = help(inorder, ileft+count+1,iright, postorder, pleft+count, pright-1);
        root.left = left;
        root.right = right;
        return root;
    }
}
