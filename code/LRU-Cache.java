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


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

//time complexity: get, set both O(1)
public class LRUCache {
    
    
    private int capacity;
    //create double link to check least recently used; latest used is in head; least used is in tail
    private cacheList cacheList;
    //hashmap to store key cacheNode pair
    private HashMap<Integer, cacheNode> cacheMap;
    
    //init
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cacheList = new cacheList();
        cacheMap = new HashMap<Integer, cacheNode>();
    }
    
    //get key, update recently used
    public int get(int key) {
        if(cacheMap.containsKey(key)){
            cacheList.shiftToFirst(cacheMap.get(key));
            return cacheMap.get(key).value;
        }
        else return -1;
    }
    
    //set key value, remove if reach capacity; 
    public void set(int key, int value) {
        if(cacheMap.containsKey(key)){
            cacheNode node = cacheMap.get(key);
            node.setVal(value);
            cacheList.shiftToFirst(node);
        }else{
           if(cacheMap.size() >= capacity){
               int toremoveKey = cacheList.removeTail();
               cacheMap.remove(toremoveKey);
           }
           
            cacheNode newNode = new cacheNode(key, value);
            cacheList.insertToFirst(newNode);
            cacheMap.put(key, newNode);
        }
    }
    
    
    //node to store key, value, prev, next pointer
    public class cacheNode{
        private int key;
        private int value;
        private cacheNode prev;
        private cacheNode next;
        
        public cacheNode(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
        
        public void setVal(int value){
            this.value = value;
        }
    }
    
    //double link
    public class cacheList{
        private cacheNode head;
        private cacheNode tail;
        
        public cacheList(){
            head = new cacheNode(-1,-1);
            tail = new cacheNode(-1,-1);
            head.next = tail;
            tail.prev = head;
        }
        
        public void shiftToFirst(cacheNode node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            
            insertToFirst(node);
            
        }
        
        public void insertToFirst(cacheNode node){
           node.next = head.next;
           head.next.prev = node;
           node.prev = head;
           head.next = node;
        }
        
        public int removeTail(){
            cacheNode toremove = tail.prev;
            toremove.prev.next = tail;
            tail.prev = toremove.prev;
            return toremove.key;
        }
    }
}


