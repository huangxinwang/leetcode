### Problem


### Analysis
- use (min, max) to keep the valid interval of subtree
- update min and max during the recursive process

### Time complexity
- O(n)

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
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        return subCheck(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public boolean subCheck(TreeNode root, int min, int max){
        //special case
        if(root==null) return true;
        if(root.val == Integer.MIN_VALUE && root.left!=null) return false;
        if(root.val == Integer.MAX_VALUE && root.right!=null) return false;
        
        //determine if left and right subtree is valid
        if(root.val< min || root.val > max) return false;
        boolean left = subCheck(root.left, min, root.val-1);
        if(!left) return false;
        boolean right = subCheck(root.right, root.val+1, max);
        if(!right) return false;
        return true;
    }
}
```
