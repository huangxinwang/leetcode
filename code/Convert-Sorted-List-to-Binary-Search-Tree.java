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

///////////////////////////////////////////////
// 2015/11/30
// Highlight: global pointer
//            recursive build the tree

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    ListNode h;
    public TreeNode sortedListToBST(ListNode head) {
        //maitain a global pointer to pint to current front element in the list
        h = head;
        int count = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            count++;
        }
        
        return help(head, 0, count-1);
    }
    
    public TreeNode help(ListNode head, int min, int max){
        if(min>max) return null;
     
        int mid = (min+max)/2;
        //get eft tree
        TreeNode left = help(head, min, mid-1);
        
        //get root
        TreeNode node = new TreeNode(h.val);
        h = h.next;
        
        //get right
        TreeNode right = help(head, mid+1, max);
        node.left = left;
        node.right = right;
        return node;
    }
}

//////////////////////////////////////////////////
// 2015/11/30
// Highlight: find mid value
// Time complexity: O(n^2), not good solution since need to repeatedly find mid
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        if(head.next==null){
            TreeNode node = new TreeNode(head.val);
            return node;
        }
        
        //find mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        //break list into two parts
        //mid node acts as root
        ListNode second = slow.next;
        slow.next = null;
        TreeNode node = new TreeNode(slow.val);
        ListNode curr = head;
        while(curr.next!=slow){
            curr = curr.next;
        }
        curr.next = null;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(second);
        return node;
    }
}
