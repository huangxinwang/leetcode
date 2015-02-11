public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        
        
        //use a hashtable to maintain the longest length starts at the key value
        //Note that for an interval, we only need to ensure that the two end keys have valid values
        Hashtable<Integer, Integer> table = new Hashtable<Integer,Integer>();
        
        for(int i=0; i<num.length; i++){
            int val = num[i];
            if(table.containsKey(val)) continue;
            if(table.containsKey(val-1) && table.containsKey(val+1)){
                int count1 = table.get(val-1);
                int count2 = table.get(val+1);
                table.put(val-count1, count1+count2+1);
                table.put(val+count2, count1+count2+1);
                table.put(val, count1+count2+1);
            }
            else if(table.containsKey(val-1)){
                int count = table.get(val-1);
                table.put(val, count+1);
                table.put(val-count, count+1);
            }
            else if(table.containsKey(val+1)){
                int count = table.get(val+1);
                table.put(val, count+1);
                table.put(val+count, count+1);
            }
            else table.put(val, 1);
        }
        
        int max = 0;
        for(Integer key: table.keySet()){
            max = max > table.get(key)? max: table.get(key);
        }
        
        return max;
    }
}
