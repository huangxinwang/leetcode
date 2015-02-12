### Problem
- Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
- For example, this binary tree is symmetric:
```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

### Code
```java
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return subIsSym(root.left, root.right);
    }
    
    public boolean subIsSym(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null && right!=null) return false;
        if(left!=null && right==null) return false;
        if(left.val != right.val) return false;
        //very beautiful recursive
        if(!subIsSym(left.right, right.left)) return false;
        if(!subIsSym(left.left, right.right)) return false;
        return true;
    }
    
}
```
