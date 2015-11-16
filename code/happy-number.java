/**
*Write an algorithm to determine if a number is "happy".
*
*A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the *sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops *endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
*
*Example: 19 is a happy number
*
*12 + 92 = 82
*82 + 22 = 68
*62 + 82 = 100
*12 + 02 + 02 = 1
*/

///////////////////////////////////////////////////
// 2015/11/15
// Highlight: recursive, maintain hashset to check if number repeats

public class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    public boolean isHappy(int n) {
        // terminate condition
        if(n==1) return true;
        if(set.contains(n)) return false;
        
        // recursive operation
        set.add(n);
        String str = String.valueOf(n);
        int val = 0;
        for(int i=0; i<str.length(); i++){
            int currval = str.charAt(i)-'0';
            val = val + currval*currval;
        }
        return isHappy(val);
    }
}
