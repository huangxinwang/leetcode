/**
 * Problem Statement: Sqrt(x) 
 * Link:https://oj.leetcode.com/problems/sqrtx/
 * Time: 476 ms
 * 
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 */


///////////////////////////////
// 2015/12/20
// Highlight: binary search

public class Solution {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        while(start<end){
            long mid = start + (end-start)/2;
            if(mid*mid==x) return (int)mid;
            //go to left part
            if(mid*mid>x) end = mid-1;
            //go to right part
            else{
                if((mid+1)*(mid+1)<=x) start = mid+1;
                //directly return
                else return (int)mid;
            }
        }
        return (int)start;
    }
    
    
}

//////////////////////////////////////////
//2015/12/31
public class Solution {
    public int mySqrt(int x) {
        return (int)help(0,x,x);
    }
    
    public long help(long left, long right, int x){
        if(left==right) return left;
        long mid = left + (right-left)/2;
        
        if(mid*mid==x) return mid;
        //go left
        if(mid*mid>x)
            return help(left, mid-1, x);
        //
        else{
            //mid is the solution
            if( (mid+1)*(mid+1) > x ) return mid;
            //go right
            else return help(mid+1, right, x);
        }
    }
}
