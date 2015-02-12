### Problem

### Analysis
- recursive solve

### Code
``` java
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null) return q==null;
        if(q==null) return p==null;
        if(p.val != q.val) return false;
        
        if(!isSameTree(p.left, q.left)) return false;
        return isSameTree(p.right, q.right);
    }
}
```
