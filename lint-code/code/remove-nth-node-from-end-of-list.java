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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        
        //need to have a dummy head
        //otherwise, for 1->2->null, 2; the slow pointer would be in the wrong position
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode fast = dummyhead;
        ListNode slow = dummyhead;
        
        int i=0;
        while(i<n){
            fast = fast.next;
            i++;
        }
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        
        
        //delete the nth node
        slow.next = slow.next.next;
        
        
        return dummyhead.next;
    }
}
