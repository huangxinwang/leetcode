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
     * @paramn n: An integer
     * @return: A list of root
     */
    public ArrayList<TreeNode> generateTrees(int n) {
        // write your code here
        return help(1,n);
    }
    
    //recursively build tree
    public ArrayList<TreeNode> help(int l, int r){
        ArrayList<TreeNode> rnt = new ArrayList<TreeNode>();
        if(l==r){
            rnt.add(new TreeNode(l));
            return rnt;
        } 
        if(l>r){ 
            rnt.add((TreeNode)null);
            return rnt;
        }
        
        for(int i=l; i<=r; i++){
            
            ArrayList<TreeNode> leftlist = help(l,i-1);
            ArrayList<TreeNode> rightlist = help(i+1, r);
            for(TreeNode nodeleft: leftlist){
                for(TreeNode noderight: rightlist){
                    TreeNode node = new TreeNode(i);
                    node.left = nodeleft;
                    node.right = noderight;
                    rnt.add(node);
                }
            }
            
        }
        
        return rnt;
        
    }
}
