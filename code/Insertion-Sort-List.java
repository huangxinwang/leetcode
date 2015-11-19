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


////////////////////////////////////////////////////////
//2015/11/18
// Reference: http://bxucode.blogspot.com/2014/05/insertion-sort-list.html
// Space complexity: O(1)
// Time complexity: O(n^2)
// Highlight: seperate the linked list into two parts; one with the head dummyhead; the other with the head curr
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head==null) return null;
        
        //use a dummyhead, in fact we seperate the whole linked list into two lists
        // one is the sorted list, whose head is the dummyhead
        // the other is the remaining list (unsorted), whose head is curr
        ListNode dummyhead = new ListNode(-1);
        
        ListNode pre = dummyhead;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode next = curr.next;
            pre = dummyhead;
            while(pre.next!=null && pre.next.val < curr.val){
                pre = pre.next;
            }
            
            curr.next = pre.next;
            pre.next = curr;
            curr = next;
        }
        
        return dummyhead.next;
    }
}


////////////////////////////////////////////////////////////
//2015/11/18
// Highlight: let the longer one advance the diff steps first
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int alen = 0;
        int blen = 0;
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA!=null){
            currA = currA.next;
            alen++;
        }
        while(currB!=null){
            currB = currB.next;
            blen++;
        }
        
        //let the longer one advance the diff steps first
        int diff = alen-blen;
        currA = headA;
        currB = headB;
        if(diff>0){
            while(diff>0){
                currA = currA.next;
                diff--;
            }
        }else{
            diff = -diff;
            while(diff>0){
                currB = currB.next;
                diff--;
            }
        }
        
        while(currA!=null && currB!=null){
            if(currA==currB) return currA;
            else{
                currA = currA.next;
                currB = currB.next;
            }
        }
        
        return null;
    }
}
