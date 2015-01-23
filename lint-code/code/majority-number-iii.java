public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(ArrayList<Integer> nums, int k) {
        // write your codej
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.size(); i++){
            int curr = nums.get(i);
            //update curr in map
            if(map.containsKey(curr)){
                map.put(curr, map.get(curr)+1);
            }
            //put curr in map
            else if(map.size() < k){
                map.put(curr,1);
            }
            //decrease for all, remove if reach 0
            else
            {
                ArrayList<Integer> keysToRemove = new ArrayList<Integer>();
                for(int key: map.keySet()){
                   int count = map.get(key)-1;
                   map.put(key, count);
                   if(count==0) keysToRemove.add(key);
                }
                
                for(int j=0; j<keysToRemove.size(); j++){
                    map.remove(keysToRemove.get(j));
                }
            }
            
        }
        
        //
        int max = 0;
        int maxkey = 0;
        for(int key: map.keySet()){
            if(map.get(key) > max){
                max = map.get(key);
                maxkey = key;
            }
        }
        
        return maxkey;
    }
}
