### Problem

The count-and-say sequence is the sequence of integers beginning as follows:
```1, 11, 21, 1211, 111221, ...```
```
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
```

Given an integer n, generate the nth sequence.
Note: The sequence of integers will be represented as a string.



### Code
``` java
public class Solution {
    public String countAndSay(int n) {
        String rnt = 1+"";
        
        while(n>1){
            StringBuffer sb = new StringBuffer();
            for(int i=0; i<rnt.length(); ){
                
                int count = 1;
                char curr = rnt.charAt(i);
                i++;
                
                //count
                while(i<rnt.length() && rnt.charAt(i) == curr){
                    count++;
                    i++;
                }
                //say
                sb.append(count);
                sb.append(curr);
            }
            //update loop variable
            rnt = sb.toString();
            n--;
        }
        
        return rnt;
    }
}
```
