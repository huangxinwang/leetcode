/**
 * Problem Statement: Partition List 
 * 
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        
        ListNode p = head;
        if(head==null) return head;
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);;
        ListNode head1 = l1;
        ListNode head2 = l2;
        
        while(p!=null){
            if(p.val<x){
                    //note "l1.next = p" is wrong, you should create ListNode by yourself
                    l1.next = new ListNode(p.val);
                    l1 = l1.next;
                
            }
            else{
                    l2.next = new ListNode(p.val);
                    l2 = l2.next;
            }
            p = p.next;
        }
        
        if(head1.next==null) return head2.next;
        l1.next = head2.next;
        return head1.next;
    }
}

//////////////////////////////////////////////////////////////
//Round 2: 12/19/2014
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
    public ListNode partition(ListNode head, int x) {
        
        //keep for large number
        ListNode large = new ListNode(-1);
        ListNode largetail = large;
        
        //keep for small number
        ListNode dummyHead = new ListNode(-1);
        ListNode smalltail = dummyHead;
        
        //traverse the list, and assign number to large/small list
        while(head!=null){
            ListNode tmp = head;
            if(head.val < x){
                smalltail.next = head;
                smalltail = smalltail.next;
            }else{
                largetail.next = head;
                largetail = largetail.next;
            }
            tmp = head.next;
            head.next = null;
            head = tmp;
        }
        
        //cancate two list together
        smalltail.next = large.next;
        return dummyHead.next;
        
    }
}


/////////////////////////////////////////////////
// 2015/11/08
// Highlight: use two lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-2);
        ListNode curr1 = head1;
        ListNode curr2 = head2;
        
        ListNode curr = head;
        while(curr!=null){
            if(curr.val<x){
                curr1.next = curr;
                curr1 = curr1.next;
            }else{
                curr2.next = curr;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        
        curr1.next = head2.next;
        curr2.next = null;
        
        return head1.next;
    }
}
