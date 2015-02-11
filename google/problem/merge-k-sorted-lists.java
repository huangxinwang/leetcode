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
        return recursiveMerge(lists, 0, lists.size()-1);
    }
    
    //recursive merge two lists
    public ListNode recursiveMerge(List<ListNode> lists, int l, int r ){
        if(l>r) return null;
        if(l==r) return lists.get(l);
        if(l+1==r) return merge(lists.get(l), lists.get(r));
        int mid = (l+r)/2;
        return merge(recursiveMerge(lists, l, mid), recursiveMerge(lists,mid+1,r));
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        
        ListNode dummyHead = new ListNode(-1);
        
        //curr pointer points to next valid number
        ListNode curr = dummyHead;
        dummyHead.next = l1;
        while(l2!=null && l1!=null){
            if(l1.val<=l2.val){
                curr.next = l1;
                l1 = l1.next;
            }
            else{
                ListNode nextl2 = l2.next;
                curr.next = l2;
                curr.next.next = l1;
                l2 = nextl2;
            }
            curr = curr.next;
        }
        
        //cancate the remaining l2
        if(l2!=null) curr.next = l2;
        

        
        return dummyHead.next;
    }
}

