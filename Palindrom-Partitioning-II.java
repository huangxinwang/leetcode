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
        
        cutNum[0] = 0;
        for(int i=1; i<=s.length(); i++)
        {
            cutNum[i] = s.length();
        }
        
        for(int i=1; i<= s.length(); i++)
        {
            for(int j=1; j<=i; j++)
            {
                if(isPalindrome(s.substring(j-1,i)))
                {
                    int tmp = cutNum[j-1]+1;
                    if(cutNum[i] > tmp)
                    {   
                        cutNum[i] = tmp;
                        break;
                    }
                }
            }
        }
        
        return cutNum[s.length()];
        
    }
    
    public boolean isPalindrome(String s)
    {
        for(int i=0; i<s.length()/2; i++)
        {
            if(s.charAt(i)!=s.charAt(s.length()-1-i))
            return false;
        }
        
        return true;
    }
}