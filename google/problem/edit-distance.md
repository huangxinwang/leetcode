### Problem
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

### Example
Given work1="mart" and work2="karma"

return 3

### Analysis
- dynamic programming
- time complexity O(len1 len2)

### Code
```
public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        // write your code here
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1==0) return len2;
        if(len2==0) return len1;
        
        //the distance between word1[0...i] and word2[0...j]
        int[][] dist = new int[len1+1][len2+1];
        
        //initialize
        for(int i=1; i<=len1; i++){
          dist[i][0] = i;
        }
        
        for(int i=1; i<=len2; i++){
           dist[0][i] = i;
        }
        
        
        //dynamic programming update the table
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dist[i][j] = dist[i-1][j-1];
                else{
                    dist[i][j] = Math.min(dist[i-1][j], dist[i][j-1])+1;
                    dist[i][j] = Math.min(dist[i][j], dist[i-1][j-1]+1);
                }
            }
        }
        
        return dist[len1][len2];
        
    }
}
```
