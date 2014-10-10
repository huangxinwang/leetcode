/**
 * Problem Statement: Path Sum II 
 * Link: https://oj.leetcode.com/problems/path-sum-ii/
 * 
 * 
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        
        //paramter
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        //special case
        if(root==null) return rnt;
        
        //initial 
        tmp.add(root.val);
        dfs(root, sum-root.val, rnt, tmp);
        return rnt;
    }
    
    public void dfs(TreeNode root, int sum, ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp){
        
        //terminate condition
        if(root.left==null && root.right==null && sum==0){
            rnt.add(tmp);
        }
        
        //dfs left and right children
        //note that we need to create leftTmp instead of put tmp.add(newvalue) directly in the call function
        if(root.left!=null){
            ArrayList<Integer> leftTmp = new ArrayList<Integer>(tmp);
            leftTmp.add(root.left.val);
            dfs(root.left, sum-root.left.val,rnt, leftTmp);
        }
        if(root.right!=null){
            ArrayList<Integer> rightTmp = new ArrayList<Integer>(tmp);
            rightTmp.add(root.right.val);
            dfs(root.right, sum-root.right.val, rnt, rightTmp);
        }
    }
}