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


//////////////////////////////////////////////////////////////////////////////
//Approach 2: Scan from left and right; build up dynamic table; and then scan from right to left
//Time complexity: O(n)
//Space complexity: O(n)

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> rnt = new ArrayList<Long>();
        if(A.size()<=1) return rnt;
        
        //leftPro[i] represents the product of A[0]*A[1]*...*A[i]
        Long[] leftPro = new Long[A.size()-1];
        long left = 1;
        for(int i=0; i<A.size()-1; i++){
            left = left*A.get(i);
            leftPro[i] = left;
        }
        
        //calculate the product with the absence of the ith element
        long right = 1;
        for(int i=A.size()-1; i>=1; i--){
            long pro = leftPro[i-1]*right;
            right = right*A.get(i);
            rnt.add(0, pro);
        }
        
        rnt.add(0, right);
        
        return rnt;
    }
}


