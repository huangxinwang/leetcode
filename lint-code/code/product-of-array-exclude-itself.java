public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        Long[] rnt = new Long[A.size()];
        
        dfs(A, 0, 0, 1, 0, rnt);
        
        ArrayList<Long> list = new ArrayList<Long>();
        if(A.size()<=1) return list;
        
        for(int i=0; i<rnt.length; i++)
            list.add(rnt[i]);
            
        return list;
    }
    
    //dfs find all products
    public void dfs(ArrayList<Integer> A, int start, int count, long product, int idx, Long[] rnt){
        if(start==A.size()){
            if(count==A.size()-1){
                rnt[idx] = product;
            }
            return;
        }
        
        //Case 1: need to continue multiply to end
        if(count==start-1)
            dfs(A, start+1, count+1, product*A.get(start), idx, rnt);
            
        
        //Case 2: can either skip current value or not
        if(count==start){
            dfs(A, start+1, count, product, start, rnt);
            dfs(A, start+1, count+1, product*A.get(start), idx, rnt);
        }
    }
}

