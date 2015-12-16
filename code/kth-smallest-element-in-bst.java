// kth smallest element in bst

/////////////////////////////////////////////////
// 2015/12/16
// Highlight: stack, tree in-order traverse
// Time: O(h)
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
    
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        return help(stack, k,0);
    }
    
    public int help( Stack<TreeNode> stack, int k, int count){
        //keep pushing left branch
        TreeNode node = stack.peek();
        while(node.left!=null){
            stack.push(node.left);
            node = node.left;
        }
        
        //keep pop out, if the right child of pop-out node is not null, keep pushing the left children in the right branch
        while(!stack.isEmpty()){
            TreeNode pop = stack.pop();
            count++;
            if(count==k) return pop.val;
            if(pop.right!=null){
                stack.push(pop.right);
                return help(stack, k, count);
            }
        }
        
        return -1;
    }
}


///////////////////////////////
// What if need to find the kth smallest frequency
// We can maintain the left-child count of each node
// Case 1: left-count+1 < k, k-= (leftcount+1), node = node.right
// Case 2: leftcount + 1 ==k , return node
// Case 3: leftcount + 1 > k, node = node.left
