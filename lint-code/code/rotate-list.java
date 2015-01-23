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
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head==null || head.next==null) return head;
        if(k==0) return head;
        
        int num = 0;
        ListNode curr = head;
        
        
        //adjust k
        while(curr!=null){
            curr = curr.next;
            num++;
        }
        k = k %num;
        
        
        //fast pointer start k steps ahead
        ListNode fast = head;
        ListNode slow = head;
        int i =0;
        while(i<k){
            fast = fast.next;
            i++;
        }
        
        //split list
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode list2 = slow.next;
        slow.next = null;
        fast.next = head;
        return list2;
        
    }
}
