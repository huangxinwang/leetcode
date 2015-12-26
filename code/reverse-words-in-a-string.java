/**
 * Problem Statement
 * Given an input string, reverse the string word by word.
 */
 
//////////////////////////////
// 2015/12/25
// Highlight: string split

public class Solution {
    public String reverseWords(String s) {
       //split string
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        //append in reverse order
        for(int i=words.length-1; i>=0; i--){
            if(words[i].equals("")) continue;
            if(sb.length()!=0) sb.append(" ");
            sb.append(words[i]);
        }
        
        return sb.toString();
    }
}
