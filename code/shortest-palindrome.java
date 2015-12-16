// Shortest palindrome


///////////////////////////////////////////
// 2015/12/15
// Highlight: brute force, check whether it is possible to make i as mid-point
// Time: O(n^2)

public class Solution {
    public String shortestPalindrome(String s) {
        if(s==null ||s.length()<=1) return s;
        int mid = s.length()/2;
        
        //the palindrome could be in mode "aba", or "aa"
        for(int i=mid; i>=0; i--){
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                String res = Palindrome(s,i,i+1);
                if(res!=null) return res;
            }
            String res = Palindrome(s,i,i);
            if(res!=null) return res;
        }
        return null;
    }
    
    //append letter in front to make palindrome
    public String Palindrome(String s, int l, int r){
        
        int i =0;
        for(; l-i>=0 && r+i<s.length(); i++){
            if(s.charAt(l-i)!=s.charAt(r+i)) break;
        }
        
        //cannot append letter in front to get palindrome
        if(l-i >0) return null;
        
        //reverse right parts, and append its reverse to left to make palindrome
        String right = s.substring(r+i);
        StringBuilder sb = new StringBuilder(right);
        sb.reverse();
        return sb.toString()+s;
    }
}
