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