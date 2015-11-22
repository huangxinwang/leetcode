/**
* Problem Statement: Power of Two
*
* Given an integer, write a function to determine if it is a power of two.
*/

////////////////////////////////////////////
// Problem Statement: Power of Two
// Highlight: recursive
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n==1) return true;
        if(n%2!=0) return false;
        if(n==0) return false;
        return isPowerOfTwo(n/2);
    }
}
