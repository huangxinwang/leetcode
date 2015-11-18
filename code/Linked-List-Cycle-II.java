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


////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

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
 
 
 
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        //meeting at k after start point
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        
        if(fast==null || fast.next== null) return null;
        
        //meeting at start point
        ListNode tmp = head;
        while(tmp!=slow){
            tmp = tmp.next;
            slow = slow.next;
        }
        
        return tmp;
    }
}


//////////////////////////////////////////////////////
// 2015/11/18
// Highlight: slow and fast pointer
// Note: draw the figure out, it should be clar
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
        if(head==null || head.next==null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        
        if(slow!=fast) return null;
        
        slow = head;
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
