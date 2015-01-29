public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        int len = s.length();
        int[] count = new int[len+1];
        for(int i=1; i<=len; i++){
            count[i] = i-1;
        }
        
        for(int i=1; i<=len; i++){
            for(int j=1; j<=i; j++){
                String curr = s.substring(j-1,i);
                if(isPalindrome(curr)){
                    if(j==1) count[i] = 0;
                    else count[i] = Math.min(count[i], count[j-1]+1);
                }
            }
        }
        
        return count[len];
    }
    
    //check if it isPalindorme
    public boolean isPalindrome(String s){
        if(s.length()<=1) return true;
        for(int i=0; i<s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
        }
        return true;
    }
};
