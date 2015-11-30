/**
* Problem: Count Complete Tree Nodes
*
*/


/////////////////////////////////////////
// 2015/11/30
// Highlight: recursive solution, does not make use of "complete" information
// Time: O(n), exceed time limit
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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return countNodes(root.left)+1+countNodes(root.right);
    }
}

/////////////////////////////////////////////////
// 2015/11/30
// Highlight: check height of left and right side, if equal, than the tree has 2^h -1 nodes
//            otherwise, nodes = letnode + rightnode + 1
// Time: O(2h)
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
    public int countNodes(TreeNode root) {
       if(root==null)
        return 0;
 
        int left = getLeftHeight(root)+1;    
        int right = getRightHeight(root)+1;
     
        if(left==right){
            //do not use Math.pow(2,left); time limite exceed
            return (2<<(left-1))-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
    }
    
   //count height of left tree
   public int getLeftHeight(TreeNode n){
    if(n==null) return 0;
 
    int height = 0;
    while(n.left!=null){
        n = n.left;
        height++;
    }
    return height;
    }


    //count height of right tree
    public int getRightHeight(TreeNode n){
        if(n==null) return 0;
     
        int height=0;
        while(n.right!=null){
            height++;
            n = n.right;
        }
        return height;
    }
}
