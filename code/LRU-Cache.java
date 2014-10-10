/**
 * Problem Statement: LRU Cache
 * 
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */
 
 /**
  * Reference
  * http://www.shaoqun.com/a/82569.aspx
  */
  
  /**
   * Solution
   * Use HashMap to find CacheNode by key in O(1) time
   * Use double linked list to maintain the LRU logic
   *    the last element in the list is the least recently used element
   */
  
  /**
   * Comments
   * This problem practice to design and use data structure
   */
 
public class LRUCache {
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheMap = new HashMap<Integer,CacheNode>();
        cacheList = new CacheList();
    }
    
    public int get(int key) {
        CacheNode node = cacheMap.get(key);
        if(node==null) return -1;
        cacheList.shiftToFirst(node);
        return node.val;
    }
    
    public void set(int key, int val) {
        
        //Case1: contain key, reset value, and shirt to first 
        if(cacheMap.containsKey(key)){
            CacheNode node = cacheMap.get(key);
            node.val = val;
            cacheList.shiftToFirst(node);
        }
        else{
            
            //Case2: does not contain key and size is full
            //remove last node
            if(cacheMap.size()==capacity){
                CacheNode toRemoveNode = cacheList.removeLast();
                cacheMap.remove(toRemoveNode.key);
            }
            
            //create and insert new node
            CacheNode node = new CacheNode(key,val);
            cacheList.insertToFirst(node);
            cacheMap.put(key,node);
        }
    }
    
    
    
    
    //Data structure: cache list
    
    private int capacity;
    private CacheList cacheList;
    private HashMap<Integer, CacheNode> cacheMap;
    
    
    //double linked list
    private class CacheList{
    
        private CacheNode head;
        private CacheNode tail;
        
        private CacheList(){
            head = new CacheNode(0,0);
            tail = new CacheNode(0,0);
            head.next = tail;
            tail.prev = head;
        }
        
        
        private void insertToFirst(CacheNode node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }
        
        private CacheNode removeLast(){
            CacheNode toRemoveNode = tail.prev;
            toRemoveNode.prev.next = tail;
            tail.prev = toRemoveNode.prev;
            return toRemoveNode;
        }
        
        private void shiftToFirst(CacheNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            insertToFirst(node);
        }
    
    }
    
    //data structure: cacheNode
    private class CacheNode{
       
        private int key;
        private int val;
        CacheNode prev;
        CacheNode next;
       
       private CacheNode(int key, int val){
           this.key = key;
           this.val = val;
           this.prev = null;
           this.next = null;
       } 
    }
    
}


