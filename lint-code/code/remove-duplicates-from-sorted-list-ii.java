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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        ListNode p1 = head;
        ListNode curr = dummyhead;
        
        while(p1!=null){
            ListNode p2 = p1.next;
            //Case 1: neigh numbers are not duplicate, add p1
            if(p2==null || p1.val != p2.val){
                
                curr.next = p1;
                curr = curr.next;
                p1 = p1.next;
            }
            
            //skip all duplicate number
            else if(p1.val == p2.val){
                int val = p1.val;
                
                
                while(p1!=null && p1.val == val){
                    p1 = p1.next;
                }
            }
            
            
        }
        
        curr.next = null;
        
        return dummyhead.next;
    }
}
