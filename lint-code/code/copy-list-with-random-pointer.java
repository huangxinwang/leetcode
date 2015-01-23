/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        
        if(head==null) return null;
        //if(head.next == null) return new RandomListNode(head.label);
        
        RandomListNode curr = head;
        while(curr!=null){
            RandomListNode node = new RandomListNode(curr.label);
            RandomListNode tmp = curr.next;
            curr.next= node;
            node.next = tmp;
            curr = tmp;
        }
        
        RandomListNode list1 = new RandomListNode(-1);
        RandomListNode list2 = new RandomListNode(-1);
        RandomListNode rnt = list2;
        
        RandomListNode rnd = head;
        while(rnd!=null){
            //be careful about null random!
            rnd.next.random = rnd.random==null ? null: rnd.random.next;
            rnd = rnd.next.next;
        }

        
        RandomListNode p1 = head;
        RandomListNode p2 = p1.next;

        while(p1 !=null){
            list1.next = p1;
            list2.next = p2;

            //be careful if p1'2 next is null
            p1.next = p2.next;
            if(p2.next != null)
                p2.next = p2.next.next;
            else p2.next = null;
            
            //advance p1 p2
            p1 = p1.next;
            p2 = p2.next;
            
            //advance front pointer of two lists
            list1 = list1.next;
            list2 = list2.next;
        }
        
       
        
        return rnt.next;
        
        
        
    }
}


//////////////////////////////////////////////////////////////////////
//Approach 2: use hash table
/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        
        if(head==null) return head;
        
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        RandomListNode curr = head;
        while(curr != null){
            RandomListNode node = new RandomListNode(curr.label);
            map.put(curr, node);
            curr = curr.next;
        }
        
        curr = head;
        while(curr != null){
            RandomListNode node = map.get(curr);
            RandomListNode currnext = curr.next;
            if(currnext == null) node.next = null;
            else node.next = map.get(currnext);
            
            RandomListNode currrandom = curr.random;
            if(currrandom == null) node.random = null;
            else node.random = map.get(currrandom);
            
            curr = curr.next;
        }
        
        return map.get(head);
    }
}

