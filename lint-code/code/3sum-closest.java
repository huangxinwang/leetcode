public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        HashSet<Integer> setOne = new HashSet<Integer>();
        HashSet<Integer> setTwo = new HashSet<Integer>();
        int dist = Integer.MAX_VALUE;
        int rnt = dist;
        
        for(int i=0; i<numbers.length; i++){
            
            //calcuate sum of 3 numbers
            for(Integer curr: setTwo){
                int sum = numbers[i]+curr;
                if(Math.abs(target-sum)<dist){
                    dist = Math.abs(target-sum);
                    rnt = sum;
                }
            }
            
            //update setTwo
            for(Integer curr: setOne){
                setTwo.add(curr+numbers[i]);
            }
            
            //update setOne
            setOne.add(numbers[i]);
        }
        
        return rnt;
    }
}
