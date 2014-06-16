/**
 * Problem Statement: Linked List Cycle II 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */


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
 
 
 /**
  * Reference
  * http://blog.csdn.net/lidalong0408/article/details/14104553
  */
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head==null) return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        //assume the starting node of the circle is k steps from the head
        //assume the length of the link list is n steps
        
        //when fast and slow pointer meets, we have
        //1.fast = 2*slow
        //2.fast - slow = (n - k) * a, where a is an integer(a>=1)
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        
        if(fast==null || fast.next==null) return null;
        
        slow = head;
        
        //now slow and fast all have k steps from the start of the circle
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        //now slow points to the start of the circle
        return slow;
    }
}