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

////////////////////////////////////////////////////////////
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        //dummyhead, keep the head of the list
        ListNode dummyhead = new ListNode(-1);
        //curr denote current traver pointer
        ListNode curr = dummyhead;
        
        while(l1!=null && l2!=null){
            //if l1 is smaller than l2, than advance pointer of l1
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                //else advance pointer of lb
                curr.next = l2;
                l2 = l2.next;
            }
            
            curr = curr.next;
            curr.next = null;
        }
        
        //add the untraversed parts
        if(l1!=null)
            curr.next = l1;
        if(l2!=null)
            curr.next = l2;
        return dummyhead.next;
    }
}

//round 3
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<=l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}


////////////////////////////////////////////////////////////////////////
// 2015/10/25
// Highlight: use a dummyhead and a curr pointer, traverse two lists when neither is null
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        while(l1!=null && l2!=null){
            if(l1.val <=l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if(l1!=null) curr.next = l1;
        if(l2!=null) curr.next = l2;
        return dummyHead.next;
    }
}
