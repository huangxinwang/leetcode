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

/////////////////////////////////////
// 2015/11/20
// Highlight: logic
public class Solution {
    public int trailingZeroes(int n) {
        if(n==0) return 0;
        //count number of 5 in numbers in 1...n
        //Note: for example 125 = 5*5*5 contains 3 of 5
        return n/5 + trailingZeroes(n/5);
    }
}
