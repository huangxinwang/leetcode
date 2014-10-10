/**
 * Problem Statement
 * Given an array of integers, every element appears three times except for one. Find that single one.
 */
 
public class Solution {
    public int singleNumber(int[] A) {
        
        HashMap<Integer, Integer> hs = new HashMap<Integer,Integer>();
        
        //use hashmap to record the appearance time
        for(int i=0; i<A.length; i++)
        {
            if(hs.containsKey(A[i]))
                hs.put(A[i], hs.get(A[i])+1);
            else
                hs.put(A[i], 1);
        }
        
        //check apperance time of each elements
        for(int i=0; i<A.length; i++)
        {
            if(hs.get(A[i])!=3) return A[i];
        }
        
        return 0;
    }
}