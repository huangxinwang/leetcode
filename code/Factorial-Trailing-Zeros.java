/**
 * Problem Statement: Factorial Trailing Zeroes
 * 
 */

ublic class Solution {
    public int trailingZeroes(int n) {
        
        if(n==0) return 0;
        //zero comes from times of 5, 2 is always enough 
        //but for number like 125 contains several 5, thus we recursive count trailing zeros in n/5
        else return n/5+trailingZeroes(n/5);
    }
}
