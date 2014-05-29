/**
 * Problem Statement
 * Implement pow(x, n).
 */

public class Solution {
    
    public double pow(double x, int n) {
        
        if(n==0) return 1;
        
        //make n non-negtive
        if(n<0){
            //make -n not overflow
            if(n==-2147483648){   
                n = -(n+1);
                return 1/(x*subPow(x,n,1));
             }
             else{
                 n = -n;
                 return 1/subPow(x,n,1);
             }
        }
        
        return subPow(x,n,1);
    }
    
    public double subPow(double x, int n, int currSum)
    {
        if(n==1) return x*currSum;
        
        int half = n/2;
        int left = n%2;
        
        double leftSum = 1;
        for(int i=0; i<left; i++)
            leftSum *= x;
            
        double halfSum = subPow(x,half,1);
        return halfSum*halfSum*leftSum*currSum;
    }
}