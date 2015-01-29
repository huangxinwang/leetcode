public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        //denote last layers
        ArrayList<Integer> last = triangle.get(0);
        //use to record the next generated layer
        ArrayList<Integer> next = new ArrayList<Integer>();
        
        for(int i=1; i<triangle.size(); i++){
            ArrayList<Integer> curr = triangle.get(i);
            next = new ArrayList<Integer>();
            for(int j=0; j<curr.size(); j++){
                int left = j==0? last.get(j):last.get(j-1);
                int right = j== last.size()? last.get(j-1): last.get(j);
                int num = Math.min(left, right) + curr.get(j);
                next.add(num);
            }
            last = next;
        }
        
        int min = last.get(0);
        for(int i=1; i<last.size(); i++){
            min = min>last.get(i)? last.get(i) : min;
        }
        
        return min;
    }
}

