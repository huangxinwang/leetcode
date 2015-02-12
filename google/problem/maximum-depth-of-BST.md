### Problem
Return maximum depth of a binary search tree

### Code
- Recursive
``` java
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
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l,r)+1;
    }
}
```

### Code-Interative
```java
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
     * @return: An integer.
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root==null) return 0;
        
       ArrayList<TreeNode> curr = new ArrayList<TreeNode>();
       curr.add(root);
       int height = 0;
       while(curr.size()!=0){
           ArrayList<TreeNode> next = new ArrayList<TreeNode>();
           for(int i=0; i<curr.size(); i++){
               TreeNode node = curr.get(i);
               if(node.left!=null) next.add(node.left);
               if(node.right!=null) next.add(node.right);
           }
           curr = new ArrayList<TreeNode>(next);
           height++;
       }
       
       return height;
    }
}
```
