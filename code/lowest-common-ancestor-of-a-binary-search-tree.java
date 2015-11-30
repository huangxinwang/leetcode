/**
* Problem Statement: Lowest Common Ancestor of a Binary Search Tree
*
*/

/////////////////////////////////////////
// 2015/11/29
// Highlight: binary search
//            compare root value to find out whether least common ancestor is in the left tree or right tree
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        
        //both less than root, then common ancestor is in leftree
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        //both larger than root, than common ancestor is in right tree
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        
        //otherwise, root is the least common ancestor
        return root;
    }
}
