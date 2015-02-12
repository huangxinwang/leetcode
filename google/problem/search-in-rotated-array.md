### Problem
Search in Rotated Sorted Array 
- Suppose a sorted array is rotated at some pivot unknown to you beforehand.

### Analysis
- draw the 3 conditions figure
- for two cases, just need to search one side
- for one case, need to search both sides

### Code
```java
public class Solution {
    public int search(int[] A, int target) {
        return help(A, 0, A.length-1, target);
    }
    
    public int help(int[] A, int left, int right, int target){
        if(left>right) return -1;
        
        int mid = left+(right-left)/2;
        if(A[mid] == target) return mid;
        else if(A[mid] < target){
            if(A[left] < A[mid])
                return help(A, mid+1, right, target);
            else{
                int idx = help(A, left, mid-1, target);
                if(idx!=-1) return idx;
                else return help(A, mid+1, right, target);
            }
        }else{
            if(A[mid] < A[right])
                return help(A, left, mid-1, target);
            else{
                int idx = help(A, left, mid-1, target);
                if(idx!=-1) return idx;
                else return help(A, mid+1, right, target);
            }
        }
        
    
    }
}
```
