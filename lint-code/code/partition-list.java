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
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
     
    
    public ListNode partition(ListNode head, int x) {
        // write your code here
        
        //use two List to keep track of partitioned number
        ListNode l1 = new ListNode(-1);
        ListNode l2 = new ListNode(-1);
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        while(head!=null){
            if(head.val < x){
                ListNode tmp = head.next;
                curr1.next = head;
                head.next = null;
                head = tmp;
                curr1 = curr1.next;
            }
            else{
                ListNode tmp = head.next;
                curr2.next = head;
                head.next = null;
                head = tmp;
                curr2 = curr2.next;
            }
        }
        
        //merge two list together
        curr1.next = l2.next;
        return l1.next;
    }
}

