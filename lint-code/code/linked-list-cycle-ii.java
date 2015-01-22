/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. 
     *           if there is no cycle, return null
     */
    public ListNode detectCycle(ListNode head) {  
        // write your code here
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }
        
        if(fast==null || fast.next==null) return null;
        
        slow = head;
        while(fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
}


//Analysis
//[front...startOfCycle] x; [start--fastMeetSlow] y; cycle length = n
//Fast and slow meet: 2(x+y) = x+kn+y
//Thus: x+y = kn
//Let slow start from head, and fast get one step each time
//When fast and slow meet: x = kn-y which means slow walked for x distance
//

