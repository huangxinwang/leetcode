### Problem
Remove duplicates from an array in place

### Example
Given input array A = [1,1,2],
Your function should return length = 2, and A is now [1,2].

### Code
```java
 public int removeDuplicates(int[] A) {
        
        int idx = 0;
        for(int i=0; i<A.length; ){
            A[idx] = A[i];
            idx++;
            int curr = A[i];
            i++;
            
            //skip duplicates
            while(i<A.length && A[i]==curr)
                i++;
        }
        
        return idx;
    }
```
