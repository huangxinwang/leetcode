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
        
        //build map to record the key value pairs
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for(int i=0; i<hashTable.length; i++){
            ListNode node = hashTable[i];
            if(node==null) continue;
            while(node!=null){
                int val = node.val;
                int idx = (val%cap + cap)%cap;
                ArrayList<Integer> list = new ArrayList<Integer>();
                if(map.containsKey(idx)) list = map.get(idx);
                list.add(val);
                map.put(idx,list);
                node = node.next;
            }
           
        }
        
        
        
        ListNode[] newTable = new ListNode[cap];
        for(int i=0; i<newTable.length; i++){
            if(map.containsKey(i)){
                ArrayList<Integer> list = map.get(i);
                ListNode dummyHead = new ListNode(-1);
                ListNode head = dummyHead;
                for(int j=0; j<list.size(); j++){
                    head.next = new ListNode(list.get(j));
                    head = head.next;
                }
                newTable[i] = dummyHead.next;
            }
        }
        
        
        return newTable;
        
        
       
        
        
        
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

