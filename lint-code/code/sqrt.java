/**
 * Problem Statement: Sqrt(x)
 * 
 */


class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        return help(x, 1, x);
        
    }
    
    //note avoid using mid*mid, but use mid and x/mid, in order to avoid overflow
    public int help(int x, int l, int r){
        if(l > x/l) return l-1;
        
        int mid = (l+r)/2;
        
        if(mid == x/mid) return mid;
        
        if(mid < x/mid)
            return help(x, mid+1, r);
        else return help(x, l, mid-1);
    }
}
