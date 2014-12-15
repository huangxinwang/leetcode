/**
 * Problem Statement
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    public int maxDepth(TreeNode root) {
        
        //special case
        if(root==null) return 0;
        
        //calculate maximum height of leftchild and rightchild
        int leftHeight = 1;
        int rightHeight = 1;
        if(root.left!=null)
        leftHeight = calHeight(root.left,1);
        if(root.right!=null)
        rightHeight = calHeight(root.right,1);
        
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
    
    public int calHeight(TreeNode node, int currHeight){
        
        //special case
        if(node==null) return currHeight;
        
        //init value, note if both leftchild and rightchild are null, then return currHeight
        int leftHeight = currHeight+1;
        int rightHeight = currHeight+1;
        
        if(node.left!=null)
            leftHeight = calHeight(node.left, currHeight+1);
        if(node.right!=null)
            rightHeight = calHeight(node.right, currHeight+1);
        return leftHeight > rightHeight ? leftHeight : rightHeight;
    }
}


////////////////////////////////////////////////////////////////////////
//Round 2: 12/12/2014
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
    public int minDepth(TreeNode root) {
        //special case
        if(root==null) return 0;
        
        //use two layers to do BFS traverse
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        
        //init
        curr.add(root);
        int depth = 1;
        
        while(curr.size()>0){
            
            //construct next layer using curr layer
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                //min depth appears when a node has no childern
                 if(node.left==null && node.right==null) return depth;
                 
                 //constructing next layer
                if(node.left!=null)
                    next.add(node.left);
               
                if(node.right!=null)
                    next.add(node.right);
               
            }
            
            //update
            depth++;
            curr = new ArrayList<TreeNode>(next);
            next = new ArrayList<TreeNode>();
        }
        
        return depth;
    }
    
    
}


///////////////////////////////////////////////////////////////////
//Round 3: 12/15/2014
//DFS

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
    public int maxDepth(TreeNode root) {
        
        //terminate case
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        
        //recursive find depth of left and right subtree
        int depth =1; 
        int leftDep = 0;
        int rightDep = 0;
       
        if(root.left!=null)
            leftDep = depth + maxDepth(root.left);
        if(root.right!=null)
            rightDep = depth + maxDepth(root.right);
        return leftDep > rightDep ? leftDep : rightDep;
        
    }
}
