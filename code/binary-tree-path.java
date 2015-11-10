/**
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 *
 */


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
   public List<String> binaryTreePaths(TreeNode root) {
       List<String> rnt = new ArrayList<String>();
       
       if(root==null) return rnt;
       List<String> lefts = binaryTreePaths(root.left);
       List<String> rights = binaryTreePaths(root.right);
       for(String l : lefts){
           rnt.add(root.val+"->"+l);
       }
       for(String r: rights){
           rnt.add(root.val+"->"+r);
       }
       
       if(rnt.size()==0) rnt.add(root.val+"");
       return rnt;
   }
}
