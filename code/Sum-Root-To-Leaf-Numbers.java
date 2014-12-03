/**
 * Problem Statement
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
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
    public int sumNumbers(TreeNode root) {
        
        if(root==null) return 0;
        int rootVal = 0;
        int leftSum = 0;
        int rightSum = 0;
        
        if(root.left==null && root.right==null) return root.val;
        
        //sum up value of left branch and right branch
        if(root.left!=null)
            leftSum =  subSumNumbers(root.left,root.val);
        if(root.right!=null)
            rightSum = subSumNumbers(root.right,root.val);
        
        
        return leftSum + rightSum;
       
    }
    
    public int subSumNumbers(TreeNode node, int currVal){
        
        if(node==null) return currVal;
        if(node.left==null && node.right==null) return currVal*10 + node.val;
        
        int leftSum = 0;
        int rightSum = 0;
        
        //sum up value of left branch and right branch recursively
        //principle: currentval * 10 + leaf's value
        if(node.left!=null)
        {
            leftSum = subSumNumbers(node.left,currVal*10+node.val);
        }
        if(node.right!=null)
        {
            rightSum = subSumNumbers(node.right,currVal*10+node.val);
        }
        
        return leftSum + rightSum;
    }
    
   
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/03/2014
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
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        dfs(root, String.valueOf(root.val), rnt);
        
        int sum = 0;
        for(int i=0; i<rnt.size(); i++)
            sum += rnt.get(i);
        return sum;
    }
    
    public void dfs(TreeNode root, String curr, ArrayList<Integer> rnt){
        if(root.left==null && root.right==null)
            rnt.add(Integer.parseInt(curr));
        if(root.left!=null)
            dfs(root.left, curr+root.left.val, rnt);
        if(root.right!=null)
            dfs(root.right, curr+root.right.val, rnt);
    }
}
