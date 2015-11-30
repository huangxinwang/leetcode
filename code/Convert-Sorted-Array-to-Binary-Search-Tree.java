/**
 * Problem Statement
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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


////////////////////////////////////////
// 2015/11/29
// Highlight: recursively build tree
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length-1);
    }
    
    public TreeNode help(int[] nums, int left, int right){
        //special case
        if(left>right) return null;
        if(left==right) return new TreeNode(nums[left]);
        
        //recursively build tree
        int mid = (left+right)/2;
      
        
        TreeNode node = new TreeNode(nums[mid]);
        node.left = help(nums, left, mid-1);
        node.right = help(nums, mid+1, right);
        return node;
    }
}
