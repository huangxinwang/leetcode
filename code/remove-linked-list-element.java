/**
* Problem Statement: Remove Linked List Elements
*
* Remove all elements from a linked list of integers that have value val.
*
* Example
* Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
* Return: 1 --> 2 --> 3 --> 4 --> 5
*/


///////////////////////////////////////
// 2015/11/19
// Highlight: keep a dummy pointer
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode curr = dummyhead;
        
        //remove node that equals to val, by putting curr.next = curr.next.next
        while(curr.next!=null){
            if(curr.next.val==val){
                curr.next = curr.next.next;
            }else
                curr = curr.next;
        }
        return dummyhead.next;
    }
}
