/**
* Problem Statement: Reverse Linked List
* 
* Reverse a singly linked list.
*
*/


/////////////////////////////////////////////
// 2015/11/18
// Highlight: use two pointers, reverse at each step

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        //use two nodes to keep track of two nodes
        ListNode prev = head;
        ListNode curr = head.next;
        
        while(curr!=null){
            //keep track of next node of curr, since we are going to change its next to prev
            ListNode tmp = curr.next;
            
            //reverse 
            curr.next = prev;
            
            //shift right by one position
            prev = curr;
            curr = tmp;
        }
        
        //set tail
        head.next = null;
        return prev;
    }
}
