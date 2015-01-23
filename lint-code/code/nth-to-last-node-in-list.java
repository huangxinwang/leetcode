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
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(head==null || head.next==null) return head;
        
        ListNode fast = head;
        ListNode slow = head;
        
        //fast node walks n-1 step ahead of slow node
        int i=0;
        while(i<(n-1)){
            fast = fast.next;
            i++;
        }
        
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
       
        return slow;
    }
    
    
}

