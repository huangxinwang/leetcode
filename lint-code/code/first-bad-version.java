/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        return help(1, n, n);
        
    }
    
    public int help(int l, int r, int n){
        if(l>=r) return l;

        int mid = (l+r)/2;
        if(VersionControl.isBadVersion(mid))
            return help(l, mid, n);
        else return help(mid+1, r, n);
    }
}


//////////////////////////////////////////////////
//Approach 2: Iterative

/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
     
    //iterative
    public int findFirstBadVersion(int n) {
        // write your code here
        int l = 0;
        int r = n;
        while(l <r){
            int mid = l + (r-l)/2;
            if(VersionControl.isBadVersion(mid))
                r = mid;
            else
                l = mid+1;
        }
        
        //return right
        return r;
        
    }
    
   
}

