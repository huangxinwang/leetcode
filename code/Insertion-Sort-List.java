/**
 * Problem Statement
 * Sort a linked list using insertion sort.
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
    public ListNode insertionSortList(ListNode head) {
        
        if(head==null || head.next==null) return head;
        
        //create a preHead that points to head in case there are only two nodes
        //e.g. the list is {3,2}, using insertion sort, then a preHead is needed 
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        
        ListNode curr = head;
        
        
        while(curr!=null)
        {
            while(curr.next!=null  && curr.next.val < curr.val)
            {
                ListNode tmp = preHead.next;
                ListNode preTmp = preHead;
                
                //find the position to insert the new element (i.e., curr.next)
                while(tmp.val < curr.next.val)
                {
                    preTmp = tmp;
                    tmp = tmp.next;
                }
                
                //insert the new element after preTmp and before tmp pointer
                preTmp.next = curr.next;
                curr.next = curr.next.next;
                preTmp.next.next = tmp;
            }
            
            curr = curr.next;
        }
        
        return preHead.next;

    }
}


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014
//time complexity O(n^2); space complexity O(n)

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
    public ListNode insertionSortList(ListNode head) {
        
        //use dummyHead to simplify the implementation
        ListNode dummyHead = new ListNode(-1);
        //use curr to denote the current scanned position
        ListNode curr = head;
        
        
        while(curr!=null){

            //if curr is to be insert right after dummyHead
            if(dummyHead.next==null || dummyHead.next.val>= curr.val){
                ListNode newNode = new ListNode(curr.val);
                newNode.next = dummyHead.next;
                dummyHead.next = newNode;
                curr = curr.next;
            }
            //if curr is to be insert in the list
            else{
                ListNode tmp = dummyHead.next;
                while(tmp.next!=null){
                    if(tmp.val <= curr.val && curr.val <= tmp.next.val)
                        break;
                    else tmp = tmp.next;
                }
                
                //insert curr between tmp and tmp.next
                ListNode newNode = new ListNode(curr.val);
                newNode.next = tmp.next;
                tmp.next = newNode;
                curr = curr.next;
            }
        }
        
        return dummyHead.next;
    }
}
