/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int maxPathSum(TreeNode root) {
        // write your code here
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        
        if(root==null) return 0;
        dfs(root, max);
        return max[0];
        
    }
    
    
    //DFS
    //Return max value of the single path(either left+root, right+root, or just root) rooted at root
    public int dfs(TreeNode root, int[] max){
        int rnt = root.val;
        int left = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if(root.left!=null){
            left = dfs(root.left, max);
        }
        if(root.right!=null){
            right = dfs(root.right, max);
        }
        int sum = rnt + Math.max(0, left) + Math.max(0, right);
        max[0] = max[0] < sum ? sum: max[0];
        if(left>0 && right>0) rnt+=Math.max(left,right);
        else if(left>0) rnt+=left;
        else if(right>0) rnt+=right;
        //max = max<rnt ? rnt : max;
        return rnt;
    }
}
