### Problem
Longest Palindromic Substring 

### Complexity
O(n^2)

### Analysis
using dynamic programming
  - use a 2D table to keep tracke of whether s[i...j] is palindorne
 
 
### Code 
  
```java
public class Solution {
    public String longestPalindrome(String s) {
        
        int len = s.length();
        //match[i][j] is true if substring s[i...j] is parlindrone
        boolean[][] match = new boolean[len][len];
        
        int max = 0;
        String rnt = new String();
        
        //length = 1
        for(int i=0; i<len; i++){
            match[i][i] = true;
            if(max<1){
                max = 1;
                rnt = s.substring(i,i+1);
            }
        }
         
        //length =2   
        for(int i=1; i<len; i++){
            if(s.charAt(i-1) == s.charAt(i)){
                match[i-1][i] = true;
                if(max<2){
                    max = 2;
                    rnt = s.substring(i-1, i+1);
                }
            }
        }
        
        //length >=3
        for(int step = 3; step<=len; step++){
            for(int i=0; i<=len-step; i++){
                if(s.charAt(i) == s.charAt(i+step-1) && match[i+1][i+step-2]){
                    match[i][i+step-1] = true;
                    if(max < step){
                        max = step;
                        rnt = s.substring(i, i+step);
                    }
                }
            }
        }
        
        return rnt;
        
        
        
    }
}
```
