/**
 * Problem Statement: Intersection of Two Linked Lists
 * Link: https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * Hardness: **
 * 
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
       //special case
       if(headA==null || headB==null) return null;
       
       //find length difference of A and B
       ListNode a = headA;
       int sizea = 0;
       while(a!=null){
           sizea++;
           a = a.next;
       }
       
       ListNode b = headB;
       int sizeb = 0;
       while(b!=null){
           sizeb++;
           b = b.next;
       }
       
       //let the longer list advanced for |sizaA - sizeB| step first
       ListNode aa = headA;
       ListNode bb = headB;
       int diff = sizea - sizeb;
       if(diff > 0){
           for(int i=0; i<diff; i++){
               aa = aa.next;
           }
       }else{
           for(int i=0; i<-diff; i++){
               bb = bb.next;
           }
       }
       
       //then both lists advanced for one step at each time, judge whether intersection happen in each step
       while(aa!=null){
          if(aa==bb) return aa;
          else{
              aa = aa.next;
              bb = bb.next;
          } 
       }
       
       return null;
       
    }
}
