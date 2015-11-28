/**
* Problem Statement: First Bad Version
* From: http://www.mitbbs.com/article_t/JobHunting/33101531.html
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return bs(1,n);
    }
    
    public int bs(int l, int r){
        if(l==r) return l;
        
        int mid = l + (r-l)/2;
        
        if(isBadVersion(mid)){
            return bs(l,mid);
        }
        else{
            return bs(mid+1,r);
        }
    }
}
