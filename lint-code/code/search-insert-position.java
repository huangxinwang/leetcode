public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(ArrayList<Integer> A, int target) {
        // write your code here
        int idx = help(A, target-1, 0, A.size()-1);
        return idx;
    }
    
    //return right_most_idx+1
    public int help(ArrayList<Integer> A, int target, int l, int r){
        if(l>r) return l;
        int mid = l + (r-l)/2;
        if(A.get(mid) > target)
            return help(A, target, l, mid-1);
        else return help(A, target, mid+1, r);
    }
}
