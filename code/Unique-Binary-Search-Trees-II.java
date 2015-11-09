/**
 * Problem: Unique Binary Search Trees II 
 * Link:https://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * Time:480ms
 * 
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *  1         3     3      2      1
 *   \       /     /      / \      \
 *   3     2     1      1   3      2
 *  /     /       \                 \
 * 2     1         2                 3
 */


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return dfs(1,n);
    }
    
    //dfs find solutions
    public ArrayList<TreeNode> dfs(int left, int right){
        
        ArrayList<TreeNode> rnt = new ArrayList<TreeNode>();
        //terminate condition
        if(left>right){
            rnt.add(null);
            return rnt;
        }
        
        //build left, right tree
        for(int i=left; i<=right; i++){
            ArrayList<TreeNode> lefts = dfs(left,i-1);
            ArrayList<TreeNode> rights = dfs(i+1,right);
            for(TreeNode l: lefts){
                for(TreeNode r: rights){
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = l;
                    tmp.right = r;
                    rnt.add(tmp);
                }
            }
        }
        return rnt;
    }
}

////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/17/2014
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        return dfs(1,n);
    }
    
    public ArrayList<TreeNode> dfs(int low, int high){
        
        ArrayList<TreeNode> rnt = new ArrayList<TreeNode>();
        
        //terminate condition
        if(low > high){
            rnt.add(null);
            return rnt;
        }
        
        //enumerate each possible combination of left and right tree
        //construct each tree under different combinations
        for(int i=low; i<=high; i++){
            ArrayList<TreeNode> left = dfs(low, i-1);
            ArrayList<TreeNode> right = dfs(i+1, high);
            for(TreeNode l: left){
                for(TreeNode r: right){
                    TreeNode tmp = new TreeNode(i);
                    tmp.left = l;
                    tmp.right = r;
                    rnt.add(tmp);
                }
            }
        }
        
        return rnt;
    }
}


///////////////////////////////////////////////////////
// 2015/11/09
// Highlight: dfs, maintain results in rnt
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
    public List<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> rnt = dfs(1,n);
        return rnt;
    }
    
    public ArrayList<TreeNode> dfs(int left, int right){
        
        //maintain result in rnt
        ArrayList<TreeNode> rnt = new ArrayList<TreeNode>();
        
        if(left>right){
            rnt.add(null);
            return rnt;
        }
        
        for(int i=0; i<=right-left; i++){
            ArrayList<TreeNode> lefts = dfs(left, i+left-1);
            ArrayList<TreeNode> rights = dfs(i+left+1, right);
            for(TreeNode l: lefts){
                for(TreeNode r: rights){
                    TreeNode node = new TreeNode(i+left);
                    node.left = l;
                    node.right = r;
                    rnt.add(node);
                }
            }
        }
        
        return rnt;
    }
}
