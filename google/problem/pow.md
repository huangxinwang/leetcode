### Problem
Implement pow(x, n).

### Time complexity
log(n)

### Code
```java
public class Solution {
    public double pow(double x, int n) {
        
        if(x==0) return 0;
        //Case 1: n is negative, convert to positive
        if(n<0) return helpPow(1/x,-n);
        return helpPow(x,n);
    }
    
    //recursive calculation
    public double helpPow(double x, int n){
        if(x==1) return 1;
        if(n==0) return 1;
        double half = helpPow(x, n/2);
        if(n%2==1) return half*half*x;
        else return half*half;
    }
}
```
