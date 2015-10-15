/**
 * Problem Statement: Remove Nth Node From End of List 
 * Link: https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * Time: 408ms
 * 
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        //special case
        if(head==null) return head;
        
        //dummy head
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        //two pointer to indicate the node to delete
        ListNode p1 = dummyHead;
        ListNode p2 = dummyHead;
        int start = 0;
        
        //p1 walks n step
        while(start<n && p1.next!=null){
            start ++;
            p1 = p1.next;
        }
        
        //p1 and p2 walks together until p1 reach the end of the list  
        while(p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        //delete node
        ListNode tmp = p2.next;
        if(p2.next!=null)
            p2.next = p2.next.next;
            
        return dummyHead.next;
    }
}


//////////////////////////////////////////////////////////
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
       
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode p1 = dummyhead;
        ListNode p2 = dummyhead;
        
        //let p1 walks n-step ahead of p2
        int i=0;
        while(i<n && p1.next!=null){
            p1 = p1.next;
            i++;
        }
        
        //p1 and p2 walk together
        while(p1.next!=null){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        //delete nodes
        if(p2.next!=null)
            p2.next = p2.next.next;
        
        return dummyhead.next;
    }
}


/////////////////////////////////////////////////////////
// 2015-10-15
// Highlight: use two pointers; use dummyhead
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // use dummyhead to avoid case 1->null and 1 need to be removed
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode p1 = dummyhead;
        ListNode p2 = dummyhead;
        
        //use two pointers to decide when it is n from end
        for(int i=0 ;i<n; i++){
            p1 = p1.next;
        }
        
        while(p1.next!=null){
            p1 = p1.next; 
            p2 = p2.next;
        }
        
        //remove the target node
        if(p2.next!=null)
            p2.next = p2.next.next;
        else p2.next = null;
        
        return dummyhead.next;
    }
}
