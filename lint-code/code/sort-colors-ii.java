class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        int[] count = new int[k];
        for(int i=0; i<colors.length; i++){
            count[colors[i]-1]++;
        }
        
        int idx = 0;
        for(int i=0; i<k; i++){
            for(int j=0; j<count[i]; j++){
                colors[idx] = i+1;
                idx++;
            }
        }
    }
}
