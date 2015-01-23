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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        int carry = 0;
        ListNode dummyhead = new ListNode(-1);
        ListNode curr = dummyhead;
        
        while(l1!=null || l2!=null){
            int num1 = l1==null ? 0: l1.val;
            int num2 = l2==null ? 0: l2.val;
            int sum = num1 + num2 + carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            l1 = l1==null? null: l1.next;
            l2 = l2==null? null: l2.next;
        }
        
        if(carry!=0){
            curr.next = new ListNode(1);
            curr = curr.next;
        } 
        
        curr.next = null;
        return dummyhead.next;
    }
}
