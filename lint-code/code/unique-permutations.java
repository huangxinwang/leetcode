class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.size()==0) return rnt;
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        Collections.sort(nums);
        int depth = nums.size();
        int[] used = new int[nums.size()];
        dfs(rnt, nums, tmp, used, depth);
        return rnt;
    }
    
    //dfs
    //use array to keep track whether a number is used
    //Note that the input array will be sorted, and if the previous duplicate number is not used
    //then no recursive would need to be performed on current number
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> nums, ArrayList<Integer> tmp, int[] used, int depth){
        if(depth==0){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        
        for(int i=0; i<nums.size(); i++){
            if(used[i]==0){
                if(i>0 && used[i-1]==0 && nums.get(i) == nums.get(i-1)) continue;
                used[i] = 1;
                tmp.add(nums.get(i));
                dfs(rnt, nums, tmp, used, depth-1);
                tmp.remove(tmp.size()-1);
                used[i] = 0;
            }
        }
    }
}

