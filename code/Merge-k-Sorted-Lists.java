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

//////////////////////////////////////////////////////
//Round 2: 1/1/2015
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
    public ListNode mergeKLists(List<ListNode> lists) {
        
        if(lists.size()==0) return null;
        if(lists.size()==1) return lists.get(0);
        
        return recursiveMerge(lists, 0, lists.size()-1);
    }
    
    //recursive merge every two list
    public ListNode recursiveMerge(List<ListNode> lists, int left, int right){
        if(left==right) return lists.get(left);
        int mid = (left+right)/2;
        return merge(recursiveMerge(lists, left, mid), recursiveMerge(lists, mid+1, right));
    }
    
    //merge two list
    public ListNode merge(ListNode p, ListNode q){
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = p;
        ListNode curr = dummyhead;
        
        while(p!=null && q!=null){
            if(p.val < q.val){
                p = p.next;
            }
            else{
                ListNode tmp = q.next;
                curr.next = q;
                q.next = p;
                q = tmp;
            }
            curr = curr.next;
        }
        
        if(q!=null)
            curr.next = q;
        return dummyhead.next;
    }
    
}


////////////////////////////////////////////////////
// 2015/10/25
// Highlight: recursive
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null ||lists.length==0) return null;
        if(lists.length==1) return lists[0];
        ListNode[] rnt = new ListNode[(lists.length+1)/2];
        for(int i=0; i<lists.length/2; i++){
            rnt[i] = mergeTwoList(lists[i], lists[lists.length-1-i]);
        }
        if(lists.length%2==1) rnt[lists.length/2] = lists[lists.length/2];
        return mergeKLists(rnt);
    }
    
    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){
                curr.next = l1;
                l1 = l1.next;
            }else{
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        
        if(l1!=null) curr.next = l1;
        if(l2!=null) curr.next = l2;
        return dummyHead.next;
    }
}
