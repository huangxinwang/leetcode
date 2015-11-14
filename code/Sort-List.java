/**
 * Problem Statement: Sort List 
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
 
/**
 * Reference
 * http://blog.csdn.net/worldwindjp/article/details/18986737
 */



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    //use merge sort to sort list
    public ListNode sortList(ListNode head) {
        
        if(head==null || head.next==null) return head;
        
        ListNode mid = getMidNode(head);
        ListNode subList2 = mid.next;
        mid.next = null;
        //sort two sublist, then merge to one list
        return mergeList(sortList(head),sortList(subList2));
        
    }
    
    //use fast and slow pointer to get mid node
    public ListNode getMidNode(ListNode head)
    {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    //merge two sorted list
    public ListNode mergeList(ListNode a, ListNode b){
        
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;

        while(a!=null && b!=null){
            if(a.val <= b.val){
                curr.next = a;
                a = a.next;
            }
            else{
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        
        curr.next = a==null? b : a;
        return dummyHead.next;
    } 
}


////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/28/2014
//Time comlexity, I think it should be O(n^2) in the worst-case, since this is like merge sort

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        
        //terminate condition
        if(head==null || head.next==null) return head;
        ListNode mid = getMid(head);
        
        //split the list into two sublist(first half, and second half)
        ListNode list2 = mid.next;
        mid.next = null;
        return mergeList(sortList(head), sortList(list2));
    }
    
    //get head of second half list
    public ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    //merge two sublist, note neeed to create a dummy head to avoid discussion of null list
    public ListNode mergeList(ListNode a, ListNode b){
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        while(a!=null && b!=null){
            if(a.val < b.val){
                curr.next = a;
                a = a.next;
            }else{
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        
        curr.next = a==null? b : a;
        return dummyHead.next;
    }
}


///////////////////////////////////////////////////////////////////
// 2015/11/13
// Highlight: merge two sorted list, get mid node by using two pointer, recursive
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next == null) return head;
        
        ListNode mid = getMid(head);
        ListNode second = mid.next;
        mid.next = null;
       
        return merge(sortList(head),sortList(second));
    }
    
    //get mid node
    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    //merge two sorted list
    public ListNode merge(ListNode list1, ListNode list2){
        if(list1==null) return list2;
        if(list2==null) return list1;
        ListNode dummyhead = new ListNode(-1);
        ListNode curr = dummyhead;
        while(list1!=null && list2!=null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else{
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1!=null) curr.next = list1;
        if(list2!=null) curr.next = list2;
        return dummyhead.next;
    }
}
