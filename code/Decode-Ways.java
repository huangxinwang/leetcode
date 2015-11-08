/**
 * Problem Statement: Decode Ways 
 * Link:https://oj.leetcode.com/problems/decode-ways/
 * Time:380 ms
 * 
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 */



public class Solution {
    public int numDecodings(String s) {
        
        //special case
        if(s.length()==0) return 0;
        
        //the ways[i] is the decode ways of string[0..i-1]
        int[] ways = new int[s.length()+1];
        
        //initialize
        ways[0] = 1;
        if(s.charAt(0)>='1' && s.charAt(0)<='9') ways[1] = 1;
        else return 0;
        
        //dynamic compute ways[i]
        for(int i=1; i<s.length(); i++){
            int first = Character.getNumericValue(s.charAt(i-1));
            int second = Character.getNumericValue(s.charAt(i));
            
            //compute ways[i+1] from ways[i-1] and ways[i]
            if(1<=first && first<=2 && 10<=first*10+second && first*10+second<=26)
                ways[i+1] = ways[i-1];
            if(1<=second && second<=9)
                ways[i+1] += ways[i];
        }
        
        return ways[s.length()];
        
    }
}


///////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/17/2014
public class Solution {
    public int numDecodings(String s) {
        
        if(s.length()==0) return 0;
        
        //ways[i]: number of ways to decode [0...i-1]
        int[] ways = new int[s.length()+1];
        
        //initialize
        ways[0] = 1;
        if(s.charAt(0)<='9' && s.charAt(0)>'0')
            ways[1] = 1;

        
        //dynamic build array ways
        for(int i=1; i<s.length(); i++){
            int c1 = Character.getNumericValue(s.charAt(i-1));
            int c2 = Character.getNumericValue(s.charAt(i));
            int sum = c1*10+c2;
            //c1 should not be 0 in order to combine c1&c2 as a group
            if(c1!=0 && 1<=sum && sum<=26){
                ways[i+1] += ways[i-1];
            }
            //c2 alone
            if(1<=c2 && c2<=9)
                ways[i+1] += ways[i];
        }
        
        return ways[s.length()];
    }
}


//////////////////////////////////////////////
// 2015/11/08
// Failed version: DFS, time complexity O(2^n), runtime exceed
public class Solution {
    public int numDecodings(String s) {
        int[] count = new int[1];
        int idx = 0;
        dfs(count, idx, s);
        return count[0];
    }
    
    public void dfs(int[] count, int idx, String s){
        if(idx>=s.length()){
            count[0] ++;
            return;
        }
        
        for(int i=1; i<=2 && idx+i<=s.length(); i++){
            String substr = s.substring(idx, idx+i);
            int num = Integer.parseInt(substr);
            if(num>=1 && num<=26){
                dfs(count, idx+i, s);
            }
        }
    }
}

////////////////////////////////////////////////////////
// 2015/11/08
