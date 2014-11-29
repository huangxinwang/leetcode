/**
 * Problem Statement
 * Given a linked list, determine if it has a cycle in it.
 * 
 */
 
 /**
  * Reference
  * http://xingxjhui.blog.163.com/blog/static/215545164201401313449112/
  */
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
    public boolean hasCycle(ListNode head) {
        
        //special case 1, null head
        if(head==null) return false;
 
        ListNode currNode = head;
        ListNode tmpNode = head;
        
        //loop when currNode.next is not head (no cycle)
        while(currNode.next!=head)
        {
            //case: no cycle
            if(currNode.next==null) return false;
            else
            {
                //change cursor to point to head
                tmpNode= currNode;
                currNode = currNode.next;
                tmpNode.next = head;
            }
        }
        
        //case: has cycle
        return true;
        
    }
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

//time complexity: O(1)

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
    public boolean hasCycle(ListNode head) {
        
        //use fast and slow pointer to decide
        //first fast and slow meet with each other, then it contains cycle
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        
        return false;
    }
}
