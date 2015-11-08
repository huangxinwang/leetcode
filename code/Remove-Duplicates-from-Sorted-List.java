/**
 * Problem Statement: Remove Duplicates from Sorted List 
 * 
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        //special case
        if(head==null || head.next==null) return head;
        
        //remove duplicates
        ListNode p = head;
        while(p!=null && p.next!=null){
            //has duplicates
            if(p.val==p.next.val)
                p.next = p.next.next;
            //has no duplicates
            else
                p = p.next;
        }
        
        return head;
    }
}

/////////////////////////////////////////////////////////////////////
//Round 2: 12/19/2014
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode curr = head;
        while(curr!=null){
            if(curr.next==null) return head;
            //if next value = current value, skip next
            if(curr.val==curr.next.val)
                curr.next = curr.next.next;
            else
            //otherwise, move curr to next
            {
                curr = curr.next;
            }
        }
        
        return head;
    }
}


///////////////////////////////////////////////////////////
// 2015/11/08
// Highlight: corner case
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode last = dummyhead;
        ListNode curr = head;
        int val = curr.val;
        
        //if next element is different from current element, then add it
        while(curr.next!=null){
            if(curr.next.val==val) {
                curr = curr.next;
                continue;
            }
            else{
                last.next = curr;
                last = curr;
                curr = curr.next;
                val = curr.val;
            }
        }
        
        //deal with last element
        last.next = curr;
        last.next.next = null;

        return dummyhead.next;
    }
}
