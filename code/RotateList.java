/**
 * Problem Statement: Rotate List 
 * Link:https://oj.leetcode.com/problems/rotate-list/
 * 
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
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
    public ListNode rotateRight(ListNode head, int n) {
        //special case
        if(head==null || n==0) return head;
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode head2 = dummyHead;
        
        //process n
        int count =0;
        ListNode p = head;
        while(p!=null){
            count++;
            p = p.next;
        }
        //trick
        n = count - n%count;

        //find start of second part
        for(int i=0; i<n; i++){
            head2 = head2.next;
        }
        
        //set start of second part
        //set the end of first part as null
        ListNode rnt = head2.next;
        head2.next = null;
        if(rnt==null) return dummyHead.next;
        
        //concat end of second part to the start of first part
        ListNode curr = rnt;
        while(curr.next!=null)
            curr = curr.next;
        curr.next = dummyHead.next;
        return rnt;
        
    }
}

///////////////////////////////////////////////////////////////////////
//Round 2: 12/24/2014
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
    public ListNode rotateRight(ListNode head, int n) {
        
        //special case
        if(head==null) return head;
        
        //create dymmyhead
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        
        //count length of list
        ListNode curr = dummyhead;
        int len=0;
        while(curr.next!=null){
            curr = curr.next;
            len++;
        }
        
        //find slit point
        int start = 0;
        curr = dummyhead;
        n = n%len;
        while(start<len-n){
            curr = curr.next;
            start++;
        }
        
        //split list, the second list (nexthead) act as head right now
        ListNode nexthead = curr.next;
        if(nexthead==null) return dummyhead.next;
        curr.next = null;
        ListNode tail = nexthead;
        while(tail.next!=null)
            tail = tail.next;
        tail.next = dummyhead.next;
        
        return nexthead;
    }
}


////////////////////////////////////////////////////////////////
// 2015/11/05
// Highlight: split and rotate
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode first = dummyhead.next;
        int len = 0;
        
        while(first!=null){
            len++;
            first = first.next;
        }
        if(len==0) return head;
        
        k = k%len;
        //to the right, so it is len - k
        k = len - k;
        if(k==0) return head;
        
        //split first part and second part
        first = dummyhead.next;
        while(k>0){
            first = first.next;
            k--;
        }
        if(first==null) return head;
        
        //connect two parts
        ListNode second = dummyhead.next;
        ListNode rnt = first;
 
        while(first.next!=null){
            first = first.next;
        }
        first.next = second;
        while(second.next!=rnt){
            second = second.next;
        }
        second.next = null;
        
        return rnt;
    }
}
