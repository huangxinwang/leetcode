/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head==null || head.next==null) return;
        
        //split list into 2, reverse second half
        ListNode mid = getMid(head);
        ListNode list2 = mid.next;
        mid.next = null;
        list2 = reverseList(list2);
        
        ListNode dummyHead = new ListNode(-1);
        
        //build target list
        ListNode curr = dummyHead;
        while(head!=null && list2!=null){
            curr.next = head;
            head = head.next;
            curr = curr.next;
            curr.next = list2;
            list2 = list2.next;
            curr = curr.next;
        }
        
        if(head!=null) curr.next = head;
        else curr.next = list2;
        
        head = dummyHead.next;
    }
    
    //get mid
    public ListNode getMid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    // reverseList
    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode first = head;
        
        while(p2 != null){
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        
        first.next = null;
        
        return p1;
        
        
    }
}
