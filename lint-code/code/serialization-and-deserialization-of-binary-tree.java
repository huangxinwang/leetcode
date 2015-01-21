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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
     
     
    //Idea: inorder traverse the tree
    //plug in # in return if current node is null
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null) return "# ";
        String rnt = new String();
        rnt += (root.val + " ");
        rnt += serialize(root.left);
        rnt += serialize(root.right);
        return rnt;
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        String[] str = data.split(" ");
        int[] index = new int[1];
        return helpDeserial(str, index);
        
    }
    
    //Idea: recursive build the tree using the inorder traverse array
    public TreeNode helpDeserial(String[] str, int[] index){
        String curr = str[index[0]];
        if(curr.equals("#")){
            index[0]++;
            return null;
        }
        else{
            TreeNode node = new TreeNode(Integer.parseInt(str[index[0]]));
            index[0]++;
            node.left = helpDeserial(str, index);
            node.right = helpDeserial(str, index);
            
            return node;
        }
    }
}

