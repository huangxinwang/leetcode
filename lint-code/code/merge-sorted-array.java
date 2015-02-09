class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        
        ArrayList<Integer> rnt = new ArrayList<Integer>();
        int aidx = 0;
        int bidx = 0;
        while(aidx<A.size() && bidx<B.size()){
            if(A.get(aidx) <= B.get(bidx)){
                rnt.add(A.get(aidx));
                aidx++;
            }else{
                rnt.add(B.get(bidx));
                bidx++;
            }
        }
        
        while(aidx<A.size()){
            rnt.add(A.get(aidx));
            aidx++;
        }
        
        while(bidx < B.size()){
            rnt.add(B.get(bidx));
            bidx++;
        }
        
        return rnt;
    }
}
