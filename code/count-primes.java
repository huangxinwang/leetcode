/**
*
*/


////////////////////////////////////////
// 2015/11/16
// Highlight: prime number property, mod 1..Math.sqrt(n) is not 0
public class Solution {
    public int countPrimes(int n) {
        
        boolean[] isPrime = new boolean[n];
        for(int i=2; i<n; i++)
            isPrime[i] = true;
        
        //prime number property    
        for(int i=2; i<=Math.sqrt(n); i++){
            if(isPrime[i]){
                for(int j=i+i; j<n; j+=i){
                    isPrime[j] = false;
                }
            }
        }
        
        int rnt = 0;
        for(int i=2; i<isPrime.length; i++){
            if(isPrime[i]) rnt++;
        }
        return rnt;
    }
}
