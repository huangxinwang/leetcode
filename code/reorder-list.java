/**
 * Problem Statement: Reorder List
 * Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 * reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * You must do this in-place without altering the nodes' values.
 * 
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */
 
 /**
  * Reference
  * http://www.2cto.com/kf/201312/265476.html
  * /



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        
        //find mid node
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        //mid node
        ListNode mid = slow;
        ListNode preHead = slow;
        if(preHead==null) return;
        
        
        //reverse second half list
        ListNode first = mid.next;
        if(first==null) return;
        
        ListNode second = first.next;
        ListNode third = first.next;
        
        first.next = null;
        
        while(third!=null){
            third = third.next;
            second.next = first;
            first = second;
            second = third; 
        }
        
        //split first half and seoncd half
        mid.next = null;
        
        //merge first-half and second-half list
        while(first!=null && head!=null){
            ListNode tmp = head.next;
            head.next = first;
            first = first.next;
            head.next.next = tmp;
            head = tmp;
        }
        
        
        
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

//time complexity O(n)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        
        //special case
        if(head==null || head.next==null) return;
        
        //split list into two sublist
        ListNode fast = head;
        ListNode slow = head;
        
        //find mid as split point
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode mid = slow;
        
        //reverse second half 
        ListNode first = mid.next;
        if(first==null) return;
        ListNode second = first.next;
        ListNode third  = first.next;
        first.next = null;
        while(third!=null){
            third = third.next;
            second.next = first;
            first = second;
            second = third;
        }
        
        mid.next = null;

        
        //merge two sublist
        while(head.next!=null && first!=null){
            ListNode tmp = head.next;
            head.next = first;
            first = first.next;
            head.next.next = tmp;
            head = tmp;
        }
    }
}

//////////////////////////////////////////////////////////
//2015/11/19
// Highlight: get mid, reverse list, inter-leave two lists
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        
        
        //get mid node, break list into two parts
        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;
        
        //reverse second part
        ListNode curr2 = reverse(second);
        ListNode curr1 = head;
        
        //interleave first and second part
        while(curr1!=null && curr2!=null){
            ListNode tmp2 = curr2.next;
            curr2.next = curr1.next;
            curr1.next = curr2;
            curr2 = tmp2;
            curr1 = curr1.next.next;
        }
    }
    
    //Get mid node
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    //reverse and return tail
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode curr = head;
        ListNode next = curr.next;
        while(next!=null){
            ListNode tmp = next.next;
            next.next = curr;
            curr = next;
            next = tmp;
        }
        head.next = null;
        return curr;
    }
}
