/**
 * Definition for ListNode
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
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        
        
        ListNode curr = dummyhead;
        
        //p1 is head
        ListNode p1 = head;
        while(p1 != null){
           
            ListNode p2 = p1.next;
            //while loop to delte duplicate number
            while(p2!=null && p2.val ==p1.val){
                p2 = p2.next;
            }
            curr.next = p1;
            p1 = p2;
            curr = curr.next;
        }
        
        curr.next = null;
        
        return dummyhead.next;
    }  
}
