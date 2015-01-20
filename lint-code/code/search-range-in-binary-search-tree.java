/**
 * Problem Statement: Search Range in Binary Search Tree
 * 
 * 
 */



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
     * @param root: The root of the binary search tree.
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        help(root, k1, k2, rnt);
        
        return rnt;
    }
    
    public void help(TreeNode root, int k1, int k2, ArrayList<Integer> rnt){
        if(root==null) return;
        //less than min
        if(root.val < k1){
            if(root.right!=null){
                help(root.right, k1, k2, rnt);
            }
        }
        //larger than max
        else if(root.val >k2){
            if(root.left !=null){
                help(root.left, k1, k2, rnt);
            }
        }
        else if (root.val >=k1 && root.val <=k2){
            //in order
            help(root.left, k1, k2, rnt);
            rnt.add(root.val);
            help(root.right, k1, k2, rnt);
        }
        
    }
}
