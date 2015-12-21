/**
 * Problem Statement
 * Given a linked list, determine if it has a cycle in it.
 * 
 */
 
 
 ///////////////////////////////////
 // 2015/12/20
 // Highlight: slow and fast pointers
 //            If there exists a cycle, then fast and slow pointer will meet
 
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
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }
}
