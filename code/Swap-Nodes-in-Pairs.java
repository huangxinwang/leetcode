/**
 * Problem Statement
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
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
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null) return head;
        ListNode rnt = new ListNode(0);
        rnt.next = head;
        
        //use zero, first, second, third to track nearest 4 ListNode
        ListNode zero = rnt;
        ListNode first = head;
        ListNode second = head.next;
        ListNode third = head.next.next;
        
        //loop
        while(first!=null && second!=null){
            
            //swap node pair
            zero.next = second;
            second.next = first;
            first.next = third;
            
            //update next node pair
            //Node if "third" is null or "third.next" is null, then stop swap and exit while loop
            if(third!=null && third.next!=null){
                zero = first;
                first = third;
                second = third.next;
                third = third.next.next;
            }else{
                first = null;
                third = null;
            }
            
        }
        
        return rnt.next;
        
    }
}

////////////////////////////////////////////////////////////////////////////////
//Round 2: 1/1/2015
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
    public ListNode swapPairs(ListNode head) {
        
        if(head==null || head.next==null) return head;
        
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        
        //swap two nodes
        ListNode curr = dummyhead;
        ListNode tmp1= curr.next;
        ListNode tmp2 = tmp1.next;
        while(tmp2!=null){
            curr.next = tmp2;
            tmp1.next = tmp2.next;
            tmp2.next = tmp1;
            curr = tmp1;
            tmp1 = curr.next;
            if(tmp1!=null)
                tmp2 = tmp1.next;
            else tmp2 = null;
        }
        
        return dummyhead.next;
        
    }
}
