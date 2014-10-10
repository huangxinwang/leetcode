/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 /**
  * Reference
  * http://blog.csdn.net/doc_sgl/article/details/12291285
  */
  
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        if(head==null) return head;
        
        duplicateList(head);
        setRandom(head);
        return seperateList(head);
    }
    
    //copy list in places
    //e.g. original: a->b->c
    //     copied: a->a'->b->b'->c->c'
    public void duplicateList(RandomListNode head){
        RandomListNode origin = head;
        while(origin!=null){
            
            RandomListNode cpy = new RandomListNode(origin.label);
            cpy.next = origin.next;
            origin.next = cpy;
            origin = cpy.next;
        }
        
    }
    
    //copy random pointer
    //e.g. original: a->b->c, 
    //     copied: a->a'->b->b'->c->c',if a random points to c, then a' random points to c'
    public void setRandom(RandomListNode head){
        RandomListNode origin = head;
        RandomListNode cpy = head.next;
        while(origin!=null){
            RandomListNode random = origin.random;
            if(random!=null){
                cpy.random = random.next;
            }else
                cpy.random = null;
                
            origin = cpy.next;
            if(origin!=null)
                cpy = origin.next;
        }
    }
    
    //seperate copied list to get duplicate copy
    //e.g. original: a->b->c, 
    //     copied: a->a'->b->b'->c->c'
    // seperate to get a'->b'->c'
    public RandomListNode seperateList(RandomListNode head){
        RandomListNode origin = head;
        RandomListNode cpy = head.next;
        RandomListNode rnt = head.next;
        while(origin!=null){
            origin.next = cpy.next;
            origin = cpy.next;
            if(origin!=null){
                cpy.next = origin.next;
                cpy = cpy.next;
            }
        }
        
        return rnt;
    }
}