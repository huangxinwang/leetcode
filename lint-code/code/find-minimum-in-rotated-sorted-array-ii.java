public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        return help(num, 0, num.length-1);
    }
    
    public int help(int[] num, int l, int r){
        if(l==r) return num[l];
        if(l+1 == r) return Math.min(num[l], num[r]);
        
        int mid = (l+r)/2;
        
        //Case 1: leftval and rightval is equal
        if(num[l] == num[r]){
            //if all equal, return min of both sides
            if(num[l] == num[mid]){
                int val1 = help(num, l, mid);
                int val2 = help(num, mid+1, r);
                return Math.min(val1, val2);
            }
            //if increasing, return leftside, otherwise return rightside
            else if(num[l] < num[mid])
                return help(num, mid, r);
            else return help(num, l, mid);
        }
        //Case 2: leftval less than rightval, then return leftside
        else if(num[l] < num[r])
            return help(num, l, mid);
        //Case 3: leftval larger than rightval
        else{
            //if leftval less than midval, then return rightside, otherwise leftside
            if(num[l] <= num[mid])
                return help(num, mid, r);
            else return help(num, l, mid);
        } 
    }
}
