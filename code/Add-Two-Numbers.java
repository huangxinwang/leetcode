/**
 * Problem Statement
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * 
 * e.g.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        //special case
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        //init
        ListNode rnt = null;
        ListNode curr = null;
        int carry = 0;
        
        //sum up
        while(l1!=null && l2!=null)
        {
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            int remain = sum%10;
            
            if(rnt==null) 
            {   
                rnt = new ListNode(remain);
                curr = rnt;
            }
            else 
            {   
                curr.next = new ListNode(remain);
                curr = curr.next;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        
        //deal with remaining part, when l1 and l2 have different length
        ListNode left = null;
        if(l1!=null) left = l1;
        if(l2!=null) left = l2;
        
        while(left!=null)
        {
            int sum = left.val + carry;
            carry = sum/10;
            int remain = sum%10;
            
            curr.next = new ListNode(remain);
            left = left.next;
            curr = curr.next;
        }
        
        //when traverse both l1 and l2 to end, deal with carry ==1
        if(left==null && carry==1)
        {
            curr.next = new ListNode(1);
        }
        
        return rnt;
    }
}