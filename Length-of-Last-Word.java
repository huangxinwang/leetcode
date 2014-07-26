/**
 * Problem Statment: Length of Last Word
 * Link: https://oj.leetcode.com/problems/length-of-last-word/
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example, 
 * Given s = "Hello World",
 * return 5.
 */


public class Solution {
    public int lengthOfLastWord(String s) {
        //special case
        if(s.length()==0) return 0;
        
        //lastLength keeps record of current lastword
        int lastLength = 0;
        //tmpLength keeps record of current word(or space)
        int tmpLength = 0;
        
        //update lastLength and tmpLength during traversing the string
        for(int i=0; i<s.length();i++){
            char curr = s.charAt(i);
            if(curr==' '){
                if(tmpLength>0) lastLength = tmpLength;
                tmpLength = 0;
            }
            else tmpLength++;
        }
        
        return tmpLength==0?lastLength:tmpLength;
    }
}