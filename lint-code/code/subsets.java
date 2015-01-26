class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        
        //sort the array
        Collections.sort(S);
        
        //create new subset using old-subset, by adding new elements 
        rnt.add(new ArrayList<Integer>());
        
        for(int i=0; i<S.size(); i++){
            int size = rnt.size();
            for(int j=0; j<size; j++){
                ArrayList<Integer> list = new ArrayList<Integer>(rnt.get(j));
                list.add(S.get(i));
                rnt.add(list);
            }
        }
        
        return rnt;
    }
}
