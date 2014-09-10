/**
 * Problem Statement: Convert Sorted List to Binary Search Tree 
 * Time: 468 ms
 * Link: https://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 * Ref: http://www.programcreek.com/2013/01/leetcode-convert-sorted-list-to-binary-search-tree-java/
 * Hardness: ***
 * 
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
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
    //use to construct root in the recursive process
    static ListNode h;
    
    public TreeNode sortedListToBST(ListNode head) {
        //special case
        if(head==null) return null;
        //initialize
        int len = getLength(head);
        h = head;
        return helperSortedListToBST(0, len-1);
        
    }
    
    //get length of ListNode
    public int getLength(ListNode head){
        int len = 0;
        ListNode p = head;
        while(p!=null){
            len++;
            p = p.next;
        }
        return len;
    }
    
    //recursive build BST
    public TreeNode helperSortedListToBST(int start, int end){
        //terminate case
        if(start>end)
            return null;
            
        int mid = (start+end)/2;
        
        //resursive build left
        TreeNode left = helperSortedListToBST(start, mid-1);
        //build root
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        //recursive build right
        TreeNode right = helperSortedListToBST(mid+1, end);
        
        root.left = left;
        root.right = right;
        return root;
    }
}