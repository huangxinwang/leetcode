public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
        int val1 = help(A, 0, A.size()-1, target-1);
        int val2 = help(A, 0, A.size()-1, target);
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        if(val1 == val2){
            rnt.add(-1);
            rnt.add(-1);
            return rnt;
        }
        else rnt.add(val1);
        rnt.add(val2-1);
        return rnt;
    }
    
    //return right_most_index + 1
    public int help(ArrayList<Integer> A, int l, int r, int target){
       if(l>r) return l;
       int mid = l + (r-l)/2;
       if(A.get(mid) > target){
           return help(A, l, mid-1, target);
       }
       //if midval == target, then keep searching right
       else
            return help(A, mid+1, r, target);
    }
}
