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


//////////////////////////////////////////////////////////////////////////////////
//Round 2: 12/24/2014
public class Solution {
    public int lengthOfLastWord(String s) {
        
        int len = 0;
        //scan from tail to head
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            //if current character is alphabeta, then len++
            if((c>='a' && c<='z') || (c>='A' && c<= 'Z'))
                len++;
            //otherwise, if len>0, then the last word found
            //else, keep finding
            else if(len>0) break;
        }
        
        return len;
    }
}


/////////////////////////////////////////////////////////////////////////////////
// 2015/11/05
// Highlight: keep track of last non-empty
public class Solution {
    public int lengthOfLastWord(String s) {
        boolean exist = false;
        int lastLen = 0;
        int currLen = 0;
        
        //keep track of length of last non-empty string
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==' '){
                if(currLen!=0) lastLen = currLen;
                currLen = 0;
            }else{
                exist = true;
                currLen++;
            } 
        }
        
        if(exist && currLen==0) return lastLen;
        return currLen;
    }
}
