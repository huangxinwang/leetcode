public class Solution {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
        if(matrix.size() == 0) return false;
        
        int row = searchRow(matrix, target, 0, matrix.size()-1);
        if(row==-1) return false;
        return searchCol(matrix.get(row), target, 0, matrix.get(0).size()-1);
    }
    
    //binary serach for the row that may contain target
    public int searchRow(ArrayList<ArrayList<Integer>> matrix, int target, int s, int e){
        if(s>e) return -1;
        int mid = s+ (e-s)/2;
        ArrayList<Integer> midlist = matrix.get(mid);
        if(midlist.get(0) <=target && target <= midlist.get(midlist.size()-1)) return mid;
        
        if(midlist.get(0) > target)
            return searchRow(matrix, target, s, mid-1);
        else return searchRow(matrix, target, mid+1, e);
    }
    
    //binary serach for target in the row
    public boolean searchCol(ArrayList<Integer> list, int target, int l, int r){
        if(l>r) return false;
        int mid = l + (r-l)/2;
        int midval = list.get(mid);
        
        if(midval == target) return true;
        
        if(midval > target)
            return searchCol(list, target, l, mid-1);
        else return searchCol(list, target, mid+1, r);
    }
}
