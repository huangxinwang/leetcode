/**
 * Problem Statement: Merge k Sorted Lists 
 * Link:https://oj.leetcode.com/problems/merge-k-sorted-lists/
 * Time:432 ms
 * Ref:http://blog.csdn.net/linhuanmars/article/details/19899259
 * 
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 */



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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        
        //special case
        if(lists==null || lists.size()==0) return null;
        if(lists.size()==1) return lists.get(0);
        
        ListNode rnt = helper(lists, 0, lists.size()-1);
        return rnt;
    }
    
    //recursively merge two sublists
    public ListNode helper(ArrayList<ListNode> lists, int l, int r){
        if(l>=r) return lists.get(l);
        int mid = (l+r)/2;
        return merge(helper(lists, l, mid), helper(lists, mid+1, r));
    }
    
    //merge two sublists
    public ListNode merge(ListNode l1, ListNode l2){
        //create dummyhead to avoid the case that either l1 or l2 is null
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = l1;
        ListNode curr = dummyHead;
        
        while(l1 !=null && l2!=null){
            //advance l1
            if(l1.val <= l2.val){
                l1 = l1.next;
            }else{
            //advance l2
                ListNode tmpl2 = l2.next;
                curr.next = l2;
                l2.next = l1;
                l2 = tmpl2;
            }
            curr = curr.next;
        }
        
        if(l2!=null) curr.next = l2;
        return dummyHead.next;
    }
}