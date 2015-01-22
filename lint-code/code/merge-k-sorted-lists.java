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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists==null || lists.size()==0) return null;
        if(lists.size()==1) return lists.get(0);
        return recurMerge(lists, 0, lists.size()-1);
    }
    
    public ListNode recurMerge(List<ListNode> lists, int l, int r){
        if(l >= r) return lists.get(l);
        
        int mid = (l+r)/2;
        return merge(recurMerge(lists, l, mid), recurMerge(lists, mid+1, r));
    }
    
    public ListNode merge(ListNode l1, ListNode l2){

        if(l1==null) return l2;
        if(l2==null) return l1;
        
        //use curr pointer to point to the smaller one of the next value
        ListNode dummyHead = new ListNode(-1);
        ListNode curr = dummyHead;
        
        
        while(l1!= null && l2!=null){
            //advance l1
            if(l1.val <= l2.val){
                curr.next = l1;
                ListNode tmp = l1.next;
                l1.next = null;
                l1 = tmp;
            }
            //advance l2
            else{
                curr.next = l2;
                ListNode tmp = l2.next;
                l2.next = null;
                l2 = tmp;
            }
            //advance curr
            curr = curr.next;
        }
        
        if(l1!=null) curr.next = l1;
        else curr.next = l2;
        
        return dummyHead.next;
    }
}
