### Problem
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,
```
Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
```

### Code
```java

public class Solution {
    public String fractionToDecimal(long numerator, long denominator) {
        if(denominator==0) return "0"; 
        
        
        //determine sign
        boolean neg = false;
        if(numerator<0 && denominator>0) neg = true;
        if(numerator>0 && denominator<0) neg = true;
        if(neg==true){
            if(numerator<0) numerator = -numerator;
            if(denominator<0) denominator = -denominator;
        }
        
        //use hashtable to keep track of whether a "remainder" is repeated
        //for each key, the value corresond to the "division result"
        HashMap<Integer, Integer> ht = new HashMap<Integer, Integer>();
        
        //tens
        long tens = numerator/denominator;
        numerator = numerator%denominator;
        
        //special case
        if(numerator==0){ 
            String rnt = new String();
            if(neg) rnt+="-";
            return rnt+tens+"";
        }
        
        ArrayList<Long> list = new ArrayList<Long>();
        int count = 0;
        int repeatKey = 0;
        
        //loop to divide
        while(numerator!=0){
            //remainder repeated, break
            if(ht.containsKey((int)numerator)){
                repeatKey = (int)numerator;
                break;
            }else{
                long val = numerator*10/denominator;
                ht.put((int)numerator, count);
                list.add(val);
                count++;
                numerator = (numerator*10)%denominator;
            }
        }
        
        //process result
        StringBuffer sb = new StringBuffer();
        if(neg) sb.append("-");
        sb.append(tens+".");
        int idx = 0;
        if(numerator !=0) idx= ht.get(repeatKey);
        
        if(idx==0 && numerator!=0) sb.append("(");
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
            if(i==idx-1 && numerator!=0) sb.append("(");
        }
        
        if(numerator!=0) 
         sb.append(")");
         
        return sb.toString();
        
    }
}
```
