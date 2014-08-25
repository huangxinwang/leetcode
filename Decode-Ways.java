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