### Problem
Reverse a linked list

### Analysis
- use two pointers
  - p1 keep track of pre value
  - p2 keep track of current value
  
### Code
```java
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
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
     
     
    //use two pointer, one point to last value, one point to current value
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head==null || head.next==null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        p1.next = null;
        while(p2!=null){
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        
        return p1;
        
    }
}

```
