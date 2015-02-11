### Problem
Remove duplicates from an array in place

### Example

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
