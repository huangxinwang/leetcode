// Number of Digit One

// Ref: http://yuanhsh.iteye.com/blog/2227478

public class Solution {
    public int countDigitOne(int n) {
        if(n<=0) return 0;
        if(n<10) return 1;
        int base = (int)Math.pow(10, (n+"").length()-1);
        int k = n/base;
        return countDigitOne(base-1)*k + (k==1? n-base+1: base) + countDigitOne(n%base);
    }
}
