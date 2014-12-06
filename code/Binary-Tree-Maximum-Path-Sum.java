/**
 * Problem Statement: Binary Tree Maximum Path Sum
 * Link:https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 * Time:556 ms
 * Ref:http://www.programcreek.com/2013/02/leetcode-binary-tree-maximum-path-sum-java/
 * 
 * Given a binary tree, find the maximum path sum.
 * The path may start and end at any node in the tree.
 * For example:
 * Given the below binary tree,
 *   1
 *  / \
 * 2   3
 * Return 6.
 * 
 * 
 * 
 * 
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
      //use max to keep record of maximum value so far
      int[] max = new int[1];
      max[0] = Integer.MIN_VALUE;
      calculateSum(root, max);
      return max[0];
    }
    
    public int calculateSum(TreeNode root, int[] max){
        if(root == null) return 0;
        
        //recursive found left and rightSum
        int leftSum = calculateSum(root.left, max);
        int rightSum = calculateSum(root.right, max);
        
        //current keep record of single path, i.e. only left or right, or either one plus current root
        int current = Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
        max[0] = Math.max(max[0], Math.max(current, root.val + leftSum + rightSum));
        return current;
    }
    
    
}

///////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/06/2014
//DFS

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
    public int maxPathSum(TreeNode root) {
        
        //use an one element array to store the largest number
        int[] max  = new int[1];
        max[0] = Integer.MIN_VALUE;
        findMax(root, max);
        return max[0];
    }
    
    public int findMax(TreeNode root, int[] max){
        if(root==null)
            return 0;
        
        int left = 0;
        if(root.left!=null)
            left = Math.max(findMax(root.left, max), 0);
        int right = 0;
        if(root.right!=null)
            right = Math.max(findMax(root.right, max), 0);
        
        //keep track maximum single path end at root.val, both left and right 
        int curr = Math.max(root.val, Math.max(root.val+left, root.val+right));
        
        //joint left and right, to update maximum path
        max[0] = Math.max(max[0], Math.max(curr, root.val+left+right));
        
        return curr;
    }
}
