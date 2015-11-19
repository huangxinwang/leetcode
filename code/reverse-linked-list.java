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
        ListNode curr = head;
        ListNode next = curr.next;
        
        //use a current pointer, and next pointer
        //reverse at each step
        while(next!=null){
            ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
        }
        
        head.next = null;
        return curr;
    }
}
