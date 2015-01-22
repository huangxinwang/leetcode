public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        
        int l = 0;
        int r = A.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(A[mid] == target) return true;
            if(A[l] == target) return true;
            if(A[r] == target) return true;
            
            //There are 3 cases
            //Case 1 and Case 2
            if(A[l] < A[mid]){
                //check monotonically increasing side
                if(A[l] < target && target < A[mid])
                    r = mid-1;
                else l = mid+1;
            }
            //Case 3
            else if(A[l] > A[mid]){
                if(A[mid] < target && target <A[r])
                    l = mid+1;
                else r = mid-1;
            }
            else l++;
        }
        
        return false;
    }
}
