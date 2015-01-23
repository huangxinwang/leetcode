/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    //use to construct root in the recursive process
     public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        if(head==null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode mid = getmid(head);
        int rootval = mid==null ? head.val: mid.next.val;
        
        TreeNode root = new TreeNode(rootval);
        ListNode list1 = mid==null ? null : head;
        ListNode list2 = mid == null? head.next :mid.next.next;
        if(mid!=null) mid.next = null;
        root.left = sortedListToBST(list1);
        root.right = sortedListToBST(list2);
        
        return root;
    }
    
    
    public ListNode getmid(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        
        ListNode slow = dummyhead;
        ListNode fast = dummyhead;
        while(fast.next.next!=null && fast.next.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if(slow == dummyhead) return null;
        else return slow;
    }
}
