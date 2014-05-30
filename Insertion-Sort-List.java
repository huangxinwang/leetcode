/**
 * Problem Statement
 * Sort a linked list using insertion sort.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null || head.next==null) return head;
        
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        
        ListNode curr = head;
        
        
        while(curr.next!=null && curr!=null)
        {
            while(curr.next!=null  && curr.next.val < curr.val)
            {
                ListNode tmp = head;
                ListNode preTmp = preHead;
                while(tmp.val < curr.next.val)
                {
                    preTmp = tmp;
                    tmp = tmp.next;
                }
                
                preTmp.next = curr.next;
                curr.next = curr.next.next;
                preTmp.next.next = tmp;
            }
            
            curr = curr.next;
        }
        
        return preHead.next;

    }
}