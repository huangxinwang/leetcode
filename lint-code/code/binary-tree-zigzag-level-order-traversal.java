/**
 * Problem Statement: Binary Tree Zigzag Level Order Traversal
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
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(root==null) return rnt;
        
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        boolean reverse = false;
        
        while(curr.size()!=0){
            ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
            ArrayList<Integer> currVal = new ArrayList<Integer>();
            
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                currVal.add(node.val);
                if(node.left!=null) nextLayer.add(node.left);
                if(node.right!=null) nextLayer.add(node.right);
            }
            
            //reverse the list val if rever is true
            if(reverse==true){ 
                Collections.reverse(currVal);
            }
            rnt.add(currVal);
            
            //change reverse
            if(reverse == true) 
                reverse = false;
            else reverse = true;
            
            //update curr layer
            curr = nextLayer;
        }
        
        return rnt;
    }
}


///////////////////////////////////////////////////////////////////////////////////
//Approach 2: Use level, if level is odd, then insert to array end; otherwise, insert to array head

/**
 * Problem Statement: Binary Tree Zigzag Level Order Traversal
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
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(root==null) return rnt;
        
        ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
        curr.add(root);
        int level = 0;
        
        while(curr.size()!=0){
            ArrayList<TreeNode> nextLayer = new ArrayList<TreeNode>();
            ArrayList<Integer> currVal = new ArrayList<Integer>();
            
            for(int i=0; i<curr.size(); i++){
                TreeNode node = curr.get(i);
                if(level%2==0)
                    currVal.add(node.val);
                else
                    currVal.add(0,node.val);
                if(node.left!=null) nextLayer.add(node.left);
                if(node.right!=null) nextLayer.add(node.right);
            }
            
            
            rnt.add(currVal);
            
            level++;
            
            //update curr layer
            curr = nextLayer;
        }
        
        return rnt;
    }
}
