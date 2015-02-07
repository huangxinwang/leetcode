public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> rnt = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        int[] used = new int[num.length];
        Arrays.sort(num);
        int start = 0;
        int curr = 0;
        dfs(rnt, tmp, num, used, start, curr, target);
        return rnt;
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> rnt, ArrayList<Integer> tmp, int[] num, int[] used,
    int start, int curr, int target){
        if(curr == target){
            rnt.add(new ArrayList<Integer>(tmp));
            return;
        }
        if(start == num.length || curr>target) return;
        
        for(int i=start; i<num.length; i++){
            if(i!=0 && num[i-1]==num[i] && used[i-1]==0) continue;
            tmp.add(num[i]);
            used[i] = 1;
            dfs(rnt, tmp, num, used, i+1, curr+num[i], target);
            used[i] = 0;
            tmp.remove(tmp.size()-1);
        }
    }
}
