public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        return help(A, target, 0, A.length-1);
    }
    
    public int help(int[] A, int target, int l, int r){
        if(l>r) return -1;
        
        if(l==r){
            if(A[l] == target) return l;
            else return -1;
        }
        
        int mid = l + (r-l)/2;
        if(A[mid] == target) return mid;
        
        //There are three cases of the rotated sorted array in the relative value of: l, mid, r
        //For each case, at least one side increasing monotically
        //Case 1: 
        if(A[l] > A[mid] && A[mid] < A[r]){
            if(A[mid] < target && target< A[r])
                return help(A, target, mid+1, r);
            else return help(A, target, l, mid-1);
        }
        //Case 2 and 3
        else{
            if(A[l] < target && target < A[mid])
                return help(A, target, l, mid-1);
            else return help(A, target, mid+1, r);
        }
        
    }
}
