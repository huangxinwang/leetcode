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
    public TreeNode sortedArrayToBST(int[] num) {
        
        if(num.length==0) return null;
        
        int mid = num.length/2;
        TreeNode trn = new TreeNode(num[mid]);
		
		//recursive call left, right tree
        trn.left = subArrayToBST(0,mid-1,num);
        trn.right = subArrayToBST(mid+1,num.length-1,num);
        
        return trn;
        
    }
    
	/*
	 * recursive sub-procedure
	 */
    public TreeNode subArrayToBST(int left, int right, int[] num)
    {
        if(left>right) return null;
        if(left==right) return new TreeNode(num[left]);
        int mid = (left+right)/2;
        TreeNode trn = new TreeNode(num[mid]);
        trn.left = subArrayToBST(left,mid-1,num);
        trn.right = subArrayToBST(mid+1,right,num);
        return trn;
    }
}