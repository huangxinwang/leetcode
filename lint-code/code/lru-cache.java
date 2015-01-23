//time complexity: get, set both O(n)
public class LRUCache {
    
    
    int size;
    LinkedList<Integer> lru;
    HashMap<Integer, Integer> map;
    
    
    //init
    public LRUCache(int capacity) {
        size = capacity;
        lru = new LinkedList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
     // @return an integer
    public int get(int key) {
        // write your code here
        int rnt = -1;
        if(map.containsKey(key)){
            rnt = map.get(key);
            updatelru(key);
        }
        return rnt;
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        // write your code here
        if(map.containsKey(key)){
            if(map.get(key)!=value)
                map.put(key, value);
            updatelru(key);
        }
        else{
            if(lru.size()==size){
                map.remove(lru.get(lru.size()-1));
                lru.remove(lru.size()-1);
                
            }
            lru.add(0, key);
            map.put(key, value);
        }
    }
    
    public void updatelru(int key){
        int idx = 0;
        for(int i=0; i<lru.size(); i++){
            if(lru.get(i)==key){
                idx = i;
                break;
            }
        }
        
        lru.remove(idx);
        lru.add(0, key);
    }
    
}
