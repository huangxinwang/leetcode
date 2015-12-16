// serialize and deserialize binary tree


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helpSeria(root, sb);
        String rnt = sb.toString();
        return rnt.substring(0, rnt.length()-1);
    }
    
    public void helpSeria(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("null"+",");
        }else{
            sb.append(root.val+",");
            helpSeria(root.left, sb);
            helpSeria(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
       if (s == null || s.length() == 0) return null;
       StringTokenizer st = new StringTokenizer(s, ",");
       return deserialize(st);
    }
    
    private TreeNode deserialize(StringTokenizer st){
    if (!st.hasMoreTokens())
        return null;
    String val = st.nextToken();
    if (val.equals("null"))
        return null;
    TreeNode root = new TreeNode(Integer.parseInt(val));
    root.left = deserialize(st);
    root.right = deserialize(st);
    return root;
}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
