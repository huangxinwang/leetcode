class Solution {
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here
        
        //note 2 is always enough
        if(n==0) return 0;
        else return n/5 + trailingZeros(n/5);
    }
};

