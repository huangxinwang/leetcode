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


///////////////////////////////////
// 2015/11/30
// Highlight: deal with carry
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyhead = new ListNode(-1);
        ListNode curr = dummyhead;
        int carry = 0;
        
        //traverse each number
        while(l1!=null || l2!=null){
            int val1 = l1==null? 0: l1.val;
            int val2 = l2==null? 0: l2.val;
            int sum = val1 + val2 + carry;
            curr.next = new ListNode(sum%10);
            carry = sum/10;
            curr = curr.next;
            l1 = l1==null? l1: l1.next;
            l2 = l2==null? l2: l2.next;
        }
        
        //deal with carry 
        if(carry!=0){
            curr.next = new ListNode(carry);
            curr = curr.next;
        }
        curr.next = null;
        
        return dummyhead.next;
    }
}
