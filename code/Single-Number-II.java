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


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Round 2: 11/29/2014

//No extra memeory, linear runtime complexity

public class Solution {
    public int singleNumber(int[] A) {
        
        int rnt = 0;
        
        for(int i=0; i<32; i++){
            int sum = 0;
            //shift left by i to create mask
            int mask = 1 << i;
            //sum up the i-th index of each numbers in A(in binary format)
            for(int j=0; j<A.length; j++){
                if((mask & A[j]) != 0)
                    sum++;
            }
            //if the sum cannot be divided by 3, then this digit appears in the single number
            if(sum%3 != 0)
                //modify rnt to reflect above finding
                rnt |= mask;
        }
        
        return rnt;
    }
}
