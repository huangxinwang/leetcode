/**
* Problem: One Edit Distance
*/ 

class Solution{
  public boolean isOneEditDistance(String s, String t){
    if(s.length() > t.length())
      return isOneEditDistance(t,s);
    
    if(s.length()-t.lenth()<-1) return false;
    boolean have = false;
    
    for(int i=0, j=0; i<s.length(); ++i, ++j){
      //slow the shorter string by one
      if(s[i]!=t[j]){
        if(have) return false;
        have = true;
        i--;
      }
    }
    
    return (have) || (s.length()<t.length());
  }
}
