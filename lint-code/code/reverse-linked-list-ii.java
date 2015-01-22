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
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        // write your code
        int i = 0;
        
        //need to have a dummyhead, otherwise, when m =1 is very complicated
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;
        
        //divide list into 2
        ListNode list1tail = dummyhead;
        while(i<(m-1)){
            list1tail = list1tail.next;
            i++;
        }
        
        ListNode list2 = list1tail.next;
        ListNode list2tail = list2;
        list1tail.next = null;
        
        //divide list2 to end into 2
        int j =0;
        while(j < (n-m)){
            list2tail = list2tail.next;
            j++;
        }
        
        ListNode list3 = list2tail.next;
        list2tail.next = null;
        
        //reverse the list in between
        reverse(list2);
        
        list1tail.next = list2tail;
        list2.next = list3;
        
        return dummyhead.next;
        
        
    }
    
    public ListNode reverse(ListNode list){
        if(list==null || list.next==null) return list;
        ListNode p1 = list;
        ListNode p2 = p1.next;
        ListNode first = list;
        
        while(p2 != null){
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        
        first.next = null;
        return p1;
    }
}
