/**
 * Problem Statement: Linked List Cycle II 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 */

///////////////////////////////////////////////
// 2015/12/20
// Highlight: slow and fast pointer; logic; calculation

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
 * 
 * Analysis: denote the node where the cycle begins as b, then denote dist(head-b)= x; dist(fast&&slow meet - b) = k, 
 * denote y as the cycle lenth
 * 
 * Fast: x + my + k; slow: (x+ny+k)*2 ==> x = wy -k where w is an integer
 * 
 * Tmp: x; slow = cy-k ==> when tmp and slow meets, we have x = cy -k, c=w
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
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //First, find whether exist cycle or not
        if(head==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean exist = false;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                exist = true;
                break;
            }
        }
        
        if(!exist) return null;
        
        //slow start from head
        //fast start from its last place
        //both advance one by each step
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
        
    }
}
