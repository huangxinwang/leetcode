/**
 * Problem Statement
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode root = null;
        ListNode curr = null;

        //end when one list is traversed to the end
        while(l1!=null && l2!=null){
            
            //next node is from l1
            if(l1.val <= l2.val){
                if(root!=null){
                    ListNode newNode = new ListNode(l1.val);
                    curr.next = newNode;
                    curr = curr.next;
                }else{
                   root = new ListNode(l1.val);
                   curr = root;
                }
                l1 = l1.next;
            }
            //next node is from l2
            else
            {
                if(root!=null){
                    ListNode newNode = new ListNode(l2.val);
                    curr.next = newNode;
                    curr = curr.next;
                }else{
                   root = new ListNode(l2.val);
                   curr = root;
                }
                l2 = l2.next;
            }
                
        }
        
        if(l1!=null) curr.next = l1;
        if(l2!=null) curr.next = l2;
        
        return root;
        }
        
}