/**
* Problem Statement: Binary Tree Right Side View
*Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
*
*For example:
*Given the following binary tree,
*   1            <---
* /   \
*2     3         <---
* \     \
*  5     4       <---
* You should return [1, 3, 4].
*/


//////////////////////////////////////
// 2015/11/19
// Highlight: binary tree bfs traverse
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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rnt = new ArrayList<Integer>();
        
        if(root==null) return rnt;
        
        //binary tree bfs traverse
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        curr.add(root);
        while(curr.size()!=0){
            next = new ArrayList<TreeNode>();
            rnt.add(curr.get(curr.size()-1).val);
            for(int i=0 ;i<curr.size(); i++){
                TreeNode node = curr.get(i);
                if(node.left!=null) next.add(node.left);
                if(node.right!=null) next.add(node.right);
            }
            curr = new ArrayList<TreeNode>(next);
        }
        
        return rnt;
    }
}
