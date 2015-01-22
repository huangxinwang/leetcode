class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(nums==null || nums.size()==0 ) return rnt;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int[] used = new int[nums.size()];
        dfs(nums, rnt, tmp, used, nums.size());
        return rnt;
    }
    
    //dfs
    //use an array to keep track of the visited element
    //use depth to keep track of current length of permutation
    public void dfs(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, int[] used, int depth){
        if(depth==0){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0; i<nums.size(); i++){
            if(used[i]==0){
                used[i] = 1;
                tmp.add(nums.get(i));
                dfs(nums, rnt, tmp, used, depth-1);
                tmp.remove(tmp.size()-1);
                used[i] = 0;
            }
        }
    }
}
