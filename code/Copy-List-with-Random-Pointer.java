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



//////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

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
        
        if(head==null) return head;
        duplicateList(head);
        setRandom(head);
        return splitList(head);
        
    }
    
    //duplicate list
    //e.g., originally we have a->b->c->d->...
    //after duplicating, we have a->a'->b->b'->c->c'->...
    public void duplicateList(RandomListNode head){
        
        RandomListNode ori = head;
        
        while(ori!=null){
            RandomListNode newnode = new RandomListNode(ori.label);
            newnode.next = ori.next;
            ori.next = newnode;
            ori = newnode.next;
        }
        
       
    }
    
    //set random pointer
    //e.g., a->a'->....>r->r'
    //if a random pointe to r, then a' random point to r'
    public void setRandom(RandomListNode head){
        RandomListNode ori = head;
        RandomListNode cpy = head.next;
        while(ori!=null){
            RandomListNode rnd = ori.random;
            if(rnd!=null){
                cpy.random = rnd.next;
            }else 
                cpy.random = null;
                
            ori = cpy.next;
            if(ori!=null) cpy = ori.next;
        }
    }
    
    //split two linked list
    public RandomListNode splitList(RandomListNode head){
         
        RandomListNode ori = head;
        RandomListNode cpy = head.next;
        RandomListNode rnt = head.next;
        while(ori!=null){
            ori.next = cpy.next;
            ori = ori.next;
            if(ori!=null) {
                cpy.next = ori.next;
                cpy=cpy.next;
            }
        }
        
        return rnt;
    }
    
    
}


///////////////////////////////////////////////////////////////
// 2015/11/18
// Highlight: copy linked list in place, split list
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
        if(head==null) return null;
        RandomListNode curr = head;
        
        //copy list
        //origin: a-b-c
        //copiedL a-a'-b-b;
        while(curr!=null){
            RandomListNode node = new RandomListNode(curr.label);
            node.next = curr.next;
            curr.next = node;
            curr = curr.next.next;
        }
        
        
        //set random pointer
        //if a random pointer is r
        //then a' has random pointer r'
        curr = head;
        while(curr!=null){
            if(curr.random!=null){
                RandomListNode currRand = curr.random;
                curr.next.random = currRand.next;
            }
            curr = curr.next.next;
        }
        
        //split list
        curr = head;
        RandomListNode rntHead = curr.next;
        RandomListNode rnt = curr.next;
        while(curr!=null){
            curr.next = rnt.next;
            curr = curr.next;
            if(curr!=null){
                rnt.next = curr.next;
            }
            rnt = rnt.next;
        }
        
        return rntHead;
    }
}
