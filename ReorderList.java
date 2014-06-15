/**
 * Problem Statement: Reorder List
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
 
 /**
  * Reference
  * http://www.2cto.com/kf/201312/265476.html
  * /



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        
        //find mid node
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //mid node
        ListNode mid = slow;
        ListNode preHead = slow;
        if(preHead==null) return;
        
        
        //reverse second half list
        ListNode first = mid.next;
        if(first==null) return;
        
        ListNode second = first.next;
        ListNode third = first.next;
        
        first.next = null;
        
        while(third!=null){
            third = third.next;
            second.next = first;
            first = second;
            second = third; 
        }
        
        //split first half and seoncd half
        mid.next = null;
        
        //merge first-half and second-half list
        while(first!=null && head!=null){
            ListNode tmp = head.next;
            head.next = first;
            first = first.next;
            head.next.next = tmp;
            head = tmp;
        }
        
        
        
    }
}