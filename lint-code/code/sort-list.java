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
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head==null || head.next==null) return head;
        ListNode mid =getmid(head);
        ListNode head2 = mid.next;
        mid.next = null;
        return merge(sortList(head), sortList(head2));
        
    }
    
    public ListNode getmid(ListNode head){
        ListNode fast = head;
        ListNode slow = fast;
        
        //note: need to ensure that 
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummyhead = new ListNode(-1);
        ListNode curr = dummyhead;
        
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                curr.next = l2;
                l2 = l2.next;
            }
            
            curr = curr.next;
        }
        
        curr.next = l1==null? l2 : l1;
        
        return dummyhead.next;
    }
}
