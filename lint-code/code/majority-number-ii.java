public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
       int size = 3;
       
       for(int i=0; i<nums.size(); i++){
           if(map.containsKey(nums.get(i))){
               map.put(nums.get(i), map.get(nums.get(i))+1);
           }
           else{
               if(map.size()>=size){
                    ArrayList<Integer> toRemove = new ArrayList<Integer>();
                   for(int key: map.keySet()){
                       int count = map.get(key);
                       map.put(key, count--);
                       if(count==0) toRemove.add(key);
                   }
                   for(int key: toRemove){
                       map.remove(key);
                   }
                   
               }
               if(map.size()<size){
                   map.put(nums.get(i),1);
               }
              
           }
       }
       
       int max = 0;
       int rnt = 0;
       for(int key: map.keySet()){
           if(max < map.get(key)){
               max =  map.get(key);
               rnt = key;
           }
       }
       
       return rnt;
    }
}
