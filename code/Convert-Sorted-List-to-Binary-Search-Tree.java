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

//////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/13/2014
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
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head==null) return null;
        if(head.next==null) return new TreeNode(head.val);
        
        //count total length
        int len = 1;
        ListNode countnode = head;
        while(countnode.next!=null){
            len++;
            countnode = countnode.next;
        }
        
        //find mid
        ListNode midnode = head;
        int mid = len/2;
        while(mid>0){
            midnode = midnode.next;
            mid--;
        }
        
        //split to firsthead and secondhead
        TreeNode rnt = new TreeNode(midnode.val);
        mid = len/2;
        ListNode firstHead = head;
        while(mid>1){
            firstHead = firstHead.next;
            mid--;
        }
        firstHead.next=null;
        
        //left subtree exist only when there are more than 2 elements in the list
        //recursive convert left and right subtree
        if(len>=2)
            rnt.left = sortedListToBST(head);
        ListNode secondHead = midnode.next;
        rnt.right = sortedListToBST(secondHead);
        
        
        return rnt;
    }
}
