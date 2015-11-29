/**
* Problem Statement: Reverse Words in a String
* Ref: http://www.mitbbs.com/article_t/JobHunting/33101531.html
*/

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(int i=words.length-1; i>=0; i--){
            //check if it is ""
            if(words[i].equals("")) continue;
            if(sb.length()!=0) sb.append(" ");
            sb.append(words[i]);
        }
        
        return sb.toString();
    }
}
