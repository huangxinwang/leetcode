class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int c = a^b;
        int mask = 1;
        int rnt = 0;
        for(int i=0; i<32; i++){
             if((mask & c)!=0) rnt++;
            mask = mask << 1;
        }
      
        return rnt;
        
        
    }
};

