/**
* Problem Statement: Palindrome Linked List
* Given a singly linked list, determine if it is a palindrome.
*
*/


/////////////////////////////////////////////////
// 2015/11/15
// Highlight: find mid, and reverse second half
// Time complexity: O(n), Space complexity: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        
        //find mid
        ListNode mid = findMid(head);
        ListNode second = mid.next;
        mid.next = null;
        
        //reverse second part
        second = reverse(second);
        ListNode first = head;
        
        while(first!=null && second!=null){
            if(first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }
       
        return true;
    }
    
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
       
        return slow;
    }
    
    public ListNode reverse(ListNode head){
        ListNode pre = head;
        ListNode curr = pre.next;
        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        head.next = null;
        return pre;
    }
}
