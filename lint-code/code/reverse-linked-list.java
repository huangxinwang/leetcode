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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head==null || head.next==null) return head;
        
        ListNode first = head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        
        while(p2!=null){
            
            ListNode p3 = (p2.next==null) ? null : p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            
        }
        
        first.next = null;
        
        return p1;
    }
}

