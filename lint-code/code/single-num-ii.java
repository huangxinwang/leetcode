public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        // write your code here
        int rnt = 0;
        int mask = 1;
        
        //scan each digit
        for(int i=0; i<32; i++){
            mask = 1 << i;
            int sum = 0;
            //sum up the bit in the i-th digit
            for(int j=0; j<A.length; j++){
                if( (mask & A[j]) !=0)
                    sum++;
            }
            
            //if cannot be divide evenly by 3, then it means it will be in the result
            if(sum%3!=0)
                rnt |= mask;
        }
        
        return rnt;
    }
}
