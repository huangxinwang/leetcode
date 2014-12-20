/**
 * Problem Statement: Remove Duplicates from Sorted List II 
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 */
 
 
  /**
  * Reference: http://blog.csdn.net/disappearedgod/article/details/24017313
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
    public ListNode deleteDuplicates(ListNode head) {
        
        if(head==null) return head;
        
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        //use pointer p to delete repeat value
        ListNode p = head;
        int del = 0;
        
        while(p!=null && p.next!=null){
            if(p.val==p.next.val){
                del = p.val;
                //delete repete listNode
                while(p.val==del){
                    p = p.next;
                     if(p==null) 
                        return dummyHead.next;
                }
               
            }
            else{
                pre.next = p;
                pre = pre.next;
                p = p.next;
                //need to set next as null, otherwise, its next will be nodes in original list
                pre.next = null;
            }
                
        }
        
        pre.next = p;
        return dummyHead.next;   
        
    }
}


////////////////////////////////////////////////////////////
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
    public ListNode deleteDuplicates(ListNode head) {
        
        //special case
        if(head==null) return head;
        
        //create a dummyHead, in case the first element needs to be deleted
        ListNode dummyHead = new ListNode(head.val-1);
        
        //pointer to get new valid elements
        ListNode pre = dummyHead;
        
        //pointer to traverse the list
        ListNode curr = head;
        
        
        while(curr!=null && curr.next!=null){
            
            //skip duplicate elements
            if(curr.val==curr.next.val){
                int del = curr.val;
                while(curr.val==del){
                    curr = curr.next;
                    if(curr==null) return dummyHead.next;
                }
            }
            //accept valid elements
            else{
                pre.next = curr;
                curr = curr.next;
                pre = pre.next;
                pre.next = null;
            }
        }
        
        //need to accept the valid elements when there is only one element
        pre.next = curr;
        return dummyHead.next;
    }
}
