/**
* Ref: http://www.mitbbs.com/article_t/JobHunting/33101531.html
*
*/

public class Solution {
    public boolean isPalindrome(String s) {
        if(s==null || s.length()<=1) return true;
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            char a = Character.toLowerCase(s.charAt(start));
            char b = Character.toLowerCase(s.charAt(end));
            if( !((a>='a' && a<='z') || (a>='0' && a <='9'))){
                start++;
                continue;
            } 
            if( !((b>='a' && b<='z') || (b>='0' && b <='9'))){
                end--;
                continue;
            } 
            if(a!=b) return false;
            start++;
            end--;
        }
        
        return true;
    }
}
