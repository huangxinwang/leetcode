//Hint: build two tables (head and tail) to avoid traversing from beginning when attempt to add elements to tail

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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int cap = hashTable.length;
        if(cap==0) return hashTable;
        if(!CheckConflict(hashTable)) return hashTable;
        
        //double capacity
        cap = cap*2;

        
        ListNode[] head = new ListNode[cap];
        ListNode[] tail = new ListNode[cap];
        for(int i=0; i<hashTable.length; i++){
           ListNode node = hashTable[i];
           if(node==null) continue;
           while(node!=null){
               int val = node.val;
               int idx = (val%cap+cap)%cap;
               if(head[idx]==null){
                   head[idx] = new ListNode(val);
                   tail[idx] = head[idx];
               }else{
                   tail[idx].next = new ListNode(val);
                   tail[idx] = tail[idx].next;
               }
               node = node.next;
           }
        }
        
        return head;
    }
    
    public boolean CheckConflict(ListNode[] hashTable){
        
        for(int i=0; i<hashTable.length; i++){
            if(hashTable[i]==null) continue;
            int count = 0;
            ListNode node = hashTable[i];
            while(node!=null){
                count++;
                node = node.next;
                if(count>=2) return true;
            }
        }
        
        return false;
    }
    
    
};

