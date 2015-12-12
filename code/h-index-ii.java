//Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?


/////////////////////////////
// 2015/12/11
// Highlight: binary search
// Time: O(logn)
public class Solution {
    public int hIndex(int[] citations) {
       if(citations==null || citations.length==0) return 0;
       return bfs(citations, 0, 0, citations.length-1);
    }
    
    public int bfs(int[] citations, int curr, int left, int right){
        if(left>right) return curr;
        int mid = left + (right-left)/2;
        if(citations[mid] > curr +(right-mid)){
            curr+= (right-mid)+1;
            return bfs(citations, curr, left, mid-1);
        }else return bfs(citations, curr, mid+1, right);
    }
}
