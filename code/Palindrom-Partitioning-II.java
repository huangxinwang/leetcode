/**
 * problem Statement
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * For example, given s = "aab",
 * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 */ 

public class Solution {
    public int minCut(String s) {
        
        if(s.length()==0) return 0;
        
        //cutNum[i] stores the min cutNum for substring s(1..i)
        int[] cutNum = new int[s.length()+1];
        
        //status[i][j] keep status of whether s(i..j) is palindrome
        boolean[][] status = new boolean[s.length()][s.length()];
       
        //initialization 
        for(int i=0; i<s.length(); i++)
        {
            status[i][i] = true;
        }
        
        cutNum[0] = -1;
        
        for(int i=1; i<=s.length(); i++)
        {
            cutNum[i] = i-1;
        }
        
        //dynamic programming
        for(int i=0; i<s.length(); i++)
        {
            for(int j=i-1; j>=0; j--)
            {
                //judge whether s(i..j) is palindrome
                if( (s.charAt(i)==s.charAt(j)) &&(i-j<=2 || status[j+1][i-1]))
                {
                    //update min cut number
                    cutNum[i+1] = Math.min(cutNum[i+1],cutNum[j]+1);
                    status[j][i] = true;
                }
                
                cutNum[i+1] = Math.min(cutNum[i]+1,cutNum[i+1]);
            }
            
        }
        
        return cutNum[s.length()];
        
    }
    
}


////////////////////////////////////////////////////////////////////////////
//Round 2: 11/30/2014
public class Solution {
    public int minCut(String s) {
        
        
        //let minnum[i] denote the mincut of s[0...i]
        int[] minnum = new int[s.length()+1];
        for(int i=1; i<minnum.length; i++)
            minnum[i] = i-1;
        //init
        minnum[0] = -1;
    
        //let ispar[i][j] denote whether s[j...i] is parlindrome
        boolean[][] ispar = new boolean[s.length()][s.length()];
        for(int i=0; i<s.length(); i++)
            ispar[i][i] = true;
         
        //dynamic update ispar and minnum   
        for(int i=0; i<s.length(); i++){
            for(int j=i-1; j>=0; j--){
                if(s.charAt(i)==s.charAt(j) && (i-j<=2 || ispar[j+1][i-1])){
                    ispar[j][i] = true;
                    minnum[i+1] = Math.min(minnum[j] + 1, minnum[i+1]);
                }
            }
            
            minnum[i+1] = Math.min(minnum[i]+1, minnum[i+1]);
        }
        
        return minnum[s.length()];
    }
}
