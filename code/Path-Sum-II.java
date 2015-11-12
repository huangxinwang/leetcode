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



//////////////////////////////////////////////////////////////////////
//Round 2: 12/11/2014
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
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(root==null) return rnt;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        dfs(rnt, tmp, root, sum);
        return rnt;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, TreeNode node, int sum){
        
        //special case
        if(node==null) return;
        
        //staisfying result
        if(node.left==null && node.right==null && sum-node.val==0){
            tmp.add(node.val);
            rnt.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size()-1);
        }
        
        //dfs left and right
        tmp.add(node.val);
        if(node.left!=null){
            dfs(rnt, tmp, node.left, sum-node.val);
           
        }
        
        if(node.right!=null){
            dfs(rnt, tmp, node.right, sum-node.val);
           
        }
        
        tmp.remove(tmp.size()-1);
    }
    
   
}


////////////////////////////////////////////////////////////////////////
// 2015/11/11
// Highlight: recursive 
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rnt = new ArrayList<List<Integer>>();
        
        if(root==null) return rnt;
        
        //special case
        if(root.left==null && root.right==null && sum - root.val==0){
            ArrayList<Integer> curr = new ArrayList<Integer>();
            curr.add(root.val);
            rnt.add(curr);
            return rnt;
        }
        
        //recursive add the list that sum up to "sum"
        List<List<Integer>> left = pathSum(root.left, sum-root.val);
        List<List<Integer>> right = pathSum(root.right, sum - root.val);
        
        for(List<Integer> list: left){
            list.add(0,root.val);
            rnt.add(list);
        }
        
        for(List<Integer> list: right){
            list.add(0, root.val);
            rnt.add(list);
        }
        
        return rnt;
    }
    
}
