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

//////////////////////////////////////////////
//Round 2: 1/8/2015

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
        
        int carry = 0;
        ListNode dummyhead = new ListNode(0);
        ListNode curr = dummyhead;
        while(l1!=null || l2!=null){
            int a = l1==null?0:l1.val;
            int b = l2==null?0:l2.val;
            int sum = carry + a + b;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            l1 = l1==null? null:l1.next;
            l2 = l2==null?null:l2.next;
            carry = sum/10;
        }
        
        if(carry==1)
            curr.next = new ListNode(1);
        return dummyhead.next;
        
        
    }
}


///////////////////////////////////////////////////
// 2015-10-03 
// Highlight: deal with whether l1 or l2 are null
// Time complexity: O(n)

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
        int carry = 0;
        ListNode dummyhead = new ListNode(0);
        ListNode pre = dummyhead;
        while(l1!=null && l2!=null){
            int val = l1.val+l2.val+carry;
            carry = val/10;
            val = val%10;
            pre.next = new ListNode(val);
            l1 = l1.next;
            l2 = l2.next;
            pre = pre.next;
        }
        ListNode remain = l1==null?l2:l1;
        while(remain!=null){
            int val = remain.val + carry;
            carry = val/10;
            val = val%10;
            pre.next = new ListNode(val);
            pre = pre.next;
            remain = remain.next;
        }
        if(carry!=0){
            pre.next = new ListNode(carry);
            pre = pre.next;
        }
        return dummyhead.next;
    }
}
