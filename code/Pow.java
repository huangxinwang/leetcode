/**
 * Problem Statement
 * Implement pow(x, n).
 */

////////////////////////////////
// 2015/12/07
// Highlight: recursion
// Time: O(logn)

public class Solution {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        //convert negative to positive
        if(n<0) {
            if(n==Integer.MIN_VALUE) return 1/myPow(x,Integer.MAX_VALUE)/x;
            else return 1/myPow(x,-n);
        }
        
        //terminate case
        if(n==0) return 1;
        if(n==1) return x;
        
        //recursive
        double half = myPow(x, n/2);
        if(n%2==0) return half*half;
        else return half*half*x;
    }
}
