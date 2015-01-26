class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<>();
        Collections.sort(S);
        int depth = 0;
        ArrayList<Integer> curr = new ArrayList<Integer>();
        int[] used = new int[S.size()];
        dfs(rnt, curr, S, depth, used);

        return rnt;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> curr, ArrayList<Integer> S, int depth, int[] used){
        
        //add every result
        rnt.add(new ArrayList<Integer>(curr));

        //terminate case
        if(depth == S.size()){
            return;
        }
        
        //dfs find all subsets
        for(int i=depth; i<S.size(); i++){
            if(i>0 && S.get(i-1)==S.get(i) && used[i-1] == 0) continue;
            used[i] = 1;
            curr.add(S.get(i));
            dfs(rnt, curr, S, i+1, used);
            curr.remove(curr.size()-1);
            used[i] = 0;
        }
    }
}
