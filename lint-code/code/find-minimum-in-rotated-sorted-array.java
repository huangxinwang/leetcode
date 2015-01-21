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
        
        int mid = l + (r-l)/2;
        
        //draw the graph, there are 3 cases
        //only in this case, you need to search for the right
        if(num[l] < num[mid] && num[mid] > num[r])
            return help(num, mid, r);
        else
             return help(num, l, mid);
        
    }
}
