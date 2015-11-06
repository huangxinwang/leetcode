/**
 * Problem Statement: Sqrt(x) 
 * Link:https://oj.leetcode.com/problems/sqrtx/
 * Time: 476 ms
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */


public class Solution {
    
    public int sqrt(int x) {
        int low = 0;
        int high = x;
        return (int)binarySearch(low, high, x);
    }
    
    //use binary search to find root
    public long binarySearch(long low, long high, int x){
        if(low>=high) return low;
        long mid = (low+high)/2;
        if(mid*mid==x) return mid;
        //this condition is necessary for successful implementing binary search
        if(mid*mid<x && (mid+1)*(mid+1)>x) return mid;
        //binar search
        if(mid*mid<x) return binarySearch(mid+1, high, x);
        else return binarySearch(low, mid-1, x);
    }
}


////////////////////////////////////////////////////////////////////////////
//Round 2: 12/22/2014
public class Solution {
    public int sqrt(int x) {
        
        //binary search
        return (int)bs(0, x, x);
    }
    
    public long bs(long low, long high, int x){
        if(low >=high) return low;
        long mid = (low+high)/2;
        if(mid*mid ==x) return mid;
        if(mid*mid<x && (mid+1)*(mid+1)>x) return mid;
        if(mid*mid<x && (mid+1)*(mid+1)<=x) return bs(mid+1, high, x);
        else return bs(low, mid, x);
    }
}

///////////////////////////////////////////////////////////////
// 2015/11/06
// Highlight: long and int
public class Solution {
    public int mySqrt(int x) {
        return (int)help(0,x,x);
    }
    
    //left and right has to be in long type
    public long help(long left, long right, int x){
        if(left>=right) return left;
        
        long mid = left + (right-left)/2;
        
        if(mid*mid==x) return mid;
        
        else if(mid*mid<x){
            if((mid+1)*(mid+1)>x) return mid;
            else return help(mid+1, right, x);
        }
        
        else return help(left,mid, x);
    }
}
