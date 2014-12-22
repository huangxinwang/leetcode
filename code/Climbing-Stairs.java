/**
 * Problem Statement--Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */

public class Solution {
    
    //fibonacci sequence f(n) = f(n-1) + f(n-2)
    public int climbStairs(int n) {
        
        //special case
        if(n==1) return 1;
        if(n==0) return 0;
        
        //declare table for storage
        int[] step = new int[n+1];
        
        //special case
        step[0] = 0;
        step[1] = 1;
        step[2] = 2;
        
        //build table
        for(int i=3; i<=n; i++){
            step[i] = step[i-1] + step[i-2];
        }
        
        return step[n];
    }
}


////////////////////////////////////////////////////////////////////
//Round 2: 12/22/2014
public class Solution {
    public int climbStairs(int n) {
        
        //fibonacci f(n) = f(n-1)+f(n-2)
        int first = 1;
        int second = 1;
        for(int i=2; i<=n; i++){
            int tmp = second;
            second = first+second;
            first = tmp;
        }
        
        return second;
    }
}
