### Problem
Implement atoi to convert a string to an integer.

### Corner Case
- +-132
- 12a12
- 124790087730008876333, return MAX_VALUE
- 12 34

### Code
```java
public class Solution {
    public int atoi(String str) {
        long rnt = 0;
        //keep track of symbol
        int pos = 0;
        int neg = 0;
        
        //keep track of whether to continue the scanning
        boolean stop = false;
        
        for(int i = 0; i<str.length() && !stop; i++){
            switch(str.charAt(i)){
                case '+':
                    if(neg>0 || pos>0) return 0;
                    pos = 1;
                    break;
                case '-':
                    if(pos>0 || neg>0) return 0;
                    neg = 1;
                    break;
                case ' ':
                    if(neg==1 || pos==1) return 0;
                    if(rnt!=0) stop = true;
                    break;
                default:
                    if('a'<=str.charAt(i) && str.charAt(i)<='z') stop = true;
                    else if('A'<=str.charAt(i) && str.charAt(i)<='Z') stop = true;
                    else rnt = rnt*10+ (str.charAt(i)-'0');
                    if(rnt>Integer.MAX_VALUE) stop = true;
            }
        }
        
        if(neg==1) rnt = -rnt;
        
        if(rnt>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(rnt<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        
        return (int)rnt;
    }
}
```
