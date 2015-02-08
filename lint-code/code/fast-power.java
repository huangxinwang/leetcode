/**
 * Ref: http://www.cnblogs.com/yuzhangcmu/p/4174781.html
 * Lrinciple: (a^n)%b = ( ( a^(n/2)%b * a^(n/2)%b )%b *(a%b))%b
 * 
 * 
 */


class Solution {
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        // write your code here
        if(a==0) return 0;
        if(n==0) return 1%b;
        
        long rnt = fastPower(a,b,n/2);
        rnt *= rnt;
        
        rnt = rnt%b;
        
        if(n%2==1)
            rnt *= (a%b);
        
        return (int)(rnt%b);
    }
};
